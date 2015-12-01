package we.are.awesome;

import org.camunda.bpm.engine.delegate.DelegateExecution;

public class TaskUeberpruefenController extends ServiceTaskController {

	/*
	 * (non-Javadoc)
	 * @see we.are.awesome.ServiceTaskController#call(org.camunda.bpm.engine.delegate.DelegateExecution)
	 * ("taskId","loggedUserId")
	 */
	@Override
	public void call(DelegateExecution delegateExecution) {
		Long taskId = (Long) delegateExecution.getVariable("taskId");
		TaskEntity taskEntity = super.getTaskEntity(taskId);
		
		taskEntity.setNeedsReview(false);
		
		super.entityManager.merge(taskEntity);
		super.entityManager.flush();
	}

}
