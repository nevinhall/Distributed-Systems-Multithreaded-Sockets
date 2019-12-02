package villians;


import java.io.Serializable;




public class SuperVillian implements SuperThing ,Serializable {
	int badness;
	protected String description;


	@Override
	public void create(int badness) {
		this.badness = badness;
		
		
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

}
