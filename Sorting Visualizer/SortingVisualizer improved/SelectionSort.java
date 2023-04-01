public class SelectionSort implements SortingAlgorithm{
    
    @Override//outer loop to iterate through the entire array is in the panel class sorting method
    public void sort(int[] array, int target) {
        int min = target;
        for(int i = target+1; i < array.length; i++) {
            if(array[min] > array[i]) {
                min = i;
            }
        }
        if(min != target) {
            int temp = array[target];
            array[target] = array[min];
            array[min] = temp;
        }
    }

    @Override
    public String getName() {
        return "selection sort";
    }
} 