package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class IsFreierTaskGatewayController extends Controller{
	
	public Boolean getIsFreierTask(Long taskId){
		
		return super.getTaskEntity(taskId).getIsFreierTask();
	}
}