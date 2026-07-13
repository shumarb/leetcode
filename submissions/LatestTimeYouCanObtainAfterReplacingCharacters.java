// Question: https://leetcode.com/problems/latest-time-you-can-obtain-after-replacing-characters/description/

class LatestTimeYouCanObtainAfterReplacingCharacters {
    public String findLatestTime(String s) {
        List<String> times = new ArrayList<>();
        boolean isTest = true;
        char[] sDigits = s.toCharArray();

        for (int i = 0; i <= 23; i++) {
            for (int j = 0; j <= 59; j++) {
                StringBuilder time = new StringBuilder();
                if (i < 10) {
                    time.append("0");
                }
                time.append(i);
                time.append(":");
                if (j < 10) {
                    time.append("0");
                }
                time.append(j);
                times.add(time.toString());
            }
        }
        if (isTest) {
            System.out.println("times:");
            for (String time: times) {
                System.out.println(" * " + time);
            }
        }

        for (int i = times.size() - 1; i >= 0; i--) {
            String time = times.get(i);
            char[] digits = time.toCharArray();
            int countCommonDigits = 0;

            if (
                    (sDigits[0] == '?' || digits[0] == sDigits[0])
                            && (sDigits[1] == '?' || digits[1] == sDigits[1])
                            && (sDigits[3] == '?' || digits[3] == sDigits[3])
                            && (sDigits[4] == '?' || digits[4] == sDigits[4])
            ) {
                return time;
            }
        }

        return "23:59";
    }
}
