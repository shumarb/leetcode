// Question: https://leetcode.com/problems/decode-the-message/description/

class DecodeTheMessage {
    public String decodeMessage(String key, String message) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        boolean[] checked = new boolean[26];
        char[] map = new char[26];
        int i = 0;

        for (char token: key.toCharArray()) {
            if (Character.isLowerCase(token) && !checked[token - 'a']) {
                if (isTest) {
                    System.out.println(token + " -> " + (char) ('a' + i));
                }
                checked[token - 'a'] = true;
                map[i++] = token;
            }
        }

        for (char token: message.toCharArray()) {
            if (Character.isLowerCase(token)) {
                int index = getIndex(map, token);
                result.append((char) ('a' + index));
            } else {
                result.append(token);
            }
        }
        if (isTest) {
            System.out.println("-------------------------------------------------------");
            System.out.println("key: " + key + "\nmessage: " + message);
            System.out.println("map: " + Arrays.toString(map));
        }

        return result.toString();
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