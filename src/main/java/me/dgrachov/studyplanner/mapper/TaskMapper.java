package me.dgrachov.studyplanner.mapper;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import me.dgrachov.studyplanner.dto.TaskDTO;
import me.dgrachov.studyplanner.model.Priority;
import me.dgrachov.studyplanner.model.Subject;
import me.dgrachov.studyplanner.model.Task;

public class TaskMapper implements Mapper<Task, TaskDTO> {
    @Override
    public Task toBase(TaskDTO dto) {
        var task = new Task();

        task.setId(dto.getId());
        task.setDescription(dto.getDescription());
        task.setPriority(Priority.valueOf(dto.getPriority()));

        var subjectId = dto.getSubjectId();
        if (subjectId != null) {
            var subject = new Subject();
            subject.setId(subjectId);
            task.setSubject(subject);
        }

        var epochDeadline = dto.getEpochDeadline();
        if (epochDeadline != null) {
            task.setDeadline(Instant.ofEpochMilli(epochDeadline));
        }

        return task;
    }

    @Override
    public List<Task> toBaseList(List<TaskDTO> dtoList) {
        var tasks = new ArrayList<Task>();

        for (var taskDTO : dtoList) {
            tasks.add(toBase(taskDTO));
        }

        return tasks;
    }

    @Override
    public TaskDTO toDTO(Task base) {
        var dto = new TaskDTO();

        dto.setId(base.getId());
        dto.setDescription(base.getDescription());
        dto.setPriority(base.getPriority().name());

        var subject = base.getSubject();
        if (subject != null) {
            dto.setSubjectId(subject.getId());
        }

        var deadline = base.getDeadline();
        if (deadline != null) {
            dto.setEpochDeadline(deadline.toEpochMilli());
        }

        return dto;
    }

    @Override
    public List<TaskDTO> toDTOList(List<Task> baseList) {
        var taskDTOs = new ArrayList<TaskDTO>();

        for (var task : baseList) {
            taskDTOs.add(toDTO(task));
        }

        return taskDTOs;
    }
}
