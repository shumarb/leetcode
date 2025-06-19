// Question: https://leetcode.com/problems/number-of-changing-keys/description/

class NumberOfChangingKeys {
    public int countKeyChanges(String s) {
        boolean isTest = false;
        char[] letters = s.toCharArray();
        int countKeyChanges = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char c = letters[i];
            if (Character.isUpperCase(c)) {
                letters[i] = Character.toLowerCase(c);
            }
        }

        for (int i = 0; i < len - 1; i++) {
            if (letters[i] != letters[i + 1]) {
                countKeyChanges++;
            }
        }
        if (isTest) {
            System.out.println("s: " + s);
            System.out.println("letters: " + Arrays.toString(letters));
            System.out.println("countKeyChanges: " + countKeyChanges);
        }

        return countKeyChanges;
    }
}