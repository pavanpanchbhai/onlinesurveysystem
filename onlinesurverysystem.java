import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class onlinesurverysystem extends JFrame implements ActionListener {
    private JLabel label1, label2, label3, label4, label5, label6, label7;
    private JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7;
    private JButton addButton, viewButton, editButton, deleteButton, clearButton, exitButton;
    private JPanel panel;
    private ArrayList<String[]> books = new ArrayList<String[]>();

    public onlinesurverysystem() {
        setTitle("Online Survery System");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label1 = new JLabel("Full name ");
        label2 = new JLabel("Address and phone number ");
        label3 = new JLabel("Title and department  ");
        label4 = new JLabel("Social Security number ");
        label5 = new JLabel("Start date ");
        label6 = new JLabel("Salary ");
        label7 = new JLabel("Educational background  ");

        textField1 = new JTextField(10);
        textField2 = new JTextField(20);
        textField3 = new JTextField(20);
        textField4 = new JTextField(20);
        textField5 = new JTextField(10);
        textField6 = new JTextField(20);
        textField7 = new JTextField(10);

        addButton = new JButton("Add");
        viewButton = new JButton("View");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");

        addButton.addActionListener(this);
        viewButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);

        panel = new JPanel(new GridLayout(10, 2));
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);
        panel.add(label4);
        panel.add(textField4);
        panel.add(label5);
        panel.add(textField5);
        panel.add(label6);
        panel.add(textField6);
        panel.add(label7);
        panel.add(textField7);
        panel.add(addButton);
        panel.add(viewButton);
        panel.add(editButton);
        panel.add(deleteButton);
        panel.add(clearButton);
        panel.add(exitButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String[] person = new String[7];
            person[0] = textField1.getText();
            person[1] = textField2.getText();
            person[2] = textField3.getText();
            person[3] = textField4.getText();
            person[4] = textField5.getText();
            person[5] = textField6.getText();
            person[6] = textField7.getText();
            books.add(person);
            JOptionPane.showMessageDialog(this, "Employee added successfully");
            clearFields();
        } else if (e.getSource() == viewButton) {
            String[] columns = { "Full name ", "Address and phone number ", "", "Title and department ",
                    "Social Security number ", "Start date",
                    "Educational background " };
            Object[][] data = new Object[books.size()][7];
            for (int i = 0; i < books.size(); i++) {
                data[i][0] = books.get(i)[0];
                data[i][1] = books.get(i)[1];
                data[i][2] = books.get(i)[2];
                data[i][3] = books.get(i)[3];
                data[i][4] = books.get(i)[4];
                data[i][5] = books.get(i)[5];
                data[i][6] = books.get(i)[6];
            }
            JTable table = new JTable(data, columns);
            JScrollPane scrollPane = new JScrollPane(table);
            JFrame frame = new JFrame("View Person");
            frame.add(scrollPane);
            frame.setSize(800, 400);
            frame.setVisible(true);
        } else if (e.getSource() == editButton) {
            String bookID = JOptionPane.showInputDialog(this, "Enter change department to edit:");
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i)[0].equals(bookID)) {
                    String[] person01 = new String[7];
                    person01[0] = bookID;
                    person01[1] = textField2.getText();
                    person01[2] = textField3.getText();
                    person01[3] = textField4.getText();
                    person01[4] = textField5.getText();
                    person01[5] = textField6.getText();
                    person01[6] = textField7.getText();
                    books.set(i, person01);
                    JOptionPane.showMessageDialog(this, "Employee edited successfully");
                    clearFields();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Employee not found");
        } else if (e.getSource() == deleteButton) {
            String bookID = JOptionPane.showInputDialog(this, "Enter Employee ID to delete:");
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i)[0].equals(bookID)) {
                    books.remove(i);
                    JOptionPane.showMessageDialog(this, "Employee deleted successfully");
                    clearFields();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Employee not found");
        } else if (e.getSource() == clearButton) {
            clearFields();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    private void clearFields() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");
        textField7.setText("");
    }

    public static void main(String[] args) {
        new onlinesurverysystem();
    }
}
