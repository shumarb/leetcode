// Question: https://leetcode.com/problems/minimum-window-substring/description/

class MinimumWindowSubstring {
    private int[] countT;

    public String minWindow(String s, String t) {
        countT = new int[52];
        int[] window = new int[52];
        int minWindowLength = Integer.MAX_VALUE;
        int minWindowStartIndex = -1;
        int left = 0;
        int n = s.length();

        for (char letter: t.toCharArray()) {
            int index = Character.isUpperCase(letter) ? letter - 'A' : 26 + letter - 'a';
            countT[index]++;
        }

        for (int right = 0; right < n; right++) {
            char letter = s.charAt(right);
            int index = Character.isUpperCase(letter) ? letter - 'A' : 26 + letter - 'a';
            window[index]++;

            while (isValid(window)) {
                int currentLength = right - left + 1;
                if (currentLength < minWindowLength) {
                    minWindowLength = currentLength;
                    minWindowStartIndex = left;
                }

                letter = s.charAt(left++);
                index = Character.isUpperCase(letter) ? letter - 'A' : 26 + letter - 'a';
                window[index]--;
            }
        }

        return minWindowStartIndex == -1 ? "" : s.substring(minWindowStartIndex, minWindowStartIndex + minWindowLength);
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