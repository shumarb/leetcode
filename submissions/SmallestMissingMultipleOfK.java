// Question: https://leetcode.com/problems/smallest-missing-multiple-of-k/description/

class SmallestMissingMultipleOfK {
    public int missingMultiple(int[] nums, int k) {
        boolean[] isPresent = new boolean[101];
        boolean isTest = false;
        int key = k;

        for (int number: nums) {
            isPresent[number] = true;
        }
        while (key <= 100 && isPresent[key]) {
            if (isTest) {
                System.out.println(" * key: " + key);
            }
            key += k;
        }
        if (isTest) {
            System.out.println(" * key: " + key);
        }

        return key;
    }
}