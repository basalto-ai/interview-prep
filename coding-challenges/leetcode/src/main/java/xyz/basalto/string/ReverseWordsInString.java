package xyz.basalto.string;

public class ReverseWordsInString {

    public String reverseWords(String s) {
        if (s == null || s.isBlank()) return "";

        String[] words = s.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for(int i = words.length - 1; i >=0; i--){
                reversed.append(words[i]);
            if (i > 0) reversed.append(" ");
        }

        return reversed.toString();
    }
}
