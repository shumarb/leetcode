// Question: https://leetcode.com/problems/lexicographically-smallest-string-after-a-swap/description/

class LexicographicallySmallestStringAfterASwap {
    public String getSmallestString(String s) {
        boolean isTest = false;
        String result = s;
        char[] numbers = s.toCharArray();

        for (int i = 0; i < s.length() - 1; i++) {
            char[] clone = numbers.clone();

            int current = s.charAt(i) - '0';
            int next = s.charAt(i + 1) - '0';
            if (isSameParity(current, next)) {
                char temp = clone[i];
                clone[i] = clone[i + 1];
                clone[i + 1] = temp;
                if (isTest) {
                    System.out.println(" * clone: " + Arrays.toString(clone) + ", result: " + result);
                }
                String newStr = new String(clone);
                if (newStr.compareTo(result) < 0) {
                    result = newStr;
                }
            }
        }

        return result;
    }

    private boolean isSameParity(int first, int second) {
        return first % 2 == second % 2;
    }
}