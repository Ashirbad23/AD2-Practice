import java.util.Arrays;

public class quickSort {

    public static void main(String[] args) {
        int arr[] = {7, 2, 5, 8, 1, 6, 3, 9, 4, 0};

        QuickSort(arr, 0, arr.length-1);
        System.out.println("Sorted array: "+ Arrays.toString(arr));


    }
    static void QuickSort(int[] arr, int low, int high){
        if(low<=high){
            int j = partition(arr, low, high);
            QuickSort(arr, low, j-1);
            QuickSort(arr, j+1, high);

        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low], i = low, j = high;

        while(i<j){
            while(i<high && arr[i]<=pivot){
                i+=1;
            }
            while(j>low && arr[j]>pivot){
                j-=1;
            }
            if(i<j){
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j; 
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}