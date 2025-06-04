// Question: https://leetcode.com/problems/strong-password-checker-ii/description/

class StrongPasswordCheckerTwo {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }
        if (!hasCase(password, "lower") || !hasCase(password, "upper")) {
            return false;
        }
        if (!hasDigit(password)) {
            return false;
        }
        if (!hasSpecialCharacter(password)) {
            return false;
        }
        if (hasSameAdjacentCharacters(password)) {
            return false;
        }

        return true;
    }

    private boolean hasSameAdjacentCharacters(String password) {
        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i) == password.charAt(i - 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSpecialCharacter(String password) {
        for (char c: password.toCharArray()) {
            if (c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '^' || c == '&' || c == '*' || c == '(' || c == ')' || c == '-' || c == '+') {
                return true;
            }
        }
        return false;
    }

    private boolean hasDigit(String password) {
        for (char c: password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCase(String password, String type) {
        if (type.equals("lower")) {
            for (char c: password.toCharArray()) {
                if (Character.isLowerCase(c)) {
                    return true;
                }
            }
            return false;
        }
        for (char c: password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

}