package me.dgrachov.studyplanner.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import me.dgrachov.studyplanner.dto.TaskDTO;
import me.dgrachov.studyplanner.model.Priority;
import me.dgrachov.studyplanner.model.Status;
import me.dgrachov.studyplanner.model.Subject;
import me.dgrachov.studyplanner.model.Task;

public class TaskMapper implements Mapper<Task, TaskDTO> {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE; // YYYY-MM-DD

    @Override
    public Task toBase(TaskDTO dto) {
        Task task = new Task();

        task.setId(dto.getId());
        task.setName(dto.getName());
        task.setDescription(dto.getDescription());
        task.setPriority(Priority.valueOf(dto.getPriority()));
        task.setStatus(Status.valueOf(dto.getStatus()));

        Long subjectId = dto.getSubjectId();
        if (subjectId != null) {
            Subject subject = new Subject();
            subject.setId(subjectId);
            subject.setName(dto.getSubjectName());
            task.setSubject(subject);
        }
        String deadlineString = dto.getDeadline();
        if (deadlineString != null && !deadlineString.isEmpty()) {
            task.setDeadline(LocalDate.parse(deadlineString, DATE_FORMATTER));
        }

        return task;
    }

    @Override
    public List<Task> toBaseList(List<TaskDTO> dtoList) {
        ArrayList<Task> tasks = new ArrayList<Task>();

        for (TaskDTO taskDTO : dtoList) {
            tasks.add(toBase(taskDTO));
        }

        return tasks;
    }

    @Override
    public TaskDTO toDTO(Task base) {
        TaskDTO dto = new TaskDTO();

        dto.setId(base.getId());
        dto.setName(base.getName());
        dto.setDescription(base.getDescription());
        dto.setPriority(base.getPriority().name());
        dto.setStatus(base.getStatus().name());

        Subject subject = base.getSubject();
        if (subject != null) {
            dto.setSubjectId(subject.getId());
            dto.setSubjectName(subject.getName());
        }

        if (base.getChecklistItems() != null && !base.getChecklistItems().isEmpty()) {
            dto.setChecklistItems(MapperProvider.getInstance().getTaskChecklistItemMapper().toDTOList(base.getChecklistItems()));
        }

        LocalDate deadline = base.getDeadline();
        if (deadline != null) {
            dto.setDeadline(deadline.format(DATE_FORMATTER));
        }

        return dto;
    }

    @Override
    public List<TaskDTO> toDTOList(List<Task> baseList) {
        ArrayList<TaskDTO> taskDTOs = new ArrayList<TaskDTO>();

        for (Task task : baseList) {
            taskDTOs.add(toDTO(task));
        }

        return taskDTOs;
    }
}
