// Question: https://leetcode.com/problems/reverse-integer/description/

class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        boolean t = false;
        while (x != 0) {
            if ( (result < (Integer.MIN_VALUE / 10)) || (result > (Integer.MAX_VALUE / 10)) ) {
                return 0;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }
        if (t) {
            System.out.println("result: " + result);
        }
        return result;
    }
}