// Question: https://leetcode.com/problems/assign-umbrella-on-rainy-days/description/

class AssignUmbrellaOnRainyDays {
    public String[] assignUmbrella(int[] rain) {
        boolean isTest = false;
        int countAlice = 0;
        int countBob = 0;
        int n = rain.length;
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            if (rain[i] == 0) {
                result[i] = "None";

            } else if (i + 1 < n && rain[i + 1] == 1 && countAlice <= countBob) {
                result[i] = "Alice";
                countAlice++;

            } else {
                result[i] = "Bob";
                countBob++;
            }
        }
        if (isTest) {
            System.out.println("rain: " + Arrays.toString(rain) + "\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}
