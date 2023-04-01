public class InsertionSort implements SortingInterface{

    @Override
    public void sort(int[] array, int i) {
        if(array[i] < array[i-1]) {
            for(int j = 0; j < i; j++) {
                if(array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    }
                }
            }
        }
    }