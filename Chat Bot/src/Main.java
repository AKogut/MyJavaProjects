import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{

    // Tying area
    private JTextField txtEnter = new JTextField();

    //Chat area
    private JTextArea txtArea = new JTextArea();

    public Main(){
        //Frame attributes
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Java Chat Bot with AI");

        //txtEnter attributes
        txtEnter.setLocation(2, 525);
        txtEnter.setSize(580, 30);

        txtEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uText = txtEnter.getText();
                txtArea.append("You: " + uText + "\n");
                txtEnter.setText("");
            }
        });

        txtArea.setLocation(15, 10);
        txtArea.setSize(550, 505);

        this.add(txtEnter);
        this.add(txtArea);

    }

    public static void main (String[]args){
        new Main();
    }
}
