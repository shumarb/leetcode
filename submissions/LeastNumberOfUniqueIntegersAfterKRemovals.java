// Question: https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/description/

class LeastNumberOfUniqueIntegersAfterKRemoval {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        List<Pair> list = new ArrayList<>();
        boolean isTest = false;
        int count = 1;
        int current;
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
        total = list.size();

        for (Pair e: list) {
            if (k >= e.count) {
                k -= e.count;
                total--;
            }
        }
        if (isTest) {
            System.out.println("list (sorted in ascending number of count): ");
            for (Pair e: list) {
                System.out.println(" * number: " + e.number + " -> count: " + e.count);
            }
            System.out.println("----------------------------------------------\ntotal: " + total);
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