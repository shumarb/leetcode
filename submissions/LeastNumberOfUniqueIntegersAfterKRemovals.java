// Question: https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/description/

class LeastNumberOfUniqueIntegersAfterKRemoval {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        List<Pair> list = new ArrayList<>();
        boolean isTest = false;
        int current;
        int count = 1;
        int total = 0;

        Arrays.sort(arr);
        current = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == current) {
                count++;
            } else {
                list.add(new Pair(current, count));
                current = arr[i];
                count = 1;
            }
        }
        list.add(new Pair(current, count));
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
                total++;
            }
        }
        if (isTest) {
            System.out.println("-------------------------------------\nafter, list: ");
            for (Pair e: list) {
                System.out.println(" * number: " + e.number + " -> count: " + e.count);
            }
        }

        return total;
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