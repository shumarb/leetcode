// Question: https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/description/

class ReplaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters {
    public String modifyString(String s) {
        char[] result = s.toCharArray();

        for (int i = 0; i < result.length; i++) {
            if (result[i] == '?') {
                // 1. ? is at start of s.
                if (i == 0) {
                    // 2. If s is of length 1, replace sole character with another character.
                    if (result.length == 1) {
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c != result[0]) {
                                result[0] = c;
                                return new String(result);
                            }
                        }
                    }
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != result[i + 1]) {
                            result[i] = c;
                            break;
                        }
                    }
                }

                // 3. ? is at end of s.
                else if (i == result.length - 1) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != result[i - 1]) {
                            result[i] = c;
                            break;
                        }
                    }

                    // 4. ? between start and end of s.
                } else {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != result[i - 1] && c != result[i + 1]) {
                            result[i] = c;
                            break;
                        }
                    }
                }
            }
        }

        return new String(result);
    }
}