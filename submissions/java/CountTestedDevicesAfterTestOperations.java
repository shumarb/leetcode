// Question: https://leetcode.com/problems/count-tested-devices-after-test-operations/description/

class CountTestedDevicesAfterTestOperations {
    public int countTestedDevices(int[] batteryPercentages) {
        int countTestedDevices = 0;
        int len = batteryPercentages.length;

        for (int i = 0; i < len; i++) {
            if (batteryPercentages[i] > 0) {
                countTestedDevices++;
                batteryPercentages = update(batteryPercentages, i + 1);
            }
        }

        return countTestedDevices;
    }

    private int[] update(int[] batteryPercentages, int startIndex) {
        int len = batteryPercentages.length;
        int[] result = Arrays.copyOf(batteryPercentages, len);
        for (int i = startIndex; i < len; i++) {
            result[i] = Math.max(0, result[i] - 1);
        }
        return result;
    }
}