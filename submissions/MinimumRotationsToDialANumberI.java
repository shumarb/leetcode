// Question: https://leetcode.com/problems/minimum-rotations-to-dial-a-number-i/description/

class MinimumRotationsToDialANumberI {
    public int minRotations(String s) {
        boolean isTest = false;
        char[] digits = s.toCharArray();
        int last = 0;
        int result = 0;

        if (isTest) {
            System.out.println("digits: " + Arrays.toString(digits));
            System.out.println("--------------------------------------------------------------------");
        }
        for (char d: digits) {
            int next = d - '0';
            int anticlockwise = (last - next + 10) % 10;
            int clockwise = (next - last + 10) % 10;

            if (isTest) {
                System.out.println(" * " + last + " -> " + next + " | anticlockwise: " + anticlockwise + " | clockwise: " + clockwise);
            }

            last = next;
            result += Math.min(anticlockwise, clockwise);
        }
        if (isTest) {
            System.out.println("--------------------------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
