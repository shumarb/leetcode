// Question: https://leetcode.com/problems/generate-tag-for-video-caption/description/

class GenerateTagForVideoCaption {
    public String generateTag(String caption) {
        String[] words = caption.trim().split("\\s+");
        StringBuilder tag = new StringBuilder("#");

        if (words.length == 0) {
            return "";
        } else if (words.length == 1 && words[0] == "") {
            return "#";
        }

        if (!words[0].isEmpty()) {
            tag.append(words[0].toLowerCase());
        }
        for (int i = 1; i < words.length && tag.length() < 100; i++) {
            if (words[i].isEmpty()) {
                continue;
            }
            String word = words[i];
            tag.append(Character.toUpperCase(word.charAt(0)));
            tag.append(word.substring(1).toLowerCase());
        }

        return tag.substring(0, Math.min(100, tag.length()));
    }
}
