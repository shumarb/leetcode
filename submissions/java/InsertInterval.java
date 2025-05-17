// Question: https://leetcode.com/problems/insert-interval/description/

class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        boolean isTest = false;
        int[][] combined = new int[intervals.length + 1][];

        int i = 0;
        for (int[] entry: intervals) {
            combined[i++] = entry;
        }
        combined[i] = newInterval;
        Arrays.sort(combined, (a, b) -> Integer.compare(a[0], b[0]));
        if (isTest) {
            display("sorted combined:", combined);
        }

        int[] current = combined[0];
        result.add(current);
        for (int[] entry: combined) {
            if (isTest) {
                System.out.println(" * checking | current: " + Arrays.toString(current) + ", entry: " + Arrays.toString(entry));
            }
            if (entry[0] <= current[1]) {
                current[1] = Math.max(entry[1], current[1]);
            } else {
                result.add(entry);
                current = entry;
            }
        }
        if (isTest) {
            System.out.println("result: ");
            for (int[] entry: result) {
                System.out.println(" * " + Arrays.toString(entry));
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    private void display(String sentence, int[][] matrix) {
        System.out.println(sentence);
        for (int[] row: matrix) {
            System.out.println(" * " + Arrays.toString(row));
        }
        System.out.println("------------------------------------------------------------------------");
    }
}