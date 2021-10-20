package App.UI;

import App.Classes.CatalogClass;
import App.Classes.GradebookClass;
import App.Classes.ProfessorClass;
import App.Classes.StudentClass;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UiFirstWindow implements ActionListener {
    Scanner sc= new Scanner(System.in);
    ProfessorClass professorClass = new ProfessorClass("a", "p", "VasileLumina", "12345123");
    CatalogClass catalogClass = new CatalogClass();
    ArrayList<JLabel> labelsMaterii = new ArrayList<JLabel>();
    ArrayList<JTextField> textFieldsMaterii = new ArrayList<JTextField>();
    JButton buttonProfessor;
    JButton buttonStudent;
    JButton buttonLogin;
    JFrame firstFrame;
    JFrame loginFrame;
    JFrame professorFrame;
    JTextField utilizatorField;
    JTextField passwordField;
    JButton addStudentButton;
    JButton addGradesToStudentButton;
    JButton goBackButton;
    JFrame addStudentFrame;
    JTextField fullName;
    JTextField spec;
    JTextField cnp;
    JTextField password;
    JTextField numberClasses;
    JTextField nameOfClass;
    JTextField numberOfGrades;
    JTextField theGrades;
    JButton addStdButton;
    JButton addMatButton;
    JLabel labelNumberOfClasses;
    String nameOfClasses[] = null;
    int numberOfGrad[] = null;
    int classGrades[][] = null;
    private boolean haveOneStudent = false;
    private String nameUser;
    private String passwordUser;
    private String userType;

    public UiFirstWindow() {
        //PROFESOR OR STUDENT----------------------------------------------------------------------------
        buttonProfessor = new JButton("Sunt profesor");
        buttonProfessor.setActionCommand("Profesor");
        buttonStudent = new JButton("Sunt student");
        buttonStudent.setActionCommand("Student");
        buttonLogin = new JButton("Log in");
        buttonLogin.setActionCommand("LogIn");
        firstFrame = new JFrame("Student sau profesor");
        firstFrame.setPreferredSize(new Dimension(500, 500));
        buttonProfessor.addActionListener(this);
        buttonStudent.addActionListener(this);
        buttonLogin.addActionListener(this);
        firstFrame.setLayout(new BorderLayout());
        firstFrame.add(new JLabel("Sunteti profesor sau student?"), BorderLayout.NORTH);
        firstFrame.add(buttonProfessor, BorderLayout.WEST);
        firstFrame.add(buttonStudent, BorderLayout.EAST);
        //LOGIN-----------------------------------------------------------------------------------------
        JLabel label1 = new JLabel("Nume utilizator");
        JLabel label2 = new JLabel("Parola");
        utilizatorField = new JTextField();
        utilizatorField.setBounds(170, 100, 150, 20);
        passwordField = new JTextField();
        passwordField.setBounds(170, 140, 150, 20);
        loginFrame = new JFrame("Login");
        loginFrame.setLayout(new BorderLayout());
        loginFrame.setPreferredSize(new Dimension(500, 500));
        loginFrame.add(label1);
        label1.setBounds(170, 80, 150, 20);
        loginFrame.add(utilizatorField);
        loginFrame.add(label2);
        label2.setBounds(170, 120, 150, 20);
        loginFrame.add(passwordField);
        loginFrame.add(new JLabel(""));
        loginFrame.add(buttonLogin, BorderLayout.SOUTH);
        //PROFESOR FRAME------------------------------------------------------------------------------------------
        professorFrame = new JFrame("Professor option");
        professorFrame.setLayout(new FlowLayout());
        professorFrame.setSize(new Dimension(1000, 100));
        addStudentButton = new JButton("Adaugati un Elev");
        addStudentButton.setActionCommand("addStudent");
        addGradesToStudentButton = new JButton("Adaugati note unui elev");
        addGradesToStudentButton.setActionCommand("addGradesToStudent");
        goBackButton = new JButton("Mergeti inapoi");
        goBackButton.setActionCommand("goBack");
        addStudentButton.addActionListener(this);
        addGradesToStudentButton.addActionListener(this);
        goBackButton.addActionListener(this);
        professorFrame.add(addStudentButton);
        professorFrame.add(addGradesToStudentButton);
        professorFrame.add(goBackButton);
        //ADD STUDENT FRAME-------------------------------------------------------------------------------------------------
        addStudentFrame = new JFrame("Add STUDENT");
        addStudentFrame.setPreferredSize(new Dimension(600, 600));
        addStudentFrame.setLayout(new BorderLayout());
        JLabel labelName = new JLabel("Specializare");
        labelName.setBounds(100, 30, 100, 20);
        JLabel labelSpec = new JLabel("CNP");
        labelSpec.setBounds(100, 70, 100, 20);
        JLabel labelCnp = new JLabel("Nume");
        labelCnp.setBounds(100, 110, 100, 20);
        JLabel labelPassword = new JLabel("Parola");
        labelPassword.setBounds(100, 150, 100, 20);
        labelNumberOfClasses = new JLabel("Numarul de ore");
        labelNumberOfClasses.setBounds(100, 200, 200, 20);
        JLabel l = new JLabel();
        spec = new JTextField();
        spec.setBounds(100, 50, 400, 20);
        cnp = new JTextField();
        cnp.setBounds(100, 90, 400, 20);
        fullName = new JTextField();
        fullName.setBounds(100, 130, 400, 20);
        password = new JTextField();
        password.setBounds(100, 170, 400, 20);
        numberClasses = new JTextField();
        numberClasses.setBounds(100, 220, 400, 20);
        addStdButton = new JButton("Adaugati");
        addStdButton.setBounds(50, 300, 100, 30);
        addStdButton.setActionCommand("addStd");
        addStdButton.addActionListener(this);

        addStudentFrame.add(labelName);
        addStudentFrame.add(fullName);
        addStudentFrame.add(labelSpec);
        addStudentFrame.add(spec);
        addStudentFrame.add(labelCnp);
        addStudentFrame.add(cnp);
        addStudentFrame.add(labelPassword);
        addStudentFrame.add(password);
        addStudentFrame.add(labelNumberOfClasses);
        addStudentFrame.add(numberClasses);
        addStudentFrame.add(l);
        addStudentFrame.add(addStdButton,BorderLayout.SOUTH);
        addStudentFrame.add(l);
        //PACKING-------------------------------------------------------------------------------------------------
        loginFrame.pack();
        firstFrame.pack();
        professorFrame.pack();
        addStudentFrame.pack();
        firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        professorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addStudentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        professorFrame.setVisible(false);
        loginFrame.setVisible(false);
        firstFrame.setVisible(true);
    }

    public void setUserType(String s) {
        this.userType = s;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("addStudent".equals((e.getActionCommand()))) {
            System.out.println("Adaugam un elev");
            addStudentFrame.setVisible(true);
            professorFrame.setVisible(false);

        } else if ("addGradesToStudent".equals(e.getActionCommand())) {
            System.out.println("Adaugam note unui elev");
        }
        if ("Profesor".equals(e.getActionCommand())) {
            loginFrame.setVisible(true);
            firstFrame.setVisible(false);
            setUserType("p");

        } else if ("Student".equals(e.getActionCommand())) {
            firstFrame.setVisible(false);
            loginFrame.setVisible(true);
            setUserType("s");
        } else if ("goBack".equals((e.getActionCommand()))) {
            System.out.println("Mergem inapoi");
        }
        if ("LogIn".equals((e.getActionCommand()))) {
            nameUser = utilizatorField.getText();
            passwordUser = passwordField.getText();
            System.out.println("Am vrut sa introducem date\n" + nameUser + " " + passwordUser);
            if (userType.equals("p")) {
                if (professorClass.getPassword().equals(passwordUser) && professorClass.getUsername().equals(nameUser)) {
                    System.out.println("Ne-am logat cu succes");
                    loginFrame.setVisible(false);
                    professorFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Nume si/sau parola gresite, reincercati", "Eroare", JOptionPane.ERROR_MESSAGE);
                }
            } else if (userType.equals("s") && !haveOneStudent) {
                JOptionPane.showMessageDialog(null, "Nu exista niciun elev introdus, asteptati un profesor sa va introduca", "Eroare", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            } else {
                System.out.println("Sunteti Student");
            }
        } else if ("addStd".equals(e.getActionCommand())) {
            String name = fullName.getText();
            String speci = spec.getText();
            String Cnp = cnp.getText();
            if(!StudentClass.isNumber(Cnp)){
                System.out.println("CNP INTRODUS INCORECT");
            }
            String pass = password.getText();
            int numOfCls = Integer.parseInt(numberClasses.getText());
            StudentClass student = new StudentClass(pass, Cnp, name, Cnp, speci);
            System.out.println(student.toString());
            String nameOfClasses[] = new String[numOfCls];
            int numberOfGrades[] = new int[numOfCls];
            int classGrades[][] = new int[numOfCls][10];
            for(int i=0;i<numOfCls;++i) {
                System.out.println("Numele materiei " + i);
                nameOfClasses[i] = sc.next();
                System.out.println("Numarul de note pe care il are la materia "+nameOfClasses[i]);
                numberOfGrades[i]=sc.nextInt();
                for (int j = 0; j < numberOfGrades[i]; ++j) {
                    System.out.println("Nota");
                    classGrades[i][j] = sc.nextInt();
                }
            }
            GradebookClass studentGrb = new GradebookClass(name,speci,Cnp,pass,numOfCls,nameOfClasses,numberOfGrades);
            studentGrb.set_classGrades(classGrades);

            for(int i=0;i<numOfCls;++i)
            {
                System.out.println(nameOfClasses[i]);
                for(int j=0;j<numberOfGrades[i];++j)
                {
                    System.out.println("Nota "+j+" "+classGrades[i][j]);
                }
            }

        }
    }
}

