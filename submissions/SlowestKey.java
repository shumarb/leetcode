// Question: https://leetcode.com/problems/slowest-key/description/

class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char result = keysPressed.charAt(0);
        int maximumDuration = releaseTimes[0];

        for (int i = 1; i < keysPressed.length(); i++) {
            char currentLetter = keysPressed.charAt(i);
            int currentDuration = releaseTimes[i] - releaseTimes[i - 1];
            if (currentDuration > maximumDuration) {
                maximumDuration = currentDuration;
                result = currentLetter;
            } else if (currentDuration == maximumDuration && currentLetter > result) {
                result = currentLetter;
            }
        }

        return result;
    }
}