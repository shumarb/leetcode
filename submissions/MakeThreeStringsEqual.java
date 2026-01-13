// Question: https://leetcode.com/problems/make-three-strings-equal/description/

class MakeThreeStringsEqual {
    public int findMinimumOperations(String s1, String s2, String s3) {
        StringBuilder prefix = new StringBuilder();
        String shortestWord = s1;
        boolean isTest = false;
        int result = 0;

        if (s2.length() < shortestWord.length()) {
            shortestWord = s2;
        }
        if (s3.length() < shortestWord.length()) {
            shortestWord = s3;
        }
        for (int i = 0; i < shortestWord.length(); i++) {
            char first = s1.charAt(i);
            char second = s2.charAt(i);
            char third = s3.charAt(i);
            if (first == second && first == third) {
                prefix.append(first);
            } else {
                break;
            }
        }
        if (isTest) {
            System.out.println("shortestWord: " + shortestWord);
            System.out.println("prefix: " + prefix.toString());
        }

        if (prefix.isEmpty()) {
            return -1;
        }

        result += (s1.length() - prefix.length());
        result += (s2.length() - prefix.length());
        result += (s3.length() - prefix.length());
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}