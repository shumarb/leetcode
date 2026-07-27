// Question: https://leetcode.com/problems/maximize-the-confusion-of-an-exam/description/

class MaximizeTheConfusionOfAnExam {
    private char[] letters;

    public int maxConsecutiveAnswers(String answerKey, int k) {
        letters = answerKey.toCharArray();
        return Math.max(getLongest(k, 'T'), getLongest(k, 'F'));
    }

    private int getLongest(int k, char letter) {
        boolean isTest = false;
        int left = 0;
        int limit = k;
        int result = 0;

        if (isTest) {
            System.out.println("-----------------------------------------------------------\nletter: " + letter);
        }
        for (int right = 0; right < letters.length; right++) {
            char incoming = letters[right];

            if (incoming != letter) {
                limit--;
            }
            while (limit < 0) {
                if (letters[left++] != letter) {
                    limit++;
                }
            }
            if (isTest) {
                System.out.println(" * valid | indices: [" + left + ", " + right
                        + "] | limit: " + limit + " | length: " + (right - left + 1) + " | subarray: " + Arrays.toString(Arrays.copyOfRange(letters, left, right + 1)));
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
