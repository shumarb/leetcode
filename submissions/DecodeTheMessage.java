// Question: https://leetcode.com/problems/decode-the-message/description/

class DecodeTheMessage {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        int i = 0;

        for (char token: key.toCharArray()) {
            if (Character.isLowerCase(token) && !set.contains(token)) {
                set.add(token);
                if (isTest) {
                    System.out.println(token + " -> " + (char) ('a' + i));
                }
                map.put(token, (char) ('a' + i));
                i++;
            }
        }

        for (char token: message.toCharArray()) {
            if (Character.isLowerCase(token)) {
                result.append(map.get(token));
            } else {
                result.append(token);
            }
        }
        if (isTest) {
            System.out.println("---------------------------------------------");
            System.out.println("key: " + key + "\nmessage: " + message);
            System.out.println("---------------------------------------------");
            System.out.println("set: " + set + "\nmap: " + map);
            System.out.println("result: " + result.toString());
        }

        return result.toString();
    }
}