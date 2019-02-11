package mix;

public class BinaryOperationsAndBitmasks {

    public static void main(String[] args) {
        System.out.println(new BinaryOperationsAndBitmasks().f(new int[]{3,1}));
    }


    private int f(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return 0; // potrebbe rientrare nel caso generale

        int result = 0;

        for (int i=0; i<nums.length; i++) {
            if((i+1) % 2 == 0 && (nums.length % 2 == 0)) result ^= nums[i];
            if((i+1) % 2 == 0 && (nums.length % 2 != 0)) continue;
            if((i+1) % 2 != 0 && (nums.length % 2 != 0)) result ^= nums[i];
            if((i+1) % 2 != 0 && (nums.length % 2 == 0)) continue;
        }

        return result;
    }

    /**
     * Comute c(a,b) = a & (a+1) & ... & (b-1) & b
     * where a < b
     * @param a
     * @param b
     * @return c(a,b) = a & (a+1) & ... & (b-1) & b
     *
     * This is not the optimal solution. See below for the optimal one.
     */
    private int c(int a, int b) {
        int c = Integer.MAX_VALUE;
        while(a <= b) {
            c &= a;
            a++;
        }
        return c;
    }

    /**
     * Comute c(a,b) = a & (a+1) & ... & (b-1) & b
     * where a < b
     * @param a
     * @param b
     * @return c(a,b) = a & (a+1) & ... & (b-1) & b
     */
    private int[] c_optimal(int[] a, int[] b) {
        int[] c = new int[b.length];
        // hypothesis: we don't have leading 0s
        // so if a and b are different in length, for sure the result is 0
        if(a.length != b.length) return c;

        // we loop from the most significant bit to the least significant one
        for(int i=b.length-1; i>=0; i--) {
            if(b[i] == a[i]) {
                c[i] = b[i];
            }else break;
        }
        return c;
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
     * Basic bitmap operations
     */
    private void bitsOperations() {

        int a =     0b101;
        int b =     0b111;

        System.out.println("a: " + a);
        System.out.println("~a: " + ~a);
        System.out.println("a & ~a: " + (a & ~a));
        System.out.println("~a + 1: " + (~a + 1));//two's complement N -> -N

        System.out.println("b: " + b);
        System.out.println("~b: " + ~b);
        System.out.println("b & ~b: " + (b & ~b));
        System.out.println("~b + 1: " + (~b + 1));//two's complement N -> -N

        System.out.println("a & b: " + (a & b));
        System.out.println("a | b: " + (a | b));
        System.out.println("a ^ b: " + (a ^ b));// XOR 1 if different
    
    }

    public int hammingWeight(int n) {
        int cont = 0;
        while(n != 0) {
            if((n & 1) == 1) cont++;
            n = n >>> 1;
        }
        return cont;
    }

    /**
     * Get the number of bit used by a generic int
     * @return
     */
    private int getIntegerBitCount() {
        int a = Integer.MAX_VALUE;

        int bit_count = 1;

        while(((a >>> 1) & 1) == 1) {
            a = a >>> 1;
            bit_count++;
        }
        System.out.println(bit_count+1);
        return bit_count+1;//+1 for sign bit
    }

    /**
     * Bit mask usage
     */
    private void bitMask() {
        // indices: 0, 1, 2 , ..., N
        // mapping between indices and mask value
        // 0 -> 2^0
        // 1 -> 2^1
        // ....
        // N -> 2^N

        // masks
        short AMMO = 1;
        short LIFE = 2;
        short FOOD = 4;
        short WATER = 8;
        short FANTASY = 16;
        short PANDORA = 32;
        short TRAVEL = 64;

        // let's create a 32 bit bit mask
        int bitMask = 0; // set all bit to 0

        // if we want to raise the flag at position 1
        bitMask = bitMask | LIFE;

        // if we want to raise the flag at position 3
        bitMask = bitMask | WATER;

        // if we want to raise the flag at position 4
        bitMask = bitMask | FANTASY;

        // if we want to raise multiple flags
        bitMask = bitMask | AMMO | PANDORA | TRAVEL | FOOD; // we set to 1 indices 0, 5, 6

        System.out.println("Bitmask before unset:" + bitMask);

        // if we want to unflag indices
        bitMask &= ~(AMMO | LIFE | WATER | FANTASY | PANDORA | TRAVEL | FOOD);

        System.out.println("Bitmask after unset:" + bitMask);
    }
}
