package miscellaneous;

public class Interviewing {
    public static void main(String[] args) {
        /**
         * Nth smallest Index
         */
        System.out.println(new NthSmallestElement().nthSmallestElement(new int[] {10, 7, 1, 8, 12, 13}, 3));
    }

    static class NthSmallestElement {
        //ToDo: This is not working
        public int nthSmallestElement(int[] array, int nthSmallestIndex) {
            return getNthSmallestElement(array, 0, array.length - 1, nthSmallestIndex);
        }

        private int getNthSmallestElement(int[] array, int low, int high, int nthSmallestIndex) {
            if (low < high) {
                int pivot = lomutoPartition(array, low, high);
                if (pivot == nthSmallestIndex) {
                    return array[nthSmallestIndex];
                }
                if (nthSmallestIndex > pivot) {
                    return getNthSmallestElement(array, nthSmallestIndex, pivot + 1, high);
                }
                return getNthSmallestElement(array, nthSmallestIndex, low, pivot - 1);
            }
            return -1;
        }

        private int lomutoPartition(int[] array, int low, int high) {
            int pivot = array[high], j = low;
            for (int i = low; i < high; i++) {
                if (array[i] < pivot) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    ++j;
                }
            }
            int temp = array[high];
            array[high] = array[j];
            array[j] = temp;
            return j;
        }
    }
}
