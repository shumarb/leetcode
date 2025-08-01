// Question: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerializeAndDeserializeBinaryTree {
    private boolean isTest = false;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 1. Edge case: Empty tree.
        if (root == null) {
            return "";
        }

        List<String> list = new ArrayList<>();
        String result;

        serialize(root, list);
        result = String.join(" ", list);
        if (isTest) {
            System.out.println("list: " + list + "\nresult: " + result);
        }

        return result;
    }

    private void serialize(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("null");
            return;
        }

        list.add(Integer.toString(node.val));
        serialize(node.left, list);
        serialize(node.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 2. Edge case: Empty string, hence empty tree.
        if (data.isEmpty()) {
            return null;
        }

        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(" ")));
        if (isTest) {
            System.out.println("----------------------\nqueue: " + queue);
        }

        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }

        String top = queue.poll();
        if (top.equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(top));
        root.left = deserialize(queue);
        root.right = deserialize(queue);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));