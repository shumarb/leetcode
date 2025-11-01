// Question: https://leetcode.com/problems/combination-sum/description/

class CombinationSum {
    private List<List<Integer>> result;
    private boolean isTest;
    private int[] candidates;
    private int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        isTest = false;
        result = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;

        helper(new ArrayList<>(), 0, 0);
        if (isTest) {
            System.out.println("--------------------------------------------\nresult:");
            for (List<Integer> e: result) {
                System.out.println(" * " + e);
            }
        }

        return result;
    }

    private void helper(List<Integer> list, int sum, int i) {
        if (isTest) {
            System.out.println("--------------------------------------------\nlist: " + list + ", sum: " + sum);
        }

        if (sum > target) {
            return;

        } else if (sum == target) {
            if (isTest) {
                System.out.println(" * add: " + list);
            }
            result.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            list.add(candidates[j]);
            helper(list, sum + candidates[j], j);
            list.removeLast();
        }
    }
}