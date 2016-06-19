package userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;

import mobData.Mob;
import mobData.MobImages;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import functionality.UserFunctionality;
import functionality.ItemFunctionality;
import functionality.MobFunctionality;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.JSplitPane;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;

public class MainFrame extends JFrame {

	private MainFrame mainFrame = this;
	private JPanel contentPane;
	private JPanel playerPanel;
	private JPanel playerStats;
	private JPanel playerActions;
	private UserFunctionality uF;
	private MobFunctionality mF;
	private ItemFunctionality iF;
	private final Action action = new SwingAction();
	JLabel lblNewLabel;
	JLabel lblNewLabel2;
	JLabel lblMobDamage;
	JLabel picLabel;
	JLabel lblMobname;
	int userCurHealth;
	int userMaxHealth;
	JProgressBar progressBar;
	JProgressBar progressBar2;
	protected Mob curMob;
	BufferedImage mobPic;
	MobImages mI = new MobImages();

	/**
	 * Create the frame.
	 */
	public MainFrame(UserFunctionality userFunc, MobFunctionality mobFunc) {
		uF = userFunc;
		mF = mobFunc;
		userCurHealth = uF.getUserHealthCurrent();
		userMaxHealth = uF.getUserHealthMax();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		playerStats = new JPanel();
		playerActions = new JPanel();
		playerPanel = new JPanel();
		playerPanel.setBounds(5, 509, 874, 47);
		playerPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		playerPanel.add(playerStats, BorderLayout.WEST);
		playerPanel.add(playerActions, BorderLayout.EAST);
		contentPane.add(playerPanel);
		
		UIManager.put("ProgressBar.background", Color.GREEN);
		UIManager.put("ProgressBar.foreground", Color.BLUE);
		UIManager.put("ProgressBar.selectionBackground", Color.BLACK);
		UIManager.put("ProgressBar.selectionForeground", Color.BLACK);
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setString(Integer.toString(userCurHealth));
		playerStats.add(progressBar);
		progressBar.setForeground(Color.green);
		
		lblNewLabel = new JLabel(userCurHealth + "/" + userMaxHealth);
		playerStats.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		playerStats.add(panel_1);
		
		JButton btnFightButton = new JButton("Fight");
		btnFightButton.setAction(action);
		playerActions.add(btnFightButton);
		JButton btnInventoryButton = new JButton("Inventory");
		btnInventoryButton.addActionListener(new InventoryAction());
		playerActions.add(btnInventoryButton);
		
		JLabel lblDmg = new JLabel("DMG: " + uF.getUserDMG());
		playerStats.add(lblDmg);
		
		JLabel lblArmor = new JLabel("Armor: " + uF.getUserArmor());
		playerStats.add(lblArmor);
		
//		JPanel panel_2 = new JPanel();
//		contentPane.add(panel_2, BorderLayout.CENTER);
		
//		JLabel lblLevel = new JLabel("level");
//		panel_2.add(lblLevel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 11, 464, 27);
		contentPane.add(panel_3);
		curMob = mF.getRandomMob(1);
		
		UIManager.put("ProgressBar2.background", Color.GREEN);
		UIManager.put("ProgressBar2.foreground", Color.BLUE);
		UIManager.put("ProgressBar2.selectionBackground", Color.BLACK);
		UIManager.put("ProgressBar2.selectionForeground", Color.BLACK);
		
		lblMobname = new JLabel(curMob.getName());
		panel_3.add(lblMobname);
		progressBar2 = new JProgressBar();
		progressBar2.setMaximum(curMob.getHealth());
		progressBar2.setStringPainted(true);
		progressBar2.setString(Integer.toString(curMob.getHealth()));
		panel_3.add(progressBar2);
		progressBar2.setForeground(Color.green);
		
		lblNewLabel2 = new JLabel(curMob.getHealth() + "/" + curMob.getHealth());
		panel_3.add(lblNewLabel2);
		
		lblMobDamage = new JLabel("Mob Damage: " + curMob.getDamage());
		panel_3.add(lblMobDamage);
		
		JPanel mobPanel = new JPanel();
		mobPanel.setBounds(5, 49, 459, 449);
		mobPic = mI.getMobImage(curMob.getName());
		picLabel = new JLabel(new ImageIcon(mobPic));
		mobPanel.add(picLabel);
		contentPane.add(mobPanel);
	}
	
	public void makeNewMob(){
		curMob = mF.getRandomMob(1);
		progressBar2.setMaximum(curMob.getHealth());
		progressBar2.setValue(curMob.getMaxHp());
		progressBar2.setStringPainted(true);
		progressBar2.setString(Integer.toString(curMob.getHealth()));
		progressBar2.setForeground(Color.green);
		mobPic = mI.getMobImage(curMob.getName());
		picLabel.setIcon(new ImageIcon(mobPic));
		lblMobname.setText(curMob.getName());
		lblNewLabel2.setText(curMob.getHealth() + "/" + curMob.getHealth());
		lblMobDamage.setText("Mob Damage: " + curMob.getDamage());
	}
	public void updatePlayerHealth(){
		//TODO Create method
	}
	public void updateMobHealth(){
		//TODO create method
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Fight");
			putValue(SHORT_DESCRIPTION, "Press to attack the enemy");
		}
		public void actionPerformed(ActionEvent e) {
			progressBar.setBackground(Color.gray);
			progressBar2.setBackground(Color.gray);
			curMob.setHealth(-damageCalculation(uF.getUserDMG(), 0));
			uF.setUserHealthCurrent(-damageCalculation(curMob.getDamage(), uF.getUserArmor()));
			userCurHealth = uF.getUserHealthCurrent();
			if (userCurHealth <= userMaxHealth/2){
				if (userCurHealth <= userMaxHealth/4){
					progressBar.setForeground(Color.red);
				}else {
					progressBar.setForeground(Color.orange);
				}
			} else {
				progressBar.setForeground(Color.green);
			}
			if (curMob.getHealth() <= curMob.getHealth()/2){
				if (curMob.getHealth() <= curMob.getHealth()/4){
					progressBar2.setForeground(Color.red);
				}else {
					progressBar2.setForeground(Color.orange);
				}
			} else {
				progressBar2.setForeground(Color.green);
			}
			progressBar.setString(Integer.toString(userCurHealth));
			progressBar.setValue(userCurHealth);
			lblNewLabel.setText(userCurHealth + "/" + userMaxHealth);
			
			progressBar2.setString(Integer.toString(curMob.getHealth()));
			progressBar2.setValue(curMob.getHealth());
			lblNewLabel2.setText(curMob.getHealth() + "/" + curMob.getMaxHp());
			if (curMob.getHealth() == 0){
				makeNewMob();
			}
		}
		public int damageCalculation(int damage, int armor){
			int actualDamage = damage - (int) (0.1 * armor);
			return actualDamage;
		}
	}
	class InventoryAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						InventoryFrame inventory = new InventoryFrame(mainFrame);
						inventory.setVisible(true);
						mainFrame.setVisible(false);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
	}
}
