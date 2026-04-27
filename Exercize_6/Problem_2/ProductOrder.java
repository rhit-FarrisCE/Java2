package Exercize_6.Problem_2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class ProductOrder extends JFrame {
    private JList<String> productList;
    private JTextField numItemsField;
    private JTextField orderInfoField;
    private JTextArea cartDisplay;
    private ArrayList<SortableDataStore> cart;
    private final int MAX_CART_SIZE = 20;

    public ProductOrder() {
        setTitle("ProductOrder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);

        // Initialize cart
        cart = new ArrayList<>();

        // Create main panel with border layout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Top label
        JLabel titleLabel = new JLabel("ProductOrder");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Create content panel divided into 3 sections
        JPanel contentPanel = new JPanel(new GridLayout(3, 1, 10, 10));

        // ===== TOP SECTION: List and Input Fields =====
        JPanel topSection = new JPanel(new GridLayout(1, 2, 10, 10));

        // Left: Product list (small)
        JPanel listPanel = new JPanel(new BorderLayout(5, 5));
        listPanel.setBorder(BorderFactory.createTitledBorder("Products"));
        String[] products = {"IBM NoteBook", "Dell Product", "MS Windows", "Sun Workstation", "Oracle DB", "MySQL"};
        productList = new JList<>(products);
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productList.setVisibleRowCount(6);
        JScrollPane listScrollPane = new JScrollPane(productList);
        listPanel.add(listScrollPane, BorderLayout.CENTER);

        // Right: Input fields
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Order Details"));
        inputPanel.add(new JLabel("Number of Items:"));
        numItemsField = new JTextField();
        inputPanel.add(numItemsField);

        inputPanel.add(new JLabel("Order Information:"));
        orderInfoField = new JTextField();
        inputPanel.add(orderInfoField);

        topSection.add(listPanel);
        topSection.add(inputPanel);
        contentPanel.add(topSection);

        // ===== MIDDLE SECTION: Large Buttons =====
        JPanel buttonSection = new JPanel(new GridLayout(1, 3, 10, 10));
        
        JButton addButton = new JButton("Add to Cart");
        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        addButton.setPreferredSize(new Dimension(0, 80));
        addButton.addActionListener(new AddButtonListener());
        buttonSection.add(addButton);

        JButton sortButton = new JButton("Sort Cart");
        sortButton.setFont(new Font("Arial", Font.BOLD, 14));
        sortButton.setPreferredSize(new Dimension(0, 80));
        sortButton.addActionListener(new SortButtonListener());
        buttonSection.add(sortButton);

        JButton resetButton = new JButton("Reset Cart");
        resetButton.setFont(new Font("Arial", Font.BOLD, 14));
        resetButton.setPreferredSize(new Dimension(0, 80));
        resetButton.addActionListener(new ResetButtonListener());
        buttonSection.add(resetButton);

        contentPanel.add(buttonSection);

        // ===== BOTTOM SECTION: Show Cart Button and Display =====
        JPanel bottomSection = new JPanel(new GridLayout(1, 2, 10, 10));

        // Left: Show Cart button (large)
        JButton showCartButton = new JButton("Show Cart");
        showCartButton.setFont(new Font("Arial", Font.BOLD, 14));
        showCartButton.addActionListener(e -> displayCart());
        bottomSection.add(showCartButton);

        // Right: Cart display
        JPanel cartPanel = new JPanel(new BorderLayout(5, 5));
        cartPanel.setBorder(BorderFactory.createTitledBorder("Cart Contents"));
        cartDisplay = new JTextArea();
        cartDisplay.setEditable(false);
        cartDisplay.setLineWrap(true);
        cartDisplay.setWrapStyleWord(true);
        JScrollPane cartScrollPane = new JScrollPane(cartDisplay);
        cartPanel.add(cartScrollPane, BorderLayout.CENTER);
        bottomSection.add(cartPanel);

        contentPanel.add(bottomSection);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    // Action Listener for Add to Cart button
    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = productList.getSelectedIndex();
            if (selectedIndex == -1) {
                return;
            }

            if (cart.size() >= MAX_CART_SIZE) {
                return;
            }

            String selectedProduct = productList.getSelectedValue();
            String numItems = numItemsField.getText().trim();
            String orderInfo = orderInfoField.getText().trim();
            
            SortableDataStore item = new SortableDataStore(selectedProduct, numItems, orderInfo);
            cart.add(item);

            // Clear input fields
            numItemsField.setText("");
            orderInfoField.setText("");
        }
    }

    // Action Listener for Sort button
    private class SortButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (cart.isEmpty()) {
                return;
            }

            Collections.sort(cart);
            displayCart();
        }
    }

    // Action Listener for Reset button
    private class ResetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cart.clear();
            cartDisplay.setText("");
        }
    }

    private void displayCart() {
        if (cart.isEmpty()) {
            cartDisplay.setText("Cart is empty.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cart.size(); i++) {
            sb.append((i + 1)).append(". ").append(cart.get(i).toString()).append("\n");
        }
        cartDisplay.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductOrder());
    }
}
