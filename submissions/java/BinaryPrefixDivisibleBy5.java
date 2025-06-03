// Question: https://leetcode.com/problems/binary-prefix-divisible-by-5/description/

class BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        boolean isTest = false;
        int value = 0;

        for (int bit: nums) {
            value = ((value << 1) + bit) % 5;
            if (isTest) {
                System.out.println("value: " + value);
            }
            result.add(value == 0);
        }

        return result;
    }
}