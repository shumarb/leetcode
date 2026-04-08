// Question: https://leetcode.com/problems/making-file-names-unique/description/

class MakingFileNamesUnique {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] result = new String[names.length];
        boolean isTest = false;
        int index = 0;

        for (String name: names) {
            if (isTest) {
                System.out.println("name: " + name + "\n * before, map: " + map);
            }
            if (!map.containsKey(name)) {
                result[index++] = name;
                map.put(name, 1);

            } else {
                StringBuilder newName = new StringBuilder(name);
                int k = map.get(name);

                newName.append("(");
                newName.append(k);
                newName.append(")");

                while (map.containsKey(newName.toString())) {
                    newName = new StringBuilder(name);
                    newName.append("(");
                    newName.append(++k);
                    newName.append(")");
                }

                result[index++] = newName.toString();
                map.put(name, k + 1);
                map.put(newName.toString(), 1);
            }

            if (isTest) {
                System.out.println(" * after, map: " + map + "\n---------------------------------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("final map: " + map + "\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}
