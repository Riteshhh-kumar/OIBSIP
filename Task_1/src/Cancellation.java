import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cancellation {
    int pnr_number;
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

        JTextField Pnr = new JTextField();
        JLabel pnr = new JLabel("PNR");
        JLabel error = new JLabel("PNR not found");
        error.setBackground(Color.RED);
        error.setBounds(690,500,150,50);
        error.setVisible(false);
        frame.add(error);



        JButton getDetails = new JButton("Get Details");
        JButton confirm = new JButton("Confirm");
        getDetails.setBounds(680,375,150,40);
        confirm.setBounds(680,375,150,40);
        getDetails.setVisible(true);
        confirm.setVisible(false);
        frame.add(confirm);


        getDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReservationSystem r = new ReservationSystem();
                try {
                    pnr_number = Integer.parseInt(Pnr.getText());
                    if (r.list.containsKey(pnr_number)) {
                        getDetails.setVisible(false);
                        confirm.setVisible(true);
                    } else {
                        error.setText("PNR Not Found");
                        error.setVisible(true);
                    }
                }
                catch (Exception x){
                    error.setText("Please Enter a PNR");
                    error.setVisible(true);
                }


            }
        });

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReservationSystem r = new ReservationSystem();
                r.cancelTicket(pnr_number);
            }
        });

        pnr.setBounds(510,285,150,30);
        Pnr.setBounds(690,285,200,30);



        frame.add(Pnr);
        frame.add(pnr);
        frame.add(getDetails);

        frame.add(back);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
