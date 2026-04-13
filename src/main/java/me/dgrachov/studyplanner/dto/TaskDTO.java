package me.dgrachov.studyplanner.dto;

public class TaskDTO {
    private Long id;
    private String description;
    private String priority;
    private Long subjectId;
    private Long epochDeadline;

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

    public Long getEpochDeadline() {
        return epochDeadline;
    }

    public void setEpochDeadline(Long epochDeadline) {
        this.epochDeadline = epochDeadline;
    }
}
