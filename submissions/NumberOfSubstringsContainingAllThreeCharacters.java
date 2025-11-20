// Question: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/

class NumberOfSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int left = 0;
        int n = s.length();
        int result = 0;

        for (int right = 0; right < n; right++) {
            char letter = s.charAt(right);
            count[letter - 'a']++;

            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result += (n - right);
                count[s.charAt(left++) - 'a']--;
            }
        }

        return result;
    }
}