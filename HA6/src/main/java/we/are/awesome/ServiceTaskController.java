package we.are.awesome;

import org.camunda.bpm.engine.delegate.DelegateExecution;

public abstract class ServiceTaskController extends Controller {

	public abstract void call(DelegateExecution delegateExecution);

}
