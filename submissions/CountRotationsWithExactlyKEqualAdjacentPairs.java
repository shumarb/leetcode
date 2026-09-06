// Question: https://leetcode.com/problems/count-rotations-with-exactly-k-equal-adjacent-pairs/description/

class CountRotationsWithExactlyKEqualAdjacentPairs {
    public int countRotations(String s, int k) {
        boolean isTest = false;
        int n = s.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            StringBuilder current = new StringBuilder();
            current.append(s.substring(i)).append(s.substring(0, i));
            char[] letters = current.toString().toCharArray();
            int score = 0;

            for (int j = 0; j < n - 1; j++) {
                if (letters[j] == letters[j + 1]) {
                    score++;
                }
            }
            if (score == k) {
                if (isTest) {
                    System.out.println(" * valid: " + current + " -> score: " + score);
                }

                result++;
            }
        }

        return result;
    }
}
