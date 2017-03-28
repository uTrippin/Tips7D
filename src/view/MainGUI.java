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
		pTrip.setLayout(new MigLayout("", "[400px,grow]", "[200px][grow]"));
		
		TextField textField = new TextField();
		pTrip.add(textField, "cell 0 0,grow");
		pTrip.setVisible(false);
		
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
	}
	
	

}
