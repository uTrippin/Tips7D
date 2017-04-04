package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Trip;
import model.SearchModel;
import controller.Admin;
import model.BookingModel;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToolBar;
import java.awt.Button;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import java.awt.TextField;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import javax.swing.JList;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private Trip tripList;
	private SearchModel search;
	private Admin adminConnection;
	private BookingModel booker;
	private String tripName;
	private Date dateBegin;
	private Date dateEnd;
	private String location;
	private int price;
	private JTextField tfEmail;
	private JTextField tfSSN;
	private JTextField tfNrOfP;
	private JTextField tfTrip;



	public void showTrips(){

	}

	public void callSearch(){

	}

	public void callBooking(){

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTrip = new JPanel();
		panelTrip.setBounds(5, 30, 424, 226);
		contentPane.add(panelTrip);
		panelTrip.setLayout(null);
		panelTrip.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("Trip");
		lblNewLabel_1.setBounds(189, 6, 61, 16);
		panelTrip.add(lblNewLabel_1);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setBounds(5, 30, 424, 226);
		contentPane.add(panelSearch);
		panelSearch.setLayout(null);
		panelSearch.setVisible(false);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setBounds(189, 6, 41, 16);
		panelSearch.add(lblSearch);
		
		JPanel panelAdmin = new JPanel();
		panelAdmin.setBounds(5, 30, 424, 226);
		contentPane.add(panelAdmin);
		panelAdmin.setLayout(null);
		panelAdmin.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Admin");
		lblNewLabel.setBounds(189, 6, 61, 16);
		panelAdmin.add(lblNewLabel);
		
		JPanel panelBook = new JPanel();
		panelBook.setBounds(5, 30, 424, 226);
		contentPane.add(panelBook);
		panelBook.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lableBookYourTrip = new JLabel("Book your tirp:");
		panelBook.add(lableBookYourTrip);
		
		JLabel label = new JLabel("");
		panelBook.add(label);
		
		JLabel label_1 = new JLabel("");
		panelBook.add(label_1);
		
		JLabel label_2 = new JLabel("");
		panelBook.add(label_2);
		
		JLabel lableSSN = new JLabel("SSN:");
		panelBook.add(lableSSN);
		
		tfSSN = new JTextField();
		panelBook.add(tfSSN);
		tfSSN.setColumns(10);
		
		JLabel label_3 = new JLabel("");
		panelBook.add(label_3);
		
		JLabel lableEmail = new JLabel("E-mail:");
		panelBook.add(lableEmail);
		
		tfEmail = new JTextField();
		panelBook.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel label_4 = new JLabel("");
		panelBook.add(label_4);
		
		JLabel LableNrOfP = new JLabel("Nr. of people");
		panelBook.add(LableNrOfP);
		
		tfNrOfP = new JTextField();
		panelBook.add(tfNrOfP);
		tfNrOfP.setColumns(10);
		
		JLabel label_5 = new JLabel("");
		panelBook.add(label_5);
		
		JLabel labelTrip = new JLabel("Trip");
		panelBook.add(labelTrip);
		
		tfTrip = new JTextField();
		tfTrip.setEnabled(false);
		panelBook.add(tfTrip);
		tfTrip.setColumns(10);
		panelBook.setVisible(false);

		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(5, 5, 424, 25);
		contentPane.add(toolBar);

		Button btnTbAdmin = new Button("Admin");
		btnTbAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTrip.setVisible(false);
				panelAdmin.setVisible(true);
				panelSearch.setVisible(false);
				panelBook.setVisible(false);
			}
		});
		toolBar.add(btnTbAdmin);

		Button btnTbTrips = new Button("Trip");
		btnTbTrips.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTrip.setVisible(true);
				panelAdmin.setVisible(false);
				panelSearch.setVisible(false);
				panelBook.setVisible(false);
			}
		});
		toolBar.add(btnTbTrips);
		
		JButton btnBookTrip = new JButton("Book trip");
		btnBookTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTrip.setVisible(false);
				panelAdmin.setVisible(false);
				panelSearch.setVisible(false);
				panelBook.setVisible(false);
				panelBook.setVisible(true);
			}
		});
		btnBookTrip.setBounds(147, 92, 117, 29);
		panelTrip.add(btnBookTrip);
	

		Button btnTbSearch = new Button("Search");
		btnTbSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTrip.setVisible(false);
				panelAdmin.setVisible(false);
				panelSearch.setVisible(true);
				panelBook.setVisible(false);
			}
		});
		toolBar.add(btnTbSearch);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		contentPane.add(panel);
	}
}
