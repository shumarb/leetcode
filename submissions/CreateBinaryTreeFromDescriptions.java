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
        Set<Integer> nonRoots = new HashSet<>();
        TreeNode root = null;
        boolean isTest = false;

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
            nonRoots.add(child);
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
            System.out.println("---------------------------------------\nnonRoots: " + nonRoots);
        }

        for (int key: map.keySet()) {
            if (!nonRoots.contains(key)) {
                root = map.get(key);
                break;
            }
        }
        if (isTest) {
            System.out.println("root: " + root.val);
        }

        return root;
    }
}