package we.are.awesome;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import org.camunda.bpm.engine.identity.User;

import java.io.Serializable;

@Entity
public class TodoEntity implements Serializable {

  private static  final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	protected Long 		id;
	
	protected String 	title;	  

	protected String 	description;
	
	protected Boolean 	isDone;
	
	protected User		assignedUser;
	  
	public TodoEntity(String title, String description,User assignedUser){
		this.title 			= title;
		this.description 	= description;
		this.isDone 		= false;
		this.assignedUser 	= assignedUser;
	}
	  
	public TodoEntity(){
		  
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

	public User getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(User assignedUser) {
		this.assignedUser = assignedUser;
	}
}

