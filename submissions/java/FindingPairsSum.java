// Question: https://leetcode.com/problems/finding-pairs-with-a-certain-sum/description/

class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        map = new HashMap<>();
        for (int number: nums2) {
            map.put(number, 1 + map.getOrDefault(number, 0));
        }
    }

    public void add(int index, int val) {
        int elementBeforeUpdate = nums2[index];

        // 1. Remove occurrences of previous value by 1
        int mapValue = map.get(elementBeforeUpdate);
        map.put(elementBeforeUpdate, map.get(elementBeforeUpdate) - 1);
        if (map.get(elementBeforeUpdate) == 0) {
            map.remove(elementBeforeUpdate);
        }

        // Increase number of times updatedElement appear in nums2 by 1
        nums2[index] += val;
        int updatedElement = nums2[index];
        map.put(updatedElement, 1 + map.getOrDefault(updatedElement, 0));
    }

    public int count(int tot) {
        /**
         nums1: [1, 1, 2, 2, 2, 3]
         nums2: [1, 4, 5, 2, 5, 4]
         map: {1 -> 1 | 2 -> 2 | 4 -> 2 | 5 -> 2}
         tot: 7 ==> indices (i, j): (2, 2), (2, 4), (3, 2), (3, 4), (4, 2), (4, 4), (5, 5)
         */
        int count = 0;
        for (int number: nums1) {
            int complement = tot - number;
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */