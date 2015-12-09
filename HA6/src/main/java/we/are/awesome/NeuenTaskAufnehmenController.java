package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class NeuenTaskAufnehmenController extends Controller{

	public void call(String title, String description) {
		TaskEntity taskEntity = new TaskEntity(title,description);
		
		taskEntity.setNeedsReview(false);
		
		entityManager.persist(taskEntity);
		super.businessProcess.setVariable("taskId", taskEntity.getId());
		
		entityManager.flush();
	}
}
