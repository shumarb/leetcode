// Question: https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/description/

class LatestTimeByReplacingHiddenDigits {
    public String maximumTime(String time) {
        String[] hours = getList(23);
        String[] minutes = getList(59);
        String hour = time.substring(0, 2);
        String minute = time.substring(3);
        StringBuilder result = new StringBuilder();
        boolean isTest = false;

        if (isTest) {
            System.out.println("hour: " + hour + "\nminute: " + minute);
            System.out.println("\nhours: " + Arrays.toString(hours) + "\nminutes: " + Arrays.toString(minutes));
        }

        if (hour.equals("??")) {
            result.append("23:");

        } else if (hour.indexOf("?") >= 0) {
            for (int i = hours.length - 1; i >= 0; i--) {
                String check = hours[i];
                int countMatches = 0;

                if (hour.charAt(0) == check.charAt(0)) {
                    countMatches++;
                }
                if (hour.charAt(1) == check.charAt(1)) {
                    countMatches++;
                }

                if (countMatches >= 1) {
                    result.append(check + ":");
                    break;
                }
            }

        } else {
            result.append(hour + ":");
        }

        if (minute.equals("??")) {
            result.append("59");

        } else if (minute.indexOf("?") >= 0) {
            for (int i = minutes.length - 1; i >= 0; i--) {
                String check = minutes[i];
                int countMatches = 0;

                if (minute.charAt(0) == check.charAt(0)) {
                    countMatches++;
                }
                if (minute.charAt(1) == check.charAt(1)) {
                    countMatches++;
                }

                if (countMatches >= 1) {
                    result.append(check);
                    break;
                }
            }

        } else {
            result.append(minute);
        }

        return result.toString();
    }

    private String[] getList(int limit) {
        String[] result = new String[limit + 1];

        for (int i = 0; i < result.length; i++) {
            StringBuilder part = new StringBuilder();
            if (i < 10) {
                part.append("0");
            }
            part.append(i);
            result[i] = part.toString();
        }

        return result;
    }
}
