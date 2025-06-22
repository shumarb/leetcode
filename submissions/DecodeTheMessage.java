// Question: https://leetcode.com/problems/decode-the-message/description/

class DecodeTheMessage {
    public String decodeMessage(String key, String message) {
        boolean isTest = false;
        boolean[] checked = new boolean[26];
        char[] result = new char[message.length()];
        char[] map = new char[26];
        int i = 0;

        for (char token: key.toCharArray()) {
            if (token == ' ') {
                continue;
            } else if (!checked[token - 'a']) {
                if (isTest) {
                    System.out.println(token + " -> " + (char) ('a' + i));
                }
                checked[token - 'a'] = true;
                map[i++] = token;
            }
        }

        for (int j = 0; j < message.length(); j++) {
            char token = message.charAt(j);
            if (Character.isLowerCase(token)) {
                result[j] = (char) ('a' + getIndex(map, token));
            } else {
                result[j] = token;
            }
        }
        if (isTest) {
            System.out.println("-------------------------------------------------------");
            System.out.println("key: " + key + "\nmessage: " + message);
            System.out.println("map: " + Arrays.toString(map));
        }

        return new String(result);
    }

    private int getIndex(char[] map, char letter) {
        for (int i = 0; i < map.length; i++) {
            if (map[i] == letter) {
                return i;
            }
        }

        return 'X'; // dummy value.
    }
}