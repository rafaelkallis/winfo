package we.are.awesome;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class TaskEntity{

	@Id
	@GeneratedValue
	protected Long 			id;
	
	protected String 		title;	  

	protected String 		description;
	
	protected Boolean 		isDone;
	
	protected Boolean		needsReview;
	
	protected Boolean		isFreierTask;
	
	protected Long			assignedUserId;
	  
	protected TaskEntity(){
		  
	}
	
	public TaskEntity(String title, String description){
		this.title 				= title;
		this.description 		= description;
		this.isDone 			= false;
		this.needsReview		= true;
		this.isFreierTask		= null;
		this.assignedUserId		= null;
	}

	public Long getId() {
		return id;
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

	public Boolean getNeedsReview(){
		return this.needsReview;
	}
	
	public void setNeedsReview(Boolean needsReview){
		this.needsReview = needsReview;
	}
	
	public Long getAssignedUserId() {
		return assignedUserId;
	}

	public void setAssignedUserId(Long assignedUserId) {
		this.assignedUserId = assignedUserId;
	}

	public Boolean getIsFreierTask() {
		return isFreierTask;
	}

	public void setIsFreierTask(Boolean isFreierTask) {
		this.isFreierTask = isFreierTask;
	}
}

