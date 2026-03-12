// Question: https://leetcode.com/problems/implement-magic-dictionary/description/

class MagicDictionary {
    private HashSet<String> set;
    private boolean isTest;

    public MagicDictionary() {
        isTest = false;
        set = new HashSet<>();
    }

    public void buildDict(String[] dictionary) {
        for (String word: dictionary) {
            set.add(word);
        }
    }

    public boolean search(String searchWord) {
        if (isTest) {
            System.out.println("set: " + set + "\nsearchWord: " + searchWord);
        }

        for (String word: set) {
            if (word.length() != searchWord.length()) {
                continue;
            }
            char[] first = word.toCharArray();
            char[] second = searchWord.toCharArray();
            int countDifferentLettersAtIndex = 0;

            for (int i = 0; i < first.length; i++) {
                if (first[i] != second[i] && ++countDifferentLettersAtIndex > 1) {
                    break;
                }
            }
            if (countDifferentLettersAtIndex == 1) {
                return true;
            }
        }

        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */