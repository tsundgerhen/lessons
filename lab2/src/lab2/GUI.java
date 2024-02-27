package lab2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener{
	
	protected int count = 0;
	protected JLabel label;
	protected JFrame frame;
	protected JPanel panel;
	public GUI() {
		frame = new JFrame();
		
		JButton button_1 = new JButton("clicl me");
		button_1.addActionListener(this);
		label = new JLabel("Number of clicks: 0");
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0,1));
		panel.add(button_1);
		panel.add(label);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("DoubleLinkedList");
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new GUI();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		label.setText("Number of clicks: " + count);
	}
	
}
