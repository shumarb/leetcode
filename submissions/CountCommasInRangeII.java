// Question: https://leetcode.com/problems/count-commas-in-range/description/

class CountCommasInRangeII {
    public long countCommas(long n) {
        if (n < 1000l) {
            return 0;
        }

        boolean isTest = false;
        long upperLimit = 9999l;
        long maximum = Math.min(upperLimit, n);
        long minimum = 1000l;
        long result = 0l;

        if (isTest) {
            System.out.println("n: " + n + "\n----------------------------------------------------------------------");
        }
        while (minimum <= maximum && maximum <= n) {
            long totalCommasPerNumber = getTotal(maximum);
            long totalNumbers = maximum - minimum + 1l;

            if (isTest) {
                System.out.println(" * [" + minimum + ", " + maximum + "] | totalNumbers: " + totalNumbers + " | totalCommasPerNumber: " + totalCommasPerNumber);
            }

            result += totalCommasPerNumber * totalNumbers;

            if (maximum == n) {
                break;
            }

            minimum *= 10l;
            upperLimit *= 10l;
            upperLimit += 9l;
            if (upperLimit > n) {
                upperLimit = n;
            }

            maximum = upperLimit;
        }
        if (isTest) {
            System.out.println("----------------------------------------------------------------------\nresult: " + result);
        }

        return result;
    }

    private long getTotal(long maximum) {
        // 1,000,000,000,000,000
        if (maximum <= 999999) {
            return 1l;

        } else if (maximum <= 999999999l) {
            return 2l;

        } else if (maximum <= 999999999999l) {
            return 3l;

        } else if (maximum <= 999999999999999l) {
            return 4l;
        }

        return 5l;
    }
}
