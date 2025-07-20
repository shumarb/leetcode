// Question: https://leetcode.com/problems/string-without-aaa-or-bbb/description/

class StringWithoutAAAOrBBB {
    public String strWithout3a3b(int a, int b) {
        StringBuilder result = new StringBuilder();

        while (a > 0 || b > 0) {
            int len = result.length();

            if (a > b) {
                if (a > 1) {
                    result.append("aa");
                    a -= 2;

                } else if (a > 0) {
                    result.append('a');
                    a--;
                }

                if (b > 0) {
                    result.append('b');
                    b--;
                }

            } else if (b > a) {
                if (b > 1) {
                    result.append("bb");
                    b -= 2;

                } else if (b > 0) {
                    result.append('b');
                    b--;
                }

                if (a > 0) {
                    result.append('a');
                    a--;
                }

            } else {
                result.append("ab");
                a--;
                b--;
            }
        }

        return result.toString();
    }
}