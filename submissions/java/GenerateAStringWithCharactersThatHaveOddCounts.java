// Question: https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/description/

class GenerateAStringWithCharactersThatHaveOddCounts {
    public String generateTheString(int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            result.append('a');
        }

        /**
         1.  Result has (n - 1) number of 'a'.

         If n is even, the result currently has an odd number of 'a's,
         so append 1 'b' so that string comprises 2 characters,
         and each characters appears odd number of times.

         If n is odd, the result currently has even number of 'a's,
         so append 1 more 'a' so there are odd number of 'a's in the string. 
         */
        if (n % 2 == 0) {
            result.append('b');
        } else {
            result.append('a');
        }

        return result.toString();
    }
}