// Question: https://leetcode.com/problems/score-validator/description/

class ScoreValidator {
    public int[] scoreValidator(String[] events) {
        int[] result = new int[2];

        for (String e: events) {
            if (!e.equals("W") && e.length() == 1) {
                result[0] += Integer.parseInt(e);

            } else if (e.equals("W")) {
                result[1]++;

            } else if (e.equals("WD") || e.equals("NB")) {
                result[0]++;
            }

            if (result[1] == 10) {
                break;
            }
        }

        return result;
    }
}

