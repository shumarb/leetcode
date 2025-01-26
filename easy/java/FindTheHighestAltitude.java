// Question: https://leetcode.com/problems/find-the-highest-altitude/description/

class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int highestAltitude = 0;
        int cumulativeAltitude = 0;
        for (int netGain: gain) {
            cumulativeAltitude += netGain;
            highestAltitude = Math.max(highestAltitude, cumulativeAltitude);
        }
        return highestAltitude;
    }
}