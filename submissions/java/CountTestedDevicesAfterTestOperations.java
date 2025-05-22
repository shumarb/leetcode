// Question: https://leetcode.com/problems/count-tested-devices-after-test-operations/description/

class CountTestedDevicesAfterTestOperations {
    public int countTestedDevices(int[] batteryPercentages) {
        int countDecrement = 0;
        int countTestedDevices = 0;

        for (int i = 0; i < batteryPercentages.length; i++) {
            if (batteryPercentages[i] - countDecrement > 0) {
                countTestedDevices++;
                countDecrement++;
            }
        }

        return countTestedDevices;
    }
}