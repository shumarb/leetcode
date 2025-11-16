// Question: https://leetcode.com/problems/combination-sum-ii/description/

class CombinationSumTwo {
    private List<List<Integer>> result;
    private boolean isTest;
    private int[] candidates;
    private int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        isTest = false;
        result = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;

        candidates = sort(candidates);
        if (isTest) {
            System.out.println("sorted candidates: " + Arrays.toString(candidates));
        }

        helper(new ArrayList<>(), 0, 0);
        if (isTest) {
            System.out.println("----------------------------------------------------------\nresult:");
            for (List<Integer> e: result) {
                System.out.println(e);
            }
        }

        return result;
    }

    private void helper(List<Integer> list, int index, int sum) {
        if (isTest) {
            System.out.println("----------------------------------------------------------\nlist: " + list);
        }

        if (sum > target) {
            return;
        }

        if (sum == target) {
            if (isTest) {
                System.out.println(" ** added: " + list);
            }
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // 1. Skip duplicates to ensure unique element is used.
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            /**
             2.  Stop search if sum after adding current element exceeds target,
             because array is sorted, hence add elements after current element exceeds target.
             */
            int current = candidates[i];
            if (sum + current > target) {
                break;
            }

            /**
             3. Explore current path and backtrack.
             */
            list.add(current);
            helper(list, i + 1, sum + current);
            list.removeLast();
        }
    }

    private int[] sort(int[] candidates) {
        int[] count;
        int j = 0;
        int largest = candidates[0];

        for (int e: candidates) {
            largest = Math.max(e, largest);
        }
        count = new int[largest + 1];

        for (int e: candidates) {
            count[e]++;
        }

        for (int i = 1; i <= largest; i++) {
            while (count[i]-- > 0) {
                candidates[j++] = i;
            }
        }

        return candidates;
    }
}