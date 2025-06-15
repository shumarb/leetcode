// Question: https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/

class MaximumScoreAfterSplittingAString {
    public int maxScore(String s) {
        boolean isTest = false;
        int len = s.length();
        int maxScore = 0;
        int partition = 1;

        while (partition != len) {
            String left = s.substring(0, partition);
            String right = s.substring(partition, len);
            int countZeroesInLeft = count(left, '0');
            int countOnesInRight = count(right, '1');
            if (isTest) {
                System.out.println("partition: " + partition);
                System.out.println("left: " + left + ", right: " + right);
                System.out.println("countZeroesInLeft: " + countZeroesInLeft + ", countOnesInRight: " + countOnesInRight);
            }
            if (isTest) {
                System.out.println("compare | maxScore: " + maxScore + ", sum of counts: " + (countZeroesInLeft + countOnesInRight));
                System.out.print("before, maxScore: " + maxScore);
            }
            maxScore = Math.max(maxScore, countZeroesInLeft + countOnesInRight);
            if (isTest) {
                System.out.println(" | after, maxScore: " + maxScore);
                System.out.println("----------------------------------------------------");
            }

            partition++;
        }

        return maxScore;
    }

    private int count(String str, char c) {
        int count = 0;
        for (char letter: str.toCharArray()) {
            if (letter == c) {
                count++;
            }
        }
        return count;
    }
}