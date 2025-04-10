import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class StudentManager {
    private JFrame frame;
    private JTextField nameField, ageField, classField, searchField;
    private JTable studentTable;
    private ArrayList<Student> studentList;
    private DefaultTableModel tableModel;

    public StudentManager() {
        studentList = new ArrayList<>();
        frame = new JFrame("Quản Lý Sinh Viên");

        // Tạo các trường nhập liệu và nhãn
        JLabel nameLabel = new JLabel("Tên:");
        JLabel ageLabel = new JLabel("Tuổi:");
        JLabel classLabel = new JLabel("Lớp:");
        JLabel searchLabel = new JLabel("Tìm kiếm:");


        nameField = new JTextField(20);
        ageField = new JTextField(20);
        classField = new JTextField(20);
        searchField = new JTextField(20);

        // Tạo các nút chức năng
        JButton deleteButton = new JButton("Xoá");
        // Tạo bảng để hiển thị danh sách sinh viên
        String[] columnNames = {"Tên", "Tuổi", "Lớp"};
        tableModel = new DefaultTableModel(columnNames, 0);
        studentTable = new JTable(tableModel);
        
        // Lắng nghe sự kiện khi nhấn nút "Xoá"
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });
        
       

        // Cấu hình giao diện
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(classLabel);
        panel.add(classField);

        panel.add(deleteButton);

       
        // Thêm bảng vào cửa sổ
        JScrollPane scrollPane = new JScrollPane(studentTable);

        // Cấu hình frame
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void deleteStudent() {
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(frame, "Vui lòng chọn sinh viên để xóa!");
            return;
        }

        studentList.remove(selectedRow);
        tableModel.removeRow(selectedRow);
    }

    public static void main(String[] args) {
        new StudentManager();
    }
}

class Student {
    private String name;
    private int age;
    private String className;

    public Student(String name, int age, String className) {
        this.name = name;
        this.age = age;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}