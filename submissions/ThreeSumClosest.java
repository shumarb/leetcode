// Question: https://leetcode.com/problems/3sum-closest/description/

class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        List<Integer> closestTriplet = new ArrayList();
        boolean isTest = false;
        int n = nums.length;
        int result = 0;
        int smallestAbsoluteDifferenceToTarget = Integer.MAX_VALUE;

        sort(nums);
        if (isTest) {
            System.out.println("target: " + target + "\nsorted nums: " + Arrays.toString(nums) + "\n---------------------------------------------------------------");
        }

        for (int i = 0; i <= n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;
            int key = target - nums[i];

            while (j < k) {
                List<Integer> triplet = List.of(nums[i], nums[j], nums[k]);
                int sum = nums[j] + nums[k];
                int tripletSum = sum + nums[i];

                if (isTest) {
                    System.out.println("indices: [" + i + ", " + j + ", " + k + "] | tripletSum: " + tripletSum + " | triplet: " + triplet);
                }

                // 1. Triplet sum == target is closest to target, no further searches needed.
                if (sum == key) {
                    closestTriplet = triplet;
                    result = target;
                    break;

                } else {
                    /**
                     2. Compute absolute difference of triplet's sum to target. If it's distance to target is smaller than what's recorded, it's sum is the closest to target.
                     */
                    int currentAbsoluteDifferenceToTarget = Math.abs(tripletSum - target);

                    if (currentAbsoluteDifferenceToTarget < smallestAbsoluteDifferenceToTarget) {
                        closestTriplet = triplet;
                        result = tripletSum;
                        smallestAbsoluteDifferenceToTarget = currentAbsoluteDifferenceToTarget;
                    }

                    if (sum < key) {
                        j++;

                    } else {
                        k--;
                    }
                }
            }
        }
        if (isTest) {
            System.out.println("---------------------------------------------------------------\nclosestTriplet: " + closestTriplet + "\nsmallestAbsoluteDifferenceToTarget: " + smallestAbsoluteDifferenceToTarget + "\nresult: " + result);
        }

        return result;
    }

    private void sort(int[] arr) {
        int[] count = new int[20001];
        int j = 0;
        int offset = 10000;

        for (int e: arr) {
            count[e + offset]++;
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                arr[j++] = i - offset;
            }
        }
    }
}
