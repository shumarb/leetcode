// Question: https://leetcode.com/problems/adding-spaces-to-a-string/description/

class AddingSpacesToAString {
    public String addSpaces(String s, int[] spaces) {
        boolean isTest = false;
        int j = 0;
        int k = 0;
        int sLen = s.length();
        char[] letters = new char[sLen + spaces.length];

        for (int i = 0; i < sLen; i++) {
            if (j < spaces.length && i == spaces[j]) {
                letters[k++] = ' ';
                j++;
            }
            letters[k++] = s.charAt(i);
        }
        if (isTest) {
            System.out.println("s: " + s + "\nspaces: " + Arrays.toString(spaces) + "\nletters: " + Arrays.toString(letters));
        }

        return new String(letters);
    }

}