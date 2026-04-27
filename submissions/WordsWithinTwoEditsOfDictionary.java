// Question: https://leetcode.com/problems/words-within-two-edits-of-dictionary/description/

class WordsWithinTwoEditsOfDictionary {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        boolean isTest = false;

        for (String query: queries) {
            for (String word: dictionary) {

                int countLetterDifference = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (query.charAt(i) != word.charAt(i) && ++countLetterDifference > 2) {
                        break;
                    }
                }
                if (countLetterDifference <= 2) {
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
