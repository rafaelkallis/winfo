package we.are.awesome;

import java.io.IOException;
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
		this.completeTask();
	}

	public void bearbeitenAction(){
		
		super.businessProcess.setVariable("actionMitarbeiterWorkspace", "bearbeiten");
		this.completeTask();
	}

	public void aufnehmenAction(){
		
		super.businessProcess.setVariable("actionMitarbeiterWorkspace", "aufnehmen");
		this.completeTask();
	}

	public void logoutAction(){
		
		super.businessProcess.setVariable("actionMitarbeiterWorkspace","logout");
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
	
	public List<TaskDAO> getUserTaskList(Long loggedUserId){
		
		List<TaskDAO> taskList = new ArrayList<TaskDAO>();
		TypedQuery<TaskEntity> query = entityManager.createQuery("SELECT t FROM TaskEntity t WHERE (t.assignedUserId = :loggedUserId OR t.isFreierTask = TRUE) AND t.isDone = FALSE",TaskEntity.class).setParameter("loggedUserId",loggedUserId);
		List<TaskEntity> rs = query.getResultList();
		for(TaskEntity taskEntity : rs){
			taskList.add(new TaskDAO(taskEntity));
		}
		return taskList;	
	}
}
