// Question: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

class LetterCombinationsOfAPhoneNumber {
    private List<String> result;
    private Map<Integer, char[]> map;
    private String digits;

    public List<String> letterCombinations(String digits) {
        // 1. Edge case: Empty string.
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        map = new HashMap<>();
        result = new ArrayList<>();
        this.digits = digits;
        boolean isTest = false;

        populate();
        dfs(new StringBuilder(), 0);
        if (isTest) {
            System.out.println("map:");
            for (Map.Entry<Integer, char[]> e: map.entrySet()) {
                System.out.println(" * " + e.getKey() + " -> " + Arrays.toString(e.getValue()));
            }
            System.out.println("------------------------------------------\nresult: " + result);
        }

        return result;
    }

    private void dfs(StringBuilder path, int currentIndex) {
        /**
            1. Formed valid letter combination where each letter is from corresponding number.
         */
        if (currentIndex == digits.length()) {
            result.add(path.toString());

        } else {
            int digit = Character.getNumericValue(digits.charAt(currentIndex));
            for (char letter: map.get(digit)) {
                /**
                 2.  Letter combination not formed,
                     so add current letter of current digit to path,
                     explore until valid letter combination formed,
                     then backtrack to create another valid letter combination.
                 */
                path.append(letter);
                dfs(path, currentIndex + 1);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    private void populate() {
        char letter = 'a';
        int number = 2;

        while (number < 10) {
            char[] letters;

            if (number == 7 || number == 9) {
                letters = new char[4];
            } else {
                letters = new char[3];
            }
            for (int i = 0; i < letters.length; i++) {
                letters[i] = letter++;
            }

            map.put(number++, letters);
        }
    }
}