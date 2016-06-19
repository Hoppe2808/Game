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
	BufferedImage angryDusty;
	
	public MobImages(){
		try {
			slimey = ImageIO.read(new File("Slimey.PNG"));
			//Thumbnails.of(img).size(newW, newH).asBufferedImage();
			ratty = ImageIO.read(new File("Ratty.PNG"));
			zwombie = ImageIO.read(new File("Zwombie.PNG"));
			mimic = ImageIO.read(new File("mimic.png"));
			dragear = ImageIO.read(new File("insanedragear.png"));
			angryDusty = ImageIO.read(new File("surNuldermand.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		hm.put("Slimey", slimey);
		hm.put("Ratty", ratty);
		hm.put("Zwombie", zwombie);
		hm.put("Mimic", mimic);
		hm.put("Dragear", dragear);
		hm.put("Angry Dusty", angryDusty);
	}
	public BufferedImage getMobImage(String name){
		return hm.get(name);
	}
}
