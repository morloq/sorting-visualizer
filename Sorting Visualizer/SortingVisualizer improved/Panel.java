import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.IntConsumer;
import java.util.stream.IntStream; // only use the imports needed, otherwise you flood the namespace of files with unneded imports

public class Panel extends JPanel{

    private static final int
        WIN_WIDTH = 1200, WIN_HEIGHT = 800,
        RANGE = WIN_HEIGHT - 100,
        ELEMENTS = 1200;

    private final Random rand = new Random();

    private final int[] array = 
        IntStream.generate(() -> rand.nextInt(RANGE)).limit(ELEMENTS).toArray();

    private final SortingAlgorithm[] algos = {
        new SelectionSort(), new InsertionSort(), new BubbleSort()
    };

   private final List<JButton> algoButtons = 
        Arrays.stream(algos)
        .map(algo -> {
            JButton button = new JButton(algo.getName());
            button.addActionListener(event -> initSort(algo));
            return button;
        }).toList();

    private final JButton resetButton = new JButton("reset");

    public Panel() {

        setPreferredSize(new Dimension(WIN_WIDTH, WIN_HEIGHT));
        setOpaque(true);//otherwise backgroundcolor won't be visible
        algoButtons.forEach(this::add);
        resetButton.addActionListener(this::resetArray);
        add(resetButton);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.ORANGE);
        for(int i = 0; i < this.getArray().length; i++) {
            g.drawRect(i, 800 - array[i], 1, array[i]);//1 is the thickness of the rectangle
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

    private void enableButtons(boolean enabled) {
        resetButton.setEnabled(enabled);
        algoButtons.stream().forEach(x -> x.setEnabled(enabled));
    }

    private void animate(IntConsumer consume, int time) {
        enableButtons(false);
        new Thread(() -> {
            for(int i = 0; i < getArray().length; i++) {
                consume.accept(i);
                render(time);
            }
            enableButtons(true);
        }).start();
    }

    public void resetArray(ActionEvent e) {
        animate(i -> array[i] = rand.nextInt(RANGE), 1);
    }

    public void initSort(SortingAlgorithm algorithm) {
        animate(i -> algorithm.sort(array, i), 10);
    }    
}