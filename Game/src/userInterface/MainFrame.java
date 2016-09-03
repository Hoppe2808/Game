package userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Image;

import mobData.Mob;
import mobData.MobImages;
import userData.Item;

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
import java.util.Random;

import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import java.awt.Font;

public class MainFrame extends JFrame {

	private MainFrame mainFrame = this;
	private JPanel contentPane;
	private JPanel playerStats;
	private JPanel playerActions;
	private UserFunctionality uF;
	private MobFunctionality mF;
	private ItemFunctionality iF = new ItemFunctionality();
	private final Action action = new SwingAction();
	JLabel lblMobDamage;
	JLabel picLabel;
	JLabel lblMobname;
	JLabel lblLevel;
	JLabel lblDmg;
	JLabel lblArmor;
	JLabel lblMessage;
	int userCurHealth;
	int userMaxHealth;
	JProgressBar progressBar;
	JProgressBar progressBar2;
	protected Mob curMob;
	BufferedImage mobPic;
	MobImages mI = new MobImages();
	private JLabel lblNewLabel_1;
	private JLabel lblPlayer;
	private JLabel lblXp;
	private JLabel lblEquipWeapon;

	/**
	 * Create the frame.
	 */
	public MainFrame(UserFunctionality userFunc, MobFunctionality mobFunc) {
		uF = userFunc;
		mF = mobFunc;
		userCurHealth = uF.getUserHealthCurrent();
		userMaxHealth = uF.getUserHealthMax();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		UIManager.put("ProgressBar.background", Color.GREEN);
		UIManager.put("ProgressBar.foreground", Color.BLUE);
		UIManager.put("ProgressBar.selectionBackground", Color.BLACK);
		UIManager.put("ProgressBar.selectionForeground", Color.BLACK);
		
//		JPanel panel_2 = new JPanel();
//		contentPane.add(panel_2, BorderLayout.CENTER);
		
//		JLabel lblLevel = new JLabel("level");
//		panel_2.add(lblLevel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 31, 464, 39);
		contentPane.add(panel_3);
		curMob = mF.getRandomMob(1);
		
		progressBar2 = new JProgressBar();
		progressBar2.setPreferredSize(new Dimension(300, 30));
		progressBar2.setMaximum(curMob.getHealth());
		progressBar2.setStringPainted(true);
		progressBar2.setString(Integer.toString(curMob.getHealth()));
		panel_3.add(progressBar2);
		progressBar2.setForeground(Color.green);
		
		lblMobDamage = new JLabel("Mob Damage: " + curMob.getDamage());
		panel_3.add(lblMobDamage);
		
		JPanel mobPanel = new JPanel();
		mobPanel.setBounds(5, 69, 459, 429);
		mobPic = mI.getMobImage(curMob.getName());
		picLabel = new JLabel();
		Image scaledImage = mobPic.getScaledInstance(459,429,Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(scaledImage);
		picLabel.setIcon(icon);
		mobPanel.add(picLabel);
		contentPane.add(mobPanel);
		
		playerStats = new JPanel();
		playerStats.setBounds(497, 31, 343, 60);
		contentPane.add(playerStats);
		progressBar = new JProgressBar();
		progressBar.setPreferredSize(new Dimension(300, 30));
		progressBar.setStringPainted(true);
		progressBar.setString(Integer.toString(userCurHealth));
		playerStats.add(progressBar);
		progressBar.setForeground(Color.green);
		
		JPanel panel_1 = new JPanel();
		playerStats.add(panel_1);
		
		lblDmg = new JLabel("DMG: " + uF.getUserDMG());
		playerStats.add(lblDmg);
		
		lblArmor = new JLabel("Armor: " + uF.getUserArmor());
		playerStats.add(lblArmor);
		
		lblNewLabel_1 = new JLabel(curMob.getName());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(144, 0, 157, 27);
		contentPane.add(lblNewLabel_1);
		
		lblPlayer = new JLabel("Player");
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlayer.setBounds(603, 0, 157, 27);
		contentPane.add(lblPlayer);
		
		lblXp = new JLabel("Experience: " + uF.getExp()[0] + "/" + uF.getExp()[1]);
		lblXp.setBounds(497, 99, 191, 14);
		contentPane.add(lblXp);
		
		JLabel lblEquipment = new JLabel("Equipment");
		lblEquipment.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEquipment.setBounds(497, 124, 343, 19);
		contentPane.add(lblEquipment);
		
		JLabel lblWeapon = new JLabel("Weapon:");
		lblWeapon.setBounds(497, 159, 54, 15);
		contentPane.add(lblWeapon);
		
		lblEquipWeapon = new JLabel();
		lblEquipWeapon.setBounds(561, 159, 146, 15);
		contentPane.add(lblEquipWeapon);
		
		JLabel lblHelmet = new JLabel("Helmet:");
		lblHelmet.setBounds(497, 199, 54, 15);
		contentPane.add(lblHelmet);
		
		JLabel lblChest = new JLabel("Chest:");
		lblChest.setBounds(497, 239, 54, 15);
		contentPane.add(lblChest);
		
		JLabel lblGloves = new JLabel("Gloves:");
		lblGloves.setBounds(497, 279, 54, 15);
		contentPane.add(lblGloves);
		
		JLabel lblPants = new JLabel("Pants:");
		lblPants.setBounds(497, 319, 54, 15);
		contentPane.add(lblPants);
		
		JLabel lblBoots = new JLabel("Boots:");
		lblBoots.setBounds(497, 359, 54, 15);
		contentPane.add(lblBoots);
		
		JLabel lblTrinket = new JLabel("Trinket:");
		lblTrinket.setBounds(497, 399, 54, 15);
		contentPane.add(lblTrinket);
		
		lblMessage = new JLabel();
		lblMessage.setBounds(497, 475, 300, 15);
		contentPane.add(lblMessage);
		playerActions = new JPanel();
		playerActions.setBounds(362, 504, 216, 70);
		contentPane.add(playerActions);
		
		JButton btnFightButton = new JButton("Fight");
		btnFightButton.setPreferredSize(new Dimension(100, 60));
		btnFightButton.setAction(action);
		playerActions.add(btnFightButton);
		playerActions.getRootPane().setDefaultButton(btnFightButton);
		
		JButton btnInventoryButton = new JButton("Inventory");
		btnInventoryButton.setPreferredSize(new Dimension(100, 60));
		btnInventoryButton.addActionListener(new InventoryAction());
		playerActions.add(btnInventoryButton);
		
		lblLevel = new JLabel("Level: " + uF.getLevel());
		lblLevel.setBounds(664, 4, 56, 20);
		contentPane.add(lblLevel);
	}
	
	public void makeNewMob(){
		curMob = mF.getRandomMob(1);
		progressBar2.setMaximum(curMob.getHealth());
		progressBar2.setValue(curMob.getMaxHp());
		progressBar2.setStringPainted(true);
		progressBar2.setString(Integer.toString(curMob.getHealth()));
		progressBar2.setForeground(Color.green);
		mobPic = mI.getMobImage(curMob.getName());
		Image scaledImage = mobPic.getScaledInstance(459,429,Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(scaledImage);
		picLabel.setIcon(icon);
		lblNewLabel_1.setText(curMob.getName());
		lblMobDamage.setText("Mob Damage: " + curMob.getDamage());
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Fight");
			putValue(SHORT_DESCRIPTION, "Press to attack the enemy");
		}
		public void actionPerformed(ActionEvent e) {
			attackFlow();
		}
	}
	private void attackFlow() {
		lblMessage.setText("");
		progressBar.setBackground(Color.gray);
		progressBar2.setBackground(Color.gray);
		curMob.setHealth(-damageCalculation(uF.getUserDMG(), 0));
		uF.setUserHealthCurrent(-damageCalculation(curMob.getDamage(), uF.getUserArmor()));
		userCurHealth = uF.getUserHealthCurrent();
		progressBarColor();
		progressBar.setString(Integer.toString(userCurHealth));
		progressBar.setValue(userCurHealth);
		
		progressBar2.setString(Integer.toString(curMob.getHealth()));
		progressBar2.setValue(curMob.getHealth());
		if (curMob.getHealth() == 0){
			if (drop(curMob.getDropChance())){
				Item droppedItem = uF.addItemToInventory(iF.getRandomItem());
				lblMessage.setText("Monster died and dropped an item: " + droppedItem.getName());
				if (droppedItem.getType() == "Weapon") {
					if (uF.getEquippedWeapon() == null){
						uF.setEquippedWeapon(droppedItem);
						lblDmg.setText("DMG: " + uF.getUserDMG());
						lblEquipWeapon.setText(uF.getEquippedWeapon().getName());
					}
				}
			} else {
				lblMessage.setText("Monster died!");
			}
			uF.addExp(0, curMob.getExp());
			makeNewMob();
			int xp = uF.getExp()[0];
			int maxXp = uF.getExp()[1];
			lblXp.setText("Experience: " + xp + "/" + maxXp);
			if (xp >= maxXp){
				levelUp(maxXp);
			}
		}
	}
	private void progressBarColor() {
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
	}
	private void levelUp(int maxXp) {
		uF.levelUp();
		uF.setExp(new int[] {0, maxXp + 50});
		lblLevel.setText("Level: " + uF.getLevel());
		lblXp.setText("Experience: " + uF.getExp()[0] + "/" + uF.getExp()[1]);
		lblDmg.setText("DMG: " + uF.getUserDMG());
		lblArmor.setText("Armor: " + uF.getUserArmor());
		progressBar.setMaximum(uF.getUserHealthMax());
		progressBar.setString(Integer.toString(uF.getUserHealthMax()));
		progressBar.setValue(uF.getUserHealthMax());
		progressBar.setForeground(Color.green);
	}
	public int damageCalculation(int damage, int armor){
		int actualDamage = damage - (int) (0.1 * armor);
		if (actualDamage < 1){
			actualDamage = 1;
		}
		return actualDamage;
	}
	private boolean drop(double dropChance){
		Random randomGenerator = new Random();
		int interval = (int) dropChance;
		if (randomGenerator.nextInt(100) <= interval){
			return true;
		}
		return false;
	}
	class InventoryAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						InventoryFrame inventory = new InventoryFrame(mainFrame, uF);
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
