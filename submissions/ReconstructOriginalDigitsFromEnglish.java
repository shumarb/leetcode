// Question: https://leetcode.com/problems/reconstruct-original-digits-from-english/description/

class ReconstructOriginalDigitsFromEnglish {
    public String originalDigits(String s) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        int[] digitFrequency = new int[10];
        int[] letterFrequency = new int[26];

        for (char letter: s.toCharArray()) {
            letterFrequency[letter - 'a']++;
        }

        /**
         1.  Certain letters are associated with one number,
             so frequency of these letters = frequency of digit.
         */
        digitFrequency[0] = letterFrequency['z' - 'a'];
        digitFrequency[2] = letterFrequency['w' - 'a'];
        digitFrequency[4] = letterFrequency['u' - 'a'];
        digitFrequency[6] = letterFrequency['x' - 'a'];
        digitFrequency[8] = letterFrequency['g' - 'a'];

        /**
         2.  Idenfify remaining digits subtracting overlaps
             for each of remaining leftover digits.
         */
        digitFrequency[1] = letterFrequency['o' - 'a'] - digitFrequency[0] - digitFrequency[2] - digitFrequency[4];
        digitFrequency[3] = letterFrequency['h' - 'a'] - digitFrequency[8];
        digitFrequency[5] = letterFrequency['f' - 'a'] - digitFrequency[4];
        digitFrequency[7] = letterFrequency['s' - 'a'] - digitFrequency[6];
        digitFrequency[9] = letterFrequency['i' - 'a'] - digitFrequency[5] - digitFrequency[6] - digitFrequency[8];
        if (isTest) {
            System.out.println("s: " + s + "\nletterFrequency: " + Arrays.toString(letterFrequency));
            System.out.println("digitFrequency: " + Arrays.toString(digitFrequency));
        }

        for (int i = 0; i < 10; i++) {
            while (digitFrequency[i]-- > 0) {
                result.append(i);
            }
        }
        if (isTest) {
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println("result: " + result.toString());
        }

        return result.toString();
    }
}