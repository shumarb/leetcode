// Question: https://leetcode.com/problems/number-of-lines-to-write-string/description/

class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        boolean isTest = false;
        int currentWidth = 0;
        int totalLines = 0;
        int width = 0;

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (isTest) {
                System.out.println("i: " + i + " -> letter: " + letter);
                System.out.println(" * before, currentWidth: " + currentWidth + "\n * totalLines: " + totalLines);
            }
            if (currentWidth + widths[letter - 'a'] <= 100) {
                currentWidth += widths[letter - 'a'];
            } else {
                totalLines++;
                currentWidth = widths[letter - 'a'];
            }
            if (isTest) {
                System.out.println(" * after, currentWidth: " + currentWidth + ", totalLines: " + totalLines);
                System.out.println("-------------------------------------------------------");
            }
        }
        if (currentWidth > 0) {
            totalLines++;
        }

        return new int[] {totalLines, currentWidth};
    }
}