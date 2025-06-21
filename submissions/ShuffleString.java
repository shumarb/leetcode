// Question: https://leetcode.com/problems/shuffle-string/description/

class ShuffleString {
    public String restoreString(String s, int[] indices) {
        boolean isTest = false;
        int len = indices.length;
        char[] letters = new char[len];

        for (int i = 0; i < len; i++) {
            int index = indices[i];
            letters[index] = s.charAt(i);
        }
        if (isTest) {
            System.out.println("s: " + s + "\nindices: " + Arrays.toString(indices));
            System.out.println("letters: " + Arrays.toString(letters));
        }

        return new String(letters);
    }
}