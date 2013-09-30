package edu.cs673.plm.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Project{
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private long id;
	private String name;

	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="UserProject",joinColumns=@JoinColumn(name="projectId"),inverseJoinColumns=@JoinColumn(name="id"))
	private List<UserProject> userProjects;

	public long getId(){
		return id;
	}

	public void setId(long id){
		this.id=id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name=name;
	}

	public List<UserProject> getUserProjects(){
		return userProjects;
	}

	public void setUserProjects(List<UserProject> userProjects){
		this.userProjects=userProjects;
	}
}
