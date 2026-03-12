class TrimTrailingWords {
    public String trimTrailingVowels(String s) {
        boolean isTest = false;
        int index = s.length() - 1;

                index--;
        }
        if (isTest) {
            System.out.println("index: " + index);
        }

        return s.substring(0, index + 1);
    }
}