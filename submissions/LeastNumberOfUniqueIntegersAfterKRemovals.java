// Question: https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/description/

class LeastNumberOfUniqueIntegersAfterKRemoval {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        List<Pair> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        boolean isTest = false;
        int count = 0;

        for (int number: arr) {
            map.put(number, 1 + map.getOrDefault(number, 0));
        }
        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            list.add(new Pair(e.getKey(), e.getValue()));
        }
        list.sort((a, b) -> Integer.compare(a.count, b.count));
        if (isTest) {
            System.out.println("before, list: ");
            for (Pair e: list) {
                System.out.println(" * number: " + e.number + " -> count: " + e.count);
            }
        }
        for (Pair e: list) {
            if (k >= e.count) {
                k -= e.count;
                e.number = -1;
            }
        }
        for (Pair e: list) {
            if (e.number != -1) {
                count++;
            }
        }
        if (isTest) {
            System.out.println("-------------------------------------\nafter, list: ");
            for (Pair e: list) {
                System.out.println(" * number: " + e.number + " -> count: " + e.count);
            }
        }

        return count;
    }
}

class Pair {
    int count = 0;
    int number = 0;

    public Pair(int number, int count) {
        this.count = count;
        this.number = number;
    }
}