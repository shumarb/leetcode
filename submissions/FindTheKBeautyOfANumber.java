// Question: https://leetcode.com/problems/find-the-k-beauty-of-a-number/description/

class FindTheKBeautyOfANumber {
    private boolean isTest = false;

    public int divisorSubstrings(int num, int k) {
        int kBeauty = 0;
        String numStr = String.valueOf(num);

        if (isTest) {
            System.out.println("num: " + num + "\nk: " + k + "\nnumStr: " + numStr);
        }

        if (k > numStr.length()) {
            return 0;
        }

        StringBuilder value = new StringBuilder();
        for (int i = 0; i < k; i++) {
            value.append(numStr.charAt(i));
        }
        if (isValid(num, value.toString())) {
            kBeauty++;
        }

        for (int i = k; i < numStr.length(); i++) {
            value.deleteCharAt(0);
            value.append(numStr.charAt(i));
            if (isValid(num, value.toString())) {
                kBeauty++;
            }
        }

        return kBeauty;
    }

    private boolean isValid(int num, String value) {
        int number = 0;
        for (int i = 0; i < value.length(); i++) {
            number *= 10;
            number += Character.getNumericValue(value.charAt(i));
        }
        if (isTest) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("num: " + num + "\nvalue: " + value + "\nnumber: " + number);
        }

        return (number != 0 && num % number == 0);
    }
}