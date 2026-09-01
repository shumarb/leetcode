// Question: https://leetcode.com/problems/count-vowel-substrings-of-a-string/description/

class CountVowelSubstringsOfAString {
    private char[] letters;

    public int countVowelSubstrings(String word) {
        letters = word.toCharArray();
        return countAtLeast(0) - countAtLeast(1);
    }

    private int countAtLeast(int minimumConsonants) {
        boolean isTest = false;
        int[] count = new int[26];
        int countDistinctConsonants = 0;
        int countDistinctVowels = 0;
        int left = 0;
        int n = letters.length;
        int result = 0;

        if (isTest) {
            System.out.println("letters: " + Arrays.toString(letters) + "\ncount subarrays with all 5 vowels and >= " + minimumConsonants + " consonants\n");
        }
        for (int right = 0; right < letters.length; right++) {
            char incoming = letters[right];

            if (++count[incoming - 'a'] == 1) {
                if (isVowel(incoming)) {
                    countDistinctVowels++;
                } else {
                    countDistinctConsonants++;
                }
            }

            while (countDistinctVowels == 5 && countDistinctConsonants >= minimumConsonants) {
                int countValidSubarrays = n - right;
                if (isTest) {
                    System.out.println(" * indices: [" + left + ", " + right + "] | countValidSubarrays: " + countValidSubarrays + " | subarray: " + Arrays.toString(Arrays.copyOfRange(letters, left, right + 1)));
                }

                char remove = letters[left++];
                if (--count[remove - 'a'] == 0) {
                    if (isVowel(remove)) {
                        countDistinctVowels--;
                    } else {
                        countDistinctConsonants--;
                    }
                }
            }

            result += left;
        }
        if (isTest) {
            System.out.println("\nresult: " + result + "\n---------------------------------------------------------------");
        }

        return result;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
