// Question: https://leetcode.com/problems/making-file-names-unique/description/

class MakingFileNamesUnique {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        boolean isTest = false;

        for (int i = 0; i < names.length; i++) {
            String file = names[i];
            int count = map.getOrDefault(file, 0);

            if (isTest) {
                System.out.println("file: " + file + "\n * before, map: " + map);
            }

            while (map.containsKey(file)) {
                file = names[i] + "(" + count + ")";
                count++;
            }

            map.put(names[i], count);
            map.put(file, 1);
            names[i] = file;
            if (isTest) {
                System.out.println(" * after, map: " + map);
                System.out.println("---------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("result: " + Arrays.toString(names));
        }

        return names;
    }
}
