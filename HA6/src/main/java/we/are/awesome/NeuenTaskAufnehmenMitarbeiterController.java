package we.are.awesome;

import org.camunda.bpm.engine.delegate.DelegateExecution;

public class NeuenTaskAufnehmenMitarbeiterController extends ServiceTaskController {

	public void call(String title, String description){
		TaskEntity taskEntity = new TaskEntity(title,description);
		
		entityManager.persist(taskEntity);
		entityManager.flush();
	}

	/*
	 * (non-Javadoc)
	 * @see we.are.awesome.ServiceTaskController#call(org.camunda.bpm.engine.delegate.DelegateExecution)
	 * ("taskTitle","taskDescription","loggedUserId")
	 * - "taskTitle"
	 * - "taskDescription"
	 */
	@Override
	public void call(DelegateExecution delegateExecution) {
		String title = (String) delegateExecution.getVariable("taskTitle");
		String description = (String) delegateExecution.getVariable("taskDescription");
		
		TaskEntity taskEntity = new TaskEntity(title,description);
				
		entityManager.persist(taskEntity);
		
		delegateExecution.removeVariable("taskTitle");
		delegateExecution.removeVariable("taskDescription");
		
		entityManager.flush();
	}
}
