package calculator;

public class Convertation {
    public static String arabicToRoman(int number) {
        int i = 0;
        RomanNumeral[] romanNums = RomanNumeral.values();
        StringBuilder sb = new StringBuilder();
        while ((number > 0) && (i < romanNums.length)){
            RomanNumeral current = romanNums[i];
            if (current.getValue() <= number) {
                sb.append(current.name());
                number -= current.getValue();
            }
            else {
                i++;
            }
        }
        return sb.toString();
    }
}

enum RomanNumeral {
    C(100), XC(90), L(50), XL(40),
    X(10), IX(9), V(5), IV(4), I(1);
    private int value;

    RomanNumeral(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}