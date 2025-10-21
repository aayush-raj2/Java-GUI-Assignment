import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentRegistrationForm extends JFrame implements ActionListener {

    private JTextField txtName, txtID, txtEmail, txtCourse;
    private JButton btnSubmit, btnClear;

    public StudentRegistrationForm() {
        setTitle("Student Registration Form");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel heading = new JLabel("Student Registration Form", JLabel.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(heading, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        formPanel.add(new JLabel("Student Name:"));
        txtName = new JTextField();
        formPanel.add(txtName);

        formPanel.add(new JLabel("Student ID:"));
        txtID = new JTextField();
        formPanel.add(txtID);

        formPanel.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        formPanel.add(txtEmail);

        formPanel.add(new JLabel("Course:"));
        txtCourse = new JTextField();
        formPanel.add(txtCourse);

        btnSubmit = new JButton("Submit");
        btnClear = new JButton("Clear");
        btnSubmit.addActionListener(this);
        btnClear.addActionListener(this);

        formPanel.add(btnSubmit);
        formPanel.add(btnClear);

        add(formPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            registerStudent();
        } else if (e.getSource() == btnClear) {
            clearFields();
        }
    }

    private void registerStudent() {
        String name = txtName.getText().trim();
        String id = txtID.getText().trim();
        String email = txtEmail.getText().trim();
        String course = txtCourse.getText().trim();

        if (name.isEmpty() || id.isEmpty() || email.isEmpty() || course.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(this, "Enter a valid email!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO students (student_id, name, email, course) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            pst.setString(2, name);
            pst.setString(3, email);
            pst.setString(4, course);

            int rows = pst.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Student Registered Successfully!");
                clearFields();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage());
        }
    }

    private void clearFields() {
        txtName.setText("");
        txtID.setText("");
        txtEmail.setText("");
        txtCourse.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentRegistrationForm().setVisible(true));
    }
}
