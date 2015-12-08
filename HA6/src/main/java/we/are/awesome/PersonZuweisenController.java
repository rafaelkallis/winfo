package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class PersonZuweisenController extends Controller {

	public void call(Long taskId,Long assignedUserId) {
		TaskEntity taskEntity = entityManager.find(TaskEntity.class, taskId);
		
		taskEntity.setAssignedUserId(assignedUserId);
		
		entityManager.merge(taskEntity);
		entityManager.flush();
	}
}
