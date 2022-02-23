import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.InputMismatchException;

public class BMI extends JFrame {



    //tf

    JTextField ftf = new JTextField();
    JTextField ptf = new JTextField();
    //Labels

    JLabel healthStatus = new JLabel("", SwingConstants.CENTER);

    JLabel titleLabel = new JLabel("Adult BMI Calculator");


    JLabel heightLabel = new JLabel("1. Height:");
    JLabel weightLabel = new JLabel("2. Weight:");

    JLabel feetLabel = new JLabel("Feet");

    JLabel poundsLabel = new JLabel("Pound");

    JLabel resultLabel = new JLabel("", SwingConstants.CENTER);
    JLabel resultTititle = new JLabel("Result");

    JLabel errorLabel = new JLabel("", SwingConstants.CENTER);

    //Button

    JButton CalculateBtn = new JButton("Calculate");

    JButton clearBTN = new JButton("Clear");

    //Color and Font


    Font fontBig = new Font("Roboto", Font.BOLD,24);


    //Variables

    private double feet;

    private double pounds;


    public BMI() {
        this.setSize(660, 550);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.decode("#448EB8"));
        this.setResizable(false);


        titleLabel.setBounds(194,12,391,29);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(fontBig);
        this.add(titleLabel);

        heightLabel.setBounds(68,133,135,33);
        heightLabel.setForeground(Color.white);
        heightLabel.setFont(fontBig);
        this.add(heightLabel);

        weightLabel.setBounds(68,274,193,39);
        weightLabel.setForeground(Color.white);
        weightLabel.setFont(fontBig);
        this.add(weightLabel);



        poundsLabel.setBounds(179,313,67,12);
        poundsLabel.setForeground(Color.white);

        this.add(poundsLabel);

        feetLabel.setBounds(179,166,37,20);
        feetLabel.setForeground(Color.white);

        this.add(feetLabel);

        //Textfield

        ftf.setBounds(179,197,67,23);
        this.add(ftf);


        ptf.setBounds(179,344,67,23);
        this.add(ptf);


        CalculateBtn.setBounds(179,398,151,28);
        this.add(CalculateBtn);

        clearBTN.setBounds(363,398,151,28);
        this.add(clearBTN);

        resultTititle.setBounds(470,184,96,50);
        resultTititle.setForeground(Color.white);
        resultTititle.setFont(fontBig);
        this.add(resultTititle);

        resultLabel.setBounds(424,225,163,88);
        this.add(resultLabel);

        healthStatus.setBounds(422,269,169,25);
        this.add(healthStatus);

        errorLabel.setBounds(245,547,201,14);
        this.add(errorLabel);




        action_Listeners();
        this.setVisible(true);

        }

        public void action_Listeners() {
        CalculateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    feet = Double.parseDouble(ftf.getText());

                    pounds = Double.parseDouble(ptf.getText());

                    double convertToInches = feet * 12;

                    double bmi = (pounds / Math.pow(convertToInches, 2) * 703);

                    NumberFormat formatter = new DecimalFormat("##.#");

                    resultLabel.setText("Your BMI is " + formatter.format(bmi));

                    if (bmi < 18.5) {
                        healthStatus.setText("Health status: Underweight");
                    } else if (bmi > 18.5 && bmi < 24.9) {
                        healthStatus.setText("Health status: Healthy");

                    } else if (bmi > 25.0 && bmi < 29.9) {
                        healthStatus.setText("Health status: Overweight");

                    } else if (bmi > 30.0) {
                        healthStatus.setText("Health status: Obese");

                    }


                    System.out.println(bmi);

                } catch (InputMismatchException h) {
                    errorLabel.setText("Please enter a valid value");
                } catch (NumberFormatException n) {
                    errorLabel.setText("Please enter a valid value");


                }


            }
        });

        clearBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ptf.setText("");
                ftf.setText("");
                resultLabel.setText("");
                healthStatus.setText("");
            }
        });
        }



        }





