// Question: https://leetcode.com/problems/permutations/description/

class Permutations {
    private List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        boolean isTest = false;
        result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            helper(new ArrayList<>(), i, nums, new HashSet<Integer>(), nums.length);
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("----------------------------\nresult:");
            for (List<Integer> list: result) {
                System.out.println(list);
            }
        }

        return result;
    }

    private void helper(List<Integer> path, int index, int[] nums, HashSet<Integer> isIndexVisited, int k) {
        /**
         1.  Mark current index as visited
             and add its element to path.
         */
        isIndexVisited.add(index);
        path.add(nums[index]);

        // 2. Valid permutation formed.
        if (isIndexVisited.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        /**
         3.  Explore remaining unvisited numbers until permutation formed,
             then backtrack to form another permutation (variation of current path).
         */
        for (int i = 0; i < nums.length; i++) {
            if (!isIndexVisited.contains(i)) {
                helper(path, i, nums, isIndexVisited, k);
                isIndexVisited.remove(i);
                path.removeLast();
            }
        }
    }
}