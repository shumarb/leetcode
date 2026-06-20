// Question: https://leetcode.com/problems/removing-stars-from-a-string/description/

class RemovingStarsFromAString {
    public String removeStars(String s) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;

        for (char c: s.toCharArray()) {
            if (isTest) {
                System.out.println("incoming: " + c + "\nbefore: " + result);
            }

            int n = result.length();
            if (c != '*') {
                result.append(c);
            } else if (c == '*' && n > 0) {
                result.setLength(n - 1);
            }

            if (isTest) {
                System.out.println("after: " + result + "\n--------------------------");
            }
        }
        if (isTest) {
            System.out.println("final result: " + result);
        }

        return result.toString();
    }
}
