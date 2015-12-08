package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class TaskAlsErledigtMarkierenController extends Controller {

	public void call(Long taskId) {
		
		TaskEntity taskEntity = super.entityManager.find(TaskEntity.class, taskId);
		
		taskEntity.setIsDone(true);				
		super.entityManager.merge(taskEntity);
		super.entityManager.flush();
	}
}
