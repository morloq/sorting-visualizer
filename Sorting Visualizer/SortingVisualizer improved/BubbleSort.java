public class BubbleSort implements SortingAlgorithm{
    
    @Override
    public void sort(int[] array, int target) {
        int i = target;
        for(int j = i+1; j < array.length; j++) {
            if(array[i] > array[j]) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }

    @Override
    public String getName() {
        return "bubble sort";
    }
}