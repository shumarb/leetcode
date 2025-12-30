// Question: https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/description/

class LengthOfLongestFibonacciSubsequence {
    public int lenLongestFibSubseq(int[] arr) {
        List<List<Long>> list = new ArrayList<>();
        Set<Long> set = new HashSet<>();
        boolean isTest = false;
        int n = arr.length;
        int result = 0;

        for (int e: arr) {
            set.add((long) e);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long first = arr[i];
                long second = arr[j];
                long sum = (long) (first + second);
                if (set.contains(sum)) {
                    List<Long> entry = new ArrayList<>();
                    entry.add(first);
                    entry.add(second);
                    int size = entry.size();
                    long newVal = entry.get(size - 1) + entry.get(size - 2);
                    while (set.contains(newVal)) {
                        entry.add(newVal);
                        int q = entry.size();
                        newVal = entry.get(q - 1) + entry.get(q - 2);
                    }
                    list.add(entry);
                    result = Math.max(result, entry.size());
                }
            }
        }
        if (isTest) {
            System.out.println("arr: " + Arrays.toString(arr) + "\nlist:");
            for (List<Long> e: list) {
                System.out.println(" * " + e);
            }
            System.out.println("-----------------------------------------------\nresult: " + result);
        }

        return result;
    }
}