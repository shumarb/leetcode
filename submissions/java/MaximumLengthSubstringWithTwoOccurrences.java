// Question: https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/description/

class MaximumLengthSubstringWithTwoOccurrences {
    public int maximumLengthSubstring(String s) {
        String maximumSubstring = "";
        boolean isTest = false;
        int[] frequency = new int[26];

        for (char letter: s.toCharArray()) {
            frequency[letter - 'a']++;
        }
        if (isTest) {
            System.out.println("s: " + s + "\nfrequency: " + Arrays.toString(frequency));
            System.out.println("-----------------------------------------------------------------------");
        }
        for (int i = 0; i < s.length(); i++) {
            StringBuilder current = new StringBuilder();
            current.append(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                current.append(s.charAt(j));
                if (isTest) {
                    System.out.println(" * checking: " + current.toString());
                }
                if (isValidSubstring(current.toString(), frequency) && current.toString().length() > maximumSubstring.length()) {
                    maximumSubstring = current.toString();
                }
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("maximumSubstring: " + maximumSubstring);
        }

        return maximumSubstring.length();
    }

    private boolean isValidSubstring(String str, int[] frequency) {
        int[] strFrequency = new int[26];
        for (char letter: str.toCharArray()) {
            strFrequency[letter - 'a']++;
        }
        for (int i = 0; i < frequency.length; i++) {
            if (strFrequency[i] > 2) {
                return false;
            }
        }
        return true;
    }
}