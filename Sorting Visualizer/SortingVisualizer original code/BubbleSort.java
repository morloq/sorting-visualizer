public class BubbleSort implements SortingInterface{

    @Override
    public void sort(int[] array, int i) {
            for(int j = i+1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }