package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.cdi.BusinessProcess;
import org.camunda.bpm.engine.cdi.jsf.TaskForm;

@Stateless
@Named
public abstract class Controller {
	
	@Inject
	protected BusinessProcess businessProcess;
	
	@Inject
	protected ProcessEngine processEngine;
	
	@Inject
	protected TaskForm	taskForm;
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	protected UserDAO getUserDAO(Long id){
		return new UserDAO(this.getUserEntity(id));
	}
	
	protected TaskDAO getTaskDAO(Long id){
		return new TaskDAO(this.getTaskEntity(id));
	}
	
	protected UserEntity getUserEntity(Long id){
		return entityManager.find(UserEntity.class, id);
	}
	
	protected TaskEntity getTaskEntity(Long id){
		return entityManager.find(TaskEntity.class, id);
	}
}
