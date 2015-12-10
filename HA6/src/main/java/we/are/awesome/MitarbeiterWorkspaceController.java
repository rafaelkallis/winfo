package we.are.awesome;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.TypedQuery;

@Named
@Stateless
public class MitarbeiterWorkspaceController extends WorkspaceController{

	public void zurueckweisenAction(){
		
		super.businessProcess.setVariable("actionMitarbeiterWorkspaceController", "zurueckweisen");
		super.completeTask();
	}

	public void bearbeitenAction(){
		
		super.businessProcess.setVariable("actionMitarbeiterWorkspaceController", "bearbeiten");
		super.completeTask();
	}

	public void taskVerschiebenAction(){
		
		super.businessProcess.setVariable("actionMitarbeiterWorkspaceController", "verschieben");
		super.completeTask();
	}

	public void newTaskAction(){
		
		super.businessProcess.setVariable("actionMitarbeiterWorkspaceController", "aufnehmen");
		super.completeTask();
	}

	public void logoutAction(){
		
		super.businessProcess.setVariable("actionMitarbeiterWorkspaceController","logout");
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
