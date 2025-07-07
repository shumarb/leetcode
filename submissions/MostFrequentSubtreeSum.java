// Question: https://leetcode.com/problems/most-frequent-subtree-sum/description/

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
class MostFrequentSubtreeSum {
    private Map<Integer, Integer> map;
    private int countMaxFrequency;
    private int maxFrequency;

    public int[] findFrequentTreeSum(TreeNode root) {
        boolean isTest = false;
        int i = 0;
        int[] result;
        map = new HashMap<>();
        countMaxFrequency = 0;
        maxFrequency = 0;

        helper(root);
        result = new int[countMaxFrequency];
        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            if (e.getValue() == maxFrequency) {
                result[i++] = e.getKey();
            }
        }
        if (isTest) {
            System.out.println("map: " + map);
            System.out.println("countMaxFrequency: " + countMaxFrequency + "\nmaxFrequency: " + maxFrequency);
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = helper(node.left);
        int right = helper(node.right);
        int subtreeSum = node.val + left + right;

        map.put(subtreeSum, 1 + map.getOrDefault(subtreeSum, 0));
        int value = map.get(subtreeSum);
        if (value > maxFrequency) {
            maxFrequency = value;
            countMaxFrequency = 1;
        } else if (value == maxFrequency) {
            countMaxFrequency++;
        }

        return subtreeSum;
    }
}