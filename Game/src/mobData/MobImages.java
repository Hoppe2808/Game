package mobData;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class MobImages {
	HashMap<String, BufferedImage> hm = new HashMap<String, BufferedImage>();
	BufferedImage slimey;
	BufferedImage ratty;
	BufferedImage zwombie;
	BufferedImage mimic;
	BufferedImage dragear;
	
	public MobImages(){
		try {
			slimey = ImageIO.read(new File("Slimey.PNG"));
			//Thumbnails.of(img).size(newW, newH).asBufferedImage();
			ratty = ImageIO.read(new File("Ratty.PNG"));
			ratty = (BufferedImage) ratty.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			zwombie = ImageIO.read(new File("Zwombie.PNG"));
			zwombie = (BufferedImage) zwombie.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			mimic = ImageIO.read(new File("mimic.png"));
			mimic = (BufferedImage) mimic.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			dragear = ImageIO.read(new File("insanedragear.png"));
			dragear = (BufferedImage) dragear.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		hm.put("Slimey", slimey);
		hm.put("Ratty", ratty);
		hm.put("Zwombie", zwombie);
		hm.put("Mimic", mimic);
		hm.put("Dragear", dragear);
	}
	public BufferedImage getMobImage(String name){
		return hm.get(name);
	}
	public BufferedImage getSlimey() {
		return slimey;
	}

	public void setSlimey(BufferedImage slimey) {
		this.slimey = slimey;
	}

	public BufferedImage getRatty() {
		return ratty;
	}

	public void setRatty(BufferedImage ratty) {
		this.ratty = ratty;
	}

	public BufferedImage getZwombie() {
		return zwombie;
	}

	public void setZwombie(BufferedImage zwombie) {
		this.zwombie = zwombie;
	}
	public BufferedImage getMimic() {
		return mimic;
	}

	public void setMimic(BufferedImage mimic) {
		this.mimic = mimic;
	}

}
