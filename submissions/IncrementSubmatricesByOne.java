// Question: https://leetcode.com/problems/increment-submatrices-by-one/description/

class IncrementSubmatricesByOne {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, int[]> queryMap = new HashMap<>();
        boolean isTest = false;
        int[][] mat = new int[n][n];

        for (int[] query: queries) {
            String key = Arrays.toString(query);
            queryMap.putIfAbsent(key, query);
            map.put(key, 1 + map.getOrDefault(key, 0));
        }
        if (isTest) {
            System.out.println("map:");
            for (String key: map.keySet()) {
                System.out.println(" * " + key + ": " + map.get(key));
            }
            System.out.println("\nqueryMap:");
            for (String key: queryMap.keySet()) {
                System.out.println(" * " + key + ": " + Arrays.toString(queryMap.get(key)));
            }
            System.out.println("-------------------------------");
        }

        for (String key: map.keySet()) {
            int[] query = queryMap.get(key);
            int value = map.get(key);
            for (int i = query[0]; i <= query[2]; i++) {
                for (int j = query[1]; j <= query[3]; j++) {
                    mat[i][j] += value;
                }
            }
            if (isTest) {
                print("query: " + Arrays.toString(query) + "\nafter:", mat);
            }
        }
        if (isTest) {
            print("final:", mat);
        }

        return mat;
    }

    private void print(String s, int[][] grid) {
        System.out.println(s);
        for (int[] row: grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("-------------------------------");
    }
}
