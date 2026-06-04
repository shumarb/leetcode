// Question: https://leetcode.com/problems/maximum-white-tiles-covered-by-a-carpet/description/

class MaximumWhiteTilesCoveredByACarpet {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        List<int[]> list = new ArrayList<>();
        boolean isTest = false;
        int[] current;
        int covered = 0;
        int j = 0;
        int n;
        int result = 0;
        long curr = 0;

        Arrays.sort(tiles,
                (a, b) -> Integer.compare(a[0], b[0]) == 0
                        ? Integer.compare(a[1], b[1])
                        : Integer.compare(a[0], b[0])
        );

        current = tiles[0];
        for (int i = 1; i < tiles.length; i++) {
            int[] incoming = tiles[i];
            if (incoming[0] == 1 + current[1]) {
                current[1] = Math.max(current[1], incoming[1]);
            } else {
                list.add(current);
                current = incoming;
            }
        }
        list.add(current);
        if (isTest) {
            System.out.println("sorted tiles:");
            for (int[] tile: tiles) {
                System.out.println(Arrays.toString(tile));
            }
            System.out.println("----------------------------\ncarpetLen: " + carpetLen + "\nlist:");
            for (int[] e: list) {
                System.out.println(Arrays.toString(e) + ": " + (e[1] - e[0] + 1));
            }
            System.out.println("----------------------------");
        }

        n = list.size();

        for (int i = 0; i < n; i++) {
            int carpetEnd = list.get(i)[0] + carpetLen - 1;

            while (j < n && list.get(j)[1] <= carpetEnd) {
                covered += list.get(j)[1] - list.get(j)[0] + 1;
                j++;
            }

            curr = covered;

            if (j < n && list.get(j)[0] <= carpetEnd) {
                curr += carpetEnd - list.get(j)[0] + 1;
            }
            if (isTest) {
                System.out.println(" * curr: " + curr);
            }

            result = Math.max((int) curr, result);

            covered -= list.get(i)[1] - list.get(i)[0] + 1;
        }
        if (isTest) {
            System.out.println("----------------------------\nresult: " + result);
        }

        return result;
    }
}
