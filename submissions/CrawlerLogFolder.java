// Question: https://leetcode.com/problems/crawler-log-folder/description/

class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        int count = 0;

        for (String log: logs) {
            if (log.equals("./")) {
                continue;

            } else if (log.equals("../")) {
                if (count > 0) {
                    count--;
                }

            } else {
                count++;
            }
        }

        return count;
    }
}