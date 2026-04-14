package me.dgrachov.studyplanner.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password_hashed", nullable = false)
    private String passwordHashed;

    @OneToMany(mappedBy = "account")
    private final List<AccountMessage> messages = new ArrayList<>();

    @OneToMany(mappedBy = "account")
    private final List<Subject> subjects = new ArrayList<>();

    @OneToMany(mappedBy = "account")
    private final List<Task> tasks = new ArrayList<>();

    @OneToMany(mappedBy = "account")
    private final List<Checklist> checklists = new ArrayList<>();
    
    public void addChecklist(Checklist checklist) {
    	if (this.checklists.add(checklist)) {
    		checklist.setAccount(this);
    	}
    }
    
    public void removeChecklist(Checklist checklist) {
    	if (this.checklists.remove(checklist)) {
    		checklist.setAccount(null);
    	}
    }
    
    public void changeChecklist(Checklist newChecklist) {
		Checklist checklistInList = checklists.stream()
				.filter(c -> c.equals(newChecklist))
				.findFirst()
				.orElse(null);
		if (checklistInList == null)
			return;
		checklistInList.setName(newChecklist.getName());
		checklistInList.getItems().clear();
		if (newChecklist.getItems() != null) {
			checklistInList.getItems().addAll(newChecklist.getItems());
		}
		checklistInList.setAccount(newChecklist.getAccount());
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHashed() {
        return passwordHashed;
    }

    public void setPasswordHashed(String passwordHashed) {
        this.passwordHashed = passwordHashed;
    }

    public List<AccountMessage> getMessages() {
        return messages;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<Checklist> getChecklists() {
        return checklists;
    }
}
