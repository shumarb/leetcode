// Question: https://leetcode.com/problems/sum-of-digits-of-string-after-convert/description/

class SumOfDigitsOfStringAfterConvert {
    public int getLucky(String s, int k) {
        boolean t = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cVal = 1 + (c - 'a');
            if (t) {
                System.out.println("c: " + c + " | cVal: " + cVal);
            }
            sb.append(cVal);
        }
        if (t) {
            System.out.println("sb: " + sb);
        }

        String convertedS = sb.toString();
        if (t) {
            System.out.println("convertedS: " + convertedS);
        }
        int num = 0;
        for (int i = 0; i < convertedS.length(); i++) {
            num += Character.getNumericValue(convertedS.charAt(i));
        }
        if (t) {
            System.out.println("num: " + num);
        }
        if (k == 1) {
            return num;
        }

        int sum = 0;
        for (int i = 0; i < k - 1; i++) {
            sum += computeSum(num);
            if (i != k - 2) {
                num = sum;
                sum = 0;
            }
        }

        return sum;
    }

    private int computeSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
}