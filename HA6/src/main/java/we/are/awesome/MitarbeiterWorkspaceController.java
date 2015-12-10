package we.are.awesome;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.TypedQuery;

@Named
@Stateless
public class MitarbeiterWorkspaceController extends Controller{
	
	public void zurueckweisenAction(){
		
		super.businessProcess.setVariable("actionMitarbeiterWorkspace", "zurueckweisen");
		super.completeTask();
	}

	public void bearbeitenAction(){
		
		super.businessProcess.setVariable("actionMitarbeiterWorkspace", "bearbeiten");
		super.completeTask();
	}

	//TODO
	public void verschiebenAction(){
		
		super.businessProcess.setVariable("actionMitarbeiterWorkspace", "verschieben");
		super.completeTask();
	}

	public void aufnehmenAction(){
		
		super.businessProcess.setVariable("actionMitarbeiterWorkspace", "aufnehmen");
		super.completeTask();
	}

	public void logoutAction(){
		
		super.businessProcess.setVariable("actionMitarbeiterWorkspace","logout");
		super.completeTask();
	}
	
	public List<TaskDAO> getUserTaskList(){
		
		List<TaskDAO> taskList = new ArrayList<TaskDAO>();
		Long userId = (Long)super.businessProcess.getVariable("loggedUserId");
		TypedQuery<TaskEntity> query = entityManager.createQuery("SELECT t FROM TaskEntity t WHERE (t.assignedUserId = :userId OR t.isFreierTask = TRUE) AND t.isDone = FALSE",TaskEntity.class).setParameter("userId",userId);
		List<TaskEntity> rs = query.getResultList();
		for(TaskEntity taskEntity : rs){
			taskList.add(new TaskDAO(taskEntity));
		}
		return taskList;	
	}
}
