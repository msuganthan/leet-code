package binarysearch;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] answer = new int[n + m];

        int i = 0;
        int j = 0;
        int k = 0;
        while(i < n && j < m) {
            if(nums1[i] < nums2[j]) {
                answer[k++] = nums1[i++];
            } else {
                answer[k++] = nums2[j++];
            }
        }
        while(i < n) {
            answer[k++] = nums1[i++];
        }
        while(j < m) {
            answer[k++] = nums2[j++];
        }
        if(answer.length % 2 == 0) {
            int mid = answer.length / 2;
            return (double)(answer[mid - 1] + answer[mid]) / 2;
        } else {
            return (double)answer[answer.length / 2];
        }
    }
}
