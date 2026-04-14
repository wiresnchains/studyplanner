package me.dgrachov.studyplanner.dto;

public class TaskDTO {
    private Long id;
    private String name;
    private String description;
    private String priority;
    private Long subjectId;
    private String subjectName;
    private Long checklistId;
    private Long epochDeadline;
    private String status;

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

    public Long getChecklistId() {return checklistId;}

    public void setChecklistId(Long checklistId) {this.checklistId = checklistId;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getSubjectName() {return subjectName;}

    public void setSubjectName(String subjectName) {this.subjectName = subjectName;}
}
