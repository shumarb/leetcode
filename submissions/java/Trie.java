// Question: https://leetcode.com/problems/implement-trie-prefix-tree/description/

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char letter: word.toCharArray()) {
            int index = letter - 'a';
            if (node.getChildren()[index] == null) {
                node.getChildren()[index] = new TrieNode();
            }
            node = node.getChildren()[index];
        }
        node.setAsEnd();

    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char letter: word.toCharArray()) {
            int index = letter - 'a';
            if (node.getChildren()[index] == null) {
                return false;
            }
            node = node.getChildren()[index];
        }
        return node.getIsEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char letter: prefix.toCharArray()) {
            int index = letter - 'a';
            if (node.getChildren()[index] == null) {
                return false;
            }
            node = node.getChildren()[index];
        }
        return true;
    }
}

class TrieNode {
    // 1. Represents each letter of the alphabet.
    private TrieNode[] children;

    // 2. Indicates that TrieNode represents last character of a string.
    private boolean isEnd;

    public TrieNode() {
        children = new TrieNode[26];
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public boolean getIsEnd() {
        return isEnd;
    }

    public void setAsEnd() {
        isEnd = true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */