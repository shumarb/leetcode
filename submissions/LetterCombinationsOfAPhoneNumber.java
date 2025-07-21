// Question: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

class LetterCombinationsOfAPhoneNumber {
    private List<String> result;
    private String[] map;
    private String digits;

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        boolean isTest = false;
        map = new String[10];
        result = new ArrayList<>();
        this.digits = digits;

        populate();
        dfs(new StringBuilder(), 0);
        if (isTest) {
            System.out.println("map:");
            for (int i = 2; i < map.length; i++) {
                System.out.println(" * " + i + " -> " + Arrays.toString(map[i].toCharArray()));
            }
            System.out.println("-------------------------------\nresult:" + result);
        }

        return result;
    }

    private void dfs(StringBuilder path, int currentIndex) {
        if (path.length() == digits.length()) {
            result.add(path.toString());
            return;
        }

        int digit = Character.getNumericValue(digits.charAt(currentIndex));
        for (char letter: map[digit].toCharArray()) {
            path.append(letter);
            dfs(path, currentIndex + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    private void populate() {
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";
    }
}