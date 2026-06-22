// Question: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/

class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;

        for (char c: s.toCharArray()) {
            if (isTest) {
                System.out.println("incoming: " + c + "\n * before: " + result);
            }

            int n = result.length();
            if (result.isEmpty() || c != result.charAt(n - 1)) {
                result.append(c);
            } else {
                result.setLength(n - 1);
            }

            if (isTest) {
                System.out.println(" * after: " + result + "\n------------------------");
            }
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result.toString();
    }
}
