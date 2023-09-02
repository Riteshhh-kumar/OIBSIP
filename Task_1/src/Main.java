import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Reservation System");
        JButton login = new JButton("Login");
        JButton reservation= new JButton("Reservation");
        JButton cancel = new JButton("Cancel");

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Login l = new Login();
            }
        });

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




        login.setBounds(690,200,200,55);
        reservation.setBounds(690,280,200,55);
        cancel.setBounds(690,360,200,55);


        frame.add(login);
        frame.add(reservation);
        frame.add(cancel);


        frame.setLayout(null);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}