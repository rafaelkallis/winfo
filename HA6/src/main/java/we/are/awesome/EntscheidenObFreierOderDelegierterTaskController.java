package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class EntscheidenObFreierOderDelegierterTaskController extends Controller{
	
	public void submit() {
		Boolean isFreierTask 	= super.businessProcess.getVariable("isFreierTask");
		Long taskId 			= super.businessProcess.getVariable("taskId");

		TaskEntity taskEntity 	= super.getTaskEntity(taskId);
		taskEntity.setIsFreierTask(isFreierTask);
		
		super.entityManager.merge(taskEntity);
		super.entityManager.flush();
		
		super.completeTask();
	}
	
	public TaskDAO getTaskDAO(){
		Long taskId = super.businessProcess.getVariable("taskId");
		return new TaskDAO(super.getTaskEntity(taskId));
	}

	public Boolean getIsFreierTask(Long taskId){
		return super.getTaskEntity(taskId).getIsFreierTask();
	}
}
