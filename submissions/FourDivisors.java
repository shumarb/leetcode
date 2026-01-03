// Question: https://leetcode.com/problems/four-divisors/description/

class FourDivisors {
    public int sumFourDivisors(int[] nums) {
        boolean isTest = false;
        int[] map;
        int largest = 0;
        int result = 0;

        for (int e: nums) {
            largest = Math.max(e, largest);
        }
        map = new int[largest + 1];

        for (int e: nums) {
            if (map[e] > 0) {
                result += map[e];
                continue;
            }

            List<Integer> divisors = new ArrayList<>();
            divisors.add(1);
            divisors.add(e);

            for (int i = 2; i <= Math.sqrt(e); i++) {
                if (e % i == 0) {
                    divisors.add(i);
                    if (e / i != i) {
                        divisors.add(e / i);
                    }
                    if (divisors.size() > 4) {
                        break;
                    }
                }
            }
            if (divisors.size() == 4) {
                if (isTest) {
                    System.out.println(" * valid: " + e + " -> divisors: " + divisors);
                }
                int sum = 0;
                for (int number: divisors) {
                    result += number;
                    sum += number;
                }
                map[e] = sum;
            }
        }
        if (isTest) {
            System.out.println("----------------------------------------------------");
            System.out.println("map: " + Arrays.toString(map) + "\nresult: " + result);
        }

        return result;
    }
}