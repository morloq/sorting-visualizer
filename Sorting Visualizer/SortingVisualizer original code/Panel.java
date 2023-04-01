import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel implements ActionListener{

    private int[] array = new int[Constants.ELEMENTS.getValue()];

    private SelectionSort selectionSort;
    private InsertionSort insertionSort;
    private BubbleSort bubbleSort;

    private JButton[] buttons;

    private JButton selectionSortButton = new JButton("selection sort");
    private JButton reset = new JButton("reset");
    private JButton insertionSortButton = new JButton("insertion sort");
    private JButton bubbleSortButton = new JButton("bubble sort");


    public Panel() {

        this.buttons = new JButton[] {selectionSortButton, insertionSortButton, bubbleSortButton, reset};
    
        this.selectionSort = new SelectionSort();
        this.insertionSort = new InsertionSort();
        this.bubbleSort = new BubbleSort();

        this.setPreferredSize(new Dimension(Constants.WIN_WIDTH.getValue(),   Constants.WIN_HEIGHT.getValue()));
        this._initArray();

        this.setOpaque(true);//otherwise backgroundcolor won't be visible

        for(JButton button : buttons){
            button.addActionListener(this);
            this.add(button);
        }
    }

    public void _initArray() {
        for(int i = 0; i < this.array.length; i++) {
            array[i] = (int)(Math.random() * Constants.RANGE.getValue()+1);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.ORANGE);
        for(int i = 0; i < this.getArray().length; i++) {
            g.drawRect(i, 800 - array[i], 1, array[i]);
            g.fillRect(i, 800 - array[i], 1, array[i]);
        }
    }

    public int[] getArray() {
        return this.array;
    }

    public void render(int time) {
        repaint();       
        try{
             Thread.sleep(time);
           }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void resetArray() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < getArray().length; i++) {
                    getArray()[i] = (int)(Math.random() * Constants.RANGE.getValue()+1);
                    render(1);
                }
            }
        });
        t.start();
    }

    public void initSort(SortingInterface sortint, int start) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = start; i <= getArray().length; i++) {
                    sortint.sort(getArray(), i);
                    render(10);
                }
            }
        });
        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.reset) {
            this.resetArray();
        }
        if(e.getSource() == this.selectionSortButton){
            initSort(selectionSort, 0);
        }
        if(e.getSource() == this.insertionSortButton) {
            initSort(insertionSort, 1);
        }
        if(e.getSource() == this.bubbleSortButton) {
            initSort(bubbleSort, 0);
        }
    }
}