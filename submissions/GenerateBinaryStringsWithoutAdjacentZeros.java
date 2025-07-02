// Question: https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros/description/

class GenerateBinaryStringsWithoutAdjacentZeros {
    private List<String> result;
    private int n;

    public List<String> validStrings(int n) {
        boolean isTest = false;
        this.n = n;
        result = new ArrayList<>();

        helper('0', new StringBuilder());
        helper('1', new StringBuilder());
        if (isTest) {
            System.out.println("n: " + n + "\nresult: " + result);
        }

        return result;
    }

    private void helper(char c, StringBuilder current) {
        if (current.length() >= n) {
            return;
        }

        char last;
        int len = current.length();

        if (len > 0) {
            last = current.charAt(current.length() - 1);
            if (last == '0' && c == '0') {
                return;
            }
        }

        current.append(c);
        if (current.length() == n) {
            result.add(current.toString());
        } else {
            if (current.length() > 0) {
                last = current.charAt(current.length() - 1);
                if (last == '0') {
                    helper('1', current);
                } else {
                    helper('0', current);
                    helper('1', current);
                }
            }
        }

        current.setLength(len);
    }
}