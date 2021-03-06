import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.Color;
import java.awt.BorderLayout;
import java.time.LocalDateTime;




public class MyFrame extends JFrame implements Runnable {
    int width = 400;
    int height = 400;
    JLabel dateLabel = new JLabel();
    public static void main(String[] args) {
        MyFrame frame = new MyFrame("タイトル");
        frame.setVisible(true);
        Thread t = new Thread(frame);
        t.start();
    }

    MyFrame(String title){
        setTitle(title);
        setSize(width, height);
        setLocationRelativeTo(null);//初期画面表示位置を中央に
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container CP = getContentPane();
        //CP.setLayout(null);

        JPanel panel = new JPanel();
        JButton startBtn = new JButton("Hello");
        startBtn.addActionListener(e -> System.out.println("Hello"));
        JButton stopBtn = new JButton("World");
        stopBtn.addActionListener(e -> System.out.println("World"));
        JButton getTimeBtn = new JButton("What Time");
        getTimeBtn.addActionListener(e -> {
            dateLabel.setText(LocalDateTime.now().toString());
            add(dateLabel);
        });
        panel.add(startBtn);
        panel.add(stopBtn);
        panel.add(getTimeBtn);
        panel.setBackground(Color.ORANGE);
        CP.add(panel, BorderLayout.NORTH);
        CP.add(dateLabel);
    }
    @Override
    public void run(){
        int count = 1;
        while (true) {
            System.out.println(count);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }
}