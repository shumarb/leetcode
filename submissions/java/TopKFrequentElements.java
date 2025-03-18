// Question: https://leetcode.com/problems/top-k-frequent-elements/description/

class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        int[] numberFrequency = new int[20001];
        boolean isTest = false;
        for (int number: nums) {
            numberFrequency[number + 10000]++;
        }

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < numberFrequency.length; i++) {
            if (numberFrequency[i] > 0) {
                list.add(new int[] {i - 10000, numberFrequency[i]});
            }
        }
        list.sort(
                (a, b) -> Integer.compare(b[1], a[1])
        );
        if (isTest) {
            System.out.println("list:");
            for (int[] entry: list) {
                System.out.println(" * (" + entry[0] + " --> freq: " + entry[1] + ")");
            }
        }

        for (int i = 0; i < k; i++) {
            result[i] = list.get(i)[0];
        }

        return result;
    }
}