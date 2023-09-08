import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    void run(){
        JFrame frame = new JFrame("Login");
        Users u = new Users();

        JLabel idLabel = new JLabel("User ID");
        JTextField userId = new JTextField();

        JLabel pass = new JLabel("Password");
        JPasswordField password = new JPasswordField();

        JButton submit = new JButton("Submit");

        JLabel error = new JLabel();
        error.setVisible(false);
        error.setBounds(700,400,100,40);
        frame.add(error);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userId.getText();
                String pass = password.getText();

                if(Users.userList.containsKey(username)){
                    if(Users.userList.get(username).equals(pass)){
                        Home h = new Home();
                        frame.dispose();
                    }
                    error.setText("Wrong Password");
                    error.setVisible(true);
                }
                error.setText("No user found");
                error.setVisible(true);
            }
        });

        idLabel.setBounds(510,285,150,30);
        userId.setBounds(690,285,200,30);
        pass.setBounds(510,335,150,30);
        password.setBounds(690,335,200,30);
        submit.setBounds(710,375,100,40);

        frame.add(idLabel);
        frame.add(userId);
        frame.add(pass);
        frame.add(password);
        frame.add(submit);


        frame.setLayout(null);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        Main m = new Main();
        m.run();
    }


}
