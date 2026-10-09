// Question: https://leetcode.com/problems/minimum-rotations-to-dial-a-number-ii/description/

class MinimumRotationsToDialANumberII {
    public int minRotations(int n, String s) {
        char[] letters = s.toCharArray();
        int base = 0;
        int gain = Integer.MIN_VALUE;
        int last = letters[n - 1] - '0';
        int previous = 0;

        for (char c: letters) {
            int current = c - '0';
            base += distance(previous, current);

            // 1. Cut is at index of c. eg: 1502, cut at index 1 (element) so 1502 becomes 1520 (2 is last element of initial s).
            gain = Math.max(gain, distance(previous, current) - distance(previous, last));
            previous = current;
        }

        return base - gain;
    }

    private int distance(int a, int b) {
        int d = (a - b + 10) % 10;
        return Math.min(d, 10 - d);
    }
}
