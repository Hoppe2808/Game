package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class InventoryFrame extends JFrame{

private MainFrame mF;
private InventoryFrame iF = this;
private JPanel contentPane;
private final Action action = new SwingAction();
	
	public InventoryFrame(MainFrame mF){
		this.mF = mF;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setAction(action);
		btnGoBack.setBounds(364, 527, 89, 23);
		contentPane.add(btnGoBack);
		
		JLabel lblInventory = new JLabel("Inventory");
		lblInventory.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInventory.setBounds(364, 11, 89, 23);
		contentPane.add(lblInventory);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Go Back");
			putValue(SHORT_DESCRIPTION, "Go back to the main menu");
		}
		public void actionPerformed(ActionEvent e) {
			mF.setVisible(true);
			iF.setVisible(false);
		}
	}
}
