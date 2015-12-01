package we.are.awesome;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

public class LoginController extends Controller { 
	
	private Boolean isProjektleiter;
	
	/*
	 * + "loggedUserId"
	 */
	public void login(Long userId){
		super.businessProcess.setVariable("loggedUserId", userId);
		
		this.isProjektleiter = super.getUserEntity(userId).getGrouppe() == Grouppe.Projektleiter;
		
		try {
			super.taskForm.completeProcessInstanceForm();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * + "loggedUserId"
	 */
	public void register(String userName, Boolean isProjektleiter){
		Grouppe userGrouppe = isProjektleiter? Grouppe.Projektleiter : Grouppe.Mitarbeiter;
		UserEntity newUser = new UserEntity(userName,userGrouppe);
		
		entityManager.persist(newUser);
		entityManager.flush();
		
		super.businessProcess.setVariable("loggedUserId", newUser.getId());
		
		this.isProjektleiter = isProjektleiter;
		
		try {
			super.taskForm.completeProcessInstanceForm();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Boolean getIsProjektleiter(){
		return this.isProjektleiter;
	}
	
	public List<UserDAO> getUsers(){
		List<UserDAO> userList = new ArrayList<UserDAO>();	

		Query query = entityManager.createQuery("SELECT u FROM UserEntity u");
		List<UserEntity> rs = query.getResultList();
		for(UserEntity userEntity : rs){
			userList.add(new UserDAO(userEntity));		
		}
		return userList;
	}
}
