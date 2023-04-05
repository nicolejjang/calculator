package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    JPanel panel;
    JButton[] number = new JButton[10];
    JButton[] funtionsB = new JButton[10];
    JButton divB, modB, plusB, minusB;
    JButton multiB, equalsB, ac;
    JButton neg, clr, dot;
    JTextField txt;

    double num1 = 0, num2 = 0, result = 0;
    char operator;


    public Calculator() {
        super("CALCULATOR");
        setLayout(null);
        setSize(500, 1000);
        setVisible(true);


        txt = new JTextField();
        txt.setBounds(50, 25, 300, 50);
        add(txt);
        // initialize components

        divB = new JButton("/");
        modB = new JButton("%");
        plusB = new JButton("+");
        minusB = new JButton("-");
        multiB = new JButton("*");
        equalsB = new JButton("=");
        ac = new JButton("AC");
        neg = new JButton("(-)");
        clr = new JButton("C");
        dot = new JButton(".");

        funtionsB[0] = divB;
        funtionsB[1] = modB;
        funtionsB[2] = plusB;
        funtionsB[3] = minusB;
        funtionsB[4] = multiB;
        funtionsB[5] = equalsB;
        funtionsB[6] = ac;
        funtionsB[7] = dot;
        funtionsB[8] = neg;
        funtionsB[9] = clr;

        for (int i = 0; i < 10; i++) {
            funtionsB[i].addActionListener(this);
        }

        for (int i = 0; i < 10; i++) {
            number[i] = new JButton(String.valueOf(i));
            number[i].addActionListener(this);

        }

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(5, 4));
        panel.add(neg);
        panel.add(modB);
        panel.add(clr);
        panel.add(ac);
        panel.add(number[7]);
        panel.add(number[8]);
        panel.add(number[9]);
        panel.add(divB);
        panel.add(number[4]);
        panel.add(number[5]);
        panel.add(number[6]);
        panel.add(multiB);
        panel.add(number[1]);
        panel.add(number[2]);
        panel.add(number[3]);
        panel.add(minusB);
        panel.add(number[0]);
        panel.add(dot);
        panel.add(equalsB);
        panel.add(plusB);

        add(panel);

        setSize(450, 500);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == number[i]) {
                txt.setText(txt.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == ac){
            txt.setText("");
        }

        if (e.getSource() == clr){
            String string = txt.getText();
            txt.setText("");
            for ( int i =0; i <string.length()-1; i++){
                txt.setText((txt.getText() +string.charAt(i)));
            }
        }
        if (e.getSource() == dot) {
            txt.setText((txt.getText().concat(".")));
        }
        if (e.getSource() == plusB) {
            num1 = Double.parseDouble(txt.getText());
            operator = '+';
            txt.setText("");
        }
        if (e.getSource() == minusB) {
            num1 = Double.parseDouble(txt.getText());
            operator = '-';
            txt.setText("");
        }
        if(e.getSource() == multiB) {
            num1 = Double.parseDouble(txt.getText());
            operator = '*';
            txt.setText("");
        }
        if(e.getSource() == divB) {
            num1 = Double.parseDouble(txt.getText());
            operator = '/';
            txt.setText("");
        }
        if(e.getSource() == modB) {
            num1 = Double.parseDouble(txt.getText());
            operator = '%';
            txt.setText("");
        }
        if(e.getSource() == neg) {
            double temp = Double.parseDouble(txt.getText());
            temp*=-1;
            txt.setText(String.valueOf(temp));
        }

        if (e.getSource() == equalsB){
            num2= Double.parseDouble(txt.getText());
            switch (operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case '%':
                    result = num1 % num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
            }
            txt.setText(String.valueOf(result));
            num1 = result;
        }
    }
}
