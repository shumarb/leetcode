// Question: https://leetcode.com/problems/words-within-two-edits-of-dictionary/description/

class WordsWithinTwoEditsOfDictionary {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        boolean isTest = false;

        for (String query: queries) {
            for (String word: dictionary) {
                char[] queryLetters = query.toCharArray();
                char[] wordLetters = word.toCharArray();

                boolean isValid = true;
                int countLetterDifference = 0;
                for (int i = 0; i < wordLetters.length; i++) {
                    if (queryLetters[i] != wordLetters[i] && ++countLetterDifference > 2) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    if (isTest) {
                        System.out.println(" * valid: " + query);
                    }
                    result.add(query);
                    break;
                }
            }
        }
        if (isTest) {
            System.out.println("------------------\nresult: " + result);
        }

        return result;
    }
}
