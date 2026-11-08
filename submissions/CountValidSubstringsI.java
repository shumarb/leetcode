// Question: https://leetcode.com/problems/count-valid-substrings-i/description/

class CountValidSubstrings {
    public long countValidSubstrings(String s) {
        boolean isTest = false;
        int left = 0;
        long result = 0;

        if (isTest) {
            System.out.println("s: " + s + "\n----------------------------------------------------------------");
        }
        for (int right = 0; right < s.length(); right++) {
            if (right >= 2 && s.charAt(right - 2) == 'a' && s.charAt(right - 1) == 'b' && s.charAt(right) == 'c') {
                left = right - 1;
            }

            int additionalSubstrings = right - left + 1;
            result += additionalSubstrings;
            if (isTest) {
                System.out.println(" * indices: [" + left + ", " + right + "] | additional substrings: " + additionalSubstrings + " | window: " + s.substring(left, right + 1));
            }
        }
        if (isTest) {
            System.out.println("----------------------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
