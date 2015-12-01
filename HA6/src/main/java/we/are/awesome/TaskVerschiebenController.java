package we.are.awesome;

import org.camunda.bpm.engine.delegate.DelegateExecution;

public class TaskVerschiebenController extends ServiceTaskController{

	/*
	 * (non-Javadoc)
	 * @see we.are.awesome.ServiceTaskController#call(org.camunda.bpm.engine.delegate.DelegateExecution)
	 *	("taskId","loggedUserId")
	 */
	@Override
	public void call(DelegateExecution delegateExecution) {
		delegateExecution.removeVariable("taskId");
	}

}
