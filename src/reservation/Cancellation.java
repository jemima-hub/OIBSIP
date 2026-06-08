package reservation;

import javax.swing.*;
import java.awt.event.*;

public class Cancellation extends JFrame implements ActionListener {

    JLabel title, pnrLabel;

    JTextField pnrField;

    JButton searchButton, cancelButton;

    public Cancellation() {

        setTitle("Ticket Cancellation");

        setSize(450,300);

        setLayout(null);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        title =
                new JLabel(
                        "CANCEL RESERVATION"
                );

        title.setBounds(120,30,250,30);

        pnrLabel =
                new JLabel(
                        "Enter PNR Number"
                );

        pnrLabel.setBounds(
                50,
                100,
                150,
                30
        );

        pnrField =
                new JTextField();

        pnrField.setBounds(
                200,
                100,
                180,
                30
        );

        searchButton =
                new JButton(
                        "Search"
                );

        searchButton.setBounds(
                70,
                180,
                120,
                40
        );

        cancelButton =
                new JButton(
                        "Cancel Ticket"
                );

        cancelButton.setBounds(
                220,
                180,
                140,
                40
        );

        searchButton.addActionListener(this);

        cancelButton.addActionListener(this);

        add(title);

        add(pnrLabel);

        add(pnrField);

        add(searchButton);

        add(cancelButton);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String pnr =
                pnrField.getText();

        if (e.getSource()
                == searchButton) {

            JOptionPane.showMessageDialog(
                    this,
                    "PNR Found\nPNR: "
                            + pnr
            );

        }

        if (e.getSource()
                == cancelButton) {

            JOptionPane.showMessageDialog(
                    this,
                    "Ticket Cancelled"
            );

        }

    }

}