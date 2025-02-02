// Question: https://leetcode.com/problems/find-words-containing-character/description/

class FindWordsContainingCharacter {
    public List<Integer> findWordsContaining(String[] words, char x) {
        String xStr = Character.toString(x);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(xStr)) {
                result.add(i);
            }
        }
        return result;
    }
}