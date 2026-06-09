// Question: https://leetcode.com/problems/set-mismatch/description/

class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] count = new int[10001];
        int first = -1;
        int second = -1;

        for (int e: nums) {
            count[e]++;
        }
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 2) {
                first = i;
            } else if (count[i] == 0) {
                second = i;
            }

            if (first != -1 && second != -1) {
                return new int[] {first, second};
            }
        }

        return new int[2];
    }
}
