package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

@Named
@Stateless
public class ProjektleiterWorkspaceController extends Controller {

	public void aufnehmenAction(){

		super.businessProcess.setVariable("actionProjektleiterWorkspace","aufnehmen");
		super.completeTask();
	}

	public void ueberpruefenAction(){

		super.businessProcess.setVariable("actionProjektleiterWorkspace","ueberpruefen");	
		super.completeTask();
	}

	public void logoutAction(){

		super.businessProcess.setVariable("actionProjektleiterWorkspace","logout");
		super.completeTask();
	}
	
	public List<TaskDAO> getNotReviewedTasks(){

		List<TaskDAO> taskList = new ArrayList<TaskDAO>();
		TypedQuery<TaskEntity> query = super.entityManager.createQuery("SELECT t FROM TaskEntity t WHERE t.needsReview = TRUE",TaskEntity.class);
		List<TaskEntity> rs = query.getResultList();
		for(TaskEntity taskEntity : rs){
			taskList.add(new TaskDAO(taskEntity));
		}
		return taskList;
	}
}
