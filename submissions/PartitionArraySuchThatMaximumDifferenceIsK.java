// Question: https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/description/

class PartitionArraySuchThatMaximumDifferenceIsK {
    public int partitionArray(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        boolean isTest = false;
        int result = 0;

        sort(nums);
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums) + ", k: " + k);
            System.out.println("---------------------------------------------------");
        }

        for (int e: nums) {
            map.merge(e, 1, Integer::sum);

            int maximum = map.lastKey();
            int minimum = map.firstKey();

            if (maximum - minimum > k) {
                map.remove(e);
                if (isTest) {
                    System.out.println(" * valid partition: " + map);
                }
                result++;

                map.clear();
                map.merge(e, 1, Integer::sum);
            }
        }
        if (!map.isEmpty()) {
            if (isTest) {
                System.out.println(" * valid partition: " + map);
            }

            result++;
        }
        if (isTest) {
            System.out.println("---------------------------------------------------\nresult: " + result);
        }

        return result;
    }

    private void sort(int[] nums) {
        int[] count = new int[100001];
        int j = 0;
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int e: nums) {
            count[e]++;
            largest = Math.max(e, largest);
            smallest = Math.min(e, smallest);
        }

        for (int i = smallest; i <= largest; i++) {
            while (count[i]-- > 0) {
                nums[j++] = i;
            }
        }
    }
}
