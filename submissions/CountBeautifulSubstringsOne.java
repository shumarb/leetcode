// Question: https://leetcode.com/problems/count-beautiful-substrings-i/description/

class CountBeautifulSubstringsOne {
    public int beautifulSubstrings(String s, int k) {
        int countBeautifulSubstrings = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            int consonants = 0;
            int vowels = 0;
            for (int j = i; j < len; j++) {
                char letter = s.charAt(j);
                if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
                if (consonants == vowels && (consonants * vowels) % k == 0) {
                    countBeautifulSubstrings++;
                }
            }
        }

        return countBeautifulSubstrings;
    }
}