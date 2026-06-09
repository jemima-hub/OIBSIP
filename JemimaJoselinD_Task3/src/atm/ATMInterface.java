package atm;

import javax.swing.*;
import java.awt.event.*;

public class ATMInterface extends JFrame
implements ActionListener {

JTextField userField;

JPasswordField pinField;

JButton login;

double balance = 5000;

String history = "";

public ATMInterface() {

setTitle("ATM Interface");

setSize(350,250);

setLayout(null);

setDefaultCloseOperation(EXIT_ON_CLOSE);

JLabel u =
new JLabel("User ID");

u.setBounds(40,40,100,30);

userField =
new JTextField();

userField.setBounds(120,40,150,30);

JLabel p =
new JLabel("PIN");

p.setBounds(40,90,100,30);

pinField =
new JPasswordField();

pinField.setBounds(120,90,150,30);

login =
new JButton("Login");

login.setBounds(110,150,100,35);

login.addActionListener(this);

add(u);

add(userField);

add(p);

add(pinField);

add(login);

setVisible(true);

}

public void actionPerformed(
ActionEvent e) {

String user =
userField.getText();

String pin =
new String(
pinField.getPassword());

if(user.equals("admin")
&& pin.equals("1234")) {

showMenu();

}

else {

JOptionPane.showMessageDialog(
this,
"Invalid Login");

}

}

void showMenu() {

while(true) {

String choice =
JOptionPane.showInputDialog(
"""
1.Transaction History
2.Withdraw
3.Deposit
4.Transfer
5.Quit
""");

if(choice==null)
break;

switch(choice) {

case "1":

JOptionPane.showMessageDialog(
this,
history.isEmpty()
?
"No Transactions"
:
history);

break;

case "2":

String w =
JOptionPane.showInputDialog(
"Withdraw Amount");

double wd =
Double.parseDouble(w);

if(wd<=balance){

balance-=wd;

history +=
"Withdraw ₹"
+ wd
+ "\n";

}

break;

case "3":

String d =
JOptionPane.showInputDialog(
"Deposit Amount");

double dp =
Double.parseDouble(d);

balance+=dp;

history +=
"Deposit ₹"
+ dp
+ "\n";

break;

case "4":

String t =
JOptionPane.showInputDialog(
"Transfer Amount");

double tr =
Double.parseDouble(t);

if(tr<=balance){

balance-=tr;

history +=
"Transfer ₹"
+ tr
+ "\n";

}

break;

case "5":

System.exit(0);

}

}

}

public static void main(
String[] args) {

new ATMInterface();

}

}