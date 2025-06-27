// Question: https://leetcode.com/problems/smallest-string-starting-from-leaf/description/

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
class SmallestStringStartingFromLeaf {
    private String result = "";
    private boolean isTest = false;

    public String smallestFromLeaf(TreeNode root) {
        findSmallestFromLeaf(root, new StringBuilder());
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }

    private void findSmallestFromLeaf(TreeNode current, StringBuilder rootToLeaf) {
        if (current == null) {
            return;
        }

        int len = rootToLeaf.length();
        rootToLeaf.append((char) ('a' + current.val));

        /**
         1.  String from root to leaf formed,
             compare result with reverse of this string and up,
             and update result accordingly.
         */
        if (current.left == null && current.right == null) {
            String leafToRoot = rootToLeaf.reverse().toString();

            // 2. Reverse rootToLeaf because when creating leaftToRoot, rootToLeaf was reversed.
            rootToLeaf.reverse();

            if (isTest) {
                System.out.println(" * rootToLeaf: " + rootToLeaf + " -> leafToRoot: " + leafToRoot);
                System.out.println(" * before, result: " + result);
            }
            if (result.length() == 0 || leafToRoot.compareTo(result) < 0) {
                result = leafToRoot;
            }
            if (isTest) {
                System.out.println(" * after, result: " + result);
                System.out.println("-----------------------------------------------------------");
            }
        }

        /**
         3.  Leaf not reached, so continue traverse its left and right children (if any)
             until leaf is reached, then backtrack set rootToLeaf to its state before the traversal.
         */
        findSmallestFromLeaf(current.left, rootToLeaf);
        findSmallestFromLeaf(current.right, rootToLeaf);
        rootToLeaf.setLength(len);
    }
}