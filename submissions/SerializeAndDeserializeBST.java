// Question: https://leetcode.com/problems/serialize-and-deserialize-bst/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerializeAndDeserializeBST {
    private boolean isTest = false;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        serialize(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            result.append(list.get(i) + " ");
        }
        result.append(list.get(list.size() - 1));
        if (isTest) {
            System.out.println("list: " + list);
            System.out.println("result: " + result.toString());
        }

        return result.toString();
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
        if (data.isEmpty()) {
            return null;
        }

        Queue<String> queue = new LinkedList<>();
        for (String token: data.split(" ")) {
            queue.offer(token);
        }
        if (isTest) {
            System.out.println("-----------------------------------\nqueue: " + queue);
        }

        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }

        String current = queue.poll();
        if (current.equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(current));
        root.left = deserialize(queue);
        root.right = deserialize(queue);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;