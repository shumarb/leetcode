// Question:

class TrimTrailingWords {
    public String trimTrailingVowels(String s) {
        boolean isTest = false;
        int index = s.length() - 1;

        while (index >= 0 && isVowel(s.charAt(index))) {
            index--;
        }
        if (isTest) {
            System.out.println("index: " + index);
        }

        return s.substring(0, index + 1);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}