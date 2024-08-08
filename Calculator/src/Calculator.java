import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JFrame frame;
    JPanel panel;
    JPanel buttonPanel;
    JTextField textField;
    JTextField textField2;


    JButton[] buttons;
    double num1 = 0, num2 = 0;
    char operator;
    Font font = new Font("Arial Black",Font.PLAIN,25);
    ImageIcon logo = new ImageIcon("SP.jpeg");
    Calculator(){

        setFrame();
    }
    public void setButtons(){
        buttons = new JButton[20];

        buttons[0] = new JButton(String.valueOf("C"));
        buttons[1] = new JButton(String.valueOf("%"));
        buttons[2] = new JButton(String.valueOf("DEL"));
        buttons[3] = new JButton(String.valueOf("/"));
        buttons[4] = new JButton(String.valueOf("1"));
        buttons[5] = new JButton(String.valueOf("2"));
        buttons[6] = new JButton(String.valueOf("3"));
        buttons[7] = new JButton(String.valueOf("*"));
        buttons[8] = new JButton(String.valueOf("4"));
        buttons[9] = new JButton(String.valueOf("5"));
        buttons[10] = new JButton(String.valueOf("6"));
        buttons[11] = new JButton(String.valueOf("-"));
        buttons[12] = new JButton(String.valueOf("7"));
        buttons[13] = new JButton(String.valueOf("8"));
        buttons[14] = new JButton(String.valueOf("9"));
        buttons[15] = new JButton(String.valueOf("+"));
        buttons[16] = new JButton(String.valueOf("+/-"));
        buttons[17] = new JButton(String.valueOf("0"));
        buttons[18] = new JButton(String.valueOf("."));
        buttons[19] = new JButton(String.valueOf("="));

        for(int i=0; i<20;i++){
            buttons[i].setFont(new Font("Calibri (Body)",Font.PLAIN,25));
            buttons[i].setFocusable(false);
            buttons[i].setForeground(Color.BLACK);
            buttons[i].setBackground(Color.WHITE);
            buttons[i].addActionListener(this);
        }

    }
    public void setButtonPanel(){
        buttonPanel = new JPanel();

        buttonPanel.setBounds(10,140,340,325);
        buttonPanel.setLayout(new GridLayout(5,4,0,0));

        buttonPanel.setBackground(Color.LIGHT_GRAY);

        setButtons();

        for(int i=0; i<20;i++){
            buttonPanel.add(buttons[i]);
        }
    }
    public void setPanel(){
        panel = new JPanel();

        setTextField();
        setButtonPanel();
        addPanel();

        panel.setLayout(null);

        panel.setBounds(10,10,360,480);
        panel.setBackground(Color.WHITE);
        panel.setBorder(new LineBorder(Color.GRAY,2));
//        panel.setOpaque(true);
    }
    public void setTextField(){
        textField = new JTextField();
        textField2 = new JTextField("");

//        textField2.setOpaque(true);

        textField.setBounds(10,10,340,80);
        textField.setEditable(false);
        textField.setBorder(new LineBorder(Color.GRAY,2));
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.WHITE);
        textField.setFont(new Font("Arial Black",Font.PLAIN,50));
        textField.setHorizontalAlignment(JTextField.RIGHT);

        textField2.setBackground(Color.BLACK);
        textField2.setForeground(Color.WHITE);
        textField2.setBorder(new LineBorder(Color.GRAY,2));
        textField2.setEditable(false);
        textField2.setBounds(295,95,53,40);
        textField2.setFont(new Font("Arial Black",Font.PLAIN,30));
        textField2.setHorizontalAlignment(JTextField.CENTER);
    }
    public void addPanel(){
        panel.add(textField);
        panel.add(buttonPanel);
        panel.add(textField2);
    }
    public void addFrame(){
        frame.add(panel);
    }
    public void setFrame() {
        frame = new JFrame("Calculator");

        setPanel();
        addFrame();

        frame.setSize(400,540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.BLACK);
        frame.getContentPane().setBackground(Color.GRAY);

        frame.setIconImage(logo.getImage());
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
//        for(int i=0; i<20; i++){
//            if(e.getSource()==buttons[i]){
//                textField.setText(textField.getText().concat(String.valueOf(i)));
//            }
//        }
        if(e.getSource()==buttons[4]){
            textField.setText(textField.getText().concat("1"));
        }else if(e.getSource()==buttons[5]){
            textField.setText(textField.getText().concat("2"));
        }else if(e.getSource()==buttons[6]){
            textField.setText(textField.getText().concat("3"));
        }else if(e.getSource()==buttons[8]){
            textField.setText(textField.getText().concat("4"));
        }else if(e.getSource()==buttons[9]){
            textField.setText(textField.getText().concat("5"));
        }else if(e.getSource()==buttons[10]){
            textField.setText(textField.getText().concat("6"));
        }else if(e.getSource()==buttons[12]){
            textField.setText(textField.getText().concat("7"));
        }else if(e.getSource()==buttons[13]){
            textField.setText(textField.getText().concat("8"));
        }else if(e.getSource()==buttons[14]){
            textField.setText(textField.getText().concat("9"));
        }else if(e.getSource()==buttons[17]){
            textField.setText(textField.getText().concat("0"));
        }
        else if(e.getSource()==buttons[0]){
            textField.setText("");
            textField2.setText("");
        }
        else if(e.getSource()==buttons[2]){
            String string = textField.getText();
            textField.setText(string.substring(0,string.length()-1));
        }
        else if(e.getSource()==buttons[16]){
            textField.setText(String.valueOf(Double.parseDouble(textField.getText())*-1));
        }
        else if(e.getSource()==buttons[1]){
            num1 = Double.parseDouble(textField.getText());
            operator = '%';
            textField2.setText(String.valueOf(operator));
            textField.setText("");
        }
        else if(e.getSource()==buttons[3]){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField2.setText(String.valueOf(operator));
            textField.setText("");
        }
        else if(e.getSource()==buttons[7]){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField2.setText(String.valueOf(operator));
            textField.setText("");
        }
        else if(e.getSource()==buttons[11]){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField2.setText(String.valueOf(operator));
            textField.setText("");
        }
        else if(e.getSource()==buttons[15]){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField2.setText(String.valueOf(operator));
            textField.setText("");
        }
        else if(e.getSource()==buttons[18]){
            textField.setText(textField.getText().concat("0"));
        }
        else if(e.getSource()==buttons[19]){
            num2 = Double.parseDouble(textField.getText());
            textField2.setText("=");

            switch (operator) {
                case '+' -> textField.setText(String.valueOf(num1 + num2));
                case '-' -> textField.setText(String.valueOf(num1 - num2));
                case '*' -> textField.setText(String.valueOf(num1 * num2));
                case '/' -> textField.setText(String.valueOf(num1 / num2));
                case '%' -> textField.setText(String.valueOf(num1 % num2));
            }

        }
    }
}
