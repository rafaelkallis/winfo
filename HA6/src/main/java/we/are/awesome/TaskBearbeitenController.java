package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class TaskBearbeitenController extends Controller{
	
	public void submit(){
		super.completeTask();
	}
	
	public TaskDAO getTaskDAO(Long taskId){

		return new TaskDAO(super.getTaskEntity(taskId));
	}
}
