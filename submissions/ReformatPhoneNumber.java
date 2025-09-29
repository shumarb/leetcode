// Question: https://leetcode.com/problems/reformat-phone-number/description/

class ReformatPhoneNumber {
    public String reformatNumber(String number) {
        Queue<Character> digits = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        boolean isTest = false;

        for (char c: number.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.offer(c);
            }
        }
        if (isTest) {
            System.out.println("before, digits: " + digits);
        }

        while (digits.size() > 4) {
            for (int i = 0; i < 3; i++) {
                result.append(digits.poll());
            }
            result.append('-');
        }

        if (digits.size() <= 3) {
            while (!digits.isEmpty()) {
                result.append(digits.poll());
            }
        } else {
            for (int i = 0; i < 2; i++) {
                result.append(digits.poll());
            }
            result.append('-');
            for (int i = 0; i < 2; i++) {
                result.append(digits.poll());
            }
        }
        if (isTest) {
            System.out.println("after, digits: " + digits);
            System.out.println("---------------------------------------\nresult: " + result.toString());
        }

        return result.toString();
    }
}