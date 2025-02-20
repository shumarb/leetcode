// Question: https://leetcode.com/problems/find-mode-in-binary-search-tree/description/

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
class FindModeInBinarySearchTree {
    private int maximumCount = Integer.MIN_VALUE;

    public int[] findMode(TreeNode root) {
        List<Integer> mode = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        boolean isTest = false;

        traverse(root, map);
        int size = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == maximumCount) {
                size++;
            }
        }
        if (isTest) {
            System.out.println("map: " + map + " | maximumCount: " + maximumCount + " | size: " + size);
        }

        int[] result = new int[size];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == maximumCount) {
                result[i++] = entry.getKey();
            }
        }
        if (isTest) {
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }

    private void traverse(TreeNode node, Map<Integer, Integer> map) {
        if (node != null) {
            map.put(node.val, 1 + map.getOrDefault(node.val, 0));
            maximumCount = Math.max(maximumCount, map.get(node.val));
            traverse(node.left, map);
            traverse(node.right, map);
        }
    }
}