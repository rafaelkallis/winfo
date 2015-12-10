package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

@Named
@Stateless
public class ProjektleiterWorkspaceController extends WorkspaceController {

	public void newTaskAction(){

		super.businessProcess.setVariable("actionProjektleiterWorkspaceController","newTask");
		super.completeTask();
	}

	public void reviewTaskAction(){

		super.businessProcess.setVariable("actionProjektleiterWorkspaceController","reviewTask");	
		super.completeTask();
	}

	public void logoutAction(){

		super.businessProcess.setVariable("actionProjektleiterWorkspaceController","logout");
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
