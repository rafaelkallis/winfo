package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.camunda.bpm.engine.cdi.BusinessProcess;
import org.camunda.bpm.engine.cdi.jsf.TaskForm;
import org.camunda.bpm.engine.delegate.DelegateExecution;

@Stateless
@Named
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
	
//	public void assertCurrentTaskId(DelegateExecution execution){
//		assert(this.businessProcess.getVariable("taskId") == execution.getVariable("taskId"));
//	}
//	
//	public void assertCurrentLoggedUserId(DelegateExecution execution){
//		assert(this.businessProcess.getVariable("loggedUserId") == execution.getVariable("loggedUserId"));
//	}
//	
//	public void assertTaskTitle(DelegateExecution execution){
//		assert(this.businessProcess.getVariable("taskTitle") == execution.getVariable("taskTitle"));
//	}
	
//	public void assertTaskDescription(DelegateExecution execution){
//		assert(this.businessProcess.getVariable("taskDescription") == execution.getVariable("taskDescription"));
//	}
//	
//	public void assertAll(DelegateExecution execution){
//		this.assertCurrentLoggedUserId(execution);
//		this.assertCurrentTaskId(execution);
//		this.assertTaskDescription(execution);
//		this.assertTaskTitle(execution);
//	}
}
