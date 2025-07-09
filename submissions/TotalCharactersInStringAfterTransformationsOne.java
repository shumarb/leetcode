// Question: https://leetcode.com/problems/total-characters-in-string-after-transformations-i/description/

class TotalCharactersInStringAfterTransformationsOne {
    private static final int DENOMINATOR = 1000000007;

    public int lengthAfterTransformations(String s, int t) {
        boolean isTest = false;
        int[] frequency = new int[26];
        long result = 0;

        for (char c: s.toCharArray()) {
            frequency[c - 'a']++;
        }
        if (isTest) {
            System.out.println("s: " + s + "\nt: " + t);
        }

        while (t-- > 0) {
            if (isTest) {
                System.out.println("-------------------------------------------");
                System.out.println("t: " + t);
                System.out.println(" * before, frequency: " + Arrays.toString(frequency));
            }
            int[] newFrequency = new int[26];
            for (int i = 0; i < 26; i++) {
                if (frequency[i] == 0) {
                    continue;
                }
                if (i < 25) {
                    newFrequency[i + 1] = (newFrequency[i + 1] + frequency[i]) % DENOMINATOR;
                } else {
                    newFrequency[0] = (newFrequency[0] + frequency[25]) % DENOMINATOR;
                    newFrequency[1] = (newFrequency[1] + frequency[25]) % DENOMINATOR;
                }
            }
            frequency = newFrequency;
            if (isTest) {
                System.out.println(" * after, frequency:  " + Arrays.toString(frequency));
            }
        }

        for (int count: frequency) {
            result = (result + count) % DENOMINATOR;
        }
        if (isTest) {
            System.out.println("-------------------------------------------");
            System.out.println("result: " + result);
        }

        return (int) result;
    }
}