// Question: https://leetcode.com/problems/k-divisible-elements-subarrays/description/

class KDivisibleElementsSubarrays {
    public int countDistinct(int[] nums, int k, int p) {
        Set<String> set = new HashSet<>();
        boolean isTest = false;
        int n = nums.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] % p == 0) {
                    count++;
                }
                if (count > k) {
                    break;
                }

                String key = Arrays.toString(Arrays.copyOfRange(nums, i, j + 1));
                if (set.add(key)) {
                    if (isTest) {
                        System.out.println(" * valid: " + key);
                    }
                    result++;
                }
            }
        }
        if (isTest) {
            System.out.println("--------------------------------------------\nset: " + set + "\nresult: " + result);
        }

        return result;
    }
}