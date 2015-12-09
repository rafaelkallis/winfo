package we.are.awesome;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.Query;

@Named
@Stateless
public class LoginController extends Controller { 
		
	public void login(){
		super.completeProcessInstanceForm();
	}
	
	public void register(){
		String userName 		= super.businessProcess.getVariable("userName");
		Boolean isProjektleiter = super.businessProcess.getVariable("isProjektleiter");
		
		Grouppe userGrouppe 	= isProjektleiter? Grouppe.Projektleiter : Grouppe.Mitarbeiter;
		UserEntity newUser 		= new UserEntity(userName,userGrouppe);
		
		super.entityManager.persist(newUser);
		super.entityManager.flush();
		
		super.businessProcess.setVariable("loggedUserId", newUser.getId());
				
		super.completeProcessInstanceForm();
	}
	
	public List<UserDAO> getUsers(){
		List<UserDAO> userList = new ArrayList<UserDAO>();	

		Query query = super.entityManager.createQuery("SELECT u FROM UserEntity u");
		List<UserEntity> rs = query.getResultList();
		for(UserEntity userEntity : rs){
			userList.add(new UserDAO(userEntity));		
		}
		return userList;
	}
	
	public Boolean getIsProjektleiter(Long loggedUserId){
		return super.getUserEntity(loggedUserId).getGrouppe() == Grouppe.Projektleiter;
	}
}
