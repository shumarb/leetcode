// Question: https://leetcode.com/problems/stone-removal-game/description/

class StoneRemovalGame {
    public boolean canAliceWin(int n) {
        List<Integer> list = new ArrayList<>();
        boolean isTest = false;
        int countRemoval = 10;
        list.add(n);

        while (true) {
            int remainder = list.get(list.size() - 1);
            if (remainder - countRemoval < 0) {
                break;
            } else {
                list.add(remainder - countRemoval);
                countRemoval--;
            }
        }
        if (isTest) {
            System.out.println("list: " + list);
        }

        return list.size() % 2 == 1 ? false : true;
    }
}