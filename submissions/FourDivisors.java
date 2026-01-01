// Question: https://leetcode.com/problems/four-divisors/description/

class FourDivisors {
    public int sumFourDivisors(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> sum = new HashMap<>();
        boolean isTest = false;
        int result = 0;

        for (int e: nums) {
            if (map.containsKey(e)) {
                continue;
            }
            List<Integer> divisors = getDivisors(e);
            if (isTest) {
                System.out.println("e: " + e + " -> divisors: " + divisors);
            }
            if (divisors.size() == 4) {
                int total = 0;
                for (int value: divisors) {
                    total += value;
                }
                map.put(e, divisors);
                sum.put(e, total);
            }
        }
        if (sum.isEmpty() || map.isEmpty()) {
            return 0;
        }

        for (int e: nums) {
            result += sum.getOrDefault(e, 0);
        }
        if (isTest) {
            System.out.println("------------------------------------");
            System.out.println("map: " + map + "\nsum: " + sum + "\nresult: " + result);
        }

        return result;
    }

    private List<Integer> getDivisors(int e) {
        List<Integer> divisors = new ArrayList<>();
        divisors.add(1);
        divisors.add(e);

        for (int i = 2; i <= Math.sqrt(e); i++) {
            if (e % i == 0) {
                divisors.add(i);
                if (e / i != i) {
                    divisors.add(e / i);
                }
            }
        }

        return divisors;
    }
}