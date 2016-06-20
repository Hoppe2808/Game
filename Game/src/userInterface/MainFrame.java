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
import java.util.Random;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.JSplitPane;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import java.awt.Font;

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
	JLabel lblMobDamage;
	JLabel picLabel;
	JLabel lblMobname;
	JLabel lblLevel;
	JLabel lblDmg;
	JLabel lblArmor;
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
		playerActions = new JPanel();
		playerPanel = new JPanel();
		playerPanel.setBounds(5, 509, 874, 47);
		playerPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		playerPanel.add(playerActions, BorderLayout.EAST);
		contentPane.add(playerPanel);
		
		UIManager.put("ProgressBar.background", Color.GREEN);
		UIManager.put("ProgressBar.foreground", Color.BLUE);
		UIManager.put("ProgressBar.selectionBackground", Color.BLACK);
		UIManager.put("ProgressBar.selectionForeground", Color.BLACK);
		
		JButton btnFightButton = new JButton("Fight");
		btnFightButton.setAction(action);
		playerActions.add(btnFightButton);
		JButton btnInventoryButton = new JButton("Inventory");
		btnInventoryButton.addActionListener(new InventoryAction());
		playerActions.add(btnInventoryButton);
		
//		JPanel panel_2 = new JPanel();
//		contentPane.add(panel_2, BorderLayout.CENTER);
		
//		JLabel lblLevel = new JLabel("level");
//		panel_2.add(lblLevel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 31, 464, 27);
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
		
		lblMobDamage = new JLabel("Mob Damage: " + curMob.getDamage());
		panel_3.add(lblMobDamage);
		
		JPanel mobPanel = new JPanel();
		mobPanel.setBounds(5, 69, 459, 429);
		mobPic = mI.getMobImage(curMob.getName());
		picLabel = new JLabel(new ImageIcon(mobPic));
		mobPanel.add(picLabel);
		contentPane.add(mobPanel);
		
		playerStats = new JPanel();
		playerStats.setBounds(497, 31, 343, 27);
		contentPane.add(playerStats);
		
		lblLevel = new JLabel("Level: " + uF.getLevel());
		playerStats.add(lblLevel);
		progressBar = new JProgressBar();
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
		
		lblNewLabel_1 = new JLabel("Enemies");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(144, 0, 157, 27);
		contentPane.add(lblNewLabel_1);
		
		lblPlayer = new JLabel("Player");
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlayer.setBounds(603, 0, 157, 27);
		contentPane.add(lblPlayer);
		
		lblXp = new JLabel("Experience: " + uF.getExp()[0] + "/" + uF.getExp()[1]);
		lblXp.setBounds(497, 69, 191, 14);
		contentPane.add(lblXp);
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
			progressBarColor();
			progressBar.setString(Integer.toString(userCurHealth));
			progressBar.setValue(userCurHealth);
			
			progressBar2.setString(Integer.toString(curMob.getHealth()));
			progressBar2.setValue(curMob.getHealth());
			if (curMob.getHealth() == 0){
				if (drop(curMob.getDropChance())){
					
				}
				makeNewMob();
				uF.addExp(0, curMob.getExp());
				int xp = uF.getExp()[0];
				int maxXp = uF.getExp()[1];
				lblXp.setText("Experience: " + xp + "/" + maxXp);
				if (xp == maxXp){
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
	}
	class InventoryAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						InventoryFrame inventory = new InventoryFrame(mainFrame, iF);
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
