import javax.swing.*;

public class Login {
    Login()
    {
        JFrame frame = new JFrame("Login");

        JLabel idLabel = new JLabel("User ID");
        JTextField userId = new JTextField();

        JLabel pass = new JLabel("Password");
        JPasswordField password = new JPasswordField();

        JButton submit = new JButton("Submit");



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
}
