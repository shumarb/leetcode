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
            for (int b = a; b <= n; b++) {
                if ((a * a + b * b) < map.length && map[a * a + b * b]) {
                    if (isTest) {
                        int first = a * a;
                        int second = b * b;
                        int third = first + second;
                        System.out.println(" * found | first: " + first + ", second: " + second + ", third: " + third);
                    }
                    /**
                     1.  Count double because a & b can be swapped to form c^2.
                         Example: 36 + 64 == 100 also means 64 + 36 == 100.
                         Hence, 1 triple is 6^2 + 8^2 == 5^2, and 8^2 + 6^2 == 5^2.
                         Hence, 2 triples are formed when 1 is formed.
                     */
                    count += 2;
                }
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------\ncount: " + count);
        }

        return count;
    }
}