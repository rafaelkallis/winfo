package we.are.awesome;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class TodoEntity implements Serializable {

  private static  final long serialVersionUID = 1L;

	@Id
	protected String title;
	  

	protected String description;
	  
	public TodoEntity(String title, String description){
		this.title = title;
		this.description = description;
	}
	  
	public TodoEntity(){
		  
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
  
	public String getTitle() {
	  return title;
	}
	
	public String getDescription() {
		return description;
	}
}

