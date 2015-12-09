package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class TaskZurueckweisenController extends Controller{
	
	public void reject(Long taskId) {
		TaskEntity taskEntity = entityManager.find(TaskEntity.class, taskId);
		
		taskEntity.setNeedsReview(true);
		taskEntity.setAssignedUserId(null);
		
		entityManager.merge(taskEntity);
		entityManager.flush();
	}
}
