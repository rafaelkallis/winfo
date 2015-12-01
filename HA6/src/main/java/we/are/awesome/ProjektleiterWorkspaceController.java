package we.are.awesome;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

public class ProjektleiterWorkspaceController extends Controller {
	
	private Boolean taskAufnehmen 		= false;
	private Boolean taskUeberpruefen 	= false;
	private Boolean logout				= false;
	
	
	
	/*
	 * ("loggedUserId")
	 * + "taskTitle"
	 * + "taskDescription"
	 */
	public void newTask(String title, String description){
		this.taskAufnehmen = true;
		
		super.businessProcess.setVariable("taskTitle", title);
		super.businessProcess.setVariable("taskDescription",description);
		
		try {
			super.taskForm.completeProcessInstanceForm();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * ("loggedUserId")
	 * + "taskId"
	 */
	public void reviewTask(Long taskId){
		this.taskUeberpruefen = true;
		
		super.businessProcess.setVariable("taskId", taskId);
		
		try {
			super.taskForm.completeProcessInstanceForm();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * ("loggedUserId")
	 */
	public void logout(){
		this.logout = true;
		
		try {
			super.taskForm.completeProcessInstanceForm();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<TaskDAO> getZurueckgewieseneTasks(){
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
