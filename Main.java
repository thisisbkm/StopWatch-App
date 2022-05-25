import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main{
    public static void main(String[] args){
        new StopWatch();
    }
}
class StopWatch implements ActionListener{
    JFrame frame = new JFrame("StopWatch");
    JButton startButton = new JButton("Start");
    JButton resetButton = new JButton("Reset");
    JLabel timeLabel = new JLabel();
    int elapsedTime  = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;

    String seconds_str = String.format("%02d", seconds);
    String minutes_str = String.format("%02d", minutes);
    String hours_str = String.format("%02d", hours);

    Timer timer = new Timer(1000, new ActionListener(){
        public void actionPerformed(ActionEvent e){
            elapsedTime+=1000;
            hours = (elapsedTime/3600000);
            minutes = (elapsedTime/60000) % 60;
            seconds = (elapsedTime/1000)%60;
            seconds_str = String.format("%02d", seconds);
            minutes_str = String.format("%02d", minutes);
            hours_str = String.format("%02d", hours);

            timeLabel.setText(hours_str+":"+minutes_str+":"+seconds_str);


        }
    });


    StopWatch(){
        timeLabel.setText(hours_str+":"+minutes_str+":"+seconds_str);
        timeLabel.setBounds(100,100,200,100);
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(100,200,100,50);
        startButton.setFont(new Font("Ink Free",Font.PLAIN,20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        resetButton.setBounds(200,200,100,50);
        resetButton.setFont(new Font("Ink Free",Font.PLAIN,20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);


        frame.add(startButton);
        frame.add(resetButton);
        frame.add(timeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==startButton && !started){
            started = true;
            startButton.setText("Stop");
            timer.start();
        }
        else if(e.getSource()==startButton && started){
            started = false;
            startButton.setText("Start");
            timer.stop();
        }else{
            timer.stop();
            startButton.setText("Start");
            started = false;
            elapsedTime = 0;
            seconds = 0;
            minutes = 0;
            hours = 0;
            seconds_str = String.format("%02d", seconds);
            minutes_str = String.format("%02d", minutes);
            hours_str = String.format("%02d", hours);
            timeLabel.setText(hours_str+":"+minutes_str+":"+seconds_str);
        }
        
    }
    // void start(){
    //     timer.start();
    // }
    // void stop(){
    //     timer.stop();
    // }
    // void reset(){
    //     timer.restart();
    // }
}