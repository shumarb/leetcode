// Question: https://leetcode.com/problems/generate-tag-for-video-caption/description/

class Solution {
    public String generateTag(String caption) {
        String[] words = caption.trim().split("\\s+");
        StringBuilder result = new StringBuilder("#");

        for (int i = 0; i < words.length && result.length() < 100; i++) {
            String word = words[i];
            if (word.isEmpty()) {
                continue;
            }
            if (i == 0) {
                result.append(word.toLowerCase());
            } else {
                result.append(Character.toUpperCase(word.charAt(0)));
                result.append(word.substring(1).toLowerCase());
            }
        }

        return result.length() > 100 ? result.substring(0, 100) : result.toString();
    }
}
