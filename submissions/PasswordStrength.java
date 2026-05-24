// Question: https://leetcode.com/problems/password-strength/description/

class PasswordStrength {
    public int passwordStrength(String password) {
        Set<Character> digit = new HashSet<>();
        Set<Character> lower = new HashSet<>();
        Set<Character> special = new HashSet<>();
        Set<Character> upper = new HashSet<>();
        boolean isTest = false;
        int result = 0;

        for (char e: password.toCharArray()) {
            if (Character.isDigit(e) && digit.add(e)) {
                if (isTest) {
                    System.out.println(" * counted: " + e + ": " + 3);
                }
                result += 3;
                continue;
            }

            if (Character.isLowerCase(e) && lower.add(e)) {
                if (isTest) {
                    System.out.println(" * counted: " + e + ": " + 1);
                }
                result += 1;
                continue;
            }

            if (Character.isUpperCase(e) && upper.add(e)) {
                if (isTest) {
                    System.out.println(" * counted: " + e + ": " + 2);
                }
                result += 2;
                continue;
            }

            if ("!@#$".indexOf(e) >= 0 && special.add(e)) {
                if (isTest) {
                    System.out.println(" * counted: " + e + ": " + 5);
                }
                result += 5;
                continue;
            }
        }
        if (isTest) {
            System.out.println("\nresult: " + result);
        }

        return result;
    }
}
