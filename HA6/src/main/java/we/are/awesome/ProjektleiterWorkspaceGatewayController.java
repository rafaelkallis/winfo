package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class ProjektleiterWorkspaceGatewayController extends Controller {

	public Boolean isAufnehmenAction(){
		
		return "aufnehmen".equals(super.businessProcess.getVariable("actionProjektleiterWorkspace"));
	}
	
	public Boolean isUeberpruefenAction(){
		
		return "ueberpruefen".equals(super.businessProcess.getVariable("actionProjektleiterWorkspace"));
	}
	
	public Boolean isLogoutAction(){
		
		return "logout".equals(super.businessProcess.getVariable("actionProjektleiterWorkspace"));
	}
}
