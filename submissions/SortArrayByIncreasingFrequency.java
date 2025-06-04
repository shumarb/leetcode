// Question: https://leetcode.com/problems/sort-array-by-increasing-frequency/description/

class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }

        int[] numberFrequency = new int[201];
        boolean isTest = false;

        if (isTest) {
            System.out.println("before, nums: " + Arrays.toString(nums));
        }
        for (int num: nums) {
            numberFrequency[num + 100]++;
        }

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (numberFrequency[nums[i] + 100] != 0) {
                list.add(new int[] {nums[i], numberFrequency[nums[i] + 100]});
                numberFrequency[nums[i] + 100] = 0;
            }
        }
        list.sort((a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        if (isTest) {
            System.out.println("list:");
            for (int[] entry: list) {
                System.out.println(" * " + entry[0] + " --> " + entry[1]);
            }
        }

        int k = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i)[1]; j++) {
                nums[k++] = list.get(i)[0];
            }
        }
        if (isTest) {
            System.out.println("after, nums: " + Arrays.toString(nums));
        }

        return nums;
    }
}