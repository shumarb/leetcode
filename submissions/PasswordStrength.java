// Question: https://leetcode.com/problems/password-strength/description/

class PasswordStrength {
    public int passwordStrength(String password) {
        Set<Character> special = new HashSet<>();
        boolean[] digits = new boolean[10];
        boolean[] letters = new boolean[52];
        boolean isTest = false;
        int result = 0;

        for (char e: password.toCharArray()) {
            if (Character.isDigit(e) && !digits[e - '0']) {
                if (isTest) {
                    System.out.println(" * counted: " + e + ": " + 3);
                }
                digits[e - '0'] = true;
                result += 3;
                continue;
            }

            if (Character.isLetter(e)) {
                if (Character.isUpperCase(e) && !letters[e - 'A']) {
                    if (isTest) {
                        System.out.println(" * counted: " + e + ": " + 2);
                    }
                    letters[e - 'A'] = true;
                    result += 2;

                } else if (Character.isLowerCase(e) && !letters[e - 'a' + 26]) {
                    if (isTest) {
                        System.out.println(" * counted: " + e + ": " + 1);
                    }
                    letters[e - 'a' + 26] = true;
                    result += 1;
                }

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
