package me.dgrachov.studyplanner.dto;

public class AccountMessageDTO {
    private Long id;
    private String sender;
    private String content;
    private Boolean isRead;
    private Long epochSeconds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Long getEpochSeconds() {
        return epochSeconds;
    }

    public void setEpochSeconds(Long epochSeconds) {
        this.epochSeconds = epochSeconds;
    }
}
