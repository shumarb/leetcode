// Question: https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/description/

class LengthOfLongestFibonacciSubsequence {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Long, Integer> map = new HashMap<>();
        int n = arr.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            map.put((long) arr[i], i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int current = 2;
                long first = arr[i];
                long second = arr[j];

                while (map.containsKey(first + second)) {
                    int nextIndex = map.get(first + second);
                    current++;
                    first = second;
                    second = arr[nextIndex];
                }
                result = Math.max(current, result);
            }
        }

        return result >= 3 ? result : 0;
    }
}