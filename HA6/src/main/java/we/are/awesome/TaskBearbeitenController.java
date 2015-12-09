package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class TaskBearbeitenController extends Controller{
	
	public void submit(){
		super.completeTask();
	}
	
	public TaskDAO getTaskDAO(){
		Long taskId = Long.parseLong(super.businessProcess.getVariable("taskId").toString()); //FIXME: getVariable() returns String instead of Long when Task was made by Mitarbeiter
		return new TaskDAO(super.getTaskEntity(taskId));
	}
}
