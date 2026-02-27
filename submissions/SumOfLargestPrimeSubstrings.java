// Question: https://leetcode.com/problems/sum-of-largest-prime-substrings/description/

class SumOfLargestPrimeSubstrings {
    public long sumOfLargestPrimes(String s) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        boolean isTest = false;
        int n = s.length();
        long result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long value = Long.parseLong(s.substring(i, j + 1));
                if (value > 1 && !set.contains(value) && isPrime(value)) {
                    if (isTest) {
                        System.out.println(" * unique prime: " + value);
                    }
                    set.add(value);
                    minHeap.offer(value);
                    if (minHeap.size() > 3) {
                        minHeap.poll();
                    }
                }
            }
        }

        if (isTest) {
            System.out.println("----------------------------------\nminHeap: " + minHeap);
        }
        while (!minHeap.isEmpty()) {
            result += minHeap.poll();
        }

        return result;
    }

    private boolean isPrime(long value) {
        for (long i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }

        return true;
    }
}