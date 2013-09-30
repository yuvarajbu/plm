package edu.cs673.plm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class UserProject{
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private long id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
	private User user;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="roleId")
	private Role role;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="projectId")
	private Project project;

	public long getId(){
		return id;
	}

	public void setId(long id){
		this.id=id;
	}

	public User getUser(){
		return user;
	}

	public void setUser(User user){
		this.user=user;
	}

	public Role getRole(){
		return role;
	}

	public void setRole(Role role){
		this.role=role;
	}

	public Project getProject(){
		return project;
	}

	public void setProject(Project project){
		this.project=project;
	}
}
