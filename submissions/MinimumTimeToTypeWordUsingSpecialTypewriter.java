// Question: https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/description/

class MinimumTimeToTypeWordUsingSpecialTypewriter {
    public int minTimeToType(String word) {
        boolean isTest = false;
        char last = 'a';
        final int click = 1;
        int result = 0;

        for (char c: word.toCharArray()) {
            if (isTest) {
                System.out.println("last: " + last + ", c: " + c);
            }
            int diff1 = Math.abs(last - c);
            int diff2 = Math.abs(26 - diff1);
            if (isTest) {
                System.out.println(" * " + last + " ==> " + c + ": " + diff1);
                System.out.println(" * " + c + " ==> " + last + ": " + diff2);
                System.out.println("----------------------------------------------");
            }
            result += Math.min(diff1, diff2);
            result += click;
            last = c;
        }

        return result;
    }
}