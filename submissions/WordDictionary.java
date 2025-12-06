// Question: https://leetcode.com/problems/design-add-and-search-words-data-structure/description/

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char letter: word.toCharArray()) {
            TrieNode[] children = node.getChildren();
            if (children[letter - 'a'] == null) {
                children[letter - 'a'] = new TrieNode();
            }
            node = children[letter - 'a'];
        }

        // 1. Currently at last letter, so denote it as end of word.
        node.setIsEnd();
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, TrieNode node) {
        /**
         2.  Reached end of word, hence all letters in word exists in trie,
         so check if word exists in trie.
         */
        if (index == word.length()) {
            return node.getIsEnd();
        }

        char letter = word.charAt(index);
        TrieNode[] children = node.getChildren();

        /**
         3.  Search if at least 1 word from all possible words
         after replacing '.' with a letter in trie exists.
         */
        if (letter == '.') {
            for (TrieNode child: children) {
                /**
                 4. At least 1 word formed after replacing '.' with a letter in trie exists.
                 */
                if (child != null && search(word, index + 1, child)) {
                    return true;
                }
            }

            /**
             5. No word formed after replacing '.' with a letter in trie exists.
             */
            return false;

        } else {
            return children[letter - 'a'] != null && search(word, index + 1, children[letter - 'a']);
        }
    }
}

class TrieNode {
    private TrieNode[] children;
    private boolean isEnd;

    public TrieNode() {
        this.children = new TrieNode[26];
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public boolean getIsEnd() {
        return isEnd;
    }

    public void setIsEnd() {
        isEnd = true;
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */