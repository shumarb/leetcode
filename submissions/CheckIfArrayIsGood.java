// Question: https://leetcode.com/problems/check-if-array-is-good/description/

class CheckIfArrayIsGood {
    public boolean isGood(int[] nums) {
        boolean isTest = false;
        int[] count;
        int largest = 0;

        for (int e: nums) {
            largest = Math.max(e, largest);
        }
        count = new int[largest + 1];
        for (int e: nums) {
            count[e]++;
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\ncount: " + Arrays.toString(count));
        }

        if (count[largest] != 2) {
            return false;
        }
        for (int i = 1; i < largest; i++) {
            if (count[i] != 1) {
                return false;
            }
        }

        return true;
    }
}
