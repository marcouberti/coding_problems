package mix;

public class Reverse {
    public int reverse(int x) {
        boolean negative = x < 0;
        if(negative) x = -x;

        int reversed = 0;
        while(x > 0) {

            if(reversed > (Integer.MAX_VALUE - (x % 10))/10) return 0;

            reversed = 10*reversed + (x % 10);
            x /= 10;
        }

        return negative?-reversed:reversed;
    }
}
