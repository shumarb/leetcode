// Question: https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/description/

class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    private boolean isTest;
    private int result;

    public int maxLength(List<String> arr) {
        isTest = false;
        result = 0;

        helper(new StringBuilder(), 0, arr);
        if (isTest) {
            System.out.println("---------------------------\nresult: " + result);
        }

        return result;
    }

    private void helper(StringBuilder current, int i, List<String> arr) {
        if (isTest) {
            System.out.println("---------------------------\ncurrent: " + current);
        }

        if (isValid(current.toString())) {
            if (isTest) {
                System.out.println(" * valid: " + current.toString());
            }
            if (current.toString().length() > result) {
                if (isTest) {
                    System.out.println(" ** longest: " + current.toString().length());
                }
                result = current.toString().length();
            }
        }

        for (int j = i; j < arr.size(); j++) {
            String incoming = arr.get(j);
            int len = current.length();
            current.append(incoming);
            if (isValid(current.toString())) {
                helper(current, j + 1, arr);
            }
            current.setLength(len);
        }
    }

    private boolean isValid(String s) {
        boolean[] isPresent = new boolean[26];

        for (char c: s.toCharArray()) {
            if (isPresent[c - 'a']) {
                return false;
            }
            isPresent[c - 'a'] = true;
        }

        return true;
    }
}