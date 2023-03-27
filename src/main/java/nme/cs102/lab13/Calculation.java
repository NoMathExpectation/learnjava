package nme.cs102.lab13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculation extends JFrame {
  private JButton plainJButton1;
  private JButton plainJButton2;
  private JButton plainJButton3;
  private JButton plainJButton4;
  private JButton plainJButton5;
  private JButton plainJButton6;
  private JButton plainJButton7;
  private JButton plainJButton8;
  private JButton plainJButton9;
  private JButton plainJButton0;
  private JButton plainJButtonAdd;
  private JButton plainJButtonSub;
  private JButton plainJButtonEq;

  private JTextField answer;

  private String operation1 = "";
  private String operation2 = "";
  private String operator = "";

  // ButtonFrame adds JButtons to JFrame
  public Calculation() {
    super("Calculator");
    JPanel jp = new JPanel();
    jp.setLayout(new GridLayout(4, 4));

    plainJButton1 = new JButton("1");
    jp.add(plainJButton1);

    plainJButton2 = new JButton("2");
    jp.add(plainJButton2);

    plainJButton3 = new JButton("3");
    jp.add(plainJButton3);

    plainJButton4 = new JButton("4");
    jp.add(plainJButton4);

    plainJButton5 = new JButton("5");
    jp.add(plainJButton5);

    plainJButton6 = new JButton("6");
    jp.add(plainJButton6);

    plainJButton7 = new JButton("7");
    jp.add(plainJButton7);

    plainJButton8 = new JButton("8");
    jp.add(plainJButton8);

    plainJButton9 = new JButton("9");
    jp.add(plainJButton9);

    plainJButton0 = new JButton("0");
    jp.add(plainJButton0);

    plainJButtonAdd = new JButton("+");
    jp.add(plainJButtonAdd);

    plainJButtonSub = new JButton("-");
    jp.add(plainJButtonSub);

    plainJButtonEq = new JButton("=");
    jp.add(plainJButtonEq);

    add(jp, BorderLayout.SOUTH);

    answer = new JTextField("");
    answer.setEditable(false);
    answer.setHorizontalAlignment(JTextField.RIGHT);
    add(answer, BorderLayout.CENTER);

    // create new ButtonHandler for button event handling
    ButtonHandler handler = new ButtonHandler();
    plainJButton1.addActionListener(handler);
    plainJButton2.addActionListener(handler);
    plainJButton3.addActionListener(handler);
    plainJButton4.addActionListener(handler);
    plainJButton5.addActionListener(handler);
    plainJButton6.addActionListener(handler);
    plainJButton7.addActionListener(handler);
    plainJButton8.addActionListener(handler);
    plainJButton9.addActionListener(handler);
    plainJButton0.addActionListener(handler);
    plainJButtonAdd.addActionListener(handler);
    plainJButtonSub.addActionListener(handler);
    plainJButtonEq.addActionListener(handler);
  } // end ButtonFrame constructor

  public int compute(String operation1, String operation2, String operator) {
    int a = Integer.parseInt(operation1);
    int b = Integer.parseInt(operation2);
    if (operator.charAt(0) == '+') {
      return a + b;
    } else {
      return a - b;
    }
  }


  public static void main(String[] args) {
    Calculation calculationFrame = new Calculation(); // create ButtonFrame
    calculationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    calculationFrame.setLocationRelativeTo(null);
    calculationFrame.pack(); // set frame size
    calculationFrame.setVisible(true); // display frame
  } // end main

  // inner class for button event handling
  private class ButtonHandler implements ActionListener {
    // handle button event

    int stored = 0;
    String currentOperation;

    StringBuilder input = new StringBuilder();

    public void actionPerformed(ActionEvent event) {
      char cmd = event.getActionCommand().charAt(0);

      switch (cmd) {
        case '+':
        case '-':
          if (currentOperation == null) {
            stored = Integer.parseInt(input.toString());
          } else {
            stored = compute(String.valueOf(stored), input.toString().isEmpty() ? "0" : input.toString(), currentOperation);
          }
          currentOperation = event.getActionCommand();
          input.setLength(0);
          answer.setText(stored + currentOperation);
          break;
        case '=':
          if (currentOperation == null) {
            stored = Integer.parseInt(input.toString());
          } else {
            stored = compute(String.valueOf(stored), input.toString().isEmpty() ? "0" : input.toString(), currentOperation);
          }
          input.setLength(0);
          currentOperation = event.getActionCommand();
          answer.setText(String.valueOf(stored));
          break;
        default:
          if ("=".equals(currentOperation)) {
            stored = 0;
            input.setLength(0);
            currentOperation = null;
          }
          input.append(cmd);
          answer.setText((stored != 0 ? String.valueOf(stored) : "") + (currentOperation != null ? currentOperation : "") + input);
      }
    } // end method actionPerformed
  } // end private inner class ButtonHandler
} // end class ButtonFrame
