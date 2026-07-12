// Question: https://leetcode.com/problems/number-of-elapsed-seconds-between-two-times/description/

class NumberOfElapsedSecondsBetweenTwoTimes {
    public int secondsBetweenTimes(String startTime, String endTime) {
        String[] endTokens = endTime.split(":");
        String[] startTokens = startTime.split(":");
        boolean isTest = false;
        int endSeconds = getTotalSeconds(endTokens);
        int startSeconds = getTotalSeconds(startTokens);

        if (isTest) {
            System.out.println("endTokens: " + Arrays.toString(endTokens) + "\nstartTokens: " + Arrays.toString(startTokens));
            System.out.println("endSeconds: " + endSeconds + "\nstartSeconds: " + startSeconds);
        }

        return endSeconds - startSeconds;
    }

    private int getTotalSeconds(String[] tokens) {
        return Integer.parseInt(tokens[0]) * 3600
                + Integer.parseInt(tokens[1]) * 60
                + Integer.parseInt(tokens[2]);
    }
}
