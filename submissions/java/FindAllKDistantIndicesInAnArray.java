// Question: https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/description/

class FindAllKDistantIndicesInAnArray {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();
        boolean[] isIndexPresent = new boolean[1001];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (!isIndexPresent[i] && Math.abs(i - j) <= k && nums[j] == key) {
                    isIndexPresent[i] = true;
                    result.add(i);
                }
            }
        }
        return result;
    }
}