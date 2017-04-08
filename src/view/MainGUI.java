package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import model.Trip;
import model.SearchModel;
import controller.Admin;
import controller.BookingController;
import controller.SearchController;
import model.BookingModel;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

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
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Label;
import java.awt.Font;
import java.awt.Scrollbar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextArea;

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
	private JPanel panelBook;
	private JTextField tfSearch;
	private Trip currentTrip;
	private JTextField tfUsername;
	private JTextField tfPw;
	private JTextField tfBiginDate;
	private JTextField tfPrice;
	private JTextField tfTripName;
	private JTextField tfLocation;
	private JTextField tfMinP;
	private JTextField tfEndDate;
	private JTextField tfMaxP;


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
	 * @throws ParseException 
	 */
	public MainGUI() throws ParseException {
		setMinimumSize(new Dimension(1000, 700));
		setSize(new Dimension(500, 1000));
		setMaximumSize(new Dimension(100000, 650000));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(500, 300));
		contentPane.setMaximumSize(new Dimension(1000, 1500));
		contentPane.setName("Day trips");
		contentPane.setSize(new Dimension(1000, 1500));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTrip = new JPanel();
		panelTrip.setName("Day Trips");
		panelTrip.setBounds(38, 26, 424, 226);
		contentPane.add(panelTrip);
		panelTrip.setLayout(null);
		panelTrip.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("Trip");
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_1.setBounds(195, 6, 34, 16);
		panelTrip.add(lblNewLabel_1);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setBounds(38, 26, 424, 226);
		contentPane.add(panelSearch);
		panelSearch.setLayout(null);
		panelSearch.setVisible(false);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setBounds(191, 30, 41, 16);
		panelSearch.add(lblSearch);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(4, 82, 415, 31);
		panelSearch.add(tfSearch);
		tfSearch.setColumns(10);
		
		JPanel panelAdmin = new JPanel();
		panelAdmin.setBounds(38, 26, 424, 226);
		contentPane.add(panelAdmin);
		panelAdmin.setLayout(null);
		panelAdmin.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Log in:");
		lblNewLabel.setBounds(189, 6, 61, 16);
		panelAdmin.add(lblNewLabel);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(180, 58, 200, 26);
		tfUsername.setText("");
		panelAdmin.add(tfUsername);
		tfUsername.setColumns(10);
		
		tfPw = new JTextField();
		tfPw.setBounds(180, 106, 200, 26);
		panelAdmin.add(tfPw);
		tfPw.setText("");
		tfPw.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(44, 58, 92, 26);
		panelAdmin.add(lblUsername);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setBounds(44, 106, 92, 26);
		panelAdmin.add(lblNewLabel_2);
		

		
		JPanel panelAddTrip = new JPanel();
		panelAddTrip.setBounds(38, 26, 424, 606);
		contentPane.add(panelAddTrip);
		panelAddTrip.setLayout(null);
		
		tfLocation = new JTextField();
		tfLocation.setBounds(250, 200, 130, 26);
		tfLocation.setColumns(10);
		panelAddTrip.add(tfLocation);
		
		tfMinP = new JTextField();
		tfMinP.setBounds(250, 170, 130, 26);
		tfMinP.setColumns(10);
		panelAddTrip.add(tfMinP);
		
		tfMaxP = new JTextField();
		tfMaxP.setColumns(10);
		tfMaxP.setBounds(250, 140, 130, 26);
		panelAddTrip.add(tfMaxP);
		
		tfPrice = new JTextField();
		tfPrice.setBounds(250, 110, 130, 26);
		tfPrice.setColumns(10);
		panelAddTrip.add(tfPrice);
		
		MaskFormatter mf1 = new MaskFormatter("####-##-##");
		mf1.setPlaceholderCharacter(' ');
	    JFormattedTextField tfEndDate = new JFormattedTextField(mf1);
		tfEndDate.setBounds(250, 80, 130, 26);
		tfEndDate.setColumns(10);
		panelAddTrip.add(tfEndDate);
							
	    JFormattedTextField tfBeginDate = new JFormattedTextField(mf1);
		tfBeginDate.setBounds(250, 50, 130, 26);
		panelAddTrip.add(tfBeginDate);
		tfBeginDate.setColumns(10);
		
		tfTripName = new JTextField();
		tfTripName.setBounds(250, 20, 130, 26);
		tfTripName.setColumns(10);
		panelAddTrip.add(tfTripName);
		
		JLabel lblTripName = new JLabel("Trip name:");
		lblTripName.setBounds(150, 30, 61, 16);
		panelAddTrip.add(lblTripName);
		
		JLabel lblBegining = new JLabel("Begining date");
		lblBegining.setBounds(150, 60, 61, 16);
		panelAddTrip.add(lblBegining);
		
		JLabel lblEndDate = new JLabel("End date:");
		lblEndDate.setBounds(150, 90, 61, 16);
		panelAddTrip.add(lblEndDate);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(50, 230, 82, 16);
		panelAddTrip.add(lblDescription);
		
		JTextArea taDescriptopn = new JTextArea();
		taDescriptopn.setBounds(26, 253, 379, 223);
		panelAddTrip.add(taDescriptopn);
		JTextArea taDescription = new JTextArea();
		taDescription.setBounds(26, 253, 379, 223);
		panelAddTrip.add(taDescription);
		
		JLabel lblMaxPeople = new JLabel("Max people:");
		lblMaxPeople.setBounds(150, 140, 61, 16);
		panelAddTrip.add(lblMaxPeople);
		
		JLabel lblMinPeople = new JLabel("Min people:");
		lblMinPeople.setBounds(150, 170, 61, 16);
		panelAddTrip.add(lblMinPeople);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setBounds(150, 200, 61, 16);
		panelAddTrip.add(lblLocation);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(150, 110, 61, 16);
		panelAddTrip.add(lblPrice);
		
		JButton btnAddTrip = new JButton("Add trip");
		btnAddTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Trip trip = new Trip(tfTripName.getText(), Date.valueOf(tfBeginDate.getText()), Date.valueOf(tfEndDate.getText()), taDescription.getText(), Integer.parseInt(tfMaxP.getText()), Integer.parseInt(tfMinP.getText()), tfLocation.getText(), Integer.parseInt(tfPrice.getText()), -1, 0 );
				Admin.addTrip(trip);
			}
		});
		btnAddTrip.setBounds(153, 500, 117, 29);
		panelAddTrip.add(btnAddTrip);
		panelAddTrip.setVisible(false);
		
		JButton btnLogin = new JButton("Log in");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = tfUsername.getText();
				String password = tfPw.getText();
				Admin.logIn(username, password);

				panelTrip.setVisible(false);
				panelAdmin.setVisible(false);
				panelSearch.setVisible(false);
				panelBook.setVisible(false);
				panelAddTrip.setVisible(true);
			}
		});

		
		btnLogin.setBounds(128, 183, 168, 37);
		panelAdmin.add(btnLogin);
		
		JButton btnSearshTrip = new JButton("SearchTrip");
		btnSearshTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTrip.setVisible(true);
				panelAdmin.setVisible(false);
				panelSearch.setVisible(false);
				panelBook.setVisible(false);
				panelAddTrip.setVisible(false);
				
			}
		});
		btnSearshTrip.setBounds(153, 149, 117, 29);
		panelSearch.add(btnSearshTrip);
		
		
		
		panelBook = new JPanel();
		panelBook.setBounds(38, 26, 424, 226);
		contentPane.add(panelBook);
		panelBook.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lableBookYourTrip = new JLabel("Book your trip:");
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
		
		JLabel lable_6 = new JLabel("");
		panelBook.add(lable_6);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTrip.setVisible(false);
				panelAdmin.setVisible(false);
				panelSearch.setVisible(false);
				panelBook.setVisible(false);
				panelAddTrip.setVisible(false);
				int tripnr = currentTrip.getTripId();
				String tripString = "" + tripnr;
				String[] searchP = {tripString, tfEmail.getText(), tfNrOfP.getText(), tfSSN.getText()};
				BookingController.bookTrip(searchP);
			}
		});
		panelBook.add(btnSubmit);
		panelBook.setVisible(false);
		
		// Create new list of trips
		JList tripsList = new JList();
		tripsList.setBounds(376, 62, -334, 113);
		panelTrip.add(tripsList);
		
		// Search for the trip's info
		String searchParam[] = {"", "", "", "", ""};
		Trip tripList[] = SearchController.findResults(searchParam);
		
		JButton[] buttons = new JButton[tripList.length];
		for (int i = 0; i < tripList.length; i++) {
			// Show trips
			Label labelTripInfo = new Label(tripList[i].getTripName());
			labelTripInfo.setFont(new Font("Dialog", Font.BOLD, 14));
			labelTripInfo.setBounds(48, 42 + i*200, 350, 16);
			panelTrip.add(labelTripInfo);
			
			// Show date
			Label labelDateInfo = new Label("From " + (String) tripList[i].getDateBegin().toString() + " until " + (String) tripList[i].getDateEnd().toString());
			labelDateInfo.setBounds(48, 92 + i*200, 350, 16);
			panelTrip.add(labelDateInfo);
			
			// Show price
			Label labelPriceInfo = new Label(Integer.toString(tripList[i].getPrice()) + " ISK");
			labelPriceInfo.setBounds(48, 159 + i*200, 350, 16);
			panelTrip.add(labelPriceInfo);
			
			// Show location
			Label labelLocationInfo = new Label((String) tripList[i].getLocation().toString());
			labelLocationInfo.setBounds(48, 126 + i*200, 350, 16);
			panelTrip.add(labelLocationInfo);
			
			int j = i;
			buttons[i] = new JButton("Book trip");
			// JButton btnBookTrip = new JButton("Book trip");
			buttons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelTrip.setVisible(false);
					panelAdmin.setVisible(false);
					panelSearch.setVisible(false);
					panelBook.setVisible(true);
					labelTripInfo.setVisible(false);
					labelDateInfo.setVisible(false);
					labelPriceInfo.setVisible(false);
					labelLocationInfo.setVisible(false);
					panelAddTrip.setVisible(false);
					tfTrip.setText(tripList[j].getTripName());
					currentTrip = tripList[j];
				}
			});
			buttons[i].setBounds(153, 191, 117, 29);
			panelTrip.add(buttons[i]);
			
		}
		
				JToolBar toolBar = new JToolBar();
				toolBar.setFloatable(false);
				toolBar.setBounds(38, 0, 424, 26);
				contentPane.add(toolBar);
				
						Button btnTbAdmin = new Button("Admin");
						btnTbAdmin.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								panelTrip.setVisible(false);
								panelAdmin.setVisible(true);
								panelSearch.setVisible(false);
								panelBook.setVisible(false);
								panelAddTrip.setVisible(false);
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
										panelAddTrip.setVisible(false);
										
									}
								});
								toolBar.add(btnTbTrips);
								
										Button btnTbSearch = new Button("Search");
										btnTbSearch.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												panelTrip.setVisible(false);
												panelAdmin.setVisible(false);
												panelSearch.setVisible(true);
												panelBook.setVisible(false);
												panelAddTrip.setVisible(false);
											}
										});
										toolBar.add(btnTbSearch);
										
																			
	}
}