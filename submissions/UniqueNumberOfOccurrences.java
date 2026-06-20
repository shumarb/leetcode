// Question: https://leetcode.com/problems/unique-number-of-occurrences/description/

class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        int[] countFrequency = new int[2001];

        for (int e: arr) {
            count[e + 1000]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0 && ++countFrequency[count[i]] > 1) {
                return false;
            }
        }

        return true;
    }
}
