package dailycodingproblem;

/*
This problem was asked by Google.

Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k. If such a subset cannot be made, then return null.

Integers can appear more than once in the list. You may assume all numbers in the list are positive.

For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.
 */

public class Problem_42 {

    public static void main(String[] args) {
        new Problem_42().execute();
    }

    // This problem is NP-Complete
    // We have 2 solutions here: recursive and with DP
    private void execute() {
        int[] mySet = new int[] {12, 1, 61, 5, 9, 2};
        //System.out.println(isSubsetSumRecursive(mySet, mySet.length, 24));
        System.out.println(isSubsetSumDP(mySet, mySet.length, 24));
    }

    // Returns true if there is a subset
    // of set[] with sum equal to given sum
    boolean isSubsetSumRecursive(int set[],
                               int n, int sum) {
        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;

        // If last element is greater than
        // sum, then ignore it
        if (set[n - 1] > sum)
            return isSubsetSumRecursive(set, n - 1, sum);

        /* else, check if sum can be obtained
        by any of the following
            (a) including the last element
            (b) excluding the last element */
        return isSubsetSumRecursive(set, n - 1, sum) ||
                isSubsetSumRecursive(set, n - 1, sum - set[n - 1]);

    }

    // Returns true if there is a subset of
    // set[] with sun equal to given sum
    boolean isSubsetSumDP(int set[],
                               int n, int sum)
    {
        // The value of subset[i][j] will be
        // true if there is a subset of
        // set[0..j-1] with sum equal to i
        boolean subset[][] =
                new boolean[sum+1][n+1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        // Fill the subset table in botton
        // up manner
        for (int i = 1; i <= sum; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                subset[i][j] = subset[i][j-1];
                if (i >= set[j-1])
                    subset[i][j] = subset[i][j] ||
                            subset[i - set[j-1]][j-1];
            }
        }

        /* // uncomment this code to print table
        for (int i = 0; i <= sum; i++)
        {
        for (int j = 0; j <= n; j++)
            System.out.println (subset[i][j]);
        } */

        return subset[sum][n];
    }
}