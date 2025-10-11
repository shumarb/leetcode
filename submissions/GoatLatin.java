// Question: https://leetcode.com/problems/goat-latin/description/

class GoatLatin {
    public String toGoatLatin(String sentence) {
        StringBuilder result = new StringBuilder();
        String[] tokens = sentence.split(" ");
        boolean isTest = false;

        if (isTest) {
            System.out.println("tokens: " + Arrays.toString(tokens));
        }
        for (int i = 0; i < tokens.length; i++) {
            result.append(update(tokens[i], i));
            if (i != tokens.length - 1) {
                result.append(" ");
            }
        }
        if (isTest) {
            System.out.println("result: " + result.toString());
        }

        return result.toString();
    }

    private String update(String word, int i) {
        StringBuilder result = new StringBuilder();

        if (isVowel(word.charAt(0))) {
            result.append(word);

        } else {
            for (int j = 1; j < word.length(); j++) {
                result.append(word.charAt(j));
            }
            result.append(word.charAt(0));
        }

        result.append("ma");
        for (int j = 0; j < i + 1; j++) {
            result.append("a");
        }

        return result.toString();
    }

    private boolean isVowel(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||
                c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}