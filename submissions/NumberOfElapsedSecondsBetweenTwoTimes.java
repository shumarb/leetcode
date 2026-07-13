// Question: https://leetcode.com/problems/number-of-elapsed-seconds-between-two-times/description/

class NumberOfElapsedSecondsBetweenTwoTimes {
    public int secondsBetweenTimes(String startTime, String endTime) {
        boolean isTest = false;
        int endSeconds = getTotalSeconds(endTime);
        int startSeconds = getTotalSeconds(startTime);

        if (isTest) {
            System.out.println("endSeconds: " + endSeconds + "\nstartSeconds: " + startSeconds);
        }

        return endSeconds - startSeconds;
    }

    private int getTotalSeconds(String time) {
        char[] tokens = time.toCharArray();
        return ((tokens[0] - '0') * 10 + (tokens[1] - '0')) * 3600
                + ((tokens[3] - '0') * 10 + (tokens[4] - '0')) * 60
                + ((tokens[6] - '0') * 10 + (tokens[7] - '0'));
    }
}
