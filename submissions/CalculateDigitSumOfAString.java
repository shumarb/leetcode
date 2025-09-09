// Question: https://leetcode.com/problems/calculate-digit-sum-of-a-string/description/

class CalculateDigitSumOfAString {
    public String digitSum(String s, int k) {
        if (s.length() == 1) {
            return s;
        }

        boolean isTest = false;

        while (s.length() > k) {
            if (isTest) {
                System.out.println("------------------------------");
                System.out.println("s: " + s);
            }

            StringBuilder newS = new StringBuilder();
            for (int i = 0; i < s.length(); i += k) {
                StringBuilder current = new StringBuilder();
                int upperBound = Math.min(i + k, s.length());

                for (int j = i; j < upperBound; j++) {
                    current.append(s.charAt(j));
                }
                if (isTest) {
                    System.out.println(" * i: " + i + " -> current: " + current.toString());
                }

                newS = update(newS, current.toString());
            }

            s = newS.toString();
        }
        if (isTest) {
            System.out.println("------------------------------");
            System.out.println("final s: " + s);
        }

        return s;
    }

    private StringBuilder update(StringBuilder newS, String current) {
        int sum = 0;

        for (char digit: current.toCharArray()) {
            sum += digit - '0';
        }
        newS.append(sum);

        return newS;
    }
}