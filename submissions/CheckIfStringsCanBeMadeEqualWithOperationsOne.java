// Question: https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i/description/

class CheckIfStringsCanBeMadeEqualWithOperationsOne {
    public boolean canBeEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        boolean isTest = false;
        char[] s1Letters = s1.toCharArray();
        char[] s2Letters = s2.toCharArray();

        for (int i = 0; i <= 1; i++) {
            char[] s1Clone = s1Letters.clone();
            char temp = s1Clone[i];
            s1Clone[i] = s1Clone[i + 2];
            s1Clone[i + 2] = temp;
            if (isTest) {
                System.out.println(" * compare: " + Arrays.toString(s1Clone) + ", " + Arrays.toString(s2Letters));
            }
            if (Arrays.equals(s1Clone, s2Letters)) {
                return true;
            }

            if (i == 0) {
                temp = s1Clone[i + 1];
                s1Clone[i + 1] = s1Clone[i + 3];
                s1Clone[i + 3] = temp;
                if (isTest) {
                    System.out.println(" * compare: " + Arrays.toString(s1Clone) + ", " + Arrays.toString(s2Letters));
                }
                if (Arrays.equals(s1Clone, s2Letters)) {
                    return true;
                }
            } else {
                temp = s1Clone[0];
                s1Clone[0] = s1Clone[2];
                s1Clone[2] = temp;
                if (isTest) {
                    System.out.println(" * compare: " + Arrays.toString(s1Clone) + ", " + Arrays.toString(s2Letters));
                }
                if (Arrays.equals(s1Clone, s2Letters)) {
                    return true;
                }
            }
        }
        for (int i = 0; i <= 1; i++) {
            char[] s2Clone = s2Letters.clone();
            char temp = s2Clone[i];
            s2Clone[i] = s2Clone[i + 2];
            s2Clone[i + 2] = temp;
            if (isTest) {
                System.out.println(" * compare: " + Arrays.toString(s2Clone) + ", " + Arrays.toString(s1Letters));
            }
            if (Arrays.equals(s2Clone, s1Letters)) {
                return true;
            }

            if (i == 0) {
                temp = s2Clone[i + 1];
                s2Clone[i + 1] = s2Clone[i + 3];
                s2Clone[i + 3] = temp;
                if (isTest) {
                    System.out.println(" * compare: " + Arrays.toString(s2Clone) + ", " + Arrays.toString(s1Letters));
                }
                if (Arrays.equals(s2Clone, s1Letters)) {
                    return true;
                }
            } else {
                temp = s2Clone[0];
                s2Clone[0] = s2Clone[2];
                s2Clone[2] = temp;
                if (isTest) {
                    System.out.println(" * compare: " + Arrays.toString(s2Clone) + ", " + Arrays.toString(s1Letters));
                }
                if (Arrays.equals(s2Clone, s1Letters)) {
                    return true;
                }
            }
        }

        return false;
    }
}