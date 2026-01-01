// Question: https://leetcode.com/problems/k-divisible-elements-subarrays/description/

class KDivisibleElementsSubarrays {
    public int countDistinct(int[] nums, int k, int p) {
        Set<String> set = new HashSet<>();
        boolean isTest = false;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            StringBuilder sub = new StringBuilder();
            int count = 0;

            for (int j = i; j < n; j++) {
                if (nums[j] % p == 0) {
                    count++;
                }
                if (count > k) {
                    break;
                }
                sub.append(nums[j]);
                sub.append(" ");
                if (set.add(sub.toString())) {
                    if (isTest) {
                        System.out.println(" * valid: " + sub.toString());
                    }
                }
            }
        }
        if (isTest) {
            System.out.println("--------------------------------------------\nset: " + set + "\nresult: " + set.size());
        }

        return set.size();
    }
}