package we.are.awesome;

import java.io.Serializable;

import org.camunda.bpm.engine.identity.User;

public class TodoDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private final String title;
	private final String description;
	private final Boolean isDone;
	private final User assignedUser;
	
	public TodoDAO(){
		this.title 			= null;
		this.description 	= null;
		this.isDone 		= null;
		this.assignedUser 	= null;
	}
	
	public TodoDAO(String title, String description,Boolean isDone, User assignedUser){
		this.title 			= title;
		this.description 	= description;
		this.isDone 		= isDone;
		this.assignedUser 	= assignedUser;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	public User getAssignedUser() {
		return assignedUser;
	}
}
