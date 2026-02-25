// Question: https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree/description/

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
class ClosestNodeQueriesInABinarySearchTree {
    private List<List<Integer>> result;
    private boolean isTest;

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> inOrder = new ArrayList<>();
        isTest = false;
        result = new ArrayList<>();

        inOrder(root, inOrder);
        if (isTest) {
            System.out.println("inOrder: " + inOrder);
        }
        for (int key: queries) {
            if (isTest) {
                System.out.println("-----------------------------------------------------\nkey: " + key);
            }
            List<Integer> values = getValues(key, inOrder);
            if (isTest) {
                System.out.println(" ** values: " + values);
            }
            result.add(values);
        }
        if (isTest) {
            System.out.println("-----------------------------------------------------\nresult:");
            for (List<Integer> e: result) {
                System.out.println(" * " + e);
            }
        }

        return result;
    }

    private List<Integer> getValues(int key, List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        int largestValueSmallerOrEqualToKey = -1; // largest value <= key
        int left = 0;
        int right = list.size() - 1;
        int smallestValueLargerOrEqualToKey = -1; // smallest value >= key

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int current = list.get(mid);

            if (isTest) {
                System.out.println(" * mid: " + mid + " -> current: " + current);
            }
            if (current == key) {
                largestValueSmallerOrEqualToKey = current;
                smallestValueLargerOrEqualToKey = current;
                break;

            } else {
                if (current < key) {
                    /**
                     1.  Current could be largest element < key, so mark it as such.
                     We want to find element == key, so ignore all elements < key.
                     */
                    largestValueSmallerOrEqualToKey = current;
                    left = mid + 1;
                } else {

                    /**
                     2.  Current could be smallest element > key, so mark it as such.
                     We want to find element == key, so ignore all elements > key.
                     */
                    smallestValueLargerOrEqualToKey = current;
                    right = mid - 1;
                }
            }
        }
        result.add(largestValueSmallerOrEqualToKey);
        result.add(smallestValueLargerOrEqualToKey);

        return result;
    }

    private void inOrder(TreeNode node, List<Integer> inOrder) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            inOrder(node.left, inOrder);
        }
        inOrder.add(node.val);
        if(node.right != null) {
            inOrder(node.right, inOrder);
        }
    }
}