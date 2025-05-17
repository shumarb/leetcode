// Question: https://leetcode.com/problems/insert-interval/description/

class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean isTest = false;
        int[][] combined = new int[intervals.length + 1][];
        int[][] result = null;

        int i = 0;
        for (int[] entry: intervals) {
            combined[i++] = entry;
        }
        combined[i] = newInterval;
        Arrays.sort(combined, (a, b) -> Integer.compare(a[0], b[0]));
        if (isTest) {
            display("sorted combined:", combined);
        }

        int j = 0;
        List<int[]> list = new ArrayList<>();
        int[] current = combined[0];
        list.add(current);
        for (int[] entry: combined) {
            if (isTest) {
                System.out.println(" * checking | current: " + Arrays.toString(current) + ", entry: " + Arrays.toString(entry));
            }
            if (entry[0] <= current[1]) {
                current[1] = Math.max(entry[1], current[1]);
            } else {
                list.add(entry);
                current = entry;
            }
        }
        if (isTest) {
            System.out.println("list:");
            for (int[] entry: list) {
                System.out.println(" * " + Arrays.toString(entry));
            }
            System.out.println("------------------------------------------------------------------------");
        }

        result = new int[list.size()][];
        if (isTest) {
            System.out.println("result size: " + result.length);
        }
        j = 0;
        for (int[] entry: list) {
            result[j++] = entry;
        }
        if (isTest) {
            display("result:", result);
        }

        return result;
    }

    private void display(String sentence, int[][] matrix) {
        System.out.println(sentence);
        for (int[] row: matrix) {
            System.out.println(" * " + Arrays.toString(row));
        }
        System.out.println("------------------------------------------------------------------------");
    }
}