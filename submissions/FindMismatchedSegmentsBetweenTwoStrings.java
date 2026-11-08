// Question: https://leetcode.com/problems/find-mismatched-segments-between-two-strings/description/

class FindMismatchedSegmentsBetweenTwoStrings {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> result = new ArrayList<>();
        boolean isTest = false;
        int left = 0;
        int n = s1.length();
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        if (s1.equals(s2)) {
            return result;
        }

        if (isTest) {
            System.out.println("s1: " + s1 + "\ns2: " + s2 + "\n------------------------------------------");
        }

        while (left < n) {
            if (s1Chars[left] != s2Chars[left]) {
                int right = left + 1;

                while (right < n && s1Chars[right] != s2Chars[right]) {
                    right++;
                }

                List<String> list = List.of(s1.substring(left, right), s2.substring(left, right));
                result.add(list);

                if (isTest) {
                    System.out.println(" * indices: [" + left + ", " + (right - 1) + "] | substrings: " + list);
                }

                left = right;

            } else {
                left++;
            }
        }

        if (isTest) {
            System.out.println("------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
