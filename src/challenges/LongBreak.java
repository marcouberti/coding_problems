package challenges;

import java.util.LinkedList;
import java.util.List;

public class LongBreak {

    public static void main(String[] args) {
        System.out.println(new LongBreak().findBreakDuration(4, 2, 1, null, null));
    }

    /*
     * Complete the 'findBreakDuration' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n: the number of presentations
     *  2. INTEGER k: the number of presentations that can be moved
     *  3. INTEGER t: the ending time of the conference
     *  4. INTEGER_ARRAY start: start time of presentation ith
     *  5. INTEGER_ARRAY finish: end time of presentation ith
     */

    public static int findBreakDuration(int n, int k, int t, List<Integer> start, List<Integer> finish) {
        // Write your code here
        int[] schedule = new int[t]; // 0 is free, otherwise is presentation number

        int[] left = new int[t];
        int[] right = new int[t];

        int[] leftSingle = new int[t];
        int[] rightSingle = new int[t];

        // fill the schedule array
        for(int i=0; i<n; i++) {
            for(int j=start.get(i); j<finish.get(i); j++) {
                schedule[j] = i+1; // 0 is for free slot
            }
        }

        // compute how many GREEN to the left "reachable" -> in between can exist PURPLEs < k
        int greenSoFar = 0;
        int purpleSoFar = 0;
        int lastPresentationNumber = 0;
        LinkedList<Integer> freeCount = new LinkedList<>();
        for(int i=0; i<t; i++) {
            if(schedule[i] == 0) greenSoFar++;
            else if(schedule[i] != 0 && schedule[i] != lastPresentationNumber) {
                if(greenSoFar > 0) {
                    purpleSoFar++;
                }
                left[i] = greenSoFar;
                lastPresentationNumber = schedule[i];
                freeCount.add(greenSoFar);
            }else if(schedule[i] != 0) {
                left[i] = greenSoFar;
            }

            //reset green count if
            if(purpleSoFar > k) {
                int frees = freeCount.isEmpty()?0:freeCount.pollLast();
                left[i] -= frees;
                greenSoFar -=frees;
            }
        }

        // LEFT SINGLE
        greenSoFar = 0;
        purpleSoFar = 0;
        lastPresentationNumber = 0;
        freeCount = new LinkedList<>();
        for(int i=0; i<t; i++) {
            if(schedule[i] == 0) greenSoFar++;
            else if(schedule[i] != 0 && schedule[i] != lastPresentationNumber) {
                if(greenSoFar > 0) {
                    purpleSoFar++;
                }
                leftSingle[i] = greenSoFar;
                lastPresentationNumber = schedule[i];
                freeCount.add(greenSoFar);
            }else if(schedule[i] != 0) {
                leftSingle[i] = greenSoFar;
            }

            //reset green count if
            if(purpleSoFar > 1) {
                int frees = freeCount.isEmpty()?0:freeCount.pollLast();
                leftSingle[i] -= frees;
                greenSoFar -=frees;
            }
        }

        // compute how many GREEN to the right "reachable" -> in between can exist PURPLEs < k
        greenSoFar = 0;
        purpleSoFar = 0;
        lastPresentationNumber = 0;
        freeCount = new LinkedList<>();
        for(int i=t-1; i>=0; i--) {
            if(schedule[i] == 0) greenSoFar++;
            else if(schedule[i] != 0 && schedule[i] != lastPresentationNumber) {
                if(greenSoFar > 0) {
                    purpleSoFar++;
                }
                right[i] = greenSoFar;
                lastPresentationNumber = schedule[i];
                freeCount.add(greenSoFar);
            }else if(schedule[i] != 0) {
                right[i] = greenSoFar;
            }

            //reset green count if
            if(purpleSoFar > k) {
                int frees = freeCount.isEmpty()?0:freeCount.pollLast();
                right[i] -= frees;
                greenSoFar -=frees;
            }
        }

        // RIGHT SINGLE
        greenSoFar = 0;
        purpleSoFar = 0;
        lastPresentationNumber = 0;
        freeCount = new LinkedList<>();
        for(int i=t-1; i>=0; i--) {
            if(schedule[i] == 0) greenSoFar++;
            else if(schedule[i] != 0 && schedule[i] != lastPresentationNumber) {
                if(greenSoFar > 0) {
                    purpleSoFar++;
                }
                rightSingle[i] = greenSoFar;
                lastPresentationNumber = schedule[i];
                freeCount.add(greenSoFar);
            }else if(schedule[i] != 0) {
                rightSingle[i] = greenSoFar;
            }

            //reset green count if
            if(purpleSoFar > 1) {
                int frees = freeCount.isEmpty()?0:freeCount.pollLast();
                rightSingle[i] -= frees;
                greenSoFar -=frees;
            }
        }

        // now scan from left to right and find the maximum break available
        int max = 0;
        for(int i=0; i<t; i++) {
            if(left[i] + rightSingle[i] > max) max = left[i] + rightSingle[i];
            if(right[i] + leftSingle[i] > max) max = right[i] + leftSingle[i];
        }

        return max;
    }

}
