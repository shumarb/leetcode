// Question: https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/description/

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
class SumOfRootToLeafBinaryNumber {
    private boolean isTest = false;
    private int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        traverse(root, new StringBuilder());
        if (isTest) {
            System.out.println("------------------------------");
            System.out.println("sum: " + sum);
        }

        return sum;
    }

    private void traverse(TreeNode node, StringBuilder path) {
        if (node == null) {
            return;
        }

        int len = path.length();
        path.append(node.val);

        if (node.left == null && node.right == null) {
            int value = computeSum(path.toString());
            if (isTest) {
                System.out.println(" * root-to-leaf path: " + path + " -> value: " + value);
            }
            sum += value;
        } else {
            traverse(node.left, path);
            traverse(node.right, path);
        }

        path.setLength(len);
    }

    private int computeSum(String binary) {
        double power = 0;
        double sum = 0;
        int i = binary.length() - 1;

        while (i >= 0) {
            if (binary.charAt(i) == '1') {
                sum += Math.pow(2.0, power);
            }
            i--;
            power++;
        }

        return (int) sum;
    }
}