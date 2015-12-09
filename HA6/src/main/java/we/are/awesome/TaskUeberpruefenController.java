package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class TaskUeberpruefenController extends Controller {

	public void call(Long taskId) {
		TaskEntity taskEntity = super.getTaskEntity(taskId);
		
		taskEntity.setNeedsReview(false);
		
		super.entityManager.merge(taskEntity);
		super.entityManager.flush();
	}

}
