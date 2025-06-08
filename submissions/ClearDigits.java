// Question: https://leetcode.com/problems/clear-digits/description/

class ClearDigits {
    public String clearDigits(String s) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;

        for (char part: s.toCharArray()) {
            if (Character.isDigit(part)) {
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else {
                result.append(part);
            }
        }
        if (isTest) {
            System.out.println("result: " + result.toString());
        }

        return result.toString();
    }
}