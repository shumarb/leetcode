// Question: https://leetcode.com/problems/sort-integers-by-the-power-value/description/

class SortIntegersByThePowerValue {
    public int getKth(int lo, int hi, int k) {
        boolean isTest = false;
        int[][] list = new int[hi - lo + 1][];
        int j = 0;

        for (int i = lo; i <= hi; i++) {
            int count = 0;
            int x = i;
            while (x != 1) {
                if (x % 2 == 0) {
                    x /= 2;
                } else {
                    x = (3 * x + 1);
                }
                count++;
            }
            list[j++] = new int[] {i, count};
        }
        Arrays.sort(list, (a, b) -> Integer.compare(a[1], b[1]));
        if (isTest) {
            System.out.println("list:");
            for (int[] entry: list) {
                System.out.println(" * " + Arrays.toString(entry));
            }
        }

        return list[k - 1][0];
    }
}