// Question: https://leetcode.com/problems/find-the-highest-altitude/description/

class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int result = 0;

        for (int g: gain) {
            currentAltitude += g;
            result = Math.max(currentAltitude, result);
        }

        return result;
    }
}
