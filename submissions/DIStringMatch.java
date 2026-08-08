// Question: https://leetcode.com/problems/di-string-match/description/

class DIStringMatch {
    public int[] diStringMatch(String s) {
        boolean isTest = false;
        int index = 0;
        int leftValue = 0;
        int n = s.length();
        int rightValue = n;
        int[] result = new int[n + 1];
        boolean[] isUsed = new boolean[n + 1];

        for (char c: s.toCharArray()) {
            if (c == 'I') {
                result[index++] = leftValue;
                isUsed[leftValue++] = true;
            } else {
                result[index++] = rightValue;
                isUsed[rightValue--] = true;
            }
        }
        for (int i = 0; i < isUsed.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                result[n] = i;
                break;
            }
        }
        if (isTest) {
            System.out.println("result: " + Arrays.toString(result) + "\nisUsed: " + Arrays.toString(isUsed));
        }

        return result;
    }
}
