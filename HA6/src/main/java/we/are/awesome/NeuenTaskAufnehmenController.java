package we.are.awesome;

import org.camunda.bpm.engine.delegate.DelegateExecution;

public class NeuenTaskAufnehmenController extends ServiceTaskController{

	/*
	 * (non-Javadoc)
	 * @see we.are.awesome.ServiceTaskController#call(org.camunda.bpm.engine.delegate.DelegateExecution)
	 * ("taskTitle","taskDescription","loggedUserId")
	 * - "title"
	 * - "description"
	 * + "taskId"
	 */
	@Override
	public void call(String title, String description) {
		TaskEntity taskEntity = new TaskEntity(title,description);
		
		taskEntity.setNeedsReview(false);
		
		entityManager.persist(taskEntity);
		
		delegateExecution.setVariable("taskId", taskEntity.id);
		
		entityManager.flush();
	}
}
