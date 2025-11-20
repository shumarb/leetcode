// Question: https://leetcode.com/problems/minimum-window-substring/description/

class MinimumWindowSubstring {
    private int[] countT;

    public String minWindow(String s, String t) {
        String result = "";
        int[] countS = new int[52];
        int left = 0;
        int n = s.length();
        countT = new int[52];

        for (char letter: t.toCharArray()) {
            int index = Character.isUpperCase(letter) ? letter - 'A' : 26 + letter - 'a';
            countT[index]++;
        }

        for (int right = 0; right < n; right++) {
            char letter = s.charAt(right);
            int index = Character.isUpperCase(letter) ? letter - 'A' : 26 + letter - 'a';
            countS[index]++;

            while (isValid(countS)) {
                String current = s.substring(left, right + 1);
                if (result.isEmpty() || current.length() < result.length() || current.length() == result.length() && current.compareTo(result) < 0) {
                    result = current;
                }

                letter = s.charAt(left++);
                index = Character.isUpperCase(letter) ? letter - 'A' : 26 + letter - 'a';
                countS[index]--;
            }
        }

        return result;
    }

    private boolean isValid(int[] countS) {
        for (int i = 0; i < countT.length; i++) {
            if (countT[i] == 0) {
                continue;
            }
            if (countT[i] > countS[i]) {
                return false;
            }
        }

        return true;
    }
}