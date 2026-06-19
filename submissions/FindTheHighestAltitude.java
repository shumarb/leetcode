// Question: https://leetcode.com/problems/find-the-highest-altitude/description/

class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int current = 0;
        int result = 0;

        for (int i = 0; i < gain.length; i++) {
            current += gain[i];
            result = Math.max(current, result);
        }

        return result;
    }
}
