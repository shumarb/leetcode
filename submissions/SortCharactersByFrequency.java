// Question: https://leetcode.com/problems/sort-characters-by-frequency/description/

class SortCharactersByFrequency {
    public String frequencySort(String s) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        int[] characterFrequency = new int[62];

        for (char c: s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                characterFrequency[c - 'A']++;
            } else if (c >= 'a' && c <= 'z') {
                characterFrequency[c - 'a' + 26]++;
            } else {
                characterFrequency[c - '0' + 52]++;
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\ncharacterFrequency: " + Arrays.toString(characterFrequency));
        }

        List<Pair> list = new ArrayList<>();
        for (char c: s.toCharArray()) {
            if (c >= 'A' && c <= 'Z' && characterFrequency[c - 'A'] > 0) {
                list.add(new Pair(c, characterFrequency[c - 'A']));
                characterFrequency[c - 'A'] = 0;
            } else if (c >= 'a' && c <= 'z' && characterFrequency[c - 'a' + 26] > 0) {
                list.add(new Pair(c, characterFrequency[c - 'a' + 26]));
                characterFrequency[c - 'a' + 26] = 0;
            } else if (c >= '0' && c <= '9' && characterFrequency[c - '0' + 52] > 0) {
                list.add(new Pair(c, characterFrequency[c - '0' + 52]));
                characterFrequency[c - '0' + 52] = 0;
            }
        }
        list.sort(
                (a, b) -> a.getCount() == b.getCount() ? a.getSChar() - b.getSChar() : b.getCount() - a.getCount()
        );
        if (isTest) {
            System.out.println("list:");
            for (Pair entry: list) {
                System.out.println(" * " + entry.getSChar() + " --> " + entry.getCount());
            }
        }

        for (Pair pair: list) {
            for (int i = 0; i < pair.getCount(); i++) {
                result.append(pair.getSChar());
            }
        }
        if (isTest) {
            System.out.println("result: " + result.toString());
        }

        return result.toString();
    }
}

class Pair {
    private char sChar;
    private int count;

    public Pair(char sChar, int count) {
        this.sChar = sChar;
        this.count = count;
    }

    public char getSChar() {
        return sChar;
    }

    public int getCount() {
        return count;
    }
}