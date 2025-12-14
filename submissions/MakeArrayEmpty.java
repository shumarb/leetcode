// Question: https://leetcode.com/problems/make-array-empty/description/

class MakeArrayEmpty {
    public long countOperationsToEmptyArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean isTest = false;
        int n = nums.length;
        int value = 0;
        long result = n;

        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);

        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums) + "\nmap: " + map);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(nums[i]) < value) {
                result += (n - i);
            }
            value = map.get(nums[i]);
        }

        return result;
    }
}