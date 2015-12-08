package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class NeuenTaskAufnehmenMitarbeiterController extends Controller {

	public void call(String title, String description){
		TaskEntity taskEntity = new TaskEntity(title,description);
		
		entityManager.persist(taskEntity);
		entityManager.flush();
	}

//	/*
//	 * (non-Javadoc)
//	 * @see we.are.awesome.ServiceTaskController#call(org.camunda.bpm.engine.delegate.DelegateExecution)
//	 * ("taskTitle","taskDescription","loggedUserId")
//	 * - "taskTitle"
//	 * - "taskDescription"
//	 */
//	public void call(String title, String description) {
//		String title = (String) delegateExecution.getVariable("taskTitle");
//		String description = (String) delegateExecution.getVariable("taskDescription");
//		
//		TaskEntity taskEntity = new TaskEntity(title,description);
//				
//		entityManager.persist(taskEntity);
//		
//		entityManager.flush();
//	}
}
