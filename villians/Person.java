package villians;

import java.io.Serializable;

public class Person implements Serializable {
	String description;
	public Person() {
		this.description = "I am a Person";
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
		
}
 

