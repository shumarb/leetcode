// Question: https://leetcode.com/problems/top-k-frequent-elements/description/

class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        boolean isTest = false;

        for (int number: nums) {
            map.put(number, 1 + map.getOrDefault(number, 0));
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            list.add(entry);
        }
        list.sort((e1, e2) -> e2.getValue() - e1.getValue());
        if (isTest) {
            System.out.println("list:");
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                System.out.println(" * " + entry);
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }
        if (isTest) {
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}