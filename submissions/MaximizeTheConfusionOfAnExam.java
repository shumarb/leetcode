// Question: https://leetcode.com/problems/maximize-the-confusion-of-an-exam/description/

class MaximizeTheConfusionOfAnExam {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] letters = answerKey.toCharArray();

        return Math.max(getLongest(letters, k, 'T'), getLongest(letters, k, 'F'));
    }

    private int getLongest(char[] letters, int k, char letter) {
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
                char remove = letters[left++];
                if (remove != letter) {
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
