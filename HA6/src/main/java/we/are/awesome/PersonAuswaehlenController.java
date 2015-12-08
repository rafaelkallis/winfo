package we.are.awesome;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.Query;

@Named
@Stateless
public class PersonAuswaehlenController extends Controller{
	
	public TaskDAO getTaskDAO(){
		Long taskId = super.businessProcess.getVariable("taskId");
		return new TaskDAO(super.getTaskEntity(taskId));
	}
	
	public List<UserDAO> getMitarbeiterUserList(){
		List<UserDAO> userList = new ArrayList<UserDAO>();	

		Query query = super.entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.grouppe=we.are.awesome.Grouppe.Mitarbeiter");
		List<UserEntity> rs = query.getResultList();
		for(UserEntity userEntity : rs){
			userList.add(new UserDAO(userEntity));		
		}
		return userList;
	}
	
	public Integer getNAssignedTasks(){		
		Long userId = super.businessProcess.getVariable("selectedUserId");
		if(userId == null){
			return 0;
		}else{
			Query query = super.entityManager.createQuery("SELECT COUNT(*) FROM TaskEntity WHERE assignedUserId='"+userId+"'");
			return query.getFirstResult();
		}
	}
}
