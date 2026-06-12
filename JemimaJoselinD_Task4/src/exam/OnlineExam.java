package exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OnlineExam extends JFrame implements ActionListener {

String username="admin";
String password="1234";

JLabel questionLabel,timer;

JRadioButton a,b,c,d;

ButtonGroup group;

JButton next,logout;

int q=0;

int score=0;

int seconds=180;

Timer examTimer;

String[][] questions={

{"1. Java is a ?","Programming Language","Browser","Database","Compiler","1"},

{"2. HTML stands for ?",
"Hyper Text Markup Language",
"High Text Machine Language",
"Home Tool Markup Language",
"Hyper Tool Machine Language","1"},

{"3. Which keyword creates object ?",
"new","class","this","create","1"},

{"4. Java extension ?",
".java",".js",".html",".py","1"},

{"5. OOP stands for ?",
"Object Oriented Programming",
"Open Online Program",
"Object Operator",
"Online Object Process","1"},

{"6. Which company developed Java ?",
"Sun Microsystems",
"Google",
"Microsoft",
"Apple","1"},

{"7. Which package imports Swing ?",
"javax.swing",
"java.swing",
"java.gui",
"javax.gui","1"},

{"8. Java is ?",
"Platform Independent",
"Platform Dependent",
"Only Windows",
"Only Linux","1"},

{"9. Which loop runs at least once ?",
"do while",
"while",
"for",
"foreach","1"},

{"10. JVM means ?",
"Java Virtual Machine",
"Java Variable Method",
"Java Visual Machine",
"Java Version Model","1"}

};

public OnlineExam(){

login();

}

void login(){

String u=
JOptionPane.showInputDialog(
"Enter Username");

String p=
JOptionPane.showInputDialog(
"Enter Password");

if(
u.equals(username)
&&
p.equals(password)
){

buildUI();

}

else{

JOptionPane.showMessageDialog(
this,
"Invalid Login");

System.exit(0);

}

}

void buildUI(){

setTitle(
"Online Examination");

setSize(
700,
500);

setLayout(
null);

setDefaultCloseOperation(
EXIT_ON_CLOSE);

questionLabel=
new JLabel();

questionLabel.setBounds(
40,
40,
620,
50);

questionLabel.setFont(
new Font(
"Arial",
Font.BOLD,
20));

add(
questionLabel);

timer=
new JLabel(
"Time: 180");

timer.setBounds(
550,
10,
120,
30);

timer.setFont(
new Font(
"Arial",
Font.BOLD,
18));

add(
timer);

a=
new JRadioButton();

b=
new JRadioButton();

c=
new JRadioButton();

d=
new JRadioButton();

a.setBounds(70,120,500,40);

b.setBounds(70,180,500,40);

c.setBounds(70,240,500,40);

d.setBounds(70,300,500,40);

a.setFont(new Font("Arial",0,18));
b.setFont(new Font("Arial",0,18));
c.setFont(new Font("Arial",0,18));
d.setFont(new Font("Arial",0,18));

group=
new ButtonGroup();

group.add(a);

group.add(b);

group.add(c);

group.add(d);

add(a);

add(b);

add(c);

add(d);

next=
new JButton(
"Next");

logout=
new JButton(
"Logout");

next.setBounds(
180,
380,
120,
40);

logout.setBounds(
350,
380,
120,
40);

next.addActionListener(
this);

logout.addActionListener(
this);

add(next);

add(logout);

loadQuestion();

examTimer=
new Timer(
1000,
e->{

seconds--;

timer.setText(
"Time: "
+
seconds);

if(seconds==0){

finish();

}

});

examTimer.start();

setVisible(true);

}

void loadQuestion(){

questionLabel.setText(
questions[q][0]);

a.setText(
questions[q][1]);

b.setText(
questions[q][2]);

c.setText(
questions[q][3]);

d.setText(
questions[q][4]);

group.clearSelection();

}

public void actionPerformed(
ActionEvent e){

if(
e.getSource()
==
logout
){

System.exit(0);

}

String answer="";

if(a.isSelected())
answer="1";

if(b.isSelected())
answer="2";

if(c.isSelected())
answer="3";

if(d.isSelected())
answer="4";

if(
answer.equals(
questions[q][5]
))

score++;

q++;

if(
q<
questions.length
)

loadQuestion();

else

finish();

}

void finish(){

examTimer.stop();

JOptionPane.showMessageDialog(

this,

"Exam Finished\n\nScore: "
+
score
+
"/10"

);

System.exit(0);

}

public static void main(
String[] args){

new OnlineExam();

}

}