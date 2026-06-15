// Question: https://leetcode.com/problems/number-of-laser-beams-in-a-bank/description/

class NumberOfLaserBeamsInABank {
    public int numberOfBeams(String[] bank) {
        int previous = 0;
        int result = 0;

        for (String e: bank) {
            int current = 0;

            for (char c: e.toCharArray()) {
                current += (c - '0');
            }
            if (current > 0) {
                result += current * previous;
                previous = current;
            }
        }

        return result;
    }
}
