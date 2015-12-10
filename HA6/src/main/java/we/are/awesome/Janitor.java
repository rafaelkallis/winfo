package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;

@Named
@Stateless
public class Janitor {
	
	private static final String[] PROJEKTLEITER_WORKSPACE_PROCESS_VARIABLES = {"taskId","title","description","isFreierTask","assignedUserId","actionProjektleiterWorkspace"};
	private static final String[] MITARBEITER_WORKSPACE_PROCESS_VARIABLES = {"taskId","title","description","actionMitarbeiterWorkspace"}; 
	
	public void sanitizeProjektleiterProcessVariables(DelegateExecution execution){
		for(String processVariable : Janitor.PROJEKTLEITER_WORKSPACE_PROCESS_VARIABLES){
			execution.removeVariable(processVariable);
		}
	}
	
	public void sanitizeMitarbeiterProcessVariables(DelegateExecution execution){
		for(String processVariable : Janitor.MITARBEITER_WORKSPACE_PROCESS_VARIABLES){
			execution.removeVariable(processVariable);
		}
	}
}
