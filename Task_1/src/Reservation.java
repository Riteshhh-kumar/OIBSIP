import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    Reservation()
    {
        JFrame frame = new JFrame("Reservation");

        ReservationSystem r = new ReservationSystem();
        r.addTrain(123,"HELLO");

        JLabel error = new JLabel("Enter a valid Train Number");
        error.setVisible(false);
        error.setBounds(600,520,300,40);
        String []arr = {"Sleeper","AC"};



        JButton back = new JButton("< BACK");
        JButton book = new JButton("Book Ticket");
        back.setBounds(50,50,100,40);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Home h = new Home();
            }
        });

        JLabel name = new JLabel("Name");
        JTextField Name = new JTextField();
        name.setBounds(560,100,100,30);
        Name.setBounds(670,100,200,30);

        JLabel age = new JLabel("Age");
        JTextField Age = new JTextField();
        age.setBounds(560,140,100,30);
        Age.setBounds(670,140,200,30);

        JComboBox
        JLabel gender = new JLabel("Gender");
        JTextField Gender = new JTextField();
        gender.setBounds(560,180,100,30);
        Gender.setBounds(670,180,200,30);

        JLabel from = new JLabel("From");
        JTextField From = new JTextField();
        from.setBounds(560,220,100,30);
        From.setBounds(670,220,200,30);

        JLabel to = new JLabel("To");
        JTextField To = new JTextField();
        to.setBounds(560,260,100,30);
        To.setBounds(670,260,200,30);



        JLabel date = new JLabel("Date");
        DateFormat df = new SimpleDateFormat("DD/MM/YYYY");
        JFormattedTextField Date = new JFormattedTextField(df);
        date.setBounds(560,300,100,30);
        Date.setBounds(670,300,200,30);




        JLabel classType = new JLabel("Class Type");
        JComboBox ClassType = new JComboBox(arr);
        classType.setBounds(560,340,100,30);
        ClassType.setBounds(670,340,200,20);

        JLabel trainNumber = new JLabel("Train Number");
        JTextField TrainNumber = new JTextField();
        trainNumber.setBounds(560,380,100,30);
        TrainNumber.setBounds(670,380,200,30);

        JLabel trainName = new JLabel("Train Name");
        JTextField TrainName = new JTextField();
        trainName.setBounds(560,420,100,30);
        TrainName.setBounds(670,420,200,30);

        JButton getName = new JButton("Get name");
        getName.setBounds(900,380,140,30);

        getName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReservationSystem r = new ReservationSystem();
                int key =Integer.parseInt(TrainNumber.getText());
                String name = r.trains.get(key);
                if(name!=null)
                TrainName.setText(name);

                else{
                    error.setVisible(true);
                }
            }
        });
        frame.add(getName);





        frame.add(book);
        book.setBounds(670,480,150,30);


        frame.add(name);
        frame.add(age);
        frame.add(gender);
        frame.add(from);
        frame.add(to);
        frame.add(date);
        frame.add(trainName);
        frame.add(trainNumber);
        frame.add(classType);
        frame.add(Name);
        frame.add(Age);
        frame.add(Gender);
        frame.add(From);
        frame.add(To);
        frame.add(Date);
        frame.add(TrainName);
        frame.add(TrainNumber);
        frame.add(ClassType);

        book.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReservationSystem r = new ReservationSystem();
                String name = Name.getText();
                int age = Integer.parseInt(Age.getText());
                String gender = Gender.getText();
                String from = From.getText();
                String to = To.getText();
                String date = Date.getText();
                String trainName = TrainName.getText();
                int trainNumber = Integer.parseInt(TrainNumber.getText());
                String classType = String.valueOf(ClassType.getSelectedItem());


                r.buyTicket(name,age,gender,from,to,date,trainName,trainNumber,classType);
            }
        });

        frame.add(back);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
