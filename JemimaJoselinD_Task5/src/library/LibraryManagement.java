package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LibraryManagement extends JFrame implements ActionListener {

JTextArea booksArea;

JLabel status;

String books =
"""
1. Java Programming
2. Data Structures
3. Database Systems
4. Computer Networks
5. Operating Systems
""";

JButton view;
JButton add;
JButton search;
JButton issue;
JButton returnBook;
JButton logout;

public LibraryManagement(){

login();

}

void login(){

String user =
JOptionPane.showInputDialog(
"Admin Username");

String pass =
JOptionPane.showInputDialog(
"Password");

if(
user.equals("admin")
&&
pass.equals("1234")
){

buildUI();

}

else{

JOptionPane.showMessageDialog(
null,
"Invalid Login");

System.exit(0);

}

}

void buildUI(){

setTitle(
"Digital Library Management");

setSize(
1000,
700);

setLayout(
null);

setLocationRelativeTo(
null);

setDefaultCloseOperation(
EXIT_ON_CLOSE);

JLabel title =
new JLabel(
"DIGITAL LIBRARY MANAGEMENT");

title.setBounds(
220,
20,
600,
40);

title.setFont(
new Font(
"Arial",
Font.BOLD,
32));

add(
title);

JLabel welcome =
new JLabel(
"Welcome Admin");

welcome.setBounds(
390,
70,
300,
30);

welcome.setFont(
new Font(
"Arial",
Font.PLAIN,
20));

add(
welcome);

booksArea =
new JTextArea();

booksArea.setFont(
new Font(
"Arial",
Font.PLAIN,
18));

booksArea.setEditable(
false);

JScrollPane scroll =
new JScrollPane(
booksArea);

scroll.setBounds(
120,
130,
730,
300);

add(
scroll);

status =
new JLabel(
"Select Operation");

status.setBounds(
350,
450,
300,
30);

status.setFont(
new Font(
"Arial",
Font.BOLD,
18));

add(
status);

view =
new JButton(
"View");

add =
new JButton(
"Add");

search =
new JButton(
"Search");

issue =
new JButton(
"Issue");

returnBook =
new JButton(
"Return");

logout =
new JButton(
"Logout");

JButton[] btns = {

view,
add,
search,
issue,
returnBook,
logout

};

int x = 60;

for(
JButton b
:
btns
){

b.setBounds(
x,
520,
130,
50);

b.setFont(
new Font(
"Arial",
Font.BOLD,
15));

b.addActionListener(
this);

add(
b);

x += 145;

}

setVisible(
true);

}

public void actionPerformed(
ActionEvent e){

if(
e.getSource()
==
view
){

booksArea.setText(
books);

status.setText(
"Books Loaded");

}

if(
e.getSource()
==
add
){

String b =
JOptionPane.showInputDialog(
"Enter Book Name");

if(
b!=null
&&
!b.isBlank()
){

books +=
books.split("\n").length
+
1
+
". "
+
b
+
"\n";

booksArea.setText(
books);

status.setText(
"Book Added");

}

}

if(
e.getSource()
==
search
){

String s =
JOptionPane.showInputDialog(
"Search Book");

if(
books.toLowerCase()
.contains(
s.toLowerCase()
)
){

status.setText(
"Book Found");

}

else{

status.setText(
"Book Not Found");

}

}

if(
e.getSource()
==
issue
){

String i =
JOptionPane.showInputDialog(
"Issue Book");

status.setText(
i
+
" Issued");

}

if(
e.getSource()
==
returnBook
){

String r =
JOptionPane.showInputDialog(
"Return Book");

status.setText(
r
+
" Returned");

}

if(
e.getSource()
==
logout
){

JOptionPane.showMessageDialog(
this,
"Logged Out");

System.exit(
0);

}

}

public static void main(
String[] args){

new LibraryManagement();

}

}