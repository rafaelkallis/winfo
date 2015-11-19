package we.are.awesome;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.metamodel.EntityType;

import org.camunda.bpm.engine.cdi.BusinessProcess;
import org.camunda.bpm.engine.delegate.DelegateExecution;

@ConversationScoped
@Named
public class TodoController {
	
	@Inject
	private BusinessProcess businessProcess;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private TodoDAO todoCache;
	
	private List<TodoDAO> taskList;
	
	public void addTask(DelegateExecution delegateExecution){
		String title 			= (String) delegateExecution.getVariable("title");
		String description 		= (String) delegateExecution.getVariable("description");
		TodoEntity todoEntity 	= new TodoEntity(title,description);
		
		entityManager.persist(todoEntity);
		entityManager.flush();
	}
	
	public void removeTask(DelegateExecution delegateExecution){
		
		String title			= (String) delegateExecution.getVariable("title");
		
		entityManager.remove(entityManager.find(TodoEntity.class, title));
		entityManager.flush();
		
		delegateExecution.removeVariables();
	}
	
	public List<TodoDAO> getTaskList(){
		List<TodoDAO> todoList = new LinkedList<TodoDAO>();
		
		for(EntityType<?> todo : entityManager.getMetamodel().getEntities()){
			String title = ((TodoEntity)todo).getTitle();
			String description = ((TodoEntity)todo).getDescription();
			todoList.add(new TodoDAO(title,description));
		}
		
		return todoList;
	}
	
	public List<TodoDAO> getTaskList2(){
		List<TodoDAO> todoList = new LinkedList<TodoDAO>();
		Query query = entityManager.createQuery("SELECT t FROM TodoEntity t");
		for(TodoEntity todo : (Collection<TodoEntity>)query.getResultList()){
			String title = todo.getTitle();
			String description = todo.getDescription();
			todoList.add(new TodoDAO(title,description));
		}
		return todoList;
	}
	
	public TodoDAO getTodoCache(){
		if (todoCache == null){
			TodoEntity temp_entity = entityManager.find(TodoEntity.class, businessProcess.getVariable("title"));
			todoCache = new TodoDAO(temp_entity.getTitle(),temp_entity.getDescription());
		}
		return todoCache;
	}
	
}
