// Question: https://leetcode.com/problems/final-value-of-variable-after-performing-operations/description/

class FindValueOfVariableAfterPerformingOoperations {
    public int finalValueAfterOperations(String[] operations) {
        int value = 0;
        for (String operation: operations) {
            // 1. Increment value if either its first or last character is '+', else decrement.
            if ((operation.charAt(0) == '+') || (operation.charAt(operation.length() - 1) == '+')) {
                value++;
            } else {
                value--;
            }
        }
        return value;
    }
}