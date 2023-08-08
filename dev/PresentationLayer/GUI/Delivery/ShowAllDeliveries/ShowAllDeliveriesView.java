package PresentationLayer.GUI.Delivery.ShowAllDeliveries;

import PresentationLayer.GUI.Delivery.ShowDelivery.ShowDeliveryModel;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Objects;

public class ShowAllDeliveriesView extends JFrame {

    ShowAllDeliveriesModel showAllDeliveriesModel;

    JLabel userInputErrorLabel;
    JButton backButton;
    JButton infoButton;
    JButton refreshButton;
    JTable deliveriesTable;
    JScrollPane tablePane;
    JComboBox<Object> userInputComboBox;

    public ShowAllDeliveriesView(ShowAllDeliveriesModel showAllDeliveriesModel, HashMap<Integer, ShowDeliveryModel> deliveries) {
        this.showAllDeliveriesModel = showAllDeliveriesModel;
        this.setTitle("Show all deliveries");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(121, 198, 252));

        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/PresentationLayer/GUI/Images/shopping-cart-icon-illustration-free-vector.jpg"))); //avoidIt
        this.setIconImage(imageIcon.getImage());

        JLabel mainTitleLabel = new JLabel();
        mainTitleLabel.setText("All delivery orders");
        mainTitleLabel.setVerticalAlignment(1);
        mainTitleLabel.setHorizontalAlignment(0);
        mainTitleLabel.setBounds(125, 0, 350, 200);
        mainTitleLabel.setFont(new Font("Sans_serif", Font.PLAIN, 18));

        this.backButton = new JButton();
        this.backButton.setText("Back");
        this.backButton.setFocusable(false);
        this.backButton.setBounds(100, 275, 200, 50);
        this.backButton.setBackground(new Color(255, 154, 162));

        this.infoButton = new JButton();
        this.infoButton.setText("Show more information");
        this.infoButton.setFocusable(false);
        this.infoButton.setBounds(205, 225, 200, 25);

        this.refreshButton = new JButton();
        this.refreshButton.setText("Refresh");
        this.refreshButton.setFocusable(false);
        this.refreshButton.setBounds(300, 275, 200, 50);

        this.userInputErrorLabel = new JLabel();
        this.userInputErrorLabel.setVerticalAlignment(1);
        this.userInputErrorLabel.setHorizontalAlignment(2);
        this.userInputErrorLabel.setFont(new Font("serif", Font.PLAIN, 12));
        this.userInputErrorLabel.setForeground(Color.RED);
        this.userInputErrorLabel.setBounds(410, 225, 150, 50);
        this.userInputErrorLabel.setText("You must choose an option");
        this.userInputErrorLabel.setVisible(false);

        this.deliveriesTable = new JTable();
        this.deliveriesTable.setModel(showAllDeliveriesModel);
        this.deliveriesTable.setDefaultEditor(Object.class, null);
        this.deliveriesTable.getTableHeader().setReorderingAllowed(false);
        this.deliveriesTable.setBounds(50, 50, 500, 200);
        this.deliveriesTable.setRowSelectionAllowed(false);
        this.deliveriesTable.setColumnSelectionAllowed(false);
        this.deliveriesTable.setCellSelectionEnabled(false);
        this.deliveriesTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        this.tablePane = new JScrollPane(this.deliveriesTable);
        this.tablePane.setBounds(50, 50, 500, 125);
        this.tablePane.setVisible(true);
        this.tablePane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.tablePane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.userInputComboBox = new JComboBox<>();
        userInputComboBox.setBounds(100, 225, 100, 25);
        userInputComboBox.addItem("-");
        for (Integer i : deliveries.keySet())
            userInputComboBox.addItem(i);

        this.add(mainTitleLabel);
        this.add(this.userInputErrorLabel);
        this.add(this.backButton);
        this.add(this.refreshButton);
        this.add(this.infoButton);
        this.add(this.tablePane);
        this.add(this.userInputComboBox);
    }
}
