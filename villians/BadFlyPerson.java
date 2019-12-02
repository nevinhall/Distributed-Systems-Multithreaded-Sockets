package villians;


public class BadFlyPerson extends SuperVillian {



	public BadFlyPerson(int badness) {
		super();
		this.description = "I am a BadFlyPerson, my Badness is " + badness;
		// TODO Auto-generated constructor stub
	}
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
