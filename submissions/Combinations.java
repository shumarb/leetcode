// Question: https://leetcode.com/problems/combinations/description/

class Combinations {
    private List<List<Integer>> result;
    private int n;

    public List<List<Integer>> combine(int n, int k) {
        boolean isTest = false;
        result = new ArrayList<>();
        this.n = n;

        for (int i = 1; i <= n; i++) {
            helper(i, new ArrayList<>(), new boolean[n + 1], k);
        }
        if (isTest) {
            System.out.println("n: " + n + "\nk: " + k);
            System.out.println("-----------------------\nresult:");
            for (List<Integer> path: result) {
                System.out.println(" * " + path);
            }
        }

        return result;
    }

    private void helper(int i, List<Integer> path, boolean[] isVisited, int k) {
        path.add(i);
        isVisited[i] = true;

        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int j = i + 1; j <= n; j++) {
            if (!isVisited[j]) {
                /**
                 1.  Explore existing path if an unvisited number encountered
                     until a valid path is found, then backtrack to explore
                     remaining unvisited numbers.
                 */
                helper(j, path, isVisited, k);
                path.removeLast();
                isVisited[j] = false;
            }
        }
    }
}