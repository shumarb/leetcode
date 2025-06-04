// Question: https://leetcode.com/problems/report-spam-message/description/

class ReportSpamMessage {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> set = new HashSet<>(Arrays.asList(bannedWords));
        int count = 0;
        for (String word: message) {
            if (set.contains(word)) {
                count++;
                if (count == 2) {
                    return true;
                }
            }
        }

        return false;
    }
}