// Question: https://leetcode.com/problems/report-spam-message/description/

class ReportSpamMessage {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> set = new HashSet<>();
        int count = 0;
        for (String word: bannedWords) {
            set.add(word);
        }
        for (String word: message) {
            if (set.contains(word)) {
                count++;
            }
            if (count == 2) {
                return true;
            }
        }

        return false;
    }
}