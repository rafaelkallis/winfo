package we.are.awesome;

public class UserDAO {
	private final String firstName;
	private final Long id;
	private final Grouppe grouppe;
	
	public UserDAO(UserEntity entity){
		this.id 		= entity.id;
		this.firstName 	= entity.getName();
		this.grouppe	= entity.grouppe;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public Long getId() {
		return id;
	}
	public Grouppe getGrouppe(){
		return this.grouppe;
	}
}
