package reservation;

import javax.swing.*;
import java.awt.event.*;

public class Reservation extends JFrame implements ActionListener {

    JLabel title;
    JLabel nameLabel;
    JLabel trainNoLabel;
    JLabel trainNameLabel;
    JLabel classLabel;
    JLabel dateLabel;
    JLabel fromLabel;
    JLabel toLabel;

    JTextField nameField;
    JTextField trainNoField;
    JTextField trainNameField;
    JTextField dateField;
    JTextField fromField;
    JTextField toField;

    JComboBox<String> classBox;

    JButton reserveButton;
    JButton cancelButton;

    public Reservation() {

        setTitle("Online Reservation System");

        setSize(550, 650);

        setLayout(null);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        title =
                new JLabel(
                        "TRAIN RESERVATION"
                );

        title.setBounds(
                160,
                20,
                250,
                30
        );

        nameLabel =
                new JLabel(
                        "Passenger Name"
                );

        nameLabel.setBounds(
                50,
                80,
                150,
                30
        );

        nameField =
                new JTextField();

        nameField.setBounds(
                220,
                80,
                180,
                30
        );

        trainNoLabel =
                new JLabel(
                        "Train Number"
                );

        trainNoLabel.setBounds(
                50,
                130,
                150,
                30
        );

        trainNoField =
                new JTextField();

        trainNoField.setBounds(
                220,
                130,
                180,
                30
        );

        trainNameLabel =
                new JLabel(
                        "Train Name"
                );

        trainNameLabel.setBounds(
                50,
                180,
                150,
                30
        );

        trainNameField =
                new JTextField();

        trainNameField.setBounds(
                220,
                180,
                180,
                30
        );

        trainNameField.setEditable(false);

        // Auto Fill Train Name

        trainNoField.addKeyListener(
                new KeyAdapter() {

                    public void keyReleased(
                            KeyEvent e
                    ) {

                        String train =
                                trainNoField.getText();

                        if (
                                train.equals("12637")
                        ) {

                            trainNameField.setText(
                                    "Pandian Express"
                            );

                        }

                        else if (
                                train.equals("12627")
                        ) {

                            trainNameField.setText(
                                    "Karnataka Express"
                            );

                        }

                        else if (
                                train.equals("12623")
                        ) {

                            trainNameField.setText(
                                    "Chennai Mail"
                            );

                        }

                        else {

                            trainNameField.setText(
                                    ""
                            );

                        }

                    }

                }

        );

        classLabel =
                new JLabel(
                        "Class Type"
                );

        classLabel.setBounds(
                50,
                230,
                150,
                30
        );

        String classes[] = {

                "Sleeper",
                "AC",
                "First Class"

        };

        classBox =
                new JComboBox<>(
                        classes
                );

        classBox.setBounds(
                220,
                230,
                180,
                30
        );

        dateLabel =
                new JLabel(
                        "Journey Date"
                );

        dateLabel.setBounds(
                50,
                280,
                150,
                30
        );

        dateField =
                new JTextField();

        dateField.setBounds(
                220,
                280,
                180,
                30
        );

        fromLabel =
                new JLabel(
                        "From"
                );

        fromLabel.setBounds(
                50,
                330,
                150,
                30
        );

        fromField =
                new JTextField();

        fromField.setBounds(
                220,
                330,
                180,
                30
        );

        toLabel =
                new JLabel(
                        "Destination"
                );

        toLabel.setBounds(
                50,
                380,
                150,
                30
        );

        toField =
                new JTextField();

        toField.setBounds(
                220,
                380,
                180,
                30
        );

        reserveButton =
                new JButton(
                        "Reserve"
                );

        reserveButton.setBounds(
                170,
                460,
                150,
                40
        );

        reserveButton.addActionListener(
                this
        );

        cancelButton =
                new JButton(
                        "Go To Cancellation"
                );

        cancelButton.setBounds(
                140,
                530,
                220,
                40
        );

        cancelButton.addActionListener(
                e -> new Cancellation()
        );

        add(title);

        add(nameLabel);
        add(nameField);

        add(trainNoLabel);
        add(trainNoField);

        add(trainNameLabel);
        add(trainNameField);

        add(classLabel);
        add(classBox);

        add(dateLabel);
        add(dateField);

        add(fromLabel);
        add(fromField);

        add(toLabel);
        add(toField);

        add(reserveButton);

        add(cancelButton);

        setVisible(true);

    }

    @Override
    public void actionPerformed(
            ActionEvent e
    ) {

        long pnr =
                (long)
                        (
                                Math.random()
                                        *
                                        1000000000
                        );

        JOptionPane.showMessageDialog(

                this,

                "Reservation Successful\n\nPNR : "
                        + pnr

        );

    }

}