package gui_counter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Counter implements ActionListener {
	/**
	 * @param args the command line arguments
	 */

	// counter of clicks
	private int counter = 0;

	private JLabel counterLabel;
	private JButton counterUpButton;
	private JButton counterDownButton;

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("Click Me!");
		f.setSize(new Dimension(400, 400));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// create the panel to display
		GUI_Counter clickMe = new GUI_Counter();
		JPanel clickMePanel = clickMe.createPanel();

		// add the panel to the center of the window
		Container contentPane = f.getContentPane();
		contentPane.add(clickMePanel, BorderLayout.CENTER);

		// Display the window
		f.setVisible(true);
	}

	/**
	 * Creates a panel that holds the button and label
	 *
	 * @return the panel that is created.
	 */
	public JPanel createPanel() {
		// create the panel that will display the form
		JPanel clickMePanel = new JPanel();

		// add the button that counts up

		counterUpButton = new JButton("Count Up");
		counterUpButton.addActionListener(this);
		clickMePanel.add(counterUpButton);

		// add the button that counts down
		counterDownButton = new JButton("Count Down");
		counterDownButton.addActionListener(this);
		clickMePanel.add(counterDownButton);

		// add a a counter to the display

		counterLabel = new JLabel("" + counter);
		clickMePanel.add(counterLabel);

		return clickMePanel;
	}

	/**
	 * Increments the counter on each button click and displays the new value
	 *
	 * @param event
	 * 		information about the button click
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == counterUpButton) {
			counter++;
			counterLabel.setText("" + counter);
		} else {
			counter--;
			counterLabel.setText("" + counter);
		}
	}
}
