
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ScreenA {

	private ScreenB myScreenB;
	JFrame frame;
	JPanel yellowPanel;
	JPanel purplePanel;
	CardLayout cards;
	JPanel cardPanel;
	JComboBox<String> options;
	JTextField txt1;
	JTextField txt2;
	JPanel pageonepanel;
	JButton login;
	JTextField txt3;
	JButton preview;
	JPanel txaPanel;
	JTextArea txa;
	JButton logout;
	JPanel txaPanel2;
	JTextArea txa2;
	JButton back;

	public ScreenA() {
		frame = new JFrame();
		frame.setTitle("ScreenA");

		Container cp = frame.getContentPane();
		cp.setLayout(new BorderLayout());

		// Create the "Deck of Cards"
		cards = new CardLayout();
		cardPanel = new JPanel();
		cardPanel.setLayout(cards);

		JPanel logindetails = new JPanel();
		logindetails.setBackground(Color.YELLOW);
		logindetails.setLayout(new FlowLayout());
		JLabel loginscreen = new JLabel("Car Rental Customer Login");
		logindetails.add(loginscreen);
		////////////////////////////////////////////
		JPanel loginbutton = new JPanel();
		loginbutton.setBackground(Color.YELLOW);
		loginbutton.setLayout(new FlowLayout());
		login = new JButton("Login");

		loginbutton.add(login);

		JPanel yellowpanel = new JPanel();
		yellowpanel.setBackground(Color.YELLOW);
		yellowpanel.setLayout(new FlowLayout());
		/////////////////////////////
		pageonepanel = new JPanel();
		pageonepanel.setLayout(new GridLayout(3, 1));

		pageonepanel.add(logindetails);
		pageonepanel.add(loginbutton);
		pageonepanel.add(yellowpanel);
		////////////////////////////////////////////////
		purplePanel = new JPanel();
		purplePanel.setBackground(Color.yellow);
		purplePanel.setLayout(new FlowLayout());
		purplePanel.setVisible(false);
		purplePanel.setBorder(BorderFactory.createTitledBorder("Update Customer Details"));
		// purplePanel.add(loginscreen4);

		JPanel cyanPanel = new JPanel();
		cyanPanel.setLayout(new FlowLayout());
		cyanPanel.setBackground(Color.cyan);
		cyanPanel.setBorder(BorderFactory.createTitledBorder("Customer Details"));
		Box b1 = new Box(BoxLayout.Y_AXIS);
		Box b2 = new Box(BoxLayout.Y_AXIS);

		JLabel nameLabel = new JLabel("Name:");
		JLabel countryLabel = new JLabel("Address:");
		JLabel StudentIDLabel = new JLabel("Duration of Rental:");
		JLabel Model = new JLabel("Model of Car");
		options = new JComboBox<String>();
		options.addItem("");
		options.addItem("Ford");
		options.addItem("Nissan");
		options.addItem("Toyota");
		options.addItem("Kia");
		// options.addActionListener(this);

		txt1 = new JTextField(20);
		txt2 = new JTextField(20);
		txt3 = new JTextField(20);

		b1.add(nameLabel);
		b2.add(txt1);

		b1.add(countryLabel);
		b2.add(txt2);

		b1.add(StudentIDLabel);
		b2.add(txt3);

		b1.add(Model);
		b2.add(options);

		cyanPanel.add(b1);
		cyanPanel.add(b2);
		////////////////////////////////////////////////////
		JPanel backpanel = new JPanel();
		backpanel.setLayout(new BorderLayout());
		preview = new JButton("Submit Details");

		backpanel.add(cyanPanel, BorderLayout.CENTER);
		backpanel.add(preview, BorderLayout.SOUTH);

		purplePanel.add(backpanel);

		///////////////////////////////////////////
		txaPanel = new JPanel();
		txaPanel.setLayout(new BorderLayout());
		//txaPanel.setVisible(true);
		txa = new JTextArea(20, 20);
		txaPanel.add(txa, BorderLayout.CENTER);
		logout = new JButton("Logout");
		txaPanel.add(logout, BorderLayout.SOUTH);
		//////////////////////////////////////////////
		txaPanel2 = new JPanel();
		txaPanel2.setLayout(new BorderLayout());
		//txaPanel2.setVisible(true);
		txa2 = new JTextArea(20, 20);
		txaPanel2.add(txa2, BorderLayout.CENTER);
		back = new JButton("Back");
		txaPanel2.add(back, BorderLayout.SOUTH);

		ActionListener clicked = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == login) {
					String myInput = JOptionPane.showInputDialog(null, "Please Enter Your Username", "Username",
							JOptionPane.INFORMATION_MESSAGE);
					String myInput2 = JOptionPane.showInputDialog(null, "Please Enter Your Password", "Password",
							JOptionPane.INFORMATION_MESSAGE);

					txt1.setText("");
					txt2.setText("");
					txt3.setText("");

					if (myInput.equals("Eoin") & myInput2.equals("1234")) {
						cards.next(cardPanel);

					} else
						JOptionPane.showMessageDialog(null, "Incorrect Details", "Warning",
								JOptionPane.WARNING_MESSAGE);
				}

				if (e.getSource() == logout) {
					pageonepanel.setVisible(true);
					txaPanel.setVisible(false);
				}
				
				if (e.getSource() == back) {
					cards.show(cardPanel, "2");

				}

				if (e.getSource() == preview) {

					int mt = options.getSelectedIndex();
					if (mt == 0) {

						myScreenB.setTheTxt("" + "\n");

					}
					if (mt == 1) {

						myScreenB.setTheTxt2(options.getSelectedItem() + "\n");
					}
					if (mt == 2) {

						myScreenB.setTheTxt3(options.getSelectedItem() + "\n");
					}
					if (mt == 3) {

						myScreenB.setTheTxt4(options.getSelectedItem() + "\n");
					}
					if (mt == 4) {

						myScreenB.setTheTxt5(options.getSelectedItem() + "\n");
					}

					myScreenB.setTheText(txt1.getText());
					myScreenB.setTheText2(txt2.getText());
					myScreenB.setTheText3(txt3.getText());

				}
			}

		};

		login.addActionListener(clicked);
		logout.addActionListener(clicked);
		options.addActionListener(clicked);
		back.addActionListener(clicked);
		preview.addActionListener(clicked);

		cardPanel.add(pageonepanel);
		cardPanel.add(purplePanel,"2");
		cardPanel.add(txaPanel, "3");
		cardPanel.add(txaPanel2,"4");

		cp.add(cardPanel);

		frame.setSize(600, 225);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void passScreenB(ScreenB screenB) {
		this.myScreenB = screenB;
	}

	public void setTheTxt(String msg) {
		txa.setText(msg);
	}
	public void setTheTxt2(String msg) {
		txa2.setText(msg);
	}
	
	
	public void addTxt(String msg) {
		options.addItem(msg);
	}

	public void removeTxt(String msg) {
		options.removeItem(msg);
	}

};
