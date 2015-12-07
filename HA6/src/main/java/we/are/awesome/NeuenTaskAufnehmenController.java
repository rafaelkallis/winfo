package we.are.awesome;

import org.camunda.bpm.engine.delegate.DelegateExecution;

public class NeuenTaskAufnehmenController extends ServiceTaskController{

	/*
	 * (non-Javadoc)
	 * @see we.are.awesome.ServiceTaskController#call(org.camunda.bpm.engine.delegate.DelegateExecution)
	 * ("taskTitle","taskDescription","loggedUserId")
	 * - "taskTitle"
	 * - "taskDescription"
	 * + "taskId"
	 */
	@Override
	public void call(DelegateExecution delegateExecution) {
		String title = (String) delegateExecution.getVariable("taskTitle");
		String description = (String) delegateExecution.getVariable("taskDescription");
		
		TaskEntity taskEntity = new TaskEntity(title,description);
		
		taskEntity.setNeedsReview(false);
		
		entityManager.persist(taskEntity);
		
		delegateExecution.setVariable("taskId", taskEntity.id);
		delegateExecution.removeVariable("taskTitle");
		delegateExecution.removeVariable("taskDescription");
		
		entityManager.flush();
	}
}
