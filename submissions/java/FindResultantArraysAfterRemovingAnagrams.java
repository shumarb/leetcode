// Question: https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/description/

class FindResultantArraysAfterRemovingAnagrams {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String previousSorted = sortLetters(words[0]);
        boolean isTest = false;

        result.add(words[0]);
        if (isTest) {
            System.out.println("word: " + words[0] + " --> previousSorted: " + previousSorted);
        }
        for (int i = 1; i < words.length; i++) {
            String current = words[i];
            String currentSorted = sortLetters(current);
            if (!currentSorted.equals(previousSorted)) {
                result.add(current);
                previousSorted = currentSorted;
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------");
            System.out.println("result: " + result);
        }

        return result;
    }

    private String sortLetters(String word) {
        char[] letters = word.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }
}