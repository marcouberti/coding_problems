package mix;

public class ReverseString {

    public static void main(String[] args) {
        new ReverseString().reverseString(new char[]{'c','i','a','o'});
    }

    // Recursion
    public void reverseString(char[] s) {
        if(s == null) return;
        reverse(s, s.length - 1);
    }

    private void reverse(char[] s, int index) {
        if(index != 0) {
            char tmp = s[index];
            s[index] = s[s.length - index];
            s[s.length - index] = tmp;
        }
    }
}
