// Question: https://leetcode.com/problems/existence-of-a-substring-in-a-string-and-its-reverse/description/

class ExistenceOfASubstringInAStringAndItsReverse {
    public boolean isSubstringPresent(String s) {
        Set<String> checked = new HashSet<>();
        String reverse;
        boolean isTest = false;
        char[] letters = s.toCharArray();
        int left = 0;
        int len = s.length();
        int right = len - 1;

        while (left < right) {
            char temp = letters[left];
            letters[left++] = letters[right];
            letters[right--] = temp;
        }
        reverse = new String(letters);
        if (isTest) {
            System.out.println("s: " + s + "\nreverse: " + reverse);
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                StringBuilder check = new StringBuilder();
                check.append(s.charAt(i));
                check.append(s.charAt(j));
                if (isTest) {
                    System.out.println("------------------------------------------------------");
                    System.out.println(" * check: " + check);
                }

                String checkStr = check.toString();
                if (!checked.contains(checkStr) && s.indexOf(checkStr) != -1 && reverse.indexOf(checkStr) != -1) {
                    return true;
                }
                checked.add(checkStr);
            }
        }

        return false;
    }
}