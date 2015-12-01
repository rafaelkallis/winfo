package we.are.awesome;

import org.camunda.bpm.engine.delegate.DelegateExecution;

public class PersonZuweisenController extends ServiceTaskController {

	@Override
	public void call(DelegateExecution delegateExecution) {
		Long taskId = (Long) delegateExecution.getVariable("taskId");
		Long assignedUserId = (Long) delegateExecution.getVariable("assignedUserId");

		TaskEntity taskEntity = entityManager.find(TaskEntity.class, taskId);
		
		taskEntity.setAssignedUserId(assignedUserId);
		entityManager.merge(taskEntity);
		entityManager.flush();
		
		delegateExecution.removeVariable("taskId");
		delegateExecution.removeVariable("assignedUserId");
	}

}
