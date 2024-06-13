import java.util.Arrays;

public class countingInversions {
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 8, 1, 6, 3, 9, 4, 0};
        int count = MergeSortAndCount(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(count);
    }

    static int MergeSortAndCount(int[] arr, int low, int high){
        int count = 0;
        if(low>=high){
            return count;
        }
        int n = (low+high)/2;
        count+=MergeSortAndCount(arr, low, n);
        count+=MergeSortAndCount(arr, n+1, high);
        count+=MergeAndCount(arr, low, n, high);
        return count;
    }
    static int MergeAndCount(int[] arr, int low, int mid, int high){
        int n1 = (mid-low)+1;
        int n2 = high-mid;
        int count = 0;

        int[] left = new int[n1];
        int[] right = new int[n2];


        for(int i=0; i<n1; i++){
            left[i] = arr[low+i];
        }
        for(int i=0; i<n2; i++){
            right[i] = arr[mid+1+i];
        }

        int i = 0,j = 0;
        int k = low;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[k] = left[i];
                i++;
            }
            else{
                arr[k] = right[j];
                count = (mid+1)-(low+i);
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j<n2){
            arr[k] = right[j];
            k++;
            j++;
        }
        return count;
    }
}
