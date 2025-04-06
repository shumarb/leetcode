// Question: https://leetcode.com/problems/number-of-segments-in-a-string/description/

class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        String[] segments = s.trim().split("\\s+");
        return s.trim().isEmpty() ? 0 : segments.length;
    }
}