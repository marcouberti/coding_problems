package mix;

public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber().letterToInt('z'));
    }

    public int titleToNumber(String s) {
        if(s == null || s.length() == 0) return 0;
        s = s.toLowerCase();

        int number = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int multiplier = s.length() - 1 - i;
            number += (26*multiplier)*letterToInt(c);
        }

        return number;
    }

    private int letterToInt(char c) {
        return c - 'a' + 1;
    }
}
