package we.are.awesome;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

public class MitarbeiterWorkspaceController extends Controller{
	private Boolean taskZurueckweisen 	= false;
	private Boolean	taskBearbeiten		= false;
	private Boolean	taskVerschieben		= false;
	private Boolean newTask				= false;
	private Boolean logout				= false;
		
	/*
	 * ("loddegUserId")
	 * + "taskId"
	 */
	public void taskZurueckweisen(){
		this.taskZurueckweisen 	= true;
		
		super.completeProcessInstanceForm();
	}
	
	/*
	 * ("loggedUserId")
	 * + "taskId"
	 */
	public void taskBearbeiten(){
		this.taskBearbeiten 	= true;
		
		super.completeProcessInstanceForm();
	}
	
	/*
	 * ("loggedUserId")
	 * + "taskId"
	 */
	public void taskVerschieben(){
		this.taskVerschieben 	= true;
		
		super.completeProcessInstanceForm();
	}
	
	/*
	 * ("loggedUserId")
	 * + "title"
	 * + "description"
	 */
	public void newTask(){
		this.newTask			= true;
		
		super.completeProcessInstanceForm();
	}
	
	/*
	 * ("loggedUserId")
	 */
	public void logout(){
		this.logout = true;
		
		super.completeProcessInstanceForm();
	}
	
	protected List<TaskDAO> getUserTaskList(){
		List<TaskDAO> taskList = new ArrayList<TaskDAO>();
		Long userId = (Long)super.businessProcess.getVariable("loggedUserId");
		Query query = entityManager.createQuery("SELECT t FROM TaskEntity t WHERE (t.assignedUserId='"+userId+"' OR t.isFreierTask=TRUE) AND t.isDone=FALSE");
		List<TaskEntity> rs = query.getResultList();
		for(TaskEntity taskEntity : rs){
			taskList.add(new TaskDAO(taskEntity));
		}
		return taskList;	
	}

	public Boolean getTaskZurueckweisen() {
		return taskZurueckweisen;
	}

	public Boolean getTaskBearbeiten() {
		return taskBearbeiten;
	}

	public Boolean getTaskVerschieben() {
		return taskVerschieben;
	}
	
	public Boolean getNewTask() {
		return newTask;
	}
	
	public Boolean getLogout(){
		return logout;
	}
}
