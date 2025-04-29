// Question: https://leetcode.com/problems/sort-integers-by-the-power-value/description/

class SortIntegersByThePowerValue {
    public int getKth(int lo, int hi, int k) {
        boolean isTest = false;
        List<int[]> list = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            list.add(new int[] {i, getPowerValue(i)});
        }
        Collections.sort(list, (a, b) -> Integer.compare(a[1], b[1]));
        if (isTest) {
            System.out.println("list:");
            for (int[] entry: list) {
                System.out.println(" * " + Arrays.toString(entry));
            }
        }
        return list.get(k - 1)[0];
    }

    private int getPowerValue(int x) {
        int count = 0;
        while (x != 1) {
            if (x % 2 == 0) {
                x /= 2;
            } else {
                x = (3 * x + 1);
            }
            count++;
        }
        return count;
    }
}