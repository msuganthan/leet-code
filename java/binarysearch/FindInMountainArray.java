package binarysearch;

public class FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();

        //Find peak
        int l = 1;
        int r = length - 2;
        int m = 0;
        while(l <= r) {
            m = (l + r) / 2;
            int left = mountainArr.get(m - 1);
            int mid = mountainArr.get(m);
            int right = mountainArr.get(m + 1);

            if(left < mid && mid < right) {
                l = m + 1;
            } else if(left > mid && mid > right) {
                r = m - 1;
            } else {
                break;
            }
        }
        int peak = m;

        //search left portion
        l = 0;
        r = peak;
        while(l <= r) {
            m = (l + r) / 2;
            int val = mountainArr.get(m);
            if(val < target) {
                l = m + 1;
            } else if(val > target) {
                r = m - 1;
            } else {
                return m;
            }
        }

        //search right portion
        l = peak;
        r = length - 1;
        while(l <= r) {
            m = (l + r) / 2;
            int val = mountainArr.get(m);
            if(val > target) {
                l = m + 1;
            } else if(val < target) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    interface MountainArray {
        public default int get(int index) {
            return index;
        }
        public default int length() {
            return 0;
        }
    }
}
