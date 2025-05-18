import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.util.ArrayList;

public class ToDoListApp extends JFrame {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskInputField;
    private JButton addButton, removeButton, clearButton, markButton;

    // Constructor
    public ToDoListApp() {
        setTitle("To-Do List");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Create the task list model and JList
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Create the input field and buttons
        taskInputField = new JTextField(20);
        addButton = new JButton("Add Task");
        removeButton = new JButton("Remove Task");
        clearButton = new JButton("Clear All");
        markButton = new JButton("Mark as Completed");

        // Panel for task input and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Task: "));
        inputPanel.add(taskInputField);
        inputPanel.add(addButton);
        inputPanel.add(markButton);
        inputPanel.add(removeButton);
        inputPanel.add(clearButton);

        // Add components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(taskList), BorderLayout.CENTER);

        // Set up button actions
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeTask();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearAllTasks();
            }
        });

        markButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                markTaskAsCompleted();
            }
        });

        setVisible(true);
    }

    // Add task to the list
    private void addTask() {
        String task = taskInputField.getText().trim();
        if (!task.isEmpty()) {
            taskListModel.addElement(task);
            taskInputField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a valid task.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Remove selected task from the list
    private void removeTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            taskListModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a task to remove.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Clear all tasks from the list
    private void clearAllTasks() {
        taskListModel.clear();
    }

    // Mark task as completed
    private void markTaskAsCompleted() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            String task = taskListModel.getElementAt(selectedIndex);
            taskListModel.setElementAt(task + " (Completed)", selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a task to mark as completed.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new ToDoListApp();
    }
}
