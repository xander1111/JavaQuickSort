public class QuickSort {
    private static void qSort(int[] array, int left, int right) {
        if (array.length < 2) { // If the array is 1 or 0 items long, it can't be not sorted.
            return;
        }

        int pivot, i, j;
        i = left + 1;
        j = right;
        pivot = array[left];

        do {

            while (!(array[i] >= pivot) && i < array.length - 1) i++; // while a larger number has not been found, move through the list


            while (!(array[j] <= pivot)) j--; // same thing but looking for a smaller number
            // no value check is needed as j will always eventually reach the pivot at the start and find that it's equal

            if (i <= j) { // if i hasn't passed j yet, swap the values at i and j
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;

                i++; // make sure the next loop doesn't look at the same numbers, if it does it can get stuck swapping the
                j--; // same number with itself when i = j and the value at that point equals the pivot value
            }
        } while (i <= j);
        // i and j passed each other, partition into 2 sub arrays

        // swap the pivot and j
        array[left] = array[j];
        array[j] = pivot;

        if (j > left) { // makes sure j doesn't go past the left bound
            qSort(array, left, j - 1);
        }

        if (i < right) { // makes sure i doesn't go past the right bound
            qSort(array, j + 1, right);
        }
    }

    public static void quickSort(int[] array) { // a more applicable method than qSort
        qSort(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        java.util.Random rand = new java.util.Random();
        int[] testArray = new int[1000];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = rand.nextInt(10000);
        }

        quickSort(testArray);
        System.out.println(java.util.Arrays.toString(testArray));
    }
}
