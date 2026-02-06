// Question: https://leetcode.com/problems/reverse-letters-then-special-characters-in-a-string/description/

class ReverseLettersThenSpecialCharactersInAString {
    public String reverseByType(String s) {
        List<Character> letters = new ArrayList<>();
        List<Character> specials = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        int a = 0;
        int b = 0;
        int n = s.length();

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                letters.add(c);
            } else {
                specials.add(c);
            }
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                result.append(letters.get(a++));
            } else {
                result.append(specials.get(b++));
            }
        }
        if (isTest) {
            System.out.println("letters: " + letters + "\nspecials: " + specials + "\nresult: " + result.toString());
        }

        return result.toString();
    }
}