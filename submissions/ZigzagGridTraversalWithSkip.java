// Question: https://leetcode.com/problems/zigzag-grid-traversal-with-skip/description/

class ZigzagGridTraversalWithSkip {
    private boolean t = false;

    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> ans = new ArrayList<> ();

        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            update(i, row, ans);
        }

        if (t) {
            System.out.println("final ans: " + ans);
        }
        return ans;
    }

    private void update(int rowNum, int[] arr, List<Integer> ans) {
        if (t) {
            System.out.println("arr: " + Arrays.toString(arr));
        }
        if (rowNum % 2 == 0) {
            for (int i = 0; i < arr.length; i += 2) {
                if (t) {
                    System.out.println("adding: " + arr[i] + " | index: " + i);
                }
                ans.add(arr[i]);
            }
        } else {
            int start = arr.length - 2;
            if (arr.length % 2 == 0) {
                start = arr.length - 1;
            }
            for (int i = start; i >= 0; i -= 2) {
                if (t) {
                    System.out.println("adding: " + arr[i] + " | index: " + i);
                }
                ans.add(arr[i]);
            }
        }
    }
}