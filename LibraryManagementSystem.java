import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Book {
    private String title;
    private String author;
    private int id;

    public Book(String title, String author, int id) {
        this.title = title;
        this.author = author;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }
}

public class LibraryManagementSystem {
    private ArrayList<Book> books;
    private JFrame frame;
    private JTextField titleField, authorField, idField;
    private JTextArea displayArea;

    public LibraryManagementSystem() {
        books = new ArrayList<>();

        books.add(new Book("The Alchemist", "Paulo Coelho", 15983));
        books.add(new Book("Harry Potter", "J.K.Rowling", 23823));
        books.add(new Book("50 rules of love", "paulo coelho", 3567483));
        books.add(new Book("How to get rich", "Abdussamad", 7463334));
        books.add(new Book("Shahid afridi the untold story ", "Abdussamad", 863549));
        books.add(new Book("the lost brian", "Yousuf Ali", 997645));
        books.add(new Book("the Stupid Kid", "Omer Nizam", 887587675));
        books.add(new Book("MQM days", "Abdul Aziz", 4457575));
        books.add(new Book("1962 fight against india", "Khubaib", 277432));
        books.add(new Book("my documentary ", "Abdussamad", 101252));

        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(800,800);
        frame.setResizable(true);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Author:"));
        authorField = new JTextField();
        inputPanel.add(authorField);
        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new AddBookListener());
        buttonPanel.add(addButton);
        JButton displayButton = new JButton("Display Books");
        displayButton.addActionListener(new DisplayBooksListener());
        buttonPanel.add(displayButton);
        JButton searchButton = new JButton("Search Book");
        searchButton.addActionListener(new SearchBookListener());
        buttonPanel.add(searchButton);

        displayArea = new JTextArea(20, 40);
        displayArea.setEditable(false);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(new JScrollPane(displayArea), BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private class AddBookListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = titleField.getText();
            String author = authorField.getText();
            int id = Integer.parseInt(idField.getText());
            books.add(new Book(title, author, id));
            titleField.setText("");
            authorField.setText("");
            idField.setText("");
        }
    }

    private class DisplayBooksListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            displayArea.setText("");
            for (Book book : books) {
                displayArea.append("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", ID: " + book.getId() + "\n");
            }
        }
    }

    private class SearchBookListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = titleField.getText();
            String author = authorField.getText();
            int id = Integer.parseInt(idField.getText());
            boolean found = false;
            displayArea.setText("");
            for (Book book : books) {
                if (book.getTitle().equals(title) || book.getAuthor().equals(author) || book.getId() == id) {
                    displayArea.append("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", ID: " + book.getId() + "\n");
                    found = true;
                }
            }
            if (!found) {
                displayArea.append("Book not found\n");
            }
        }
    }

    public static void main(String[] args) {
        new LibraryManagementSystem();
    }
