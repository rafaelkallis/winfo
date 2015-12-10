package we.are.awesome;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class IsProjektleiterGatewayController extends Controller{
	
	public Boolean getIsProjektleiter(Long loggedUserId){
		
		return super.getUserEntity(loggedUserId).getIsProjektleiter();
	}
}