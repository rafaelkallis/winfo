package we.are.awesome;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

public class PersonAuswaehlenController extends Controller{
	

	public void chooseUser(Long assignedUserId) {
		super.businessProcess.setVariable("assignedUserId", assignedUserId);
		
		try {
			super.taskForm.completeProcessInstanceForm();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public TaskDAO getTaskDAO(){
		Long taskId = super.businessProcess.getVariable("taskId");
		return super.getTaskDAO(taskId);
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
	
	public Integer getNAssignedTasks(Long userId){		
		Query query = super.entityManager.createQuery("SELECT COUNT(*) FROM TaskEntity WHERE assignedUserId='"+userId+"'");
		return query.getFirstResult();
	}
}
