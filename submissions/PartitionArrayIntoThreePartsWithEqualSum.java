// Question: https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/description/

class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] arr) {
        int countPartitions = 0;
        int runningSum = 0;
        int total = 0;

        for (int e: arr) {
            total += e;
        }

        /**
         1.  If sum of elements is divisible by 3,
             it is possible to partition array into 3 parts,
             so compute a running sum and increase number of partitions if it is equal to total / 3 and reset it to 0.
             Return true once 3 partitions are formed.
         */
        if (total % 3 == 0) {
            for (int i = 0; i < arr.length; i++) {
                runningSum += arr[i];
                if (runningSum == (total / 3)) {
                    if (++countPartitions == 3) {
                        return true;
                    }
                    runningSum = 0;
                }
            }
        }

        return false;
    }
}
