// Question: https://leetcode.com/problems/number-of-senior-citizens/description/

class NumberOfSeniorCitizens {
    public int countSeniors(String[] details) {
        int countSeniors = 0;
        for (String detail: details) {
            if ((10 * (detail.charAt(11) - '0')) + (detail.charAt(12) - '0') > 60) {
                countSeniors++;
            }
        }
        return countSeniors;
    }
}