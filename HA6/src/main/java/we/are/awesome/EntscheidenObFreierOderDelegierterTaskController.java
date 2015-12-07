package we.are.awesome;

import java.io.IOException;

public class EntscheidenObFreierOderDelegierterTaskController extends Controller{
	
	protected Boolean isFreierTask;
	
	/*
	 * ("taskId","loggedUserId")
	 */
	public void call(Boolean isFreierTask) {
		this.isFreierTask = isFreierTask;
		Long taskId = super.businessProcess.getVariable("taskId");
		TaskEntity taskEntity = super.getTaskEntity(taskId);
		taskEntity.setIsFreierTask(isFreierTask);
		
		super.entityManager.merge(taskEntity);
		super.entityManager.flush();
		
		try {
			super.taskForm.completeProcessInstanceForm();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public TaskDAO getTaskDAO(){
		Long taskId = super.businessProcess.getVariable("taskId");
		return new TaskDAO(super.getTaskEntity(taskId));
	}

	public void setIsFreierterTask(Boolean isFreierTask) {
		this.isFreierTask = isFreierTask;
	}
	
	public Boolean getIsFreierTak(){
		return this.isFreierTask;
	}
	
}
