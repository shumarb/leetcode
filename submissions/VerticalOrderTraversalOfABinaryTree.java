// Question: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private Map<Integer, List<int[]>> map;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        boolean isTest = false;
        map = new TreeMap<>();

        /**
         1.  Form treemap where keys are columns, and values are integer arrays of size 2:
         first element is row number, second element is node value.
         */
        dfs(root, 0, 0);
        if (isTest) {
            System.out.println("map:");
            for (Map.Entry<Integer, List<int[]>> e: map.entrySet()) {
                System.out.print(e.getKey() + " -> ");
                for (int[] val: e.getValue()) {
                    System.out.print(Arrays.toString(val) + " ");
                }
                System.out.println();
            }
        }

        /**
         2. For each key-value mapping, sort the value in ascending row number,
         followed by ascending node value.

         Form a new list and add the node values to the list after the sort above,
         then add the list to result.
         */
        for (Map.Entry<Integer, List<int[]>> e: map.entrySet()) {
            List<int[]> value = e.getValue();
            if (value.size() > 1) {
                value.sort(
                        (a, b) -> Integer.compare(a[0], b[0]) == 0
                                ? Integer.compare(a[1], b[1])
                                : Integer.compare(a[0], b[0])
                );
            }

            List<Integer> incoming = new ArrayList<>();
            for (int[] entry: value) {
                incoming.add(entry[1]);
            }
            result.add(incoming);
        }
        if (isTest) {
            System.out.println("----------------------------\nresult:");
            for (List<Integer> e: result) {
                System.out.println(" * " + e);
            }
        }

        return result;
    }

    private void dfs(TreeNode node, int row, int col) {
        if (node == null) {
            return;
        }

        if (!map.containsKey(col)) {
            List<int[]> val = new ArrayList<>();
            map.put(col, val);
        }

        map.get(col).add(new int[] {row, node.val});

        dfs(node.left, row + 1, col - 1);
        dfs(node.right, row + 1, col + 1);
    }
}