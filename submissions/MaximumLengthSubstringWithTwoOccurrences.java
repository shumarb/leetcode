// Question: https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/description/

class MaximumLengthSubstringWithTwoOccurrences {
    public int maximumLengthSubstring(String s) {
        boolean isTest = false;
        char[] letters = s.toCharArray();
        int[] count = new int[26];
        int left = 0;
        int result = 0;

        if (isTest) {
            System.out.println("letters: " + Arrays.toString(letters) + "\n-------------------------------------------------");
        }
        for (int right = 0; right < letters.length; right++) {
            char incoming = letters[right];
            count[incoming - 'a']++;

            while (count[incoming - 'a'] > 2) {
                count[letters[left++] - 'a']--;
            }

            int length = right - left + 1;
            if (isTest) {
                System.out.println(" * indices: [" + left + ", " + right + "] | length: " + length + " | substring: " + s.substring(left, left + length));
            }

            result = Math.max(length, result);
        }
        if (isTest) {
            System.out.println("-------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
