package we.are.awesome;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.io.Serializable;

@Entity
public class TodoEntity implements Serializable {

  private static  final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	protected Long id;
	
	protected String title;	  

	protected String description;
	
	protected Boolean isDone;
	  
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
	
	public Long getId(){
		return id;
	}
}

