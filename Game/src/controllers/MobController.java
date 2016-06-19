package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import mobData.Mob;

public class MobController {
	private ArrayList<int[]> mobs1 = new ArrayList<int[]>();
	private ArrayList<int[]> rareMobs1 = new ArrayList<int[]>();
	private ArrayList<String> mobNames1 = new ArrayList<String>();
	private ArrayList<String> rareMobNames1 = new ArrayList<String>();
	Random randomGenerator = new Random();
	private Mob mob;
	private int number;
	
	public MobController(){

		mobs1.add(new int[] {25, 3});
		mobs1.add(new int[] {35, 2});
		mobs1.add(new int[] {70, 1});
		rareMobs1.add(new int[] {65, 2});
		rareMobs1.add(new int[] {230, 5});
		mobNames1.add("Slimey");
		mobNames1.add("Ratty");
		mobNames1.add("Zwombie");
		rareMobNames1.add("Mimic");
		rareMobNames1.add("Dragear");

	}
	public void createMob(int level){
		if(level == 1){
			int chance = randomGenerator.nextInt(10);
			if (chance < 9){
				number = randomGenerator.nextInt(mobs1.size());
				mob = new Mob(mobs1.get(number)[0], mobs1.get(number)[1]);
				mob.setName(mobNames1.get(number));
			}else if (chance == 9){
				number = randomGenerator.nextInt(rareMobs1.size());
				mob = new Mob(rareMobs1.get(number)[0], rareMobs1.get(number)[1]);
				mob.setName(rareMobNames1.get(number));
			}
		}
	}
	
	public Mob getCurrentMob(){
		return mob;
	}
}
