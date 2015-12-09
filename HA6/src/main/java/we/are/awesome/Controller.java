package we.are.awesome;

import java.io.IOException;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.camunda.bpm.engine.cdi.BusinessProcess;
import org.camunda.bpm.engine.cdi.jsf.TaskForm;

public abstract class Controller {
	
	@Inject
	protected BusinessProcess businessProcess;
	
	@Inject
	protected TaskForm	taskForm;
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	protected UserEntity getUserEntity(Long id){
		return entityManager.find(UserEntity.class, id);
	}
	
	protected TaskEntity getTaskEntity(Long id){
		return entityManager.find(TaskEntity.class, id);
	}
	
	protected void completeProcessInstanceForm(){
		try {
			this.taskForm.completeProcessInstanceForm();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	protected void completeTask(){
		try {
			this.taskForm.completeTask();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	protected Long debugLoggedUserId(){
		return this.businessProcess.getVariable("loggedUserId");
	}
	
	protected String debugLoggedUserName(){
		return this.getUserEntity((Long)this.businessProcess.getVariable("loggedUserId")).getName();
	}
	
	protected Long debugTaskId(){
		return this.businessProcess.getVariable("taskId");
	}
	
	protected String debugTaskTitle(){
		return this.getTaskEntity((Long)this.businessProcess.getVariable("taskId")).getTitle();
	}
}
