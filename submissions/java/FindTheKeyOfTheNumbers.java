// Question: https://leetcode.com/problems/find-the-key-of-the-numbers/description/

class FindTheKeyOfTheNumbers {
    public int generateKey(int num1, int num2, int num3) {
        int key = 0;
        boolean isTest = false;

        String num1Str = getString(num1);
        String num2Str = getString(num2);
        String num3Str = getString(num3);
        if (isTest) {
            System.out.println(num1 + " --> " + num1Str);
            System.out.println(num2 + " --> " + num2Str);
            System.out.println(num3 + " --> " + num3Str);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int firstDigit = Character.getNumericValue(num1Str.charAt(i));
            int secondDigit = Character.getNumericValue(num2Str.charAt(i));
            int thirdDigit = Character.getNumericValue(num3Str.charAt(i));
            result.append(Math.min(thirdDigit, Math.min(firstDigit, secondDigit)));
        }

        return Integer.parseInt(result.toString());
    }


    private String getString(int num) {
        StringBuilder result = new StringBuilder();
        result.append(num);
        while (result.length() < 4) {
            result.insert(0, '0');
        }
        return result.toString();
    }
}