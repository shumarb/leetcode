// Question: https://leetcode.com/problems/unique-morse-code-words/description/

class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        // 1. 1 unique combination if total words is 1.
        if (words.length == 1) {
            return 1;
        }

        Set<String> morseCodes = new HashSet<>();
        for (String word: words) {
            morseCodes.add(getMorseCode(word));
        }

        return morseCodes.size();
    }

    private String getMorseCode(String word) {
        StringBuilder result = new StringBuilder();
        String[] morseCodes = new String[] {
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };

        for (char letter: word.toCharArray()) {
            result.append(morseCodes[letter - 'a']);
        }

        return result.toString();
    }
}