package we.are.awesome;


public class NeuenTaskAufnehmenController extends Controller{

	/*
	 * (non-Javadoc)
	 * @see we.are.awesome.ServiceTaskController#call(org.camunda.bpm.engine.delegate.DelegateExecution)
	 * ("taskTitle","taskDescription","loggedUserId")
	 * - "title"
	 * - "description"
	 * + "taskId"
	 */
	public void call(String title, String description) {
		TaskEntity taskEntity = new TaskEntity(title,description);
		
		taskEntity.setNeedsReview(false);
		
		entityManager.persist(taskEntity);
		
		super.businessProcess.setVariable("taskId", taskEntity.id);
		
		entityManager.flush();
	}
}
