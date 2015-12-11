package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class PersonZuweisenController extends Controller {

	public void assign(Long taskId,Long assignedUserId) {
		
		TaskEntity taskEntity = super.entityManager.find(TaskEntity.class, taskId);
		taskEntity.setAssignedUserId(assignedUserId);
		super.entityManager.merge(taskEntity);
		super.entityManager.flush();
	}
}
