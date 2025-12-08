// Question: https://leetcode.com/problems/count-square-sum-triples/description/

class CountSquareSumTriples {
    public int countTriples(int n) {
        boolean[] map = new boolean[n * n + 1];
        boolean isTest = false;
        int count = 0;

        for (int i = 1; i <= n; i++) {
            map[i * i] = true;
        }
        if (isTest) {
            System.out.println("map: " + Arrays.toString(map));
            System.out.println("-----------------------------------------");
        }
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if ((a * a + b * b) < map.length && map[a * a + b * b]) {
                    if (isTest) {
                        int first = a * a;
                        int second = b * b;
                        int third = first + second;
                        System.out.println(" * found | first: " + first + ", second: " + second + ", third: " + third);
                    }
                    count++;
                }
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------\ncount: " + count);
        }

        return count;
    }
}