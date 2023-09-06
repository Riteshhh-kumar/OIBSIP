import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Home {
    Home() {
        JFrame frame = new JFrame("Reservation System");
        JButton reservation= new JButton("Reservation");
        JButton cancel = new JButton("Cancel");
        JButton logout = new JButton("LOGOUT");
        logout.setBounds(50,50,100,40);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Main m = new Main();
                m.run();
            }
        });
        frame.add(logout);


        reservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Reservation l = new Reservation();


            }
        });


        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Cancellation l = new Cancellation();
            }
        });





        reservation.setBounds(690,280,200,55);
        cancel.setBounds(690,360,200,55);



        frame.add(reservation);
        frame.add(cancel);


        frame.setLayout(null);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}