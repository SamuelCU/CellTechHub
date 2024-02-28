import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new pdf().pdfpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850,550);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
