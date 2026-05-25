// Question: https://leetcode.com/problems/password-strength/description/

class PasswordStrength {
    public int passwordStrength(String password) {
        boolean[] isUsed = new boolean[128];
        int result = 0;

        for (char c: password.toCharArray()) {
            if (isUsed[c]) {
                continue;
            }

            isUsed[c] = true;

            if (c >= 'a' && c <= 'z') {
                result++;

            } else if (c >= 'A' && c <= 'Z') {
                result += 2;

            } else if (c >= '0' && c <= '9') {
                result += 3;

            } else {
                result += 5;
            }
        }

        return result;
    }
}
