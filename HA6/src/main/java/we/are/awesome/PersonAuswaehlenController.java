package we.are.awesome;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Named
@Stateless
public class PersonAuswaehlenController extends Controller{
	
	public void submit(){
		super.completeTask();
	}
	
	public TaskDAO getTaskDAO(){
		Long taskId = super.businessProcess.getVariable("taskId");
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
	
	public Long getNAssignedTasks(){		
		Long userId = null;
		Long NTasks = 0L;
		if((userId = super.businessProcess.getVariable("selectedUserId")) != null){
			Query query = super.entityManager.createQuery("SELECT COUNT(*) FROM TaskEntity t WHERE t.assignedUserId = :userId").setParameter("userId", userId);
			NTasks = (Long) query.getSingleResult();
		}
		System.out.println("Size of NAssignedTasks = "+NTasks);
		return NTasks;
	}
}
