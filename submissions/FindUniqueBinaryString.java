// Question: https://leetcode.com/problems/find-unique-binary-string/description/

class FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> set = new HashSet<>();
        boolean isTest = false;
        int n = nums.length;

        for (String s: nums) {
            set.add(getDecimal(s));
        }
        if (isTest) {
            System.out.println("set: " + set);
        }

        int i = 0;
        while (i <= n) {
            if (!set.contains(i)) {
                StringBuilder result = new StringBuilder();
                Stack<Integer> bits = new Stack<>();
                int number = i;

                for (int j = 0; j < n; j++) {
                    bits.push(number % 2);
                    number /= 2;
                }
                while (!bits.isEmpty()) {
                    result.append(bits.pop());
                }
                if (isTest) {
                    System.out.println("bits: " + bits);
                    System.out.println("result: " + result.toString());
                }

                return result.toString();
            } else {
                i++;
            }
        }

        return "";
    }

    private int getDecimal(String s) {
        double number = 0;
        double power = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                number += Math.pow(2.0, power);
            }
            power++;
        }

        return (int) number;
    }
}

