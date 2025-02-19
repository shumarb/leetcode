// Question: https://leetcode.com/problems/jewels-and-stones/description/

class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        boolean isTest = false;
        boolean[] jewelsFrequency = new boolean[52];

        for (char letter: jewels.toCharArray()) {
            if (Character.isUpperCase(letter)) {
                jewelsFrequency[letter - 'A'] = true;
            } else {
                jewelsFrequency[letter - 'a' + 26] = true;
            }
        }
        if (isTest) {
            System.out.println("jewels: " + jewels + " | jewelsFrequency: " + Arrays.toString(jewelsFrequency));
        }

        for (char letter: stones.toCharArray()) {
            if (Character.isUpperCase(letter)) {
                if (jewelsFrequency[letter - 'A']) {
                    count++;
                }
            }
            if (Character.isLowerCase(letter)) {
                if (jewelsFrequency[letter - 'a' + 26]) {
                    count++;
                }
            }
        }

        return count;
    }
}