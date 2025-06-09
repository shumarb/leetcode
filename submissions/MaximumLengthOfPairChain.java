// Question: https://leetcode.com/problems/maximum-length-of-pair-chain/description/

class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        // 1. Edge case: Total pairs is 1, so longest chain is 1.
        if (pairs.length == 1) {
            return 1;
        }

        List<int[]> chain = new ArrayList<>();
        boolean isTest = false;

        if (isTest) {
            display("before sort, pairs: ", pairs);
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        if (isTest) {
            display("after sort, pairs: ", pairs);
        }

        int[] current = pairs[0];
        chain.add(current);
        for (int i = 1; i < pairs.length; i++) {
            int[] incoming = pairs[i];
            if (isTest) {
                System.out.println(" * i: " + i + "\ncurrent: " + Arrays.toString(current) + "\nincoming: " + Arrays.toString(incoming));
                System.out.println("-----------------------------------------------------------------");
            }
            if (current[1] < incoming[0]) {
                chain.add(incoming);
                current = incoming;
            }
        }
        if (isTest) {
            System.out.println("chain: ");
            for (int i = 0; i < chain.size() - 1; i++) {
                System.out.print(Arrays.toString(chain.get(i)) + " -> ");
            }
            System.out.println(Arrays.toString(chain.get(chain.size() - 1)));
        }

        return chain.size();
    }

    private void display(String sentence, int[][] pairs) {
        System.out.println(sentence);
        for (int[] pair: pairs) {
            System.out.println(Arrays.toString(pair));
        }
        System.out.println("-----------------------------------------------------------------");
    }
}