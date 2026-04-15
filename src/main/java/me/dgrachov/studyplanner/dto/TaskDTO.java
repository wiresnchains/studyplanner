package me.dgrachov.studyplanner.dto;

import java.util.List;

public class TaskDTO {
    private Long id;
    private String name;
    private String description;
    private String priority;
    private Long subjectId;
    private String subjectName;
    private String deadline;
    private String status;
    private List<TaskChecklistItemDTO> checklistItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getSubjectName() {return subjectName;}

    public void setSubjectName(String subjectName) {this.subjectName = subjectName;}

    public List<TaskChecklistItemDTO> getChecklistItems() {
        return checklistItems;
    }

    public void setChecklistItems(List<TaskChecklistItemDTO> checklistItems) {
        this.checklistItems = checklistItems;
    }
}
