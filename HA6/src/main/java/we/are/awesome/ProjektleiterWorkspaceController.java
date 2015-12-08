package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

@Named
@Stateless
public class ProjektleiterWorkspaceController extends Controller {
	
	private Boolean taskAufnehmen 		= false;
	private Boolean taskUeberpruefen 	= false;
	private Boolean logout				= false;

	/*
	 * ("loggedUserId")
	 * + "title"
	 * + "description"
	 */
	public void newTask(){
		this.taskAufnehmen = true;
		
		super.completeTask();
	}
	
	/*
	 * ("loggedUserId")
	 * + "selectedTaskId"
	 */
	public void reviewTask(){
		this.taskUeberpruefen = true;
				
		super.completeTask();
	}
	
	/*
	 * ("loggedUserId")
	 */
	public void logout(){
		this.logout = true;
		
		super.completeTask();
	}
	
	public List<TaskDAO> getNotReviewedTasks(){
		List<TaskDAO> taskList = new ArrayList<TaskDAO>();
		
		Query query = entityManager.createQuery("SELECT t FROM TaskEntity t WHERE t.needsReview=TRUE");
		List<TaskEntity> rs = query.getResultList();
		for(TaskEntity taskEntity : rs){
			taskList.add(new TaskDAO(taskEntity));
		}
		return taskList;
	}

	public Boolean getTaskAufnehmen() {
		return taskAufnehmen;
	}

	public Boolean getTaskUeberpruefen() {
		return taskUeberpruefen;
	}
	
	public Boolean getLogout(){
		return this.logout;
	}
}
