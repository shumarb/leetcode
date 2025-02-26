// Question: https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description/

class SortIntegersByTheNumberOf1Bits {
    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        List<Pair> sortedNumbers = new ArrayList();
        boolean isTest = false;

        for (int element: arr) {
            sortedNumbers.add(new Pair(element, getNumOneBits(element)));
        }
        sortedNumbers.sort((e1, e2) -> e1.getElement() != e2.getElement() ? e1.getNumOneBits() - e2.getNumOneBits() : e1.getElement() - e2.getElement());
        if (isTest) {
            System.out.println("before, nums: " + Arrays.toString(arr));
            System.out.print("sorted numbers: [");
            for (int i = 0; i < sortedNumbers.size() - 1; i++) {
                Pair current = sortedNumbers.get(i);
                System.out.print("(" + current.getElement() + ", " + current.getNumOneBits() + "), ");
            }
            Pair last = sortedNumbers.get(sortedNumbers.size() - 1);
            System.out.println("(" + last.getElement() + ", " + last.getNumOneBits() + ")]");
        }

        int i = 0;
        for (Pair current: sortedNumbers) {
            arr[i++] = current.getElement();
        }
        if (isTest) {
            System.out.println("after, nums: " + Arrays.toString(arr));
        }

        return arr;
    }

    private int getNumOneBits(int element) {
        int countNumOneBits = 0;
        while (element != 0) {
            if (element % 2 == 1) {
                countNumOneBits++;
            }
            element /= 2;
        }
        return countNumOneBits;
    }
}

class Pair {
    private int element;
    private int numOneBits;

    public Pair(int element, int numOneBits) {
        this.element = element;
        this.numOneBits = numOneBits;
    }

    public int getElement() {
        return element;
    }

    public int getNumOneBits() {
        return numOneBits;
    }
}