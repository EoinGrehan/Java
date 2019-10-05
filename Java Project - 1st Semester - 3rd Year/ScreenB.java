
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ScreenB {

	private ScreenA myScreenA;

	JPanel yellowPanel;
	JPanel yellowPanel2;
	JPanel greenPanel;
	JPanel purplePanel;
	CardLayout cards;
	JPanel cardPanel;
	JPanel redPanel;
	JPanel pinkPanel;
	JPanel bluePanel;
	JPanel cyanPanel2;
	JButton login;
	JPanel pageonepanel;
	JPanel textArea;
	JTextField txt1;
	JTextField txt2;
	JTextField txt3;
	JScrollPane scroll;
	DefaultTableModel model;
	JTable myTable;
	JTextField txt4;
	JLabel name;
	JLabel country;
	JLabel id;
	JButton preview;
	JTextField jTextField1;
	JButton addButton;
	JButton removeButton;
	JButton backButton;
	JPanel addremove;
	JFrame frame;
	JButton edit;

	public ScreenB() {
		frame = new JFrame();
		frame.setTitle("ScreenB");

		Container cp = frame.getContentPane();
		cp.setLayout(new BorderLayout());

		// Create the "Deck of Cards"
		cards = new CardLayout();
		cardPanel = new JPanel();
		cardPanel.setLayout(cards);

		JPanel logindetails = new JPanel();
		logindetails.setBackground(Color.blue);
		logindetails.setLayout(new FlowLayout());
		JLabel loginscreen = new JLabel("Car Rental Admin Login");
		logindetails.add(loginscreen);
		////////////////////////////////////////////
		JPanel loginbutton = new JPanel();
		loginbutton.setBackground(Color.blue);
		loginbutton.setLayout(new FlowLayout());
		login = new JButton("Login");

		loginbutton.add(login);

		JPanel yellowpanel = new JPanel();
		yellowpanel.setBackground(Color.blue);
		yellowpanel.setLayout(new FlowLayout());
		/////////////////////////////
		pageonepanel = new JPanel();
		pageonepanel.setLayout(new GridLayout(3, 1));

		pageonepanel.add(logindetails);
		pageonepanel.add(loginbutton);
		pageonepanel.add(yellowpanel);
		///////////////////////////////////////////
		purplePanel = new JPanel();
		purplePanel.setBackground(Color.blue);
		purplePanel.setLayout(new FlowLayout());
		purplePanel.setVisible(false);
		purplePanel.setBorder(BorderFactory.createTitledBorder("Update Admin Details"));
		// purplePanel.add(loginscreen4);

		JPanel cyanPanel = new JPanel();
		cyanPanel.setLayout(new FlowLayout());
		cyanPanel.setBackground(Color.cyan);
		cyanPanel.setBorder(BorderFactory.createTitledBorder("Admin Details"));
		Box b1 = new Box(BoxLayout.Y_AXIS);
		Box b2 = new Box(BoxLayout.Y_AXIS);

		JLabel nameLabel = new JLabel("Name:");
		JLabel countryLabel = new JLabel("Address:");
		JLabel StudentIDLabel = new JLabel("Duration of Rental:");
		JLabel Model = new JLabel("Model of Car");

		// options.addActionListener(this);

		txt1 = new JTextField(20);
		txt2 = new JTextField(20);
		txt3 = new JTextField(20);
		txt4 = new JTextField(20);

		b1.add(nameLabel);
		b2.add(txt1);

		b1.add(countryLabel);
		b2.add(txt2);

		b1.add(StudentIDLabel);
		b2.add(txt3);

		b1.add(Model);
		b2.add(txt4);

		cyanPanel.add(b1);
		cyanPanel.add(b2);
		///////////////////////////
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(1, 2));
		preview = new JButton("Confirm Rental");
		edit = new JButton("Edit Selection of Vehicles");

		buttons.add(preview);
		buttons.add(edit);
		/////////////////////////////

		JPanel backpanel = new JPanel();
		backpanel.setLayout(new BorderLayout());

		backpanel.add(cyanPanel, BorderLayout.CENTER);
		backpanel.add(buttons, BorderLayout.SOUTH);

		purplePanel.add(backpanel);
		//////////////////////////////////////////////
		addremove = new JPanel();
		addremove.setLayout(new FlowLayout());

		jTextField1 = new JTextField(20);

		addButton = new JButton("Add to List");

		removeButton = new JButton("Remove from List");

		backButton = new JButton("Back");

		addremove.add(jTextField1);
		addremove.add(addButton);
		addremove.add(removeButton);
		addremove.add(backButton);

		ActionListener clicked = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == login) {
					String myInput = JOptionPane.showInputDialog(null, "Please Enter Your Username", "Username",
							JOptionPane.INFORMATION_MESSAGE);
					String myInput2 = JOptionPane.showInputDialog(null, "Please Enter Your Password", "Password",
							JOptionPane.INFORMATION_MESSAGE);

					if (myInput.equals("admin") & myInput2.equals("1234")) {
						cards.next(cardPanel);

					} else
						JOptionPane.showMessageDialog(null, "Incorrect Details", "Warning",
								JOptionPane.WARNING_MESSAGE);
				}

				if (e.getSource() == preview) {

					myScreenA.setTheTxt("Your Rental Application has been approved." + "\n" + "\n" + "Details Below:"
							+ "\n" + "\n" + "Name-" + txt1.getText() + "\n" + "Address-" + txt2.getText() + "\n"
							+ "Duration-" + txt3.getText() + "\n" + "Model-" + txt4.getText());

					myScreenA.cards.show(myScreenA.cardPanel, "3");
					// pageonepanel.setVisible(true);
					purplePanel.setVisible(false);

				}

				if (e.getSource() == edit) {
					cards.show(cardPanel, "4");

				}

				if (e.getSource() == backButton) {
					cards.show(cardPanel, "3");

				}

				if (e.getSource() == addButton) {
					myScreenA.addTxt(jTextField1.getText());
				}

				if (e.getSource() == removeButton) {

					myScreenA.removeTxt(jTextField1.getText());
					
					myScreenA.cards.show(myScreenA.cardPanel, "4");
					myScreenA.setTheTxt2("*ATTENTION*"+"\n"+"\n"+ "A Vehicle Has Been Removed, Sorry For Any Inconvenience Caused");
					
					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
					txt4.setText("");

				}

			}
		};

		login.addActionListener(clicked);
		preview.addActionListener(clicked);
		addButton.addActionListener(clicked);
		removeButton.addActionListener(clicked);
		edit.addActionListener(clicked);
		backButton.addActionListener(clicked);

		cardPanel.add(pageonepanel);
		cardPanel.add(purplePanel, "3");
		cardPanel.add(addremove, "4");

		cp.add(cardPanel);

		frame.setSize(600, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void passScreenA(ScreenA screenA) {
		this.myScreenA = screenA;
	}

	public void setTheText(String msg) {
		txt1.setText(msg + "\n");

	}

	public void setTheText2(String msg) {
		txt2.setText(msg + "\n");

	}

	public void setTheText3(String msg) {
		txt3.setText(msg + "\n");

	}

	public void setTheTxt(String msg) {
		txt4.setText(msg + "\n");

	}

	public void setTheTxt2(String msg) {
		txt4.setText(msg + "\n");

	}

	public void setTheTxt3(String msg) {
		txt4.setText(msg + "\n");

	}

	public void setTheTxt4(String msg) {
		txt4.setText(msg + "\n");

	}

	public void setTheTxt5(String msg) {
		txt4.setText(msg + "\n");

	}

};
