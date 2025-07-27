package xyz.basalto.string;

import java.util.Map;

public class RomanToIntegerConverter {

    private final static Map<Character, Integer> ROMAN = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) return 0;

        int total = 0;
        int prev = 0;
        s = s.toUpperCase();

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            Integer current = ROMAN.get(c);

            if (current == null) {
                throw new IllegalArgumentException("Invalid Roman numeral character: " + c);
            }

            if (current < prev) {
                total -= current;
            } else {
                total += current;
                prev = current;
            }
        }

        return total;
    }

}
