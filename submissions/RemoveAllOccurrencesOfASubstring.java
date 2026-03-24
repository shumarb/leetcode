// Question: https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/

class RemoveAllOccurrencesOfASubstring {
    public String removeOccurrences(String s, String part) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        int k = part.length();

        // 1. Edge case: impossible to form part from s.
        if (s.length() < k || !s.contains(part)) {
            return s;
        }

        for (char c: s.toCharArray()) {
            if (isTest) {
                System.out.println("c: " + c + "\n * before, result: " + result);
            }

            result.append(c);
            while (result.indexOf(part) != -1) {
                for (int i = 0; i < k; i++) {
                    result.deleteCharAt(result.length() - 1);
                }
            }

            if (isTest) {
                System.out.println(" * after, result: " + result);
                System.out.println("----------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("final result: " + result);
        }

        return result.toString();
    }
}
