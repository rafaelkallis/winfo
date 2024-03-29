package we.are.awesome;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.TypedQuery;

@Named
@Stateless
public class PersonAuswaehlenController extends Controller{
	
	public void assign(Long userId,Long taskId){
		
		TaskEntity task = super.getTaskEntity(taskId);
		task.setAssignedUserId(userId);
		
		super.entityManager.merge(task);
		super.entityManager.flush();
		
		try {
			this.taskForm.completeTask();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}	
	}
	
	public TaskDAO getTaskDAO(Long taskId){
 
		return new TaskDAO(super.getTaskEntity(taskId));
	}
	
	public List<UserDAO> getMitarbeiterList(){

		List<UserDAO> userList = new ArrayList<UserDAO>();	
		TypedQuery<UserEntity> query = super.entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.isProjektleiter = FALSE",UserEntity.class);
		List<UserEntity> rs = query.getResultList();
		for(UserEntity userEntity : rs){
			userList.add(new UserDAO(userEntity));		
		}
		return userList;
	}
}
