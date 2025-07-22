// Question: https://leetcode.com/problems/permutations/description/

class Permutations {
    private List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            helper(new ArrayList<>(), i, nums, new boolean[n]);
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

    private void helper(List<Integer> path, int index, int[] nums, boolean[] isVisited) {
        /**
         1.  Mark current index as visited
         and add its element to path.
         */
        isVisited[index] = true;
        path.add(nums[index]);

        // 2. Valid permutation formed.
        if (isValidPermutation(isVisited)) {
            result.add(new ArrayList<>(path));
            return;
        }

        /**
         3.  Explore remaining unvisited numbers until permutation formed,
         then backtrack to form alternative permutations.
         */
        for (int i = 0; i < nums.length; i++) {
            if (!isVisited[i]) {
                helper(path, i, nums, isVisited);
                isVisited[i] = false;
                path.removeLast();
            }
        }
    }

    private boolean isValidPermutation(boolean[] isVisited) {
        for (int i = 0; i < isVisited.length; i++) {
            if (!isVisited[i]) {
                return false;
            }
        }

        return true;
    }
}