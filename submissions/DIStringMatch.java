// Question: https://leetcode.com/problems/di-string-match/description/

class DIStringMatch {
    public int[] diStringMatch(String s) {
        boolean isTest = false;
        int index = 0;
        int leftValue = 0;
        int n = s.length();
        int rightValue = n;
        int[] result = new int[n + 1];

        for (char c: s.toCharArray()) {
            result[index++] = c == 'I' ? leftValue++ : rightValue--;
        }
        result[index] = leftValue;
        if (isTest) {
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}