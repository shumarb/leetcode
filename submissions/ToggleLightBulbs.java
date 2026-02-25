// Question: https://leetcode.com/problems/toggle-light-bulbs/description/

class ToggleLightBulbs {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        List<Integer> result = new ArrayList<>();
        boolean[] isOn;
        boolean isTest = false;
        int largest = 0;

        for (int bulb: bulbs) {
            largest = Math.max(bulb, largest);
        }
        isOn = new boolean[largest + 1];

        if (isTest) {
            System.out.println("before, isOn: " + Arrays.toString(isOn));
        }
        for (int bulb: bulbs) {
            if (isOn[bulb]) {
                isOn[bulb] = false;
            } else {
                isOn[bulb] = true;
            }
        }

        for (int i = 1; i <= largest; i++) {
            if (isOn[i]) {
                result.add(i);
            }
        }
        if (isTest) {
            System.out.println("after, isOn: " + Arrays.toString(isOn) + "\nresult: " + result);
        }

        return result;
    }
}                                                                                             | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/TwoOutOfThree.java)                                          | 1ms     | 100%   |
