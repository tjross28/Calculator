/*  TJ Ross
    4/30/24
    Comp 167 Section: 004
    Description: GUI calculator made using swing and awt, offers a comprehensive set of mathematical operations and functions 
                    in a kid - friendly user interface.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.lang.Math;



public class Calculating implements ActionListener {

    JFrame frame;
    JLabel calcLabel;
    JTextField text_field;
    JTextField output_text_field;
    JPanel left_panel;
    JPanel right_panel;
    JButton addButton, subtractButton, multiplyButton, divideButton, equalsButton;
    JButton Num1Button, Num2Button, Num3Button, Num4Button, Num5Button, Num6Button, Num7Button, Num8Button, Num9Button, Num0Button;
    JButton percentButton, one_over_nButton, sqr_rootButton, modulusButton, squaredButton, cubedButton, decimalButton, logButton, lnButton;
    JButton sinButton, cosButton, tanButton, asinButton, acosButton, atanButton, sinhButton, coshButton, tanhButton;
    JButton clearButton;
    JButton exitButton;                                                                 //GUI Components Declarations
    JButton[] numButtons = new JButton[15];
    JButton[] operatorButtons = new JButton[18];
    double num1 = 0, num2 = 0;
    String operator;
    double result;
    String answer;
    


    Calculating() {
        Border border = BorderFactory.createLineBorder(new Color(0,115,0), 14);
        Border text_border = BorderFactory.createLineBorder(Color.magenta, 5);   // Different borders 
        Border output_border = BorderFactory.createLineBorder(Color.BLUE, 5);
        Border button_border = BorderFactory.createLineBorder(new Color(0,90, 0), 5);
        frame = new JFrame();
        frame.setSize(950, 1000);                       //Setting up of frame properties
        frame.setTitle("Calculator"); 
        frame.getContentPane().setBackground(Color.black); // Changes background color of frame
        frame.setLayout(null);
        


        text_field = new JTextField();
        text_field.setBounds(265, 70, 400, 30);
        text_field.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
        text_field.setEditable(false);
        text_field.setVisible(true);                //Setting up input text field
        text_field.setBorder(text_border);


        output_text_field = new JTextField(); // Initialize output text field
        output_text_field.setBounds(265, 30, 400, 30); // Position output text field
        output_text_field.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
        output_text_field.setEditable(false);
        output_text_field.setVisible(true);
        output_text_field.setBorder(output_border);

        Num1Button = new JButton("1");
        Num2Button = new JButton("2");
        Num3Button = new JButton("3");
        Num4Button = new JButton("4");
        Num5Button = new JButton("5");
        Num6Button = new JButton("6");
        Num7Button = new JButton("7");
        Num8Button = new JButton("8");                  //Setting up  number buttons
        Num9Button = new JButton("9");
        Num0Button = new JButton("0");
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");

        numButtons[0] = Num1Button;
        numButtons[1] = Num2Button;
        numButtons[2] = addButton;
        numButtons[3] = Num3Button;
        numButtons[4] = Num4Button;
        numButtons[5] = subtractButton;
        numButtons[6] = Num5Button;                             //Sets buttons to a specific index in numButtons array
        numButtons[7] = Num6Button;
        numButtons[8] = multiplyButton;         
        numButtons[9] = Num7Button;
        numButtons[10] = Num8Button;
        numButtons[11] = divideButton;
        numButtons[12] = Num9Button;
        numButtons[13] = Num0Button;
        numButtons[14] = equalsButton;


        for (int i = 0; i < 15; i++) {
            numButtons[i].setFont(new Font("Comic Sans Ms", Font.BOLD, 35));
            numButtons[i].addActionListener(this);              //Iterates through numButtons array and sets font, action listener and border
            numButtons[i].setBorder(button_border);
            
        }


        percentButton = new JButton("%");
        one_over_nButton = new JButton("1/n");
        sqr_rootButton = new JButton("√");
        modulusButton = new JButton("mod");
        squaredButton = new JButton("x²");
        cubedButton = new JButton("x³");
        decimalButton = new JButton(".");
        logButton = new JButton("log");
        lnButton = new JButton("ln");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");                 //Setting up operator buttons
        asinButton = new JButton("asin");
        acosButton = new JButton("acos");
        atanButton = new JButton("atan");
        sinhButton = new JButton("sinh");
        coshButton = new JButton("cosh"); 
        tanhButton = new JButton("tanh");



        operatorButtons[0] = sinButton;
        operatorButtons[1] = asinButton;
        operatorButtons[2] = sinhButton;
        operatorButtons[3] = cosButton;
        operatorButtons[4] = acosButton;
        operatorButtons[5] = coshButton;
        operatorButtons[6] = tanButton;
        operatorButtons[7] = atanButton;
        operatorButtons[8] = tanhButton;
        operatorButtons[9] = percentButton;
        operatorButtons[10] = decimalButton;
        operatorButtons[11] = one_over_nButton;             //Sets operator buttons to specific index in operator Button array
        operatorButtons[12] = squaredButton;
        operatorButtons[13] = cubedButton;
        operatorButtons[14] = sqr_rootButton;
        operatorButtons[15] = logButton;
        operatorButtons[16] = lnButton;
        operatorButtons[17] = modulusButton;


        for (int i = 0; i < 18; i++) {
            operatorButtons[i].setFont(new Font("Comic Sans Ms", Font.BOLD, 30));
            operatorButtons[i].addActionListener(this);         //For loop which iterates through operator buttons
            operatorButtons[i].setBorder(button_border);
            
        }



        clearButton = new JButton("CLEAR");
        clearButton.setBounds(770, 20, 100, 70);
        clearButton.setFont(new Font("Comic Sans Ms", Font.BOLD, 20));          //Set up for clear button
        clearButton.addActionListener(this);

        exitButton = new JButton("EXIT");
        exitButton.setBounds(50, 20, 100, 70);                  //Set up for exit button
        exitButton.setFont(new Font("Comic Sans Ms", Font.BOLD, 20));
        exitButton.addActionListener(this);
        
        


        left_panel = new JPanel(new GridLayout(5,3));                       //Left panel setup
        left_panel.setBounds(15,120, 350, 600);
        left_panel.setBackground(Color.lightGray);
        
        

        left_panel.add(Num1Button);
        left_panel.add(Num2Button);
        left_panel.add(addButton);
        left_panel.add(Num3Button);
        left_panel.add(Num4Button);
        left_panel.add(subtractButton);
        left_panel.add(Num5Button);
        left_panel.add(Num6Button);
        left_panel.add(multiplyButton);
        left_panel.add(Num7Button);
        left_panel.add(Num8Button);                 //Adds number buttons to left panel
        left_panel.add(divideButton);
        left_panel.add(Num9Button);
        left_panel.add(Num0Button);
        left_panel.add(equalsButton);


        right_panel = new JPanel(new GridLayout(6, 3));         //Right panel setup
        right_panel.setBounds(550,120,350,600);
        right_panel.setBackground(Color.lightGray);

        right_panel.add(sinButton);
        right_panel.add(asinButton);
        right_panel.add(sinhButton);
        right_panel.add(cosButton);
        right_panel.add(acosButton);
        right_panel.add(coshButton);
        right_panel.add(tanButton);                     //Adds buttons to right panel
        right_panel.add(atanButton);
        right_panel.add(tanhButton);
        right_panel.add(percentButton);
        right_panel.add(decimalButton);
        right_panel.add(one_over_nButton);
        right_panel.add(squaredButton);
        right_panel.add(cubedButton);
        right_panel.add(sqr_rootButton);
        right_panel.add(logButton);
        right_panel.add(lnButton);
        right_panel.add(modulusButton);

        calcLabel = new JLabel("These operators require number input first" + " -->");
        calcLabel.setForeground(Color.white);
        calcLabel.setBounds(370, 90, 500, 500);
        calcLabel.setFont(new Font("C Sans", Font.BOLD, 8));            //Label set up
        
        

        frame.add(text_field);
        frame.add(output_text_field);
        frame.add(left_panel);
        frame.add(right_panel);
        frame.add(clearButton);             //Adds everything to the frame
        frame.add(exitButton);
        frame.getRootPane().setBorder(border);
        frame.add(calcLabel);
        frame.setVisible(true);
        
    
    }

    public static void main(String[] args) {
        new Calculating();  //Initialize the GUI Calculator
    }



    @Override
    public void actionPerformed(ActionEvent e) {
      try {
        JButton clickedButton = (JButton) e.getSource();
        
        // If a number button is clicked
        if ((clickedButton == Num1Button || clickedButton == Num2Button || clickedButton == Num3Button ||
            clickedButton == Num4Button || clickedButton == Num5Button || clickedButton == Num6Button ||
            clickedButton == Num7Button || clickedButton == Num8Button || clickedButton == Num9Button ||
            clickedButton == Num0Button )) {
            // Append the clicked number to the text field
            text_field.setText(text_field.getText() + clickedButton.getText());
           
        } 
        else if (clickedButton == decimalButton && !text_field.getText().contains(".")) {
            // Append the decimal button's text to the text field
            text_field.setText(text_field.getText() + decimalButton.getText());
        }
        
        else if (clickedButton == addButton || clickedButton == subtractButton ||
                clickedButton == multiplyButton || clickedButton == divideButton 
                || clickedButton == percentButton || clickedButton == modulusButton || clickedButton == one_over_nButton || clickedButton == sqr_rootButton || clickedButton == squaredButton || clickedButton == cubedButton || clickedButton == logButton || clickedButton == lnButton || clickedButton == sinButton ||
                clickedButton == cosButton || clickedButton == tanButton || clickedButton == asinButton ||        // If an operator button that takes one number is clicked
                clickedButton == acosButton || clickedButton == atanButton || clickedButton == sinhButton ||            
                clickedButton == coshButton || clickedButton == tanhButton )  {
            if (num1 == 0) {
                num1 = Double.parseDouble(String.valueOf(text_field.getText()));            //Store the first number or use result if available
            }
            else {
                num1 = (double) result;
            }
            operator = clickedButton.getText();         //Store operator 
            text_field.setText(text_field.getText());
            output_text_field.setText(operator);
            switch (operator) {         //Perform operation depending on operator
                case "1/n": // Inverse of a number
                    result = 1 / num1;
                    output_text_field.setText(String.valueOf(result));
                    break;
                case "√": // Square root
                    result = Math.sqrt(num1);
                    output_text_field.setText(String.valueOf(result));
                    break;                                  
                case "x²": // Square of a number
                    result = Math.pow((num1), 2);
                    output_text_field.setText(String.valueOf(result));
                    break;
                case "x³": // Cube of a number
                    result = Math.pow((num1), 3);
                    output_text_field.setText(String.valueOf(result));
                    break;
                case "log": // Logarithm base 10
                    result = Math.log10(num1);
                    output_text_field.setText(String.valueOf(result));
                    break;
                case "ln": // Natural logarithm                     
                    result = Math.log(num1);
                    output_text_field.setText(String.valueOf(result));
                    break;
                case "sin": // Sine
                    result = Math.sin(num1);
                    output_text_field.setText(String.valueOf(result));
                    break;
                case "cos": // Cosine
                    result = Math.cos(num1);
                    output_text_field.setText(String.valueOf(result));
                    break;
                case "tan": // Tangent
                    result = Math.tan(num1);
                    output_text_field.setText(String.valueOf(result));
                    break;
                case "asin": // Arcsine
                    result = Math.asin(num1);
                    output_text_field.setText(String.valueOf(result));
                    break;
                case "acos": // Arccosine
                    result = Math.acos(num1);       
                    output_text_field.setText(String.valueOf(result));  
                    break;
                case "atan": // Arctangent
                    result = Math.atan(num1);
                    output_text_field.setText(String.valueOf(result));
                    break;
                case "sinh": // Hyperbolic sine
                    num1 = Math.sinh(num1);
                    output_text_field.setText(String.valueOf(result));
                    break;
                case "cosh": // Hyperbolic cosine
                    result = Math.cosh(num1);
                    output_text_field.setText(String.valueOf(result));
                    break;
                case "tanh": // Hyperbolic tangent
                    result = Math.tanh(num1);
                    output_text_field.setText(String.valueOf(result));
                    break;
        
            }
            // Clear the text field for the next number input
            text_field.setText("");
            
            
            
        }

        // If the equals button is clicked
        else if (clickedButton == equalsButton) {
            // Get the second number
            num2 = Double.parseDouble(text_field.getText());
            // Perform the operation based on the stored operator
            switch (operator) {  // Handle different operations
                case "+":
                    result = num1 + num2;
                    answer = String.format("%.2f", result);         //Add
                    break;
                case "-":
                    result = num1 - num2;
                    answer = String.format("%.2f", result);         //Subtract
                    break;
                case "*":
                    result = num1 * num2;
                    answer = String.format("%.2f", result);         //Multiply
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;                               //Divide
                        answer = String.format("%.2f", result);
                    } else {
                        // Handle division by zero error
                        output_text_field.setText("Error: Division by zero. Press clear");
                        return;
                    }
                    break;
                case "%":
                    result = (num1 * .01) * num2;
                    answer = String.format("%.2f", result);         //Percentage
                    
                    break;
                case "mod":
                    result = num1 % num2;
                    answer = String.format("%.2f", result);         //Remainders
                    break;
            }
            
            // Display the result in the text field
            output_text_field.setText(answer);
            num1 = (double) result; //Store result for future calculations
            text_field.setText("Choose a new operator or clear");
        }             
        
        // If the clear button is clicked
        if (clickedButton == clearButton) {
            // Clear the text field and reset the variables
            text_field.setText("");
            output_text_field.setText("");
            num1 = 0;
            num2 = 0;
            operator = "";
            result = 0;
        } 
        
        // If the exit button is clicked
        else if (clickedButton == exitButton) {
            // Close the application
            System.exit(0);
        }
    
        
      } catch (Exception Error) {
        output_text_field.setText("Error clear calculator");               //Exception handling
        text_field.setText("");
        
        num2 = 0;
        operator = "";
        result = 0;
        answer = "";
      }  
    }
}