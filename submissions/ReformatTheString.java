// Question: https://leetcode.com/problems/reformat-the-string/description/

class ReformatTheString {
    public String reformat(String s) {
        List<Character> digits = new ArrayList<>();
        List<Character> letters = new ArrayList<>();
        char[] result;
        boolean isTest = false;

        for (char token: s.toCharArray()) {
            if (Character.isDigit(token)) {
                digits.add(token);
            } else {
                letters.add(token);
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\ndigits: " + digits + "\nletters: " + letters);
        }

        if (Math.abs(digits.size() - letters.size()) > 1) {
            return "";
        }

        List<Character> first = letters;
        List<Character> second = digits;
        if (digits.size() > letters.size()) {
            first = digits;
            second = letters;
        }
        result = new char[digits.size() + letters.size()];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < first.size() || j < second.size()) {
            if (k % 2 == 0) {
                result[k++] = first.get(i++);
            } else {
                result[k++] = second.get(j++);
            }
        }
        if (isTest) {
            System.out.println("result: " + Arrays.toString(result));
        }

        return new String(result);
    }
}