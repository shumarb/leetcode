// Question: https://leetcode.com/problems/categorize-box-according-to-criteria/description/

class CategorizeBoxAccordingToCriteria {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean isBulky = false;
        boolean isHeavy = false;
        boolean isTest = false;
        long volume = (long) length * (long) width * (long) height;

        if (volume >= 1000000000 || isBulkyDimension(length) || isBulkyDimension(width) || isBulkyDimension(height)) {
            isBulky = true;
        }
        if (mass >= 100) {
            isHeavy = true;
        }

        if (isTest) {
            System.out.println("length: " + length + ", width: " + width + ", height: " + height);
            System.out.println("mass: " + mass);
            System.out.println("volume: " + volume);
            System.out.println("isBulky: " + isBulky + ", isHeavy: " + isHeavy);
        }

        if (isBulky && isHeavy) {
            return "Both";
        } else if (!isBulky && !isHeavy) {
            return "Neither";
        } else if (isBulky && !isHeavy) {
            return "Bulky";
        } else {
            return "Heavy";
        }
    }

    private boolean isBulkyDimension(int dimension) {
        return dimension >= 10000;
    }
}