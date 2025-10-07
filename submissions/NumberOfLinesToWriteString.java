// Question: https://leetcode.com/problems/number-of-lines-to-write-string/description/

class NumberOfLinesToWriteString {
    public int[] numberOfLines(int[] widths, String s) {
        int totalLines = 1;
        int width = 0;

        for (char letter: s.toCharArray()) {
            int letterWidth = widths[letter - 'a'];
            if (width + letterWidth > 100) {
                totalLines++;
                width = letterWidth;
            } else {
                width += letterWidth;
            }
        }

        return new int[] {totalLines, width};
    }
}