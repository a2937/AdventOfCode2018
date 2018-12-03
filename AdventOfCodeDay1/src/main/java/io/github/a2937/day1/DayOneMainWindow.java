package io.github.a2937.day1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class DayOneMainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblOutput;

	/**
	 * Create the frame.
	 */
	public DayOneMainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setName("Summation Calculator GUI");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextArea lblInstructions = new JTextArea("Type the path of a file containing numbers on each line or type in series of values separated by a comma then press the button labelled Enter. ");
		lblInstructions.setLineWrap(true);
		lblInstructions.setRows(3);
		lblInstructions.setEditable(false);
		lblInstructions.setBounds(10, 11, 404, 74);
		panel.add(lblInstructions);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(arg0 ->
		{
			if(textField.getText().contains(","))
			{
				lblOutput.setText("Output: Summation: " + FrequencyCalculator.calculateFrequency(textField.getText(),','));

			}
			else
			{
				if(new File(textField.getText()).exists())
				{
				    String fileContents = FileReader.readValuesFromFile(textField.getText());
					lblOutput.setText("Output: \n Summation: " + FrequencyCalculator.calculateFrequency(fileContents,'\n'));
				}
				else
				{
					lblOutput.setText("Output: Specified file does not exists");
				}
			}
		});
		btnEnter.setBounds(168, 154, 89, 23);
		panel.add(btnEnter);
		
		textField = new JTextField();
		textField.setBounds(109, 123, 227, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		 lblOutput = new JLabel("Output:");
		lblOutput.setBounds(68, 199, 236, 41);
		panel.add(lblOutput);
	}
}
