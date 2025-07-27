package xyz.basalto.string;

public class IntegerToRomanConverter {

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length && num > 0; i++) {
            int currentValue = values[i];
            while (num >= currentValue) {
                roman.append(numerals[i]);
                num -= values[i];
            }
        }

        return roman.toString();
    }

}
