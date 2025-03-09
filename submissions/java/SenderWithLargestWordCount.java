// Question: https://leetcode.com/problems/sender-with-largest-word-count/description/

class SenderWithLargestWordCount {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();
        boolean isTest = false;
        String result = null;

        for (int i = 0; i < senders.length; i++) {
            if (isTest) {
                System.out.println(" * " + senders[i] + " --> " + messages[i]);
            }
            if (!map.containsKey(senders[i])) {
                map.put(senders[i], messages[i].split(" ").length);
            } else {
                map.put(senders[i], map.get(senders[i]) + messages[i].split(" ").length);
            }
        }
        if (isTest) {
            System.out.println("------------------------------------------------------------");
            System.out.println("map: " + map);
        }

        int currentCount = -1;
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (result == null) {
                result = entry.getKey();
                currentCount = entry.getValue();
            } else {
                if (entry.getValue() > currentCount) {
                    currentCount = entry.getValue();
                    result = entry.getKey();
                } else if (entry.getValue() == currentCount && entry.getKey().compareTo(result) > 0) {
                    result = entry.getKey();
                }
            }
        }

        return result;
    }
}