public class SelectionSort implements SortingInterface{
 
    @Override
    public void sort(int[] array, int i) {
        int min = i;
        for(int j = i+1; j < array.length; j++) {
            if(array[j] < array[min]) {
                min = j;
           }
        }
        if(min != i) {
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
} 