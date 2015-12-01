package we.are.awesome;

import org.camunda.bpm.engine.delegate.DelegateExecution;

public class TaskFertigstellenController extends ServiceTaskController {

	@Override
	public void call(DelegateExecution delegateExecution) {
		delegateExecution.removeVariable("taskId");
	}

}
