// Question: https://leetcode.com/problems/minimum-window-substring/description/

class MinimumWindowSubstring {
    private int[] countT;

    public String minWindow(String s, String t) {
        countT = new int[52];
        char[] sLetters = s.toCharArray();
        int[] window = new int[52];
        int left = 0;
        int minimumWindowLength = Integer.MAX_VALUE;
        int minimumWindowStartIndex = -1;
        int n = sLetters.length;

        for (char letter: t.toCharArray()) {
            int index = letter >= 'A' && letter <= 'Z' ? letter - 'A' : 26 + letter - 'a';
            countT[index]++;
        }

        for (int right = 0; right < n; right++) {
            char letter = sLetters[right];
            int index = letter >= 'A' && letter <= 'Z' ? letter - 'A' : 26 + letter - 'a';
            window[index]++;

            while (isValid(window)) {
                int length = right - left + 1;
                if (length < minimumWindowLength) {
                    minimumWindowLength = length;
                    minimumWindowStartIndex = left;
                }

                letter = sLetters[left++];
                index = letter >= 'A' && letter <= 'Z' ? letter - 'A' : 26 + letter - 'a';
                window[index]--;
            }
        }

        return minimumWindowStartIndex == -1 ? "" : s.substring(minimumWindowStartIndex, minimumWindowStartIndex + minimumWindowLength);
    }

    private boolean isValid(int[] countS) {
        for (int i = 0; i < countT.length; i++) {
            if (countT[i] > countS[i]) {
                return false;
            }
        }

        return true;
    }
}
