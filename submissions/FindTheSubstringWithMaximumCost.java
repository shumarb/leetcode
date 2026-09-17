// Question: https://leetcode.com/problems/find-the-substring-with-maximum-cost/description/

class FindTheSubstringWithMaximumCost {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        boolean isTest = false;
        char[] charsLetters = chars.toCharArray();
        char[] letters = s.toCharArray();
        int bestLeft = 0;
        int bestRight = 0;
        int currentCost;
        int left = 0;
        int n = letters.length;
        int result = 0;
        int[] costPerLetter = new int[26];
        int[] values = new int[n];

        for (int i = 0; i < 26; i++) {
            costPerLetter[i] = i + 1;
        }
        for (int i = 0; i < vals.length; i++) {
            char c = charsLetters[i];
            costPerLetter[c - 'a'] = vals[i];
        }
        for (int i = 0; i < n; i++) {
            values[i] = costPerLetter[letters[i] - 'a'];
        }
        if (isTest) {
            System.out.println("letters: " + Arrays.toString(letters) + "\ncharsLetters: " + Arrays.toString(charsLetters) + "\ncostPerLetter: " + Arrays.toString(costPerLetter) + "\nvalues:  " + Arrays.toString(values) + "\n-----------------------------------------------------------------");
        }

        currentCost = result = values[0];
        if (isTest) {
            System.out.println(" * indices: [" + bestLeft + ", " + bestRight + "] | maximum cost: " + result + " | substring: " + Arrays.toString(Arrays.copyOfRange(letters, bestLeft, bestRight + 1)));
        }
        for (int right = 1; right < n; right++) {
            int incoming = values[right];

            /**
             1. Apply Kadane's algorithm by assigning current cost as the substring with the larger cost:
             * [left, right]
             * [right, right]
             */
            if (incoming + currentCost > incoming) {
                currentCost += incoming;

            } else {
                currentCost = incoming;
                left = right;
            }

            if (currentCost > result) {
                bestLeft = left;
                bestRight = right;
                result = currentCost;
                if (isTest) {
                    System.out.println(" * indices: [" + bestLeft + ", " + bestRight + "] | maximum cost: " + result + " | substring: " + Arrays.toString(Arrays.copyOfRange(letters, bestLeft, bestRight + 1)));
                }
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------------------------------\nresult: " + result);
        }

        return result < 0 ? 0 : result;
    }
}
