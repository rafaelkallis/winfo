package we.are.awesome;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.TypedQuery;

@Named
@Stateless
public class MitarbeiterWorkspaceController extends WorkspaceController{

	public void taskZurueckweisen(){
		super.businessProcess.setVariable("action", "zurueckweisen");
		super.completeTask();
	}

	public void taskBearbeiten(){
		super.businessProcess.setVariable("action", "bearbeiten");
		super.completeTask();
	}

	public void taskVerschieben(){
		super.businessProcess.setVariable("action", "verschieben");
		super.completeTask();
	}

	public void newTask(){
		super.businessProcess.setVariable("action", "aufnehmen");
		super.completeTask();
	}

	public void logout(){
		super.businessProcess.setVariable("action","logout");
		super.completeTask();
	}
	
	public List<TaskDAO> getUserTaskList(){
		List<TaskDAO> taskList = new ArrayList<TaskDAO>();
		Long userId = (Long)super.businessProcess.getVariable("loggedUserId");
		TypedQuery<TaskEntity> query = entityManager.createQuery("SELECT t FROM TaskEntity t WHERE (t.assignedUserId='"+userId+"' OR t.isFreierTask=TRUE) AND t.isDone=FALSE",TaskEntity.class);
		List<TaskEntity> rs = query.getResultList();
		for(TaskEntity taskEntity : rs){
			taskList.add(new TaskDAO(taskEntity));
		}
		return taskList;	
	}
}
