package dailycodingproblem;

/*
This problem was asked by Google.

Given an array of integers where every integer occurs three times except for one integer, which only occurs once, find and return the non-duplicated integer.

For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.

Do this in O(N) time and O(1) space.*/

import java.util.*;
import java.util.stream.Collectors;

public class Problem_40 {

    public static void main(String[] args) {
        new Problem_40().execute();
    }

    private void execute() {
        int[] input = new int[]{6,1,3,3,3,6,6};
        System.out.println(getSingle(input, input.length));

        /*
        int[] input = new int[]{6,1,3,3,3,6,6};
        System.out.println(getSingleEquation(input, input.length));
        */

        /*
        int[] input = new int[]{6,1,3,3,6};
        System.out.println(getSingleSimple(input, input.length));
        */
    }

    // Method to find the element that occur only once
    int getSingle(int arr[], int n)
    {
        int ones = 0, twos = 0;
        int common_bit_mask;

        for(int i=0; i<n; i++ )
        {
            /*"one & arr[i]" gives the bits that are there in
            both 'ones' and new element from arr[]. We
            add these bits to 'twos' using bitwise OR*/
            twos = twos | (ones & arr[i]);

            /*"one & arr[i]" gives the bits that are
            there in both 'ones' and new element from arr[].
            We add these bits to 'twos' using bitwise OR*/
            ones = ones ^ arr[i];

            /* The common bits are those bits which appear third time
            So these bits should not be there in both 'ones' and 'twos'.
            common_bit_mask contains all these bits as 0, so that the bits can
            be removed from 'ones' and 'twos'*/
            common_bit_mask = ~(ones & twos);

            /*Remove common bits (the bits that appear third time) from 'ones'*/
            ones &= common_bit_mask;

            /*Remove common bits (the bits that appear third time) from 'twos'*/
            twos &= common_bit_mask;
        }
        return ones;
    }

    // Method to find the element that occur only once,
    // and the other occurs only 2 times instead of 3.
    int getSingleSimple(int arr[], int n)
    {
        int ones = 0;

        for(int i=0; i<n; i++ )
        {
            ones = ones ^ arr[i];
        }
        return ones;
    }

    /*
    Array [] : [a, a, a, b, b, b, c, c, c, d]
    Mathematical Equation = ( 3*(a+b+c+d) – (a + a + a + b + b + b + c + c + c + d) ) / 2

    In more simple words: ( 3*(sum_of_array_without_duplicates) – (sum_of_array) ) / 2
     */
    int getSingleEquation(int arr[], int n) {

        List<Integer> myList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int allSum = myList.stream().mapToInt(Integer::intValue).sum();

        Set<Integer> results = new HashSet<>(myList);
        int singleValuesSum = results.stream().mapToInt(Integer::intValue).sum();

        return (3*singleValuesSum - allSum)/2;
    }
}