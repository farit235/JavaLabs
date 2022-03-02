package com;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class MainClass {
    public static void main(String[] args) {

        JFrame frame = new JFrame();



        JButton button = new JButton("Confirm");
        button.setBounds(100,190,100, 40);




        JTextField field1 = new JTextField("");
        field1.setBounds(50,60,200,30);

        JTextField field2 = new JTextField("");
        field2.setBounds(50,100,200,30);

        JTextField field3 = new JTextField("");
        field3.setBounds(50,140,200,30);

        field1.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                changed();
            }
            public void removeUpdate(DocumentEvent e) {
                changed();
            }
            public void insertUpdate(DocumentEvent e) {
                changed();
            }

            public void changed() {
                if (field1.getText() != null && field1.getText().equals("")) {
                    button.setEnabled(false);
                    JLabel welcome = new JLabel("");
                    welcome.setText("Input smth to all text boxes!");
                    frame.add(welcome);
                    frame.pack();
                    frame.setVisible(true);

                } else {
                    button.setEnabled(true);
                }


            }
        });


        //слушатель кнопки
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String textFieldValue1 = field1.getText();
                String textFieldValue2 = field2.getText();
                String textFieldValue3 = field3.getText();



                if ((field1.getText() != null && field1.getText().equals("")) || (field2.getText() != null && field2.getText().equals("")) || (field3.getText() != null && field3.getText().equals("")) ) {

                    System.out.println("Wrong input!");
                    JOptionPane.showMessageDialog(frame, "Input something to all text boxes!");

                } else {

                    System.out.println("Car name: " + textFieldValue1);
                    System.out.println("Car model: " + textFieldValue2);



                    try {

                        int i = Integer.parseInt(textFieldValue3);

                        System.out.println("Car weight: " + i);

                        try{

                            String content = "Car name: " + textFieldValue1 + "\n" + "Car model: " + textFieldValue2 + "\n" +  "Car weight: " + i + "\n";
                            String path="/Users/farit_sib/IdeaProjects/lab6/info.txt";
                            File file = new File(path);


                            if (!file.exists()) {
                                file.createNewFile();
                            }

                            FileWriter fw = new FileWriter(file.getAbsoluteFile());
                            BufferedWriter bw = new BufferedWriter(fw);


                            bw.write(content);


                            bw.close();

                        }

                        catch(Exception e){

                            System.out.println(e);

                        }

                        JOptionPane.showMessageDialog(frame, "Car successfully saved!");


                    }

                    catch (NumberFormatException e) {

                        JOptionPane.showMessageDialog(frame, "Wight should be integer number!");

                    }



                }

            }
        });





        frame.setTitle("Application");
        frame.add(field1);
        frame.add(field2);
        frame.add(field3);
        frame.add(button);

        frame.setSize(400,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

}
