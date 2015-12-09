package we.are.awesome;

public class UserDAO {
	
	private final Long id;
	private final String name;
	private final Boolean isProjektleiter;
	
	public UserDAO(UserEntity entity){
		this.id 				= entity.getId();
		this.name 				= entity.getName();
		this.isProjektleiter	= entity.getIsProjektleiter();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public Boolean getIsProjektleiter(){
		return this.isProjektleiter;
	}
}
