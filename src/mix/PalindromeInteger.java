package mix;

import java.util.LinkedList;

public class PalindromeInteger {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        LinkedList<Integer> list = new LinkedList<>();
        while(x != 0) {
            list.add(x % 10);
            x /= 10;
        }

        while(list.size() > 1) {
            int l = list.pollFirst();
            int r = list.pollLast();
            if(l != r) return false;
        }
        return true;
    }
}
