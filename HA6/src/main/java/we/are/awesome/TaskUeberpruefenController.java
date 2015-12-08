package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class TaskUeberpruefenController extends Controller {

	/*
	 * (non-Javadoc)
	 * @see we.are.awesome.ServiceTaskController#call(org.camunda.bpm.engine.delegate.DelegateExecution)
	 * ("taskId","loggedUserId")
	 */
	public void call(Long taskId) {
		TaskEntity taskEntity = super.getTaskEntity(taskId);
		
		taskEntity.setNeedsReview(false);
		
		super.entityManager.merge(taskEntity);
		super.entityManager.flush();
	}

}
