package we.are.awesome;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.TypedQuery;

@Named
@Stateless
public class LoginController extends Controller { 
		
	public void login(){

		this.completeProcessInstanceForm();
	}
	
	protected void completeProcessInstanceForm(){
		
		try {
			this.taskForm.completeProcessInstanceForm();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void register(String userName, Boolean isProjektleiter){
		 		
		UserEntity newUser 		= new UserEntity(userName,isProjektleiter);	
		super.entityManager.persist(newUser);
		super.businessProcess.setVariable("loggedUserId", newUser.getId());	
		super.entityManager.flush();		
		this.login();
	}
	
	public List<UserDAO> getUsers(){

		List<UserDAO> userList = new ArrayList<UserDAO>();	
		TypedQuery<UserEntity> query = super.entityManager.createQuery("SELECT u FROM UserEntity u",UserEntity.class);
		List<UserEntity> rs = query.getResultList();
		for(UserEntity userEntity : rs){
			userList.add(new UserDAO(userEntity));		
		}
		return userList;
	}
}
