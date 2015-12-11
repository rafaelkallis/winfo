package we.are.awesome;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.TypedQuery;

@Named
@Stateless
public class PersonAuswaehlenController extends Controller{
	
	public void submit(){
		
		super.completeTask();
	}
	
	public TaskDAO getTaskDAO(Long taskId){
 
		return new TaskDAO(super.getTaskEntity(taskId));
	}
	
	public List<UserDAO> getMitarbeiterUserList(){

		List<UserDAO> userList = new ArrayList<UserDAO>();	
		TypedQuery<UserEntity> query = super.entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.isProjektleiter = FALSE",UserEntity.class);
		List<UserEntity> rs = query.getResultList();
		for(UserEntity userEntity : rs){
			userList.add(new UserDAO(userEntity));		
		}
		return userList;
	}
}
