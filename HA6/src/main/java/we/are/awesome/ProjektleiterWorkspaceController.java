package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

@Named
@Stateless
public class ProjektleiterWorkspaceController extends WorkspaceController {

	public void newTask(){
		super.businessProcess.setVariable("action","newTask");
		super.completeTask();
	}

	public void reviewTask(){
		super.businessProcess.setVariable("action","reviewTask");	
		super.completeTask();
	}

	public void logout(){
		super.businessProcess.setVariable("action","logout");
		super.completeTask();
	}
	
	public List<TaskDAO> getNotReviewedTasks(){
		List<TaskDAO> taskList = new ArrayList<TaskDAO>();
		
		Query query = super.entityManager.createQuery("SELECT t FROM TaskEntity t WHERE t.needsReview=TRUE");
		List<TaskEntity> rs = query.getResultList();
		for(TaskEntity taskEntity : rs){
			taskList.add(new TaskDAO(taskEntity));
		}
		return taskList;
	}
}
