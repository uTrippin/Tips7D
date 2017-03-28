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
	private JTextField tfNrOfPeople;
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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);

		Button btnTbAdmin = new Button("Admin");
		btnTbAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pSearch.setVisible(false);
				pTrip.setVisible(false);
			}
		});

		Button btnTbTrips = new Button("Trip");
		btnTbTrips.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pTrip.setVisible(true);
				pSearch.setVisible(false);
			}
		});
		toolBar.add(btnTbTrips);
		toolBar.add(btnTbAdmin);

		Button btnTbSearch = new Button("Search");
		btnTbSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pTrip.setVisible(false);
				pSearch.setVisible(true);

			}
		});
		toolBar.add(btnTbSearch);

		JPanel pBook = new JPanel();
		contentPane.add(pBook, BorderLayout.CENTER);
		GridBagLayout gbl_pBook = new GridBagLayout();
		gbl_pBook.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pBook.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pBook.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pBook.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pBook.setLayout(gbl_pBook);

		JLabel lBookYourTrip = new JLabel("Book your trip");
		GridBagConstraints gbc_lBookYourTrip = new GridBagConstraints();
		gbc_lBookYourTrip.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lBookYourTrip.insets = new Insets(0, 0, 5, 5);
		gbc_lBookYourTrip.gridx = 1;
		gbc_lBookYourTrip.gridy = 0;
		pBook.add(lBookYourTrip, gbc_lBookYourTrip);

		JLabel lSSN = new JLabel("SSN:");
		GridBagConstraints gbc_lSSN = new GridBagConstraints();
		gbc_lSSN.insets = new Insets(0, 0, 5, 5);
		gbc_lSSN.anchor = GridBagConstraints.EAST;
		gbc_lSSN.gridx = 1;
		gbc_lSSN.gridy = 1;
		pBook.add(lSSN, gbc_lSSN);

		tfSSN = new JTextField();
		GridBagConstraints gbc_tfSSN = new GridBagConstraints();
		gbc_tfSSN.insets = new Insets(0, 0, 5, 0);
		gbc_tfSSN.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSSN.gridx = 2;
		gbc_tfSSN.gridy = 1;
		pBook.add(tfSSN, gbc_tfSSN);
		tfSSN.setColumns(10);

		JLabel lEmail = new JLabel("E-mail:");
		GridBagConstraints gbc_lEmail = new GridBagConstraints();
		gbc_lEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lEmail.anchor = GridBagConstraints.EAST;
		gbc_lEmail.gridx = 1;
		gbc_lEmail.gridy = 2;
		pBook.add(lEmail, gbc_lEmail);

		tfEmail = new JTextField();
		GridBagConstraints gbc_tfEmail = new GridBagConstraints();
		gbc_tfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_tfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfEmail.gridx = 2;
		gbc_tfEmail.gridy = 2;
		pBook.add(tfEmail, gbc_tfEmail);
		tfEmail.setColumns(10);

		JButton btnBook = new JButton("Book!");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JLabel lNrOfPeople = new JLabel("Nr. of people:");
		GridBagConstraints gbc_lNrOfPeople = new GridBagConstraints();
		gbc_lNrOfPeople.insets = new Insets(0, 0, 5, 5);
		gbc_lNrOfPeople.anchor = GridBagConstraints.EAST;
		gbc_lNrOfPeople.gridx = 1;
		gbc_lNrOfPeople.gridy = 3;
		pBook.add(lNrOfPeople, gbc_lNrOfPeople);

		tfNrOfPeople = new JTextField();
		GridBagConstraints gbc_tfNrOfPeople = new GridBagConstraints();
		gbc_tfNrOfPeople.insets = new Insets(0, 0, 5, 0);
		gbc_tfNrOfPeople.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNrOfPeople.gridx = 2;
		gbc_tfNrOfPeople.gridy = 3;
		pBook.add(tfNrOfPeople, gbc_tfNrOfPeople);
		tfNrOfPeople.setColumns(10);

		JLabel lblFer = new JLabel("Trip:");
		GridBagConstraints gbc_lblFer = new GridBagConstraints();
		gbc_lblFer.insets = new Insets(0, 0, 5, 5);
		gbc_lblFer.anchor = GridBagConstraints.EAST;
		gbc_lblFer.gridx = 1;
		gbc_lblFer.gridy = 4;
		pBook.add(lblFer, gbc_lblFer);

		tfTrip = new JTextField();
		GridBagConstraints gbc_tfTrip = new GridBagConstraints();
		gbc_tfTrip.insets = new Insets(0, 0, 5, 0);
		gbc_tfTrip.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTrip.gridx = 2;
		gbc_tfTrip.gridy = 4;
		pBook.add(tfTrip, gbc_tfTrip);
		tfTrip.setColumns(10);
		GridBagConstraints gbc_btnBook = new GridBagConstraints();
		gbc_btnBook.insets = new Insets(0, 0, 5, 0);
		gbc_btnBook.anchor = GridBagConstraints.EAST;
		gbc_btnBook.gridx = 2;
		gbc_btnBook.gridy = 5;
		pBook.add(btnBook, gbc_btnBook);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new CardLayout(0, 0));

		JList list = new JList();
		panel.add(list, "name_257112016322875");
	}
}
