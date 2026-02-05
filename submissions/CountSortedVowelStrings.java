// Question: https://leetcode.com/problems/count-sorted-vowel-strings/description/

class CountSortedVowelStrings {
    private boolean isTest;
    private char[] letters;
    private int n;
    private int result;

    public int countVowelStrings(int n) {
        isTest = false;
        letters = new char[] {'a', 'e', 'i', 'o', 'u'};
        this.n = n;

        explore(new StringBuilder(), 0);
        if (isTest) {
            System.out.println("---------------------\nresult: " + result);
        }

        return result;
    }

    private void explore(StringBuilder current, int index) {
        if (current.length() == n) {
            if (isTest) {
                System.out.println(" * valid: " + current);
            }
            result++;
            return;
        }

        for (int j = index; j < letters.length; j++) {
            current.append(letters[j]);
            explore(current, j);
            current.setLength(current.length() - 1);
        }
    }
}