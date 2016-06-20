package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import mobData.Mob;

public class MobController {
	private ArrayList<String> mobs1 = new ArrayList<String>();
	private ArrayList<String> rareMobs1 = new ArrayList<String>();
	private ArrayList<String> mobNames1 = new ArrayList<String>();
	private ArrayList<String> rareMobNames1 = new ArrayList<String>();
	Random randomGenerator = new Random();
	private Mob mob;
	private int number;
	
	public MobController(){

		mobs1.add("25 3 10 10");
		mobs1.add("35 2 8 12");
		mobs1.add("70 1 13 15");
		mobs1.add("15 5 5 7");
		rareMobs1.add("65 2 25 20");
		rareMobs1.add("230 5 35 75");
		mobNames1.add("Slimey");
		mobNames1.add("Ratty");
		mobNames1.add("Zwombie");
		mobNames1.add("Angry Dusty");
		rareMobNames1.add("Mimic");
		rareMobNames1.add("Dragear");

	}
	public void createMob(int level){
		if(level == 1){
			int chance = randomGenerator.nextInt(10);
			if (chance < 9){
				number = randomGenerator.nextInt(mobs1.size());
				String[] splittet = mobs1.get(number).split("\\s+");
				mob = new Mob(Integer.parseInt(splittet[0]), Integer.parseInt(splittet[1]), Double.parseDouble(splittet[2]), Integer.parseInt(splittet[3]));
				mob.setName(mobNames1.get(number));
			}else if (chance == 9){
				number = randomGenerator.nextInt(rareMobs1.size());
				String[] splittet = rareMobs1.get(number).split("\\s+");
				mob = new Mob(Integer.parseInt(splittet[0]), Integer.parseInt(splittet[1]), Double.parseDouble(splittet[2]), Integer.parseInt(splittet[3]));
				mob.setName(rareMobNames1.get(number));
			}
		}
	}
	
	public Mob getCurrentMob(){
		return mob;
	}
}
