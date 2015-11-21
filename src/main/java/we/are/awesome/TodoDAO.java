package we.are.awesome;

import java.io.Serializable;

public class TodoDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private final String title;
	private final String description;
	
	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	
	public TodoDAO(){
		this.title = null;
		this.description = null;
	}
	
	public TodoDAO(String title, String description){
		this.title = title;
		this.description = description;
	}
}
