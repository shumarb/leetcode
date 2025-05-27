// Question: https://leetcode.com/problems/sender-with-largest-word-count/description/

class SenderWithLargestWordCount {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();
        String result = "";
        boolean isTest = false;
        int maximumCount = -1;

        for (int i = 0; i < senders.length; i++) {
            String sender = senders[i];
            String message = messages[i];
            if (isTest) {
                System.out.println(" * " + sender + " --> " + message);
            }
            if (!map.containsKey(sender)) {
                map.put(sender, message.split(" ").length);
            } else {
                map.put(sender, map.get(sender) + message.split(" ").length);
            }
        }

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            String currentSender = entry.getKey();
            int currentCount = entry.getValue();
            if (currentCount > maximumCount || (currentCount == maximumCount && currentSender.compareTo(result) > 0)) {
                result = currentSender;
                maximumCount = currentCount;
            }
        }
        if (isTest) {
            System.out.println("------------------------------------------------------------");
            System.out.println("map: " + map);
            System.out.println("result: " + result + " | maximumCount: " + maximumCount);
        }

        return result;
    }
}