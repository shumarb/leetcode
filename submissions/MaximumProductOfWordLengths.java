// Question: https://leetcode.com/problems/maximum-product-of-word-lengths/description/

class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        boolean isTest = false;
        int maximumProduct = 0;

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String first = words[i];
                String second = words[j];
                if (first.length() * second.length() > maximumProduct && isValid(first, second)) {
                    if (isTest) {
                        System.out.println(" * valid: " + first + ", " + second);
                    }
                    maximumProduct = first.length() * second.length();
                }
            }
        }

        return maximumProduct;
    }

    private boolean isValid(String first, String second) {
        int[] frequency = new int[26];

        for (char letter: first.toCharArray()) {
            frequency[letter - 'a']++;
        }
        for (char letter: second.toCharArray()) {
            if (frequency[letter - 'a'] > 0) {
                return false;
            }
        }

        return true;
    }
}