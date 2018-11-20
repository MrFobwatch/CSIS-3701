package gui_accumulator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Accumulator extends Frame implements ActionListener {
    private Label lblInput; // Declare input label
    private Label lblOutput; // Declare output label
    private TextField tfInput; // Declare input TextField
    private TextField tfOutput; // Declare output TextField
    private int sum = 0; // The accumulated sum init to 0

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int numberIn = Integer.parseInt(tfInput.getText());
        // Get the String entered, convert to int
        sum += numberIn; // Accumulate numbers entered into sum
        tfInput.setText(""); // Clear input TextField
        tfOutput.setText("" + sum); // Display sum on the output TextField, convert int to String
    }

    // Constructor to setup the UI components and event handlers
    public GUI_Accumulator() {
        setLayout(new FlowLayout()); // "super" frame set to FLowLayout

        lblInput = new Label("Enter an Integer"); // Constructs component Label
        add(lblInput); // "super" frame adds the textField

        tfInput = new TextField(10); // Construct component TextField
        add(tfInput);

        tfInput.addActionListener(this);
        // tfinput is a source that fires Action Event when entered
        // The source add "this" instance as a ActionEVent Listener, which provides
        // an ActionEvent handler called actionPerformed();
        // hitting enter on tfInput invokes actionPerformed();

        lblOutput = new Label("Accumulated Sum is"); // Construct component Label
        add(lblOutput); // "Super" frame adds  Label

        tfOutput = new TextField(10); // Construct component TextField
        tfOutput.setEditable(false); // read-only
        add(tfOutput); // "super" frame shows

	    setVisible(true);
    }
    /** @param args the command line args */
    public static void main(String[] args) {
        //
        new GUI_Accumulator();
    }
}
