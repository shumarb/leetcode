// Question: https://leetcode.com/problems/count-subarrays-with-k-distinct-integers/description/

class CountSubarraysWithKDistinctIntegers {
    public long countSubarrays(int[] nums, int k, int m) {
        boolean isTest = false;
        int[] count = new int[100001];
        int countDistinct = 0;
        int countValid = 0;
        int left = 0;
        int n = nums.length;
        int prefixCount = 0; // number of all possible starting positions that satisfy countValid >= m
        long result = 0;

        if (isTest) {
            System.out.println("k: " + k + "\nm: " + m + "\nnums: " + Arrays.toString(nums) + "\n-------------------------------------------------------------------------");
        }
        for (int right = 0; right < n; right++) {
            int incoming = nums[right];

            if (++count[incoming] == 1) {
                countDistinct++;
            }
            if (count[incoming] == m) {
                countValid++;
            }

            while (countDistinct > k) {
                int remove = nums[left++];

                if (count[remove]-- == m) {
                    countValid--;
                }
                if (count[remove] == 0) {
                    countDistinct--;
                }

                prefixCount = 0;
            }

            while (countDistinct == k && count[nums[left]] > m) {
                int remove = nums[left++];
                if (count[remove]-- == m) {
                    countValid--;
                }

                prefixCount++;
            }

            if (countDistinct == k && countValid == k) {
                if (isTest) {
                    System.out.println(" * indices: [" + left + ", " + right + "] | prefixCount: " + prefixCount + " | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)));
                }

                result += 1 + prefixCount;
            }
        }
        if (isTest) {
            System.out.println("-------------------------------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
