package xyz.basalto.string;

public class IsSubsequence {

    public boolean isSubsequence(String subsequence, String reference) {
        if (subsequence == null || reference == null) return false;
        if (subsequence.isEmpty()) return true;

        int subsequenceIndex  = 0;
        int referenceIndex = 0;

        while (subsequenceIndex < subsequence.length() && referenceIndex < reference.length()) {
            if (subsequence.charAt(subsequenceIndex) == reference.charAt(referenceIndex)) {
                subsequenceIndex++;
            }
            referenceIndex++;
        }

        return subsequenceIndex == subsequence.length();
    }

}
