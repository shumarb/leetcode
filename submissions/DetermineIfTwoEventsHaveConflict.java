// Question: https://leetcode.com/problems/determine-if-two-events-have-conflict/description/

class DetermineIfTwoEventsHaveConflict {
    public boolean haveConflict(String[] event1, String[] event2) {
        /**
         1st check: end of first event is after or exactly at the start of second event.
         2nd check: end of second event is after or exactly at the start of first event.
         Overlap occurs if both checks return true.
         */
        return event1[1].compareTo(event2[0]) >= 0 && event2[1].compareTo(event1[0]) >= 0;
    }
}