/*import java.util.Scanner;

class CalculatorProgram{
               public static void main(String[] args) {
                
                Scanner sc = new Scanner(System.in);
                System.out.println(" --------CALCULATOR--------");
                System.out.println();
                   
               System.out.println("enter the first number : ");
                double num1 = sc.nextInt();

                System.out.println("enter the second number : ");
                double num2 =  sc.nextInt();


               
                System.out.println("product       : " + num1 * num2);

                System.out.println("sum           : " + (num1 + num2));

                System.out.println("Substraction  : " + (num1 - num2));

                System.out.println("Division      : " + (num1 / num2));


                }
               }*/

               import javax.swing.*;
               import java.awt.*;
               import java.awt.event.ActionEvent;
               import java.awt.event.ActionListener;
               import javax.script.ScriptEngine;
               import javax.script.ScriptEngineManager;
               import javax.script.ScriptException;
               
               public class CalculatorProgram extends JFrame implements ActionListener {
                   private JTextField textField;
                   private String input = "";
               
                   public CalculatorProgram() {
                       setTitle("Calculator");
                       setSize(400, 500);
                       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                       setLayout(new BorderLayout());
               
                       // Display field
                       textField = new JTextField();
                       textField.setFont(new Font("Arial", Font.BOLD, 24));
                       textField.setHorizontalAlignment(JTextField.RIGHT);
                       textField.setEditable(false);
                       add(textField, BorderLayout.NORTH);
               
                       // Button panel
                       JPanel buttonPanel = new JPanel();
                       buttonPanel.setLayout(new GridLayout(5, 4, 10, 10));
               
                       String[] buttons = {
                           "7", "8", "9", "/",
                           "4", "5", "6", "*",
                           "1", "2", "3", "-",
                           "0", ".", "=", "+",
                           "C", "←"
                       };
               
                       for (String text : buttons) {
                           JButton button = new JButton(text);
                           button.setFont(new Font("Arial", Font.BOLD, 20));
                           button.addActionListener(this);
                           buttonPanel.add(button);
                       }
               
                       add(buttonPanel, BorderLayout.CENTER);
                       setVisible(true);
                   }
               
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       String command = e.getActionCommand();
               
                       if (command.equals("C")) {
                           input = "";
                       } else if (command.equals("←")) {
                           if (!input.isEmpty()) {
                               input = input.substring(0, input.length() - 1);
                           }
                       } else if (command.equals("=")) {
                           input = evaluateExpression(input);
                       } else {
                           input += command;
                       }
               
                       textField.setText(input);
                   }
               
                   private String evaluateExpression(String expression) {
                       try {
                           // Using Java's ScriptEngine to evaluate mathematical expressions
                           ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
                           return String.valueOf(engine.eval(expression));
                       } catch (ScriptException e) {
                           return "Error";
                       }
                   }
               
                   public static void main(String[] args) {
                       new CalculatorProgram();
                   }
               }
               