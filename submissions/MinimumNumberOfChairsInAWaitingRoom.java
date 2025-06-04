// Question: https://leetcode.com/problems/minimum-number-of-chairs-in-a-waiting-room/description/

class MinimumNumberOfChairsInAWaitingRoom {
    public int minimumChairs(String s) {
        int minimumChairs = 0;
        int currentChairs = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'E') {
                currentChairs++;
            } else {
                currentChairs--;
            }
            minimumChairs = Math.max(minimumChairs, currentChairs);
        }
        return minimumChairs;
    }
}