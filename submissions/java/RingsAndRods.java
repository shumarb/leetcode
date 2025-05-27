// Question: https://leetcode.com/problems/rings-and-rods/description/

class RingsAndRods {
    public int countPoints(String rings) {
        boolean isTest = false;
        Map<Integer, Set<Character>> map = new HashMap<>();
        int countPoints = 0;

        for (int i = 0; i < rings.length(); i += 2) {
            char letter = rings.charAt(i);
            int rod = Character.getNumericValue(rings.charAt(i + 1));
            if (isTest) {
                System.out.println(letter + " -> " + rod);
            }
            if (!map.containsKey(rod)) {
                Set<Character> set = new HashSet<>();
                set.add(letter);
                map.put(rod, set);
            } else {
                Set<Character> set = map.get(rod);
                set.add(letter);
            }
        }
        for (Map.Entry<Integer, Set<Character>> entry: map.entrySet()) {
            if (entry.getValue().size() == 3) {
                countPoints++;
            }
        }

        if (isTest) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("rings: " + rings);
            System.out.println("map:");
            for (Map.Entry<Integer, Set<Character>> entry: map.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
            System.out.println("-------------------------------------------------------------");
            System.out.println("countPoints: " + countPoints);
        }

        return countPoints;
    }
}