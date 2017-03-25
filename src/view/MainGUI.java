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
	private JTextField tfSearch;
	
	
	
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
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel pTrip = new JPanel();
		panel.add(pTrip);
		
		JPanel pSearch = new JPanel();
		panel.add(pSearch);
		pSearch.setLayout(new MigLayout("", "[400px,grow]", "[200px][grow]"));
		pSearch.setVisible(false);
		
		
		tfSearch = new JTextField();
		pSearch.add(tfSearch, "flowx,cell 0 0,growx,aligny center");
		tfSearch.setColumns(10);
		
		JButton btnSearchTrip = new JButton("Search Trips");
		btnSearchTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pTrip.setVisible(true);
				pSearch.setVisible(false);
			}
		});
		pSearch.add(btnSearchTrip, "cell 0 0,alignx trailing,aligny center");
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		Button btnTbAdmin = new Button("Admin");
		btnTbAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pSearch.setVisible(false);
			}
		});
		
		Button btnTbTrips = new Button("Trip");
		btnTbTrips.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pSearch.setVisible(false);
			}
		});
		toolBar.add(btnTbTrips);
		toolBar.add(btnTbAdmin);
		
		Button btnTbSearch = new Button("Search");
		btnTbSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pSearch.setVisible(true);
				
			}
		});
		toolBar.add(btnTbSearch);
	}
	
	

}
