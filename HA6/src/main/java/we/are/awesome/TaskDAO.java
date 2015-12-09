package we.are.awesome;

public class TaskDAO{
	
	private	final Long	 id;
	private final String title;
	private final String description;
	
	public TaskDAO(TaskEntity entity){
		this.id					= entity.getId();
		this.title 				= entity.getTitle();
		this.description 		= entity.getDescription();
	}
	
	public Long getId(){
		return this.id;
	}
	
	public String getTitle() {
		return this.title;
	}

	public String getDescription() {
		return this.description;
	}
}
