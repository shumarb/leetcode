// Question: https://leetcode.com/problems/unique-number-of-occurrences/description/

class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numbers = new HashMap<>();
        boolean[] occurrences = new boolean[1001];

        for (int number: arr) {
            numbers.put(number, 1 + numbers.getOrDefault(number, 0));
        }

        for (Map.Entry<Integer, Integer> entry: numbers.entrySet()) {
            int numberOfOccurrences = entry.getValue();
            if (occurrences[numberOfOccurrences]) {
                return false;
            }
            occurrences[numberOfOccurrences] = true;
        }

        return true;
    }
}