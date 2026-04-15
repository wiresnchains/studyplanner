package me.dgrachov.studyplanner.dto;

public class TaskChecklistItemDTO {
    private Long id;
    private Long taskId;
    private Long checklistItemTemplateId;
    private String name;
    private boolean completed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getChecklistItemTemplateId() {
        return checklistItemTemplateId;
    }

    public void setChecklistItemTemplateId(Long checklistItemTemplateId) {
        this.checklistItemTemplateId = checklistItemTemplateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
