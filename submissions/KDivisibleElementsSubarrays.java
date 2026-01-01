// Question: https://leetcode.com/problems/k-divisible-elements-subarrays/description/

class KDivisibleElementsSubarrays {
    public int countDistinct(int[] nums, int k, int p) {
        Set<String> set = new HashSet<>();
        boolean isTest = false;
        int n = nums.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int[] sub = Arrays.copyOfRange(nums, i, j + 1);
                String key = Arrays.toString(sub);
                if (!set.contains(key)) {
                    set.add(key);
                    if (isValid(sub, p, k)) {
                        if (isTest) {
                            System.out.println(" * valid: " + key);
                        }
                        result++;
                    }
                }
            }
        }
        if (isTest) {
            System.out.println("--------------------------------------------\nset: " + set + "\nresult: " + result);
        }

        return result;
    }

    private boolean isValid(int[] arr, int p, int k) {
        for (int e: arr) {
            if (e % p == 0) {
                if (--k < 0) {
                    return false;
                }
            }
        }

        return true;
    }
}