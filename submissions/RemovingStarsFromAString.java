// Question: https://leetcode.com/problems/removing-stars-from-a-string/description/

class RemovingStarsFromAString {
    public String removeStars(String s) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;

        for (char c: s.toCharArray()) {
            if (isTest) {
                System.out.println("c: " + c + "\nbefore: " + result);
            }

            if (c >= 'a' && c <= 'z') {
                result.append(c);

            } else if (!result.isEmpty()) {
                result.setLength(result.length() - 1);
            }

            if (isTest) {
                System.out.println("after: " + result);
                System.out.println("--------------------------------");
            }
        }
        if (isTest) {
            System.out.println("final result: " + result);
        }

        return result.toString();
    }
}
