// Question: https://leetcode.com/problems/extra-characters-in-a-string/description/

class ExtraCharactersInAString {
    private Integer[] memo;
    private Set<String> set;

    private int solve(int index, int length, String sentence) {
        // 1. Base case: Reached end of string.
        if (index >= sentence.length()) {
            return 0;
        }

        // 2. Return cached result if already computed.
        if (memo[index] != null) {
            return memo[index];
        }

        // 3. Count current character as an extra character.
        int minExtra = 1 + solve(index + 1, length, sentence);

        // 4. Form substrings starting from current index.
        for (int end = index; end < length; end++) {
            String substring = sentence.substring(index, end + 1);

            /**
             5.  If substring is in dictionary,
             update minimum extra characters.
             */
            if (set.contains(substring)) {
                minExtra = Math.min(minExtra, solve(end + 1, length, sentence));
            }
        }

        // 6. Store result in the memo and return.
        return memo[index] = minExtra;
    }

    public int minExtraChar(String s, String[] dictionary) {
        int length = s.length();
        memo = new Integer[length];
        set = new HashSet<>(Arrays.asList(dictionary));
        return solve(0, length, s);
    }
}