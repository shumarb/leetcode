// Question: https://leetcode.com/problems/smallest-missing-multiple-of-k/description/

class SmallestMissingMultipleOfK {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        boolean isTest = false;
        int key = k;

        for (int number: nums) {
            set.add(number);
        }
        while (set.contains(key)) {
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