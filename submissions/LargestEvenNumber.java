// Question: https://leetcode.com/problems/largest-even-number/description/

class LargestEvenNumber {
    public String largestEven(String s) {
        boolean isTest = false;
        int index = s.length() - 1;

        while (index >= 0 && s.charAt(index) == '1') {
            index--;
        }
        if (isTest) {
            System.out.println("s: " + s + "\nindex: " + index);
        }

        return index < 0 ? "" : s.substring(0, index + 1);
    }
}