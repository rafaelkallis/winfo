package we.are.awesome;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

public class MitarbeiterWorkspace extends Controller{
	private Boolean taskZurueckweisen 	= false;
	private Boolean	taskBearbeiten		= false;
	private Boolean	taskVerschieben		= false;
	private Boolean newTask				= false;
	private Boolean logout				= false;
		
	/*
	 * ("loddegUserId")
	 * + "taskId"
	 */
	public void taskZurueckweisen(Long taskId){
		this.taskZurueckweisen 	= true;
		
		super.businessProcess.setVariable("taskId", taskId);
		
		try {
			super.taskForm.completeProcessInstanceForm();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * ("loggedUserId")
	 * + "taskId
	 */
	public void taskBearbeiten(Long taskId){
		this.taskBearbeiten 	= true;
		
		super.businessProcess.setVariable("taskId", taskId);
		
		try {
			super.taskForm.completeProcessInstanceForm();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * ("loggedUserId")
	 * + "taskId
	 */
	public void taskVerschieben(Long taskId){
		this.taskVerschieben 	= true;
		
		super.businessProcess.setVariable("taskId", taskId);
		
		try {
			super.taskForm.completeProcessInstanceForm();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * ("loggedUserId")
	 * + "taskTitle"
	 * + "taskDescription"
	 */
	public void newTask(String title,String description){
		this.newTask			= true;
		
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
	 */
	public void logout(){
		this.logout = true;
		
		try {
			super.taskForm.completeProcessInstanceForm();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
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
