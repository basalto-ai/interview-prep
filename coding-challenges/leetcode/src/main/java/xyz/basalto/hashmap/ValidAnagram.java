package xyz.basalto.hashmap;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> countMap = new HashMap<>();

        // Count characters from s
        for (char ch : s.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        // Subtract counts using t
        for (char ch : t.toCharArray()) {
            if (!countMap.containsKey(ch)) {
                return false;
            }
            countMap.put(ch, countMap.get(ch) - 1);
            if (countMap.get(ch) == 0) {
                countMap.remove(ch);
            }
        }

        return countMap.isEmpty();
    }

}
