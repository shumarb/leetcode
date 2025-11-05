// Question: https://leetcode.com/problems/find-missing-elements/description/

class FindMissingElements {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        boolean[] isPresent;
        int largest = nums[0];
        int smallest = nums[0];

        for (int i = 1; i < nums.length; i++) {
            largest = Math.max(largest, nums[i]);
            smallest = Math.min(smallest, nums[i]);
        }
        isPresent = new boolean[largest + 1];
        for (int e: nums) {
            isPresent[e] = true;
        }

        for (int i = smallest; i <= largest; i++) {
            if (!isPresent[i]) {
                result.add(i);
            }
        }

        return result;
    }
}