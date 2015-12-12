package we.are.awesome;

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
		
		return this.entityManager.find(UserEntity.class, id);
	}
	
	protected TaskEntity getTaskEntity(Long id){
		
		return this.entityManager.find(TaskEntity.class, id);
	}
}
