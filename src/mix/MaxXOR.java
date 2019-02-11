package mix;

public class MaxXOR {

    public static void main(String[] args) {
        System.out.println(new MaxXOR().findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
        System.out.println(new MaxXOR().findMaximumXOROptimal(new int[]{3, 10, 5, 25, 2, 8}));
    }

    // non optimal solution O(N^2)
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums.length; j++) {
                if(i == j) continue;
                if((nums[i] ^ nums[j]) > max) max = nums[i] ^ nums[j];
            }
        }
        return max;
    }

    //optimal solution
    public int findMaximumXOROptimal(int[] nums) {

        Trie root = new Trie();
        Trie curNode;

        // we can use a Trie to store all the available bit prefixes in a first pass
        for (int n :
                nums) {
            curNode = root;
            for (int i = 31; i >= 0; i--) {
                int value = getBit(n, i);
                if(curNode.tries[value] == null) {
                    curNode.tries[value] = new Trie();
                }else {
                    curNode.tries[value].count++;
                }
                curNode = curNode.tries[value];
            }
        }
        // in the second pass we check foreach of the N integers the max XOR path using during the trie navigation
        // a the first choise the opposite of the i-th bit, if not present the same bit value so we can proceed deeper
        // and consider also the least significant bits values
        int max = 0;

        for (int n :
                nums) {
            curNode = root;
            int xor = 0;
            for (int i = 31; i >= 0; i--) {
                int value = getBit(n, i);
                if(curNode.tries[1-value] != null) {
                    xor += (1 << i);
                    curNode = curNode.tries[1-value];
                }else if(curNode.tries[value] != null) {
                    curNode = curNode.tries[value];
                }else break;
            }
            if(xor > max) max = xor;
        }

        return max;
    }

    /**
     * Get i-th bit in a integer
     * @param n
     * @param k
     * @return i-th bit value in a integer
     */
    int getBit(int n, int k) {
        return (n >> k) & 1;
    }

    /**
     * Trie data structure
     */
    class Trie {
        int count = 1;
        Trie[] tries = new Trie[2];
    }
}
