package we.are.awesome;

import java.io.IOException;

public class TaskBearbeitenController extends Controller{
	
	public void finish(){
		try {
			super.taskForm.completeTask();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public TaskDAO getTaskDAO(){
		Long taskId = super.businessProcess.getVariable("taskId");
		return new TaskDAO(super.getTaskEntity(taskId));
	}
}
