package we.are.awesome;

public class TaskDAO{
	
	private final Long	 id;
	private final String title;
	private final String description;
	private final Boolean isDone;
	private final Long assignedUserId;
	private final Boolean needsReview;
	private final Boolean isFreierTask;
	
	public TaskDAO(TaskEntity entity){
		this.id					= entity.getId();
		this.title 				= entity.getTitle();
		this.description 		= entity.getDescription();
		this.isDone 			= entity.getIsDone();
		this.assignedUserId 	= entity.getAssignedUserId();
		this.needsReview		= entity.getNeedsReview();
		this.isFreierTask		= entity.getIsFreierTask();
	}
	
	public Long getId(){
		return this.id;
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

	public Long getAssignedUserId() {
		return assignedUserId;
	}
	
	public Boolean getNeedsReview(){
		return this.needsReview;
	}

	public Boolean getIsFreierTask() {
		return isFreierTask;
	}
}
