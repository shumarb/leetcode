// Question: https://leetcode.com/problems/combinations/description/

class Combinations {
    private List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        boolean[] isVisited = new boolean[n + 1];
        boolean isTest = false;
        isTest = false;
        result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!isVisited[i]) {
                helper(i, k, new ArrayList<>(), isVisited);
            }
        }
        if (isTest) {
            System.out.println("n: " + n + "\nk: " + k);
            System.out.println("----------------------------\nresult:");
            for (List<Integer> e: result) {
                System.out.println(e);
            }
        }

        return result;
    }

    private void helper(int i, int k, List<Integer> path, boolean[] isVisited) {
        isVisited[i] = true;
        path.add(i);

        // 1. Valid permutation created.
        if (path.size() == k) {
            result.add(new ArrayList<>(path));

        } else {
            /**
                2.  Explore current path until valid permutation formed.
             */
            for (int j = i + 1; j < isVisited.length; j++) {
                if (!isVisited[j]) {
                    helper(j, k, path, isVisited);
                }
            }
        }

        // 3. Backtrack to form alternative permutations of current path.
        isVisited[i] = false;
        path.removeLast();
    }
}