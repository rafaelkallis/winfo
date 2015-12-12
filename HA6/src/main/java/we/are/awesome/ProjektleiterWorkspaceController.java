package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

@Named
@Stateless
public class ProjektleiterWorkspaceController extends Controller {

	public void aufnehmenAction(){

		super.businessProcess.setVariable("actionProjektleiterWorkspace","aufnehmen");
		this.completeTask();
	}

	public void ueberpruefenAction(){

		super.businessProcess.setVariable("actionProjektleiterWorkspace","ueberpruefen");	
		this.completeTask();
	}

	public void logoutAction(){

		super.businessProcess.setVariable("actionProjektleiterWorkspace","logout");
		this.completeTask();
	}
	
	private void completeTask(){
		
		try {
			this.taskForm.completeTask();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getUserName(Long userId){
		return super.getUserEntity(userId).getName();
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
