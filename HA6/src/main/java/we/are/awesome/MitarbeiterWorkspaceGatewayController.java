package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class MitarbeiterWorkspaceGatewayController extends Controller {
	
	public Boolean isAufnehmenAction(){
		
		return "aufnehmen".equals(super.businessProcess.getVariable("actionMitarbeiterWorkspace"));
	}
	
	public Boolean isBearbeitenAction(){
		
		return "bearbeiten".equals(super.businessProcess.getVariable("actionMitarbeiterWorkspace"));
	}
	
	public Boolean isZurueckweisenAction(){
		
		return "zurueckweisen".equals(super.businessProcess.getVariable("actionMitarbeiterWorkspace"));
	}
	
	public Boolean isLogoutAction(){
		
		return "logout".equals(super.businessProcess.getVariable("actionMitarbeiterWorkspace"));
	}
	
}
