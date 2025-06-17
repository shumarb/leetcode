// Question: https://leetcode.com/problems/existence-of-a-substring-in-a-string-and-its-reverse/description/

class ExistenceOfASubstringInAStringAndItsReverse {
    public boolean isSubstringPresent(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        boolean isTest = false;
        int len = s.length();

        if (isTest) {
            System.out.println("s: " + s + "\nreverse: " + reverse);
        }

        for (int i = 0; i < len - 1; i++) {
            String toCheck = s.substring(i, i + 2);
            if (isTest) {
                System.out.println("----------------------------------");
                System.out.println(" * toCheck: " + toCheck);
            }
            if (s.indexOf(toCheck) != -1 && reverse.indexOf(toCheck) != -1) {
                return true;
            }
        }

        return false;
    }
}