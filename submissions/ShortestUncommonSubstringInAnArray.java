// Question: https://leetcode.com/problems/shortest-uncommon-substring-in-an-array/description/

class ShortestUncommonSubstringInAnArray {
    public String[] shortestSubstrings(String[] arr) {
        boolean isTest = false;
        int n = arr.length;
        String[] result = new String[n];

        Arrays.fill(result, "");
        for (int k = 0; k < n; k++) {
            String word = arr[k];
            if (isTest) {
                System.out.println("---------------------\nword: " + word);
            }

            char[] letters = word.toCharArray();
            for (int i = 0; i < letters.length; i++) {
                StringBuilder substring = new StringBuilder();
                for (int j = i; j < letters.length; j++) {
                    substring.append(letters[j]);
                    if (isTest) {
                        System.out.println(" * substring: " + substring);
                    }

                    String key = substring.toString();
                    boolean isUncommon = true;
                    if (isCommon(key, k, arr)) {
                        isUncommon = false;
                    }
                    if (isUncommon) {
                        if (result[k].equals("")
                                || key.length() < result[k].length()
                                || (key.length() == result[k].length() && key.compareTo(result[k]) < 0)) {
                            if (isTest) {
                                System.out.println(" ** valid: " + key);
                            }
                            result[k] = key;
                        }
                    }
                }
            }
        }

        return result;
    }

    private boolean isCommon(String key, int i, String[] arr) {
        for (int k = 0; k < arr.length; k++) {
            if (k == i) {
                continue;
            }
            if (arr[k].contains(key)) {
                return true;
            }
        }

        return false;
    }
}
