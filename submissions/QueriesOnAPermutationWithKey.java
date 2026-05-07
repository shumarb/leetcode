// Question: https://leetcode.com/problems/queries-on-a-permutation-with-key/description/

class QueriesOnAPermutationWithKey {
    public int[] processQueries(int[] queries, int m) {
        boolean isTest = false;
        int n = queries.length;
        int[] P = new int[m];
        int[] result = new int[n];

        for (int i = 0; i < P.length; i++) {
            P[i] = i + 1;
        }
        if (isTest) {
            System.out.println("P: " + Arrays.toString(P));
        }

        for (int i = 0; i < n; i++) {
            int key = queries[i];
            if (isTest) {
                System.out.println("---------------------------------\ni: " + i + " -> key: " + key);
                System.out.println("before, P: " + Arrays.toString(P));
            }

            for (int j = 0; j < P.length; j++) {
                if (P[j] == key) {
                    result[i] = j;
                    P = update(P, key);
                    break;
                }
            }

            if (isTest) {
                System.out.println("after, P:  " + Arrays.toString(P));
            }
        }

        return result;
    }

    private int[] update(int[] P, int key) {
        int[] result = new int[P.length];
        int j = 0;
        result[j++] = key;

        for (int i = 0; i < P.length; i++) {
            if (P[i] == key) {
                continue;
            }
            result[j++] = P[i];
        }

        return result;
    }
}
