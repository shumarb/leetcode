// Question: https://leetcode.com/problems/sum-of-unique-elements/description/

class SumOfUniqueElements {
    public int sumOfUnique(int[] nums) {
        int[] count = new int[101];
        int result = 0;

        for (int e: nums) {
            count[e]++;
        }
        for (int i = 1; i <= 100; i++) {
            if (count[i] == 1) {
                result += i;
            }
        }

        return result;
    }
}
