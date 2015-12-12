package we.are.awesome;

import java.io.IOException;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class EntscheidenObFreierOderDelegierterTaskController extends Controller{
	
	public void submit(Long taskId, Boolean isFreierTask) {
		
		TaskEntity taskEntity 	= super.getTaskEntity(taskId);
		taskEntity.setIsFreierTask(isFreierTask);
		super.entityManager.merge(taskEntity);
		super.entityManager.flush();
		this.completeTask();
	}
	
	private void completeTask(){
		
		try {
			this.taskForm.completeTask();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public TaskDAO getTaskDAO(Long taskId){
 
 		return new TaskDAO(super.getTaskEntity(taskId));
	}
}
