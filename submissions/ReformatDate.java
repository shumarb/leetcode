// Question: https://leetcode.com/problems/reformat-date/description/

class ReformatDate {
    public String reformatDate(String date) {
        StringBuilder result = new StringBuilder();
        String[] tokens = date.split(" ");
        boolean isTest = false;

        result.append(tokens[2]);
        result.append('-');
        result.append(getMonthValue(tokens[1]));
        result.append('-');

        String part = tokens[0].substring(0, 2);
        if (Character.isDigit(part.charAt(0)) && Character.isDigit(part.charAt(1))) {
            result.append(part.substring(0, 2));
        } else {
            result.append('0');
            result.append(part.charAt(0));
        }

        if (isTest) {
            System.out.println("tokens: " + Arrays.toString(tokens) + "\nresult: " + result);
        }

        return result.toString();
    }

    private String getMonthValue(String month) {
        switch(month) {
            case "Jan": return "01";
            case "Feb": return "02";
            case "Mar": return "03";
            case "Apr": return "04";
            case "May": return "05";
            case "Jun": return "06";
            case "Jul": return "07";
            case "Aug": return "08";
            case "Sep": return "09";
            case "Oct": return "10";
            case "Nov": return "11";
            default: return "12";
        }
    }
}