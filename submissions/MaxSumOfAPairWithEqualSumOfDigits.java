// Question: https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/description/

class MaxSumOfAPairWithEqualSumOfDigits {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        boolean isTest = false;
        int n = s.length();

        // 1. Edge case: Insuffient characters.
        if (n < 10) {
            return result;
        }

        for (int i = 0; i <= n - 10; i++) {
            String substring = s.substring(i, i + 10);
            map.put(substring, 1 + map.getOrDefault(substring, 0));
        }
        for (Map.Entry<String, Integer> e: map.entrySet()) {
            if (e.getValue() > 1) {
                result.add(e.getKey());
            }
        }
        if (isTest) {
            System.out.println("map:");
            for (Map.Entry<String, Integer> e: map.entrySet()) {
                System.out.println(e.getKey() + " -> " + e.getValue());
            }
            System.out.println("-------------------------------\nresult: " + result);
        }

        return result;
    }
}