package dailycodingproblem;

/*
This problem was asked by Google.

Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all the Rs
come first, the Gs come second, and the Bs come last. You can only swap elements of the array.

Do this in linear time and in-place.

For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].
 */

public class Problem_35 {

    public static void main(String[] args) {
        new Problem_35().execute();
    }

    private void execute() {
        char[] input = new char[]{'G', 'B', 'R', 'R', 'B', 'R', 'G'};

        int numR = 0;
        int numG = 0;
        int numB = 0;

        for(int i=0; i<input.length; i++) {
            if(input[i] == 'R') numR++;
            if(input[i] == 'G') numG++;
            if(input[i] == 'B') numB++;
        }

        int index = 0;
        while (numR > 0) {
            input[index] = 'R';
            index++;
            numR--;
        }
        while (numG > 0) {
            input[index] = 'G';
            index++;
            numG--;
        }
        while (numB > 0) {
            input[index] = 'B';
            index++;
            numB--;
        }

        System.out.println(input);
    }

}
