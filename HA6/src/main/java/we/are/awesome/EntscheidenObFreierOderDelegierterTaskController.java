package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class EntscheidenObFreierOderDelegierterTaskController extends Controller{
	
	public void submit() {
		Boolean isFreierTask 	= super.businessProcess.getVariable("isFreierTask");
		Long taskId 			= Long.parseLong(super.businessProcess.getVariable("taskId").toString()); //FIXME: getVariable() returns String instead of Long when Task was made by Mitarbeiter
		TaskEntity taskEntity 	= super.getTaskEntity(taskId);
		taskEntity.setIsFreierTask(isFreierTask);
		super.entityManager.merge(taskEntity);
		super.entityManager.flush();
		super.completeTask();
	}
	
	public TaskDAO getTaskDAO(){
		Long taskId = Long.parseLong(super.businessProcess.getVariable("taskId").toString()); //FIXME: getVariable() returns String instead of Long when Task was made by Mitarbeiter
		return new TaskDAO(super.getTaskEntity(taskId));
	}

	public Boolean getIsFreierTask(Long taskId){
		return super.getTaskEntity(taskId).getIsFreierTask();
	}
}
