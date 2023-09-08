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
                Home h = new Home();
                frame.dispose();
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
        confirm.setBounds(680,575,150,40);
        getDetails.setVisible(true);
        confirm.setVisible(false);
        frame.add(confirm);


        getDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try
                {
                    pnr_number = Integer.parseInt(Pnr.getText());
                    if (ReservationSystem.list.containsKey(pnr_number)) {
                        error.setVisible(false);
                        getDetails.setVisible(false);
                        confirm.setVisible(true);
                        JLabel name = new JLabel("Name: "+ReservationSystem.list.get(pnr_number).name);
                        JLabel gender = new JLabel("Gender: "+ReservationSystem.list.get(pnr_number).age);
                        JLabel age = new JLabel("Age: "+ReservationSystem.list.get(pnr_number).gender);
                        JLabel from = new JLabel("From: "+ReservationSystem.list.get(pnr_number).from);
                        JLabel to = new JLabel("To: "+ReservationSystem.list.get(pnr_number).to);
                        JLabel date = new JLabel("Date: "+ReservationSystem.list.get(pnr_number).date);
                        JLabel trainNumber = new JLabel("Train Number: "+ReservationSystem.list.get(pnr_number).trainNumber);
                        JLabel trainName = new JLabel("Train Name: "+ReservationSystem.list.get(pnr_number).trainName);
                        JLabel classType = new JLabel("Class type"+ReservationSystem.list.get(pnr_number).classType);
                        frame.add(name);
                        frame.add(gender);
                        frame.add(age);
                        frame.add(from);
                        frame.add(to);
                        frame.add(date);
                        frame.add(trainNumber);
                        frame.add(trainName);
                        frame.add(classType);

                        name.setBounds(510,320,150,20);
                        gender.setBounds(510,350,150,20);
                        age.setBounds(510,380,150,20);
                        from.setBounds(510,410,150,20);
                        to.setBounds(510,440,150,20);
                        date.setBounds(510,470,150,20);
                        trainNumber.setBounds(510,500,150,20);
                        trainName.setBounds(510,530,150,20);
                        classType.setBounds(510,560,150,20);

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
                ReservationSystem.cancelTicket(pnr_number);
                Cancellation c = new Cancellation();
                frame.dispose();
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
