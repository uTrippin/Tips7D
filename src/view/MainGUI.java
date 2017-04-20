package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import model.Trip;
import controller.Admin;
import controller.BookingController;
import controller.SearchController;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;

import java.awt.Button;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Rectangle;
import java.awt.ScrollPane;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfEmail;
	private JTextField tfSSN;
	private JTextField tfNrOfP;
	private Label tfTrip;
	private JPanel panelBook;
	private Trip currentTrip;
	private JTextField tfUsername;
	private JTextField tfPrice;
	private JTextField tfTripName;
	private JTextField tfLocation;
	private JTextField tfMinP;
	private JTextField tfMaxP;

	private static int start = 0;
	private int searchCount = 0;
	private JTextField tfTripNameSearch;
	private JTextField tfLocationSearch;
	private JTextField tfPriceSearch;
	private Trip[] tripSearchList;
	private Trip[] tripList;

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
		setMinimumSize(new Dimension(515, 740));
		setSize(new Dimension(523, 700));
		setMaximumSize(new Dimension(100000, 650000));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(500, 310));
		contentPane.setMaximumSize(new Dimension(1000, 1500));
		contentPane.setName("Day trips");
		contentPane.setSize(new Dimension(1000, 1500));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelTrip = new JPanel();
		panelTrip.setName("Day Trips");
		panelTrip.setBounds(38, 36, 424, 646);
		contentPane.add(panelTrip);
		panelTrip.setLayout(null);
		panelTrip.setVisible(false);

		JPanel panelSearch = new JPanel();
		panelSearch.setBounds(38, 36, 424, 646);
		contentPane.add(panelSearch);
		panelSearch.setLayout(null);

		JLabel lblTripNameSearch = new JLabel("Trip name:");
		lblTripNameSearch.setBounds(10, 37, 120, 26);
		panelSearch.add(lblTripNameSearch);

		tfTripNameSearch = new JTextField();
		tfTripNameSearch.setBounds(139, 37, 250, 26);
		panelSearch.add(tfTripNameSearch);
		tfTripNameSearch.setColumns(10);

		JLabel lbdateBegin = new JLabel("Date begin");
		lbdateBegin.setBounds(10, 67, 120, 26);
		panelSearch.add(lbdateBegin);

		MaskFormatter mf0 = new MaskFormatter("####-##-##");
		mf0.setPlaceholderCharacter(' ');

		JFormattedTextField tfdateBeginSearch = new JFormattedTextField(mf0);
		tfdateBeginSearch.setBounds(139, 67, 250, 26);
		panelSearch.add(tfdateBeginSearch);
		tfdateBeginSearch.setColumns(10);

		JLabel lbdateEnd = new JLabel("Date End");
		lbdateEnd.setBounds(10, 97, 120, 26);
		panelSearch.add(lbdateEnd);

		JFormattedTextField tfdateEndSearch = new JFormattedTextField(mf0);
		tfdateEndSearch.setBounds(139, 97, 250, 26);
		panelSearch.add(tfdateEndSearch);
		tfdateEndSearch.setColumns(10);

		JLabel lblocationSearch = new JLabel("Location");
		lblocationSearch.setBounds(10, 127, 120, 26);
		panelSearch.add(lblocationSearch);

		tfLocationSearch = new JTextField();
		tfLocationSearch.setBounds(139, 127, 250, 26);
		panelSearch.add(tfLocationSearch);
		tfLocationSearch.setColumns(10);

		JLabel lbPriceSearch = new JLabel("Price");
		lbPriceSearch.setBounds(10, 157, 120, 26);
		panelSearch.add(lbPriceSearch);

		tfPriceSearch = new JTextField();
		tfPriceSearch.setBounds(139, 157, 250, 26);
		panelSearch.add(tfPriceSearch);
		tfPriceSearch.setColumns(10);

		JButton btnSearchTrip = new JButton("Search Trip");
		btnSearchTrip.setBounds(150, 200, 117, 29);
		panelSearch.add(btnSearchTrip);

		JLabel lbCounterResult = new JLabel("");
		lbCounterResult.setBounds(10, 240, 424, 14);
		panelSearch.add(lbCounterResult);

		// Trip
		JLabel lbTripR = new JLabel("Trip:");
		lbTripR.setBounds(10, 260, 75, 16);
		
		Label lbTripNameResult = new Label("");
		lbTripNameResult.setBounds(150, 260, 424, 14);
		panelSearch.add(lbTripNameResult);
		
		// Date	
		Label lbDateToR = new Label("Date:");
		lbDateToR.setBounds(10, 290, 50, 16);
		lbDateToR.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		Label lbDateToResult = new Label("");
		lbDateToResult.setBounds(150, 290, 75, 16);
		panelSearch.add(lbDateToResult);

		Label lbDateTo = new Label(" to ");
		lbDateTo.setBounds(225, 290, 20, 16);
		lbDateTo.setFont(new Font("Tahoma", Font.BOLD, 12));

		Label lbDateFromResult = new Label("");
		lbDateFromResult.setBounds(250, 290, 75, 16);
		panelSearch.add(lbDateFromResult);

		// Location
		Label lbLocationR = new Label("Location:");
		lbLocationR.setBounds(10, 320, 100, 16);
		lbLocationR.setFont(new Font("Tahoma", Font.BOLD, 12));

		Label lbLocationResult = new Label("");
		lbLocationResult.setBounds(150, 320, 75, 16);
		panelSearch.add(lbLocationResult);

		// Price
		Label lbPriceR = new Label("Price:");
		lbPriceR.setBounds(10, 350, 100, 16);
		lbPriceR.setFont(new Font("Tahoma", Font.BOLD, 12));

		Label lbPriceResult = new Label("");
		lbPriceResult.setBounds(150, 350, 75, 16);
		panelSearch.add(lbPriceResult);
		
		// Description
		Label lbDescriptionR = new Label("Description:");
		lbDescriptionR.setBounds(10, 380, 100, 16);
		lbDescriptionR.setFont(new Font("Tahoma", Font.BOLD, 12));

		JTextArea lbDescriptionResult = new JTextArea("");
		lbDescriptionResult.setBounds(150, 380, 250, 200);
		lbDescriptionResult.setWrapStyleWord(true);
		lbDescriptionResult.setLineWrap(true);
		lbDescriptionResult.setOpaque(false);
		lbDescriptionResult.setEditable(false);
		lbDescriptionResult.setFocusable(false);

		btnSearchTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelSearch.add(lbTripR);
				panelSearch.add(lbDateToR);
				panelSearch.add(lbDateTo);
				panelSearch.add(lbPriceR);
				panelSearch.add(lbLocationR);
				panelSearch.add(lbDescriptionR);

				searchCount = 0;
				String tripName = tfTripNameSearch.getText();
				String location = tfLocationSearch.getText();
				String beginDate =tfdateBeginSearch.getText();
				String endDate = tfdateEndSearch.getText();
				String price = tfPriceSearch.getText();
				String[] searchParam = {tripName, beginDate, endDate, location, price};
				try {
					tripSearchList = SearchController.findResults(searchParam);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lbCounterResult.setText("Result nr. " + 1 + " of " + tripSearchList.length);
				lbTripNameResult.setText(tripSearchList[0].getTripName());
				lbDateToResult.setText("" + tripSearchList[0].getDateBegin());
				lbDateFromResult.setText("" + tripSearchList[0].getDateEnd());
				lbLocationResult.setText(tripSearchList[0].getLocation());
				lbPriceResult.setText("" + tripSearchList[0].getPrice() + " ISK");
				lbDescriptionResult.setText("" + tripSearchList[0].getDescription());
				panelSearch.add(lbDescriptionResult);
				
				JButton book = new JButton("Book trip");
				book.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panelTrip.setVisible(false);
						panelSearch.setVisible(false);
						panelBook.setVisible(true);
						tfTrip.setText(tripSearchList[0].getTripName());
						currentTrip = tripSearchList[0];
					}
				});
				book.setBounds(10, 410, 100, 29);
				panelSearch.add(book);
				
				if(tripSearchList.length > 1){
					Button buttonNext = new Button("Next trip");
					buttonNext.setBounds(306, 620, 88, 22);
					panelSearch.add(buttonNext);
					buttonNext.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							searchCount++;
							int c = searchCount % tripSearchList.length;
							lbCounterResult.setText("Result nr. " + (c+1) + " of " + tripSearchList.length);
							lbTripNameResult.setText(tripSearchList[c].getTripName());
							lbDateToResult.setText("" + tripSearchList[c].getDateBegin());
							lbDateFromResult.setText("" + tripSearchList[c].getDateEnd());
							lbLocationResult.setText(tripSearchList[c].getLocation());
							lbPriceResult.setText("" + tripSearchList[c].getPrice() + " ISK");
							lbDescriptionResult.setText("" + tripSearchList[c].getDescription());
							
							JButton book1 = new JButton("Book trip");
							book1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									panelTrip.setVisible(false);
									panelSearch.setVisible(false);
									panelBook.setVisible(true);
									tfTrip.setText(tripSearchList[searchCount].getTripName());
									currentTrip = tripSearchList[searchCount];
								}
							});
							book1.setBounds(10, 410, 100, 29);
							panelSearch.add(book1);
						}
					});

					Button buttonPrev = new Button("Previous trip");
					buttonPrev.setBounds(28, 620, 88, 22);
					panelSearch.add(buttonPrev);
					buttonPrev.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							searchCount--;
							if(searchCount < 0) searchCount = tripSearchList.length-1;
							int c = searchCount % tripSearchList.length;
							lbCounterResult.setText("Result nr. " + (c+1) + " of " + tripSearchList.length);
							lbTripNameResult.setText(tripSearchList[c].getTripName());
							lbDateToResult.setText("" + tripSearchList[c].getDateBegin());
							lbDateFromResult.setText("" + tripSearchList[c].getDateEnd());
							lbLocationResult.setText(tripSearchList[c].getLocation());
							lbPriceResult.setText("" + tripSearchList[c].getPrice() + " ISK");
							lbDescriptionResult.setText("" + tripSearchList[c].getDescription());
							
							JButton book1 = new JButton("Book trip");
							book1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									panelTrip.setVisible(false);
									panelSearch.setVisible(false);
									panelBook.setVisible(true);
									tfTrip.setText(tripSearchList[searchCount].getTripName());
									currentTrip = tripSearchList[searchCount];
								}
							});
							book1.setBounds(10, 410, 100, 29);
							panelSearch.add(book1);
						}
					});
					
					
				}


			}
		});



		JPanel panelAdmin = new JPanel();
		panelAdmin.setBounds(38, 36, 424, 646);
		contentPane.add(panelAdmin);
		panelAdmin.setLayout(null);
		panelAdmin.setVisible(false);

		JLabel lblNewLabel = new JLabel("To add a trip you must log in");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 10, 368, 20);
		panelAdmin.add(lblNewLabel);

		tfUsername = new JTextField();
		tfUsername.setBounds(139, 47, 250, 26);
		tfUsername.setText("");
		panelAdmin.add(tfUsername);
		tfUsername.setColumns(10);

		JPasswordField tfPw = new JPasswordField();
		tfPw.setBounds(139, 77, 250, 26);
		panelAdmin.add(tfPw);
		tfPw.setText("");
		tfPw.setColumns(10);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 47, 120, 26);
		panelAdmin.add(lblUsername);

		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setBounds(10, 77, 120, 26);
		panelAdmin.add(lblNewLabel_2);



		JPanel panelAddTrip = new JPanel();
		panelAddTrip.setBounds(38, 36, 424, 646);
		contentPane.add(panelAddTrip);
		panelAddTrip.setLayout(null);

		tfLocation = new JTextField();
		tfLocation.setBounds(139, 217, 250, 26);
		tfLocation.setColumns(10);
		panelAddTrip.add(tfLocation);

		tfMinP = new JTextField();
		tfMinP.setBounds(139, 187, 250, 26);
		tfMinP.setColumns(10);
		panelAddTrip.add(tfMinP);

		tfMaxP = new JTextField();
		tfMaxP.setColumns(10);
		tfMaxP.setBounds(139, 157, 250, 26);
		panelAddTrip.add(tfMaxP);

		tfPrice = new JTextField();
		tfPrice.setBounds(139, 127, 250, 26);
		tfPrice.setColumns(10);
		panelAddTrip.add(tfPrice);

		MaskFormatter mf1 = new MaskFormatter("####-##-##");
		mf1.setPlaceholderCharacter(' ');
		JFormattedTextField tfEndDate = new JFormattedTextField(mf1);
		tfEndDate.setBounds(139, 97, 250, 26);
		tfEndDate.setColumns(10);
		panelAddTrip.add(tfEndDate);

		JFormattedTextField tfBeginDate = new JFormattedTextField(mf1);
		tfBeginDate.setBounds(139, 67, 250, 26);
		panelAddTrip.add(tfBeginDate);
		tfBeginDate.setColumns(10);

		tfTripName = new JTextField();
		tfTripName.setBounds(139, 37, 250, 26);
		tfTripName.setColumns(10);
		panelAddTrip.add(tfTripName);

		JLabel lblTripName = new JLabel("Trip name:");
		lblTripName.setBounds(10, 37, 120, 26);
		panelAddTrip.add(lblTripName);

		JLabel lblBeginning = new JLabel("Beginning date:");
		lblBeginning.setBounds(10, 67, 120, 26);
		panelAddTrip.add(lblBeginning);

		JLabel lblEndDate = new JLabel("End date:");
		lblEndDate.setBounds(10, 97, 120, 26);
		panelAddTrip.add(lblEndDate);

		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(10, 247, 120, 26);
		panelAddTrip.add(lblDescription);
		
		JTextArea taDescription = new JTextArea();
		taDescription.setLineWrap(true);
		taDescription.setWrapStyleWord(true);			
		JScrollPane scroll = new JScrollPane(taDescription);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setBounds(10, 270, 379, 223);
	    panelAddTrip.add(scroll);

		JLabel lblMaxPeople = new JLabel("Max people:");
		lblMaxPeople.setBounds(10, 157, 120, 26);
		panelAddTrip.add(lblMaxPeople);

		JLabel lblMinPeople = new JLabel("Min people:");
		lblMinPeople.setBounds(10, 187, 120, 26);
		panelAddTrip.add(lblMinPeople);

		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setBounds(10, 217, 120, 26);
		panelAddTrip.add(lblLocation);

		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(10, 127, 150, 26);
		panelAddTrip.add(lblPrice);

		JButton btnAddTrip = new JButton("Add trip");
		btnAddTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Trip trip = new Trip(tfTripName.getText(), Date.valueOf(tfBeginDate.getText()), Date.valueOf(tfEndDate.getText()), taDescription.getText(), Integer.parseInt(tfMaxP.getText()), Integer.parseInt(tfMinP.getText()), tfLocation.getText(), Integer.parseInt(tfPrice.getText()), -1, 0 );
				Admin.addTrip(trip);
								
				JOptionPane.showMessageDialog(panelBook,"Trip added");
				try {
					String searchParam[] = {"", "", "", "", ""};
					tripList = SearchController.findResults(searchParam);
				} catch (ParseException e1) {
					// do nothing
				}
				
				tfTripName.setText("");
				tfBeginDate.setText(""); 
				tfEndDate.setText("");
				taDescription.setText(""); 
				tfMaxP.setText("");
				tfMinP.setText("");
				tfLocation.setText("");
				tfPrice.setText("");
				
				showTrips(panelTrip, panelAdmin, panelSearch, panelAddTrip, tripList);
				panelTrip.setVisible(true);
				panelAddTrip.setVisible(false);

			}
		});
		btnAddTrip.setBounds(137, 517, 117, 29);
		panelAddTrip.add(btnAddTrip);
		panelAddTrip.setVisible(false);

		JButton btnLogin = new JButton("Log in");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = tfUsername.getText();
				String password = tfPw.getText();
				if(Admin.logIn(username, password)){
					panelTrip.setVisible(false);
					panelAdmin.setVisible(false);
					panelSearch.setVisible(false);
					panelBook.setVisible(false);
					panelAddTrip.setVisible(true);
				}
				else{
				}
			}
		});


		btnLogin.setBounds(128, 150, 168, 37);
		panelAdmin.add(btnLogin);



		panelBook = new JPanel();
		panelBook.setBounds(38, 36, 424, 646);
		contentPane.add(panelBook);
		panelBook.setLayout(null);

		JLabel lableBookYourTrip = new JLabel("Please fill out all the fields");
		lableBookYourTrip.setFont(new Font("Tahoma", Font.BOLD, 14));
		lableBookYourTrip.setBounds(new Rectangle(10, 10, 368, 20));
		panelBook.add(lableBookYourTrip);

		JLabel lableSSN = new JLabel("SSN:");
		lableSSN.setBounds(10, 37, 120, 26);
		panelBook.add(lableSSN);

		tfSSN = new JTextField();
		tfSSN.setBounds(139, 37, 250, 26);
		panelBook.add(tfSSN);
		tfSSN.setColumns(10);

		JLabel lableEmail = new JLabel("E-mail:");
		lableEmail.setBounds(10, 67, 120, 26);
		panelBook.add(lableEmail);

		tfEmail = new JTextField();
		tfEmail.setBounds(139, 67, 250, 26);
		panelBook.add(tfEmail);
		tfEmail.setColumns(10);

		JLabel LableNrOfP = new JLabel("Nr. of people");
		LableNrOfP.setBounds(10, 97, 120, 26);
		panelBook.add(LableNrOfP);

		tfNrOfP = new JTextField();
		tfNrOfP.setBounds(139, 97, 250, 26);
		panelBook.add(tfNrOfP);
		tfNrOfP.setColumns(10);

		JLabel labelTrip = new JLabel("Trip");
		labelTrip.setBounds(10, 127, 120, 26);
		panelBook.add(labelTrip);

		tfTrip = new Label();
		tfTrip.setBounds(139, 127, 250, 26);
		panelBook.add(tfTrip);

		JButton btnSubmit = new JButton("Book trip");
		btnSubmit.setBounds(150, 167, 117, 29);
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
				String bookingResult = BookingController.bookTrip(searchP);
				
				JOptionPane.showMessageDialog(panelBook,bookingResult);
				panelTrip.setVisible(true);
			}
		});
		panelBook.add(btnSubmit);
		panelBook.setVisible(false);

		// Create new list of trips
		/*JList tripsList = new JList();
		tripsList.setBounds(376, 30, -334, 114);
		panelTrip.add(tripsList);*/

		// Search for the trip's info
		String searchParam[] = {"", "", "", "", ""};
		tripList = SearchController.findResults(searchParam);

		Button button = new Button("Next page");
		Button button_1 = new Button("Previous page");

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(start < tripList.length - 3) {
					start = start + 3;
				} else {
					start = 0;
				}

				panelTrip.removeAll();
				panelTrip.revalidate();
				panelTrip.add(button);
				panelTrip.add(button_1);
				showTrips(panelTrip, panelAdmin, panelSearch, panelAddTrip, tripList);
			}
		});
		button.setBounds(306, 614, 88, 22);
		panelTrip.add(button);

		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(start < 3) {
					start = tripList.length - tripList.length % 3;
				} else {
					start = start - 3;
				}

				panelTrip.removeAll();
				panelTrip.revalidate();
				panelTrip.add(button);
				panelTrip.add(button_1);
				showTrips(panelTrip, panelAdmin, panelSearch, panelAddTrip, tripList);
			}
		});
		button_1.setBounds(28, 614, 88, 22);
		panelTrip.add(button_1);

		panelTrip.removeAll();
		panelTrip.revalidate();
		panelTrip.add(button);
		panelTrip.add(button_1);
		showTrips(panelTrip, panelAdmin, panelSearch, panelAddTrip, tripList);

		JLabel label_6 = new JLabel("Fill in the search fields or leave them empty");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(10, 10, 368, 20);
		panelSearch.add(label_6);

		JLabel lblNewLabel_1 = new JLabel("Please fill out all the information");
		lblNewLabel_1.setBounds(10, 10, 384, 20);
		panelAddTrip.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblNoteTheBoth = new JLabel("Note: Both begin and end date must be on the format [yyyy-mm-dd]");
		lblNoteTheBoth.setBounds(10, 575, 404, 14);
		panelAddTrip.add(lblNoteTheBoth);
		lblNoteTheBoth.setFont(new Font("Tahoma", Font.ITALIC, 11));

		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(38, 10, 424, 26);
		contentPane.add(toolBar);


		Admin.getIsLoggedIn();

		Button btnTbAdmin = new Button("Admin");
		btnTbAdmin.setFont(new Font("Dialog", Font.BOLD, 12));
		btnTbAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Admin.getIsLoggedIn()){
					panelAddTrip.setVisible(true);
					panelAdmin.setVisible(false);
					panelSearch.setVisible(false);
					panelBook.setVisible(false);
					panelTrip.setVisible(false);
				}
				else{
					panelTrip.setVisible(false);
					panelAdmin.setVisible(true);
					panelSearch.setVisible(false);
					panelBook.setVisible(false);
					panelAddTrip.setVisible(false);
				}
			}
		});
		toolBar.add(btnTbAdmin);

		Button btnTbTrips = new Button("All trips");
		btnTbTrips.setFont(new Font("Dialog", Font.BOLD, 12));
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
		btnTbSearch.setFont(new Font("Dialog", Font.BOLD, 12));
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

	public void showTrips(JPanel panelTrip, JPanel panelAdmin, JPanel panelSearch, JPanel panelAddTrip, Trip[] tripList) {
		JLabel tripNum;
		if(start+3 > tripList.length) {
			tripNum = new JLabel("Trips " + (start+1) + "-" + (start+(tripList.length%3)));
		} else {
			tripNum = new JLabel("Trips " + (start+1) + "-" + (start+3));
		}
		tripNum.setFont(new Font("Tahoma", Font.BOLD, 11));
		tripNum.setBounds(330, 11, 70, 14);
		panelTrip.add(tripNum);
		panelTrip.add(tripNum);	
		panelTrip.add(tripNum);

		JButton[] buttons = new JButton[tripList.length];
		for (int i = start; i < tripList.length; i++) {
			// Show trips
			Label labelTripInfo = new Label(tripList[i].getTripName());
			labelTripInfo.setFont(new Font("Dialog", Font.BOLD, 14));
			labelTripInfo.setBounds(10, 22 + (i%3)*200, 650, 16);
			panelTrip.add(labelTripInfo);

			// Date
			Label labelDate = new Label("Date:");
			labelDate.setBounds(10, 50 + (i%3)*200, 50, 16);
			labelDate.setFont(new Font("Tahoma", Font.BOLD, 12));
			panelTrip.add(labelDate);

			Label labelDateResultFrom = new Label(tripList[i].getDateBegin().toString());
			labelDateResultFrom.setBounds(150, 50 + (i%3)*200, 75, 16);
			panelTrip.add(labelDateResultFrom);

			Label labelTo = new Label(" to ");
			labelTo.setBounds(225, 50 + (i%3)*200, 20, 16);
			labelTo.setFont(new Font("Tahoma", Font.BOLD, 12));
			panelTrip.add(labelTo);

			Label labelDateResultTo = new Label(tripList[i].getDateEnd().toString());
			labelDateResultTo.setBounds(250, 50 + (i%3)*200, 75, 16);
			panelTrip.add(labelDateResultTo);

			// Location	
			Label labelLocation = new Label("Location:");
			labelLocation.setBounds(10, 80 + (i%3)*200, 100, 16);
			labelLocation.setFont(new Font("Tahoma", Font.BOLD, 12));
			panelTrip.add(labelLocation);

			Label labelLocationResult = new Label(tripList[i].getLocation().toString());
			labelLocationResult.setBounds(150, 80 + (i%3)*200, 75, 16);
			panelTrip.add(labelLocationResult);

			// Price
			Label labelPrice = new Label("Price:");
			labelPrice.setBounds(10, 110 + (i%3)*200, 100, 16);
			labelPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
			panelTrip.add(labelPrice);

			Label labelPriceResult = new Label(Integer.toString(tripList[i].getPrice()) + " ISK");
			labelPriceResult.setBounds(150, 110 + (i%3)*200, 75, 16);
			panelTrip.add(labelPriceResult);

			// Description
			Label labelDescription = new Label("Description:");
			labelDescription.setBounds(10, 140 + (i%3)*200, 100, 16);
			labelDescription.setFont(new Font("Tahoma", Font.BOLD, 12));
			panelTrip.add(labelDescription);

			JTextArea textArea = new JTextArea(16,58);
			textArea.setText(tripList[i].getDescription().toString());
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			textArea.setEditable(false);
			textArea.setFocusable(false);
			textArea.setBackground(new Color(240,240,240));
			
			JScrollPane scroll = new JScrollPane(textArea);
		    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		    scroll.setBounds( 150, 140 + (i%3)*200, 250, 60);
			panelTrip.add(scroll);


			int j = i;
			buttons[i] = new JButton("Book trip");
			buttons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelTrip.setVisible(false);
					panelAdmin.setVisible(false);
					panelSearch.setVisible(false);
					panelBook.setVisible(true);
					//labelTripInfo.setVisible(false);
					//labelDateInfo.setVisible(false);
					//labelPriceInfo.setVisible(false);
					//labelLocationInfo.setVisible(false);
					panelAddTrip.setVisible(false);
					tfTrip.setText(tripList[j].getTripName());
					currentTrip = tripList[j];
				}
			});
			buttons[i].setBounds(10, 170 + (i%3)*200, 100, 29);
			panelTrip.add(buttons[i]);

		}

	}
}