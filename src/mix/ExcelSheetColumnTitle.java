package mix;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {

        StringBuffer result = new StringBuffer();

        while(n > 26) {
            result.append(intToLetter(n % 26));
            if(n % 26 == 0) n -=1;
            n /= 26;
        }

        result.append(n);

        return result.reverse().toString();
    }

    private char intToLetter(int n) {
        if(n == 0) return 'Z';
        else return (char)('A' + 1 + n);
    }
}
