// Question: https://leetcode.com/problems/resulting-string-after-adjacent-removals/description/

class ResultingStringAfterAdjacentRemovals {
    public String resultingString(String s) {
        StringBuilder result = new StringBuilder();

        for (char c: s.toCharArray()) {
            if (result.length() > 0) {
                char top = result.charAt(result.length() - 1);
                int absoluteDifference = Math.abs(top - c);

                if (absoluteDifference == 1 || absoluteDifference == 25) {
                    /**
                     1.  If adjacent pair (incoming + last character of result),
                         remove last character of result and skip appending c.
                     */
                    result.deleteCharAt(result.length() - 1);
                    continue;
                }
            }

            result.append(c);
        }

        return result.toString();
    }
}