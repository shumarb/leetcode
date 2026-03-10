// Question: https://leetcode.com/problems/create-binary-tree-from-descriptions/description/

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
class CreateBinaryTreeFromDescriptions {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        TreeNode root = null;
        boolean[] isChild;
        boolean isTest = false;
        int largest = 0;

        for (int[] row: descriptions) {
            largest = Math.max(largest, Math.max(row[0], row[1]));
        }
        isChild = new boolean[largest + 1];

        for (int[] row: descriptions) {
            int child = row[1];
            int isLeft = row[2];
            int parent = row[0];
            if (isTest) {
                System.out.println(" * parent: " + parent + " | child: " + child + " | isLeft: " + isLeft);
            }

            TreeNode childNode = map.getOrDefault(child, new TreeNode(child));
            TreeNode parentNode = map.getOrDefault(parent, new TreeNode(parent));
            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            map.put(child, childNode);
            map.put(parent, parentNode);
            isChild[child] = true;
        }
        if (isTest) {
            System.out.println("---------------------------------------\nmap:");
            for (Map.Entry<Integer, TreeNode> e: map.entrySet()) {
                System.out.print(" * " + e.getKey());

                TreeNode node = e.getValue();
                if (node.left != null) {
                    System.out.print(" | left: " + node.left.val);
                } else {
                    System.out.print(" | left: null ");
                }
                if (node.right != null) {
                    System.out.println(" | right: " + node.right.val);
                } else {
                    System.out.println(" | right: null ");
                }
            }
        }

        for (int[] row: descriptions) {
            if (!isChild[row[0]]) {
                root = map.get(row[0]);
                break;
            }
        }
        if (isTest) {
            System.out.println("---------------------------------------\nisChild: " + Arrays.toString(isChild) + "\nroot: " + root.val);
        }

        return root;
    }
}