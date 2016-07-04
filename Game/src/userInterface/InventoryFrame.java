package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import functionality.ItemFunctionality;
import functionality.UserFunctionality;
import userData.Item;

import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;

public class InventoryFrame extends JFrame{

private MainFrame mF;
private InventoryFrame iF = this;
private JPanel contentPane;
private final Action action = new SwingAction();
private Object[][] weapons;
	
	public InventoryFrame(MainFrame mF, UserFunctionality uF){
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 35, 864, 481);
		contentPane.add(tabbedPane);
		
		ArrayList<Item> items = new ArrayList<Item>();
		items = uF.getUserInventory();
		
		JPanel tabbedPaneWeapons = new JPanel();
		tabbedPaneWeapons.setLayout(new BoxLayout(tabbedPaneWeapons, BoxLayout.Y_AXIS));
        tabbedPane.addTab("Weapons", null, tabbedPaneWeapons, null);
		
		for (int i = 0; i < items.size(); i++){
			if (items.get(i).getType().equals("Weapon")){
				for (int j = 0; j < 5; j++){
					for (int k = 0; k < 7; k++){
						weapons[0][0] = items.get(i).getName();
					}
				}
				//tabbedPaneWeapons.add(new JLabel(items.get(i).getName()));
			}
		}
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Armor", null, tabbedPane_2, null);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Misc", null, tabbedPane_3, null);
		
		JButton btnEquip = new JButton("Equip");
		btnEquip.setBounds(265, 527, 89, 23);
		contentPane.add(btnEquip);
		
	}
	class EquipAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
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
