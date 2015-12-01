package we.are.awesome;

import org.camunda.bpm.engine.delegate.DelegateExecution;

public class TaskZurueckweisenController extends ServiceTaskController{
	
	/*
	 * ("taskId","loggeduserId")
	 *  - "taskId"
	 *  - "loggedUserId"
	 */
	@Override
	public void call(DelegateExecution delegateExecution) {
		//TODO parseLong
		Long taskId = (Long)delegateExecution.getVariable("taskId");
		TaskEntity taskEntity = entityManager.find(TaskEntity.class, taskId);
		
		taskEntity.setNeedsReview(true);
		taskEntity.setAssignedUserId(null);
		
		entityManager.merge(taskEntity);
		entityManager.flush();
		
		delegateExecution.removeVariable("taskId");
		delegateExecution.removeVariable("loggedUserId");
	}
}
