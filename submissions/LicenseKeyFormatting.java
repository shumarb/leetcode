// Question: https://leetcode.com/problems/license-key-formatting/description/

class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder parts = new StringBuilder();
        StringBuilder result = new StringBuilder();
        boolean isTest = false;

        for (char letter: s.toCharArray()) {
            if (Character.isLowerCase(letter)) {
                parts.append(Character.toUpperCase(letter));
            } else {
                if (letter != '-') {
                    parts.append(letter);
                }
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\nk: " + k + "\nparts: " + parts.toString());
            System.out.println("----------------------------------------------------------");
        }

        int i = parts.length() - 1;

        while (i >= 0) {
            if (isTest) {
                System.out.println(" * i: " + i + "\nbefore, result: " + result.toString());
            }
            int count = 0;
            while (count != k && i >= 0) {
                result.append(parts.charAt(i));
                count++;
                i--;
            }
            if (i >= 0) {
                result.append('-');
            }
            if (isTest) {
                System.out.println(" * after, result: " + result.toString());
                System.out.println("----------------------------------------------------------");
            }
        }
        result = result.reverse();
        if (isTest) {
            System.out.println("result after reverse: " + result.toString());
        }

        return result.toString();
    }
}