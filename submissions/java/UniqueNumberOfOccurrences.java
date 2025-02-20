// Question: https://leetcode.com/problems/unique-number-of-occurrences/description/

class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numbers = new HashMap<>();
        boolean[] frequency = new boolean[1001];

        for (int number: arr) {
            numbers.put(number, 1 + numbers.getOrDefault(number, 0));
        }

        for (int numberOfOccurrences: numbers.values()) {
            if (frequency[numberOfOccurrences]) {
                return false;
            }
            frequency[numberOfOccurrences] = true;
        }

        return true;
    }
}