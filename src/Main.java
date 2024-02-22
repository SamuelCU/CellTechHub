import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        Color color1=new Color(230, 230, 250);
        frame.setContentPane(new login().loginpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550,300);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(color1);
        //frame.setUndecorated(true);
        frame.setVisible(true);
    }
}