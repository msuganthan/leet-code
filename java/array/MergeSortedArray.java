package array;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int num1Index = 0;
        int num2Index = 0;
        int[] answer = new int[m + n];
        int answerIndex = 0;
        while(num1Index < m && num2Index < n) {
            if(nums1[num1Index] < nums2[num2Index]) {
                answer[answerIndex] = nums1[num1Index];
                num1Index++;
            } else {
                answer[answerIndex] = nums2[num2Index];
                num2Index++;
            }
            answerIndex++;
        }
        while(num1Index < m) {
            answer[answerIndex++] = nums1[num1Index++];
        }
        while(num2Index < n) {
            answer[answerIndex++] = nums2[num2Index++];
        }
        System.arraycopy(answer, 0, nums1, 0, answer.length);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while(i >= 0 && j >= 0) {
            if(nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }

        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
