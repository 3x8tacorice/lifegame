import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.Color;
import java.awt.BorderLayout;
import java.time.LocalDateTime;

import java.awt.Graphics;
import java.lang.Thread;
import java.awt.List;
import java.util.ArrayList;
import java.util.stream.Stream;


class MainPanel extends JPanel implements Runnable {
    JLabel dateLabel = new JLabel();
    String dateString;
    MainPanel(){
        // setBackground(Color.BLUE);
        // add(dateLabel);
        Thread t = new Thread(this);
        t.start();
    }
    public JLabel getDateLabel(){
        return this.dateLabel;
    }
    @Override
    public void paintComponent(Graphics g){
        System.out.println("Repaint!!!");
        super.paintComponent(g);
        // dateLabel.setText("Hello");
        this.add(dateLabel);
    }
    @Override
    public void run(){
        Integer count = 1;
        ArrayList<Cell> cells = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            cells.add(new Cell(Math.random() < 0.5, i, 0));
        }
        while (true) {
            System.out.println(count);
            // dateLabel.setText(count.toString());
            cells.stream()
                .forEach(c -> {
                    c.setIsAlive(Math.random() < 0.5);
                    System.out.println(c.getIsAlive());
                });
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // repaint();
            count++;
        }
    }
}