package we.are.awesome;

import java.io.IOException;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class TaskBearbeitenController extends Controller{
	
	public void complete(Long taskId){
		
		TaskEntity taskEntity = super.entityManager.find(TaskEntity.class, taskId);
		taskEntity.setIsDone(true);				
		super.entityManager.merge(taskEntity);
		super.entityManager.flush();
		this.completeTask();
	}
	
	public void postpone(){
		
		this.completeTask();
	}
	
	private void completeTask(){
		
		try {
			super.taskForm.completeTask();
		} catch (IOException e){
			throw new RuntimeException(e);
		}
	}
	
	public TaskDAO getTaskDAO(Long taskId){

		return new TaskDAO(super.getTaskEntity(taskId));
	}
}
