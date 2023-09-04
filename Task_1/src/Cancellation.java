import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cancellation {
    Cancellation()
    {
        JFrame frame = new JFrame("Cancellation");

        JButton back = new JButton("< BACK");
        back.setBounds(50,50,100,40);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Home h = new Home();
            }
        });
        frame.add(back);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
