// Question: https://leetcode.com/problems/count-substrings-with-k-frequency-characters-i/description/

class CountSubstringsWithKFrequencyCharactersOne {
    public int numberOfSubstrings(String s, int k) {
        int n = s.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int[] frequency = new int[26];
            int maximumFrequency = 0;

            for (int j = i; j < n; j++) {
                char letter = s.charAt(j);
                maximumFrequency = Math.max(++frequency[letter - 'a'], maximumFrequency);
                if (maximumFrequency >= k) {
                    result += (n - j);
                    break;
                }
            }
        }

        return result;
    }
}