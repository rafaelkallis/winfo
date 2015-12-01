package we.are.awesome;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserEntity {
	
	@Id
	@GeneratedValue
	protected Long id;

	protected Grouppe grouppe;	
	protected String name;
	
	public UserEntity(){
		id = null;
	}
	
	public UserEntity(String name,Grouppe grouppe){
		this.name = name;
		this.grouppe = grouppe;
	}

	public Long getId() {
		return id;
	}

	public String getName(){
		return this.name;
	}

	public Grouppe getGrouppe() {
		return grouppe;
	}

	public void setGrouppe(Grouppe grouppe) {
		this.grouppe = grouppe;
	}
}
