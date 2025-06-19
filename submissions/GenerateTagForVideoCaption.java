// Question: https://leetcode.com/problems/generate-tag-for-video-caption/description/

class GenerateTagForVideoCaption {
    public String generateTag(String caption) {
        String[] words = caption.trim().split("\\s+");
        StringBuilder result = new StringBuilder("#");

        if (!words[0].isEmpty()) {
            result.append(words[0].toLowerCase());
        }
        for (int i = 1; i < words.length && result.length() < 100; i++) {
            if (words[i].isEmpty()) {
                continue;
            }
            String word = words[i];
            result.append(Character.toUpperCase(word.charAt(0)));
            result.append(word.substring(1).toLowerCase());
        }

        return result.substring(0, Math.min(100, result.length()));
    }
}
