// Question: https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors/description/

class MaximumConsecutiveFloorsWithoutSpecialFloors {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int len = special.length;
        int maxConsecutive = 0;

        /**
         1. Sort special floors in ascending order to find consecutive non-special floors:
             - bottom to first special floor.
             - between special floors.
             - last special floor to top.
         */
        Arrays.sort(special);

        // 2. Check for number of consecutive non-special floors from bottom to first special floor.
        maxConsecutive = Math.max(maxConsecutive, special[0] - bottom);

        // 3. Check for number of consecutive non-special floors between the special floors.
        for (int i = 1; i < len; i++) {
            maxConsecutive = Math.max(maxConsecutive, special[i] - special[i - 1] - 1);
        }

        // 4. Check for number of consecutive non-special floors between the special floors.
        return Math.max(maxConsecutive, top - special[len - 1]);

    }
}