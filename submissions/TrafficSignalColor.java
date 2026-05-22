// Question: https://leetcode.com/problems/traffic-signal-color/description/

class TrafficSignalColor {
    public String trafficSignal(int timer) {
        if (timer == 0) {
            return "Green";
        } else if (timer == 30) {
            return "Orange";
        }

        return timer > 30 && timer <= 90 ? "Red" : "Invalid";
    }
}
