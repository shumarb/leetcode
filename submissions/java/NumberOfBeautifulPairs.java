// Question: https://leetcode.com/problems/number-of-beautiful-pairs/description/

class NumberOfBeautifulPairs {
    public int countBeautifulPairs(int[] nums) {
        int countBeautifulPairs = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int first = nums[i];
                while (first >= 10) {
                    first /= 10;
                }
                if (gcd(first, nums[j] % 10) == 1) {
                    countBeautifulPairs++;
                }
            }
        }
        return countBeautifulPairs;
    }

    private int gcd(int first, int second) {
        while (second != 0) {
            int temp = second;
            second = first % second;
            first = temp;
        }
        return first;
    }
}