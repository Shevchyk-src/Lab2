package Interface;

import dto.Product;
import utils.DateBase;

import javax.swing.*;
import java.awt.*;

/** Frame to work with database */
public class DataWindow extends JFrame {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    /** DateBase field for this frame to work with */
    private DateBase db;

    /** Visual components */
    private JTextField searchField;
    private JPanel infoPanel;
    private JList<Product> productList;
    private JList<String> groupList;
    private JScrollPane productScroll;
    private JScrollPane groupScroll;
    private JTextArea infoTextArea;
    private JPanel buttonPanel;
    private JButton addButton;
    private JButton removeButton;

    private JMenuBar menuBar;

    /** Constructor with DateBase param */
    //public DataWindow(DateBase db){
        public DataWindow(){
      //  this.db = db;
        setTitle("DataBase");
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setResizable(false);
        init();
        BorderLayout layout = new BorderLayout();
        layout.setVgap(5);
        setLayout(layout);
        add(searchField, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

    }

    /** Initialization of visual components */
    private void init(){
        if(searchField == null){
            searchField = new JTextField("Search");
            searchField.setPreferredSize(new Dimension(7*WIDTH/8, HEIGHT/8));
            searchField.setSize(new Dimension(7*WIDTH/8, HEIGHT/8));
            searchField.setFont(new Font("Calibri", Font.PLAIN, 20));
        }
        if(infoTextArea == null){
            infoTextArea = new JTextArea("");
            infoTextArea.setPreferredSize(new Dimension(7*WIDTH/24, 6*HEIGHT/8));
            infoTextArea.setEditable(false);
        }
        if(productList == null){
            productList = new JList<>();
            //productList.setPreferredSize(new Dimension(7*WIDTH/24, 5*HEIGHT/8));
            productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        }
        if(productScroll == null){
            productScroll = new JScrollPane(productList);
            productScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            productScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        }
        if(groupList == null){
            groupList = new JList<>();
         //   groupList.setPreferredSize(new Dimension(7*WIDTH/24, 5*HEIGHT/8));
            groupList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        }
        if(groupScroll == null){
            groupScroll = new JScrollPane(groupList);
            groupScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            groupScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        }
        if(infoPanel == null){
            infoPanel = new JPanel();
            GridLayout layout = new GridLayout(1, 3);
            layout.setHgap(5);
            layout.setVgap(10);
            infoPanel.setLayout(layout);
            infoPanel.add(groupScroll);
            infoPanel.add(productScroll);
            infoPanel.add(infoTextArea);
        }
        if(addButton == null){
            addButton = new JButton("Add");
            addButton.setPreferredSize(new Dimension(WIDTH/5, HEIGHT/ 10));

        }
        if(removeButton == null){
            removeButton = new JButton("Remove");
            removeButton.setPreferredSize(new Dimension(WIDTH/5, HEIGHT/ 10));

        }
        if(buttonPanel == null){
            buttonPanel = new JPanel(new GridLayout(1, 2));
            JPanel temp = new JPanel();
            temp.setLayout(new FlowLayout(FlowLayout.RIGHT));
            temp.add(addButton);
            buttonPanel.add(temp);
            temp = new JPanel();
            temp.setLayout(new FlowLayout(FlowLayout.LEFT));
            temp.add(removeButton);
            buttonPanel.add(temp);
        }
    }


    public static void main(String[] args){
        DataWindow ui = new DataWindow();
        ui.setVisible(true);
    }
}