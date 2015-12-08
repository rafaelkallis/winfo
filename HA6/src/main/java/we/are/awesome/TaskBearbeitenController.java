package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class TaskBearbeitenController extends Controller{
	
	public TaskDAO getTaskDAO(){
		Long taskId = super.businessProcess.getVariable("taskId");
		return new TaskDAO(super.getTaskEntity(taskId));
	}
}
