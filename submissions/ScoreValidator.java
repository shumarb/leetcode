// Question: https://leetcode.com/problems/score-validator/description/

class ScoreValidator {
    public int[] scoreValidator(String[] events) {
        int[] result = new int[2];

        for (String e: events) {
            if (e.equals("1") || e.equals("2") || e.equals("3") || e.equals("4") || e.equals("5") || e.equals("6")) {
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
