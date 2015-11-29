package we.are.awesome;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.metamodel.EntityType;

import org.camunda.bpm.engine.cdi.BusinessProcess;
import org.camunda.bpm.engine.delegate.DelegateExecution;

@Stateless
@Named
public class TodoController {
	
	@Inject
	private BusinessProcess businessProcess;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	//all tasks
	private List<TodoDAO> taskList;
	//local task
	private String titleCache;
	
	public void addTask(DelegateExecution delegateExecution){
		String title 				= (String) delegateExecution.getVariable("title");
		String description 		= (String) delegateExecution.getVariable("description");
		TodoEntity todoEntity 	= new TodoEntity(title,description);
		
		entityManager.persist(todoEntity);
		entityManager.flush();
		
		delegateExecution.removeVariable("title");
		delegateExecution.removeVariable("description");
		delegateExecution.setVariable("todoId", todoEntity.getId());
	}
	
	public void removeTask(DelegateExecution delegateExecution){		
		entityManager.remove(entityManager.find(TodoEntity.class, businessProcess.getVariable("todoId")));
		entityManager.flush();
		
		delegateExecution.removeVariable("title");
	}
	
	public List<TodoDAO> getTaskList(){
		this.taskList = new ArrayList<TodoDAO>();	

		Query query = entityManager.createQuery("SELECT t FROM TodoEntity t");
		List<TodoEntity> rs = query.getResultList();
		for(TodoEntity todo : rs){
			this.taskList.add(new TodoDAO(todo.getTitle(),todo.getDescription()));
		}
		return this.taskList;

	}
	
	public String getTitleCache(){
		this.titleCache = this.entityManager.find(TodoEntity.class, businessProcess.getVariable("todoId")).getTitle();
		return this.titleCache;
	}
}
