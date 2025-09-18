// Question: https://leetcode.com/problems/print-words-vertically/description/

class PrintWordsVertically {
    public List<String> printVertically(String s) {
        List<String> result = new ArrayList<>();
        String[] words = s.split(" ");
        boolean isTest = false;
        int longest = 0;

        for (String word: words) {
            longest = Math.max(longest, word.length());
        }
        for (int i = 0; i < longest; i++) {
            StringBuilder current = new StringBuilder();
            for (String word: words) {
                char c = i < word.length() ? word.charAt(i) : ' ';
                current.append(c);
            }
            while (s.length() > 0 && current.charAt(current.length() - 1) == ' ') {
                current.deleteCharAt(current.length() - 1);
            }
            result.add(current.toString());
        }
        if (isTest) {
            System.out.println("words: " + Arrays.toString(words));
            System.out.println("longest: " + longest + "\nresult: " + result);
        }

        return result;
    }
}