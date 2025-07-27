package xyz.basalto.hashmap;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] letterCount = new int[26];

        for (char ch: magazine.toCharArray()){
            letterCount[ch - 'a']++;
        }

        for (char ch: ransomNote.toCharArray()) {
            int index = ch - 'a';
            if (letterCount[index] == 0) {
                return false;
            }
            letterCount[index]--;
        }
        return true;
    }
}
