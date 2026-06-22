// Question: https://leetcode.com/problems/maximum-number-of-balloons/description/

class MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        boolean isTest = false;
        int[] count = new int[26];
        int result = 0;

        for (char c: text.toCharArray()) {
            count[c - 'a']++;
        }
        if (isTest) {
            System.out.println("text: " + text + "\ncount: " + Arrays.toString(count));
        }

        while (true) {
            if (count['b' - 'a'] == 0) {
                break;
            }
            count['b' - 'a']--;

            if (count['a' - 'a'] == 0) {
                break;
            }
            count['a' - 'a']--;

            if (count['l' - 'a'] <= 1) {
                break;
            }
            count['l' - 'a'] -= 2;

            if (count['o' - 'a'] <= 1) {
                break;
            }
            count['o' - 'a'] -= 2;

            if (count['n' - 'a'] == 0) {
                break;
            }
            count['n' - 'a']--;

            result++;
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}
