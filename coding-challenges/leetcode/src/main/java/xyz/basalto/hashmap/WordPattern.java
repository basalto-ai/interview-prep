package xyz.basalto.hashmap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++){
            char patternChar = pattern.charAt(i);
            String word = words[i];

            // check char -> word mapping
            if(charToWord.containsKey(patternChar)) {
                if(!charToWord.get(patternChar).equals(word)) return false;
            } else {
                charToWord.put(patternChar, word);
            }

            if (wordToChar.containsKey(word)) {
                if (!wordToChar.get(word).equals(patternChar)) return false;
            } else {
                wordToChar.put(word, patternChar);
            }
        }

        return true;
    }
}
