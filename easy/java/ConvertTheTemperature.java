// Question: https://leetcode.com/problems/convert-the-temperature/description/

class ConvertTheTemperature {
    public double[] convertTemperature(double celsius) {
        return new double[] {celsius + 273.15, celsius * 1.80 + 32.00};
    }
}