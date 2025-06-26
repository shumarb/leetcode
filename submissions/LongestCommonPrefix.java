// Question: https://leetcode.com/problems/longest-common-prefix/description/

class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String shortest = getShortest(strs);
        StringBuilder result = new StringBuilder();
        boolean isTest = false;

        for (int i = 0; i < shortest.length(); i++) {
            char letter = shortest.charAt(i);
            if (isCommonPrefix(i, letter, strs)) {
                result.append(letter);
            } else {
                break;
            }
        }
        if (isTest) {
            System.out.println("strs: " + Arrays.toString(strs));
            System.out.println("shortest: " + shortest);
            System.out.println("result: " + result.toString());
        }

        return result.toString();
    }

    private boolean isCommonPrefix(int i, char letter, String[] strs) {
        for (String str: strs) {
            if (str.charAt(i) != letter) {
                return false;
            }
        }
        return true;
    }

    private String getShortest(String[] arr) {
        String shortest = arr[0];
        for (String s: arr) {
            if (s.length() < shortest.length()) {
                shortest = s;
            }
        }
        return shortest;
    }
}