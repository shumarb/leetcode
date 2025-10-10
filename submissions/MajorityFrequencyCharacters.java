// Question: https://leetcode.com/problems/majority-frequency-characters/description/

class MajorityFrequencyCharacters {
    public String majorityFrequencyGroup(String s) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        int[] count = new int[26];
        int[] countFrequency;
        int largestCount = 0;
        int largestFrequency = 0;
        int largestFrequencyElement = -1;

        for (char c: s.toCharArray()) {
            largestCount = Math.max(largestCount, ++count[c - 'a']);
        }
        countFrequency = new int[largestCount + 1];
        for (int e: count) {
            if (e == 0) {
                continue;
            }
            countFrequency[e]++;
        }
        for (int i = 1; i < countFrequency.length; i++) {
            if (countFrequency[i] == 0) {
                continue;
            }
            if (countFrequency[i] >= largestFrequency) {
                largestFrequency = countFrequency[i];
                largestFrequencyElement = i;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == largestFrequencyElement) {
                result.append((char) ('a' + i));
            }
        }
        if (isTest) {
            System.out.println("count: " + Arrays.toString(count) + "\nlargestCount: " + largestCount);
            System.out.println("countFrequency: " + Arrays.toString(countFrequency));
            System.out.println("largestFrequencyElement: " + largestFrequencyElement + " -> largestFrequency: " + largestFrequency);
            System.out.println("-------------------------------------------------------------------\nresult: " + result.toString());
        }

        return result.toString();
    }
}