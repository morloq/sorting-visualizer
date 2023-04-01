import javax.swing.*;

public class Frame extends JFrame{

    public Frame() {
        this.getContentPane().add(new Panel());
        this.setTitle("Sorting visualizer");
        this.pack();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}