// Question: https://leetcode.com/problems/random-pick-index/description/

class RandomPickIndex {
    private Map<Integer, List<Integer>> map;
    private Random random;

    public RandomPickIndex(int[] nums) {
        map = new HashMap<>();
        random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                map.get(key).add(i);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                map.put(key, indices);
            }
        }
    }

    public int pick(int target) {
        List<Integer> indices = map.get(target);
        if (indices.size() == 1) {
            return indices.get(0);
        }

        int randomIndex = random.nextInt(0, indices.size());
        return indices.get(randomIndex);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */