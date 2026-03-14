// Question: https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/

class Solution {
    private List<String> list;
    private boolean isTest;
    private char[] letters;
    private int k;
    private int n;

    public String getHappyString(int n, int k) {
        String result = "";
        this.isTest = false;
        this.k = k;
        this.letters = new char[] {'a', 'b', 'c'};
        this.list = new ArrayList<>();
        this.n = n;

        explore(new StringBuilder());
        result = list.size() == k ? list.get(list.size() - 1) : "";
        if (isTest) {
            System.out.println("k: " + k + "\n----------------------\nlist:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(" * " + (i + 1) + ": " + list.get(i));
            }
            System.out.println("----------------------\nresult: " + result);
        }

        return result;
    }

    private void explore(StringBuilder current) {
        if (list.size() == k) {
            return;
        }
        if (current.length() == n) {
            list.add(current.toString());
            return;
        }

        for (char c: letters) {
            if (current.isEmpty() || current.charAt(current.length() - 1) != c) {
                current.append(c);
                explore(current);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
}