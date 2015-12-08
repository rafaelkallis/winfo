package we.are.awesome;

public class UserDAO {
	private final String name;
	private final Long id;
	private final Grouppe grouppe;
	
	public UserDAO(UserEntity entity){
		this.id 		= entity.getId();
		this.name 		= entity.getName();
		this.grouppe	= entity.getGrouppe();
	}
	
	public String getName() {
		return name;
	}
	public Long getId() {
		return id;
	}
	public Grouppe getGrouppe(){
		return this.grouppe;
	}
}
