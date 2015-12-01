package we.are.awesome;

import org.camunda.bpm.engine.delegate.DelegateExecution;

public class TaskAlsErledigtMarkierenController extends ServiceTaskController {

	/*
	 * (non-Javadoc)
	 * @see we.are.awesome.ServiceTaskController#call(org.camunda.bpm.engine.delegate.DelegateExecution)
	 * ("taskId","loggedUserId")
	 */
	@Override
	public void call(DelegateExecution delegateExecution) {
		//TODO parseLong
		Long taskId = (Long)delegateExecution.getVariable("taskId");
		
		TaskEntity taskEntity = entityManager.find(TaskEntity.class, taskId);
		
		taskEntity.setIsDone(true);				
		super.entityManager.merge(taskEntity);
		super.entityManager.flush();
		
		delegateExecution.removeVariable("taskId");
	}
}
