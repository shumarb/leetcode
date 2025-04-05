// Question: https://leetcode.com/problems/thousand-separator/description/

class ThousandSeparator {
    public String thousandSeparator(int n) {
        StringBuilder result = new StringBuilder();
        String nString = String.valueOf(n);
        boolean isTest = false;

        if (isTest) {
            System.out.println("n: " + n + "\nnString: " + nString);
        }

        int i = nString.length() - 1;
        while (i >= 0) {
            for (int j = 0; j < 3 && i >= 0; j++) {
                result.append(nString.charAt(i--));
            }
            if (i >= 0) {
                result.append('.');
            }
        }
        result = result.reverse();

        if (isTest) {
            System.out.println("result: " + result.toString());
        }

        return result.toString();
    }
}