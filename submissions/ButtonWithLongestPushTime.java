// Question: https://leetcode.com/problems/button-with-longest-push-time/description/

class ButtonWithLongestPushTime {
    public int buttonWithLongestTime(int[][] events) {
        int longestTime = events[0][1];
        int longestTimeIndex = events[0][0];

        for (int i = 1; i < events.length; i++) {
            int difference = events[i][1] - events[i - 1][1];
            if ((difference > longestTime) || (difference == longestTime && events[i][0] < longestTimeIndex)) {
                longestTime = difference;
                longestTimeIndex = events[i][0];
            }
        }

        return longestTimeIndex;
    }
}
