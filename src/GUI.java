import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.NoSuchElementException;


@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JPanel contentPane;
	private static JTextField inputField;
	private static JTextArea console;
	private static JTextArea inventoryList;

	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		super(Game.name+" v"+Game.version);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Command-entering text field
		inputField = new JTextField();
		inputField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				// If ENTER is pressed, send the entered text to be interpreted and clear the text field
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						Game.input(inputField.getText());
					} catch(NoSuchElementException e) {}
					inputField.setText("");
				}
				// If UP is pressed, set inputField's text equal to the last command entered
				if(arg0.getKeyCode() == KeyEvent.VK_UP) {
					inputField.setText(Game.lastCmd);
				}
			}
		});
		inputField.setBounds(196, 289, 424, 28);
		contentPane.add(inputField);
		inputField.setColumns(10);
		
		// Event history scroller/container
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(196, 6, 424, 278);
		contentPane.add(scrollPane);
		
		// Main event history
		// TODO: add padding to this
		console = new JTextArea();
		console.setWrapStyleWord(true);
		console.setLineWrap(true);
		console.setEditable(false);
		scrollPane.setViewportView(console);
		
		// Inventory container/scroller
		JScrollPane inventoryScroll = new JScrollPane();
		inventoryScroll.setBounds(6, 6, 185, 311);
		contentPane.add(inventoryScroll);
		
		// Inventory display
		inventoryList = new JTextArea();
		inventoryScroll.setViewportView(inventoryList);
		inventoryList.setEditable(false);
		
		// Make inputField have focus when window first opened
		this.addWindowListener(new WindowAdapter() {
		    public void windowOpened(WindowEvent e){
		        inputField.requestFocus();
		    }
		}); 
	}
	
	public static void updateInventory(int[] inv) {
		inventoryList.setText("");
		for(int i=0; i<inv.length; i++) {
			inventoryList.append("\n"+Actions.GetItemName((int)inv[i]));
		}
	}
	
	public static void log(String output) {
		console.append("\n"+output);
		console.selectAll();
		int x	= console.getSelectionEnd();
		console.select(x, x);
	}
}
