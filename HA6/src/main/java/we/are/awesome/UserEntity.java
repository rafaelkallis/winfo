package we.are.awesome;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserEntity {
	
	@Id
	@GeneratedValue
	protected Long id;

	protected Boolean isProjektleiter;	
	protected String name;
	//protected Boolean isSignedIn; TODO
	
	protected UserEntity(){
		
	}
	
	public UserEntity(String name,Boolean isProjektleiter){
		this.name = name;
		this.isProjektleiter = isProjektleiter;
	}

	public Long getId() {
		return id;
	}

	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public Boolean getIsProjektleiter() {
		return this.isProjektleiter;
	}

	public void setIsProjektleiter(Boolean isProjektleiter) {
		this.isProjektleiter = isProjektleiter;
	}
}
