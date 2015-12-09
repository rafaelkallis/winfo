package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class NeuenTaskAufnehmenMitarbeiterController extends Controller {

	public void add(String title, String description){
		TaskEntity taskEntity = new TaskEntity(title,description);
		
		entityManager.persist(taskEntity);		
		entityManager.flush();
	}
}
