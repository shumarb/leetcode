// Question: https://leetcode.com/problems/button-with-longest-push-time/description/

class ButtonWithLongestPushTime {
    public int buttonWithLongestTime(int[][] events) {
        int longestTime = events[0][1];
        int longestTimeIndex = events[0][0];

        for (int i = 1; i < events.length; i++) {
            int currentTime = events[i][1];
            int difference = events[i][1] - events[i - 1][1];
            if (difference > longestTime) {
                longestTime = difference;
                longestTimeIndex = events[i][0];

            } else if (difference == longestTime && events[i][0] < longestTimeIndex) {
                longestTimeIndex = events[i][0];
            }
        }

        return longestTimeIndex;
    }
}