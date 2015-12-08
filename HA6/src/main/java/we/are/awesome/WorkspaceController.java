package we.are.awesome;

public abstract class WorkspaceController extends Controller {

	public String getAction(){
		return super.businessProcess.getVariable("action");
	}
}
