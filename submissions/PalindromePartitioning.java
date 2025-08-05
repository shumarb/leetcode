// Question: https://leetcode.com/problems/palindrome-partitioning/description/

class PalindromePartitioning {
    private List<List<String>> result;

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }

        return true;
    }

    private void helper(String s, List<String> path, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            String subString = s.substring(start, end + 1);
            if (isPalindrome(subString)) {
                path.add(subString);
                helper(s, path, end + 1);
                path.removeLast();
            }
        }
    }

    public List<List<String>> partition(String s) {
        boolean isTest = false;
        result = new ArrayList<>();

        helper(s, new ArrayList<>(), 0);
        if (isTest) {
            System.out.println("s: " + s + "\n-------------------------");
            System.out.println("result:");
            for (List<String> e: result) {
                System.out.println(" * " + e);
            }
        }

        return result;
    }
}