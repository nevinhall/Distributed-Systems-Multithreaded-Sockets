

import java.io.Serializable;

import villians.SuperThing;

public class SuperHero implements SuperThing, Serializable {
	int goodness;
	public SuperHero(int goodness) {
		this.goodness = goodness;
		//System.out.println("I am a SuperHero, my goodness is:" + goodness);
		
	}
	@Override
	public void create(int strength) {
		// TODO Auto-generated method stub
		
	}

}
