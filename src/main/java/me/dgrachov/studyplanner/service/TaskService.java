package me.dgrachov.studyplanner.service;
import me.dgrachov.studyplanner.dto.ChecklistDTO;
import me.dgrachov.studyplanner.dto.SubjectDTO;
import me.dgrachov.studyplanner.model.*;
import me.dgrachov.studyplanner.dto.TaskDTO;
import me.dgrachov.studyplanner.exception.ServiceException;
import me.dgrachov.studyplanner.mapper.MapperProvider;
import me.dgrachov.studyplanner.persistence.dao.DAOFactory;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public class TaskService {
    private static final MapperProvider mapperProvider = MapperProvider.getInstance();

    public List<TaskDTO> getTasksOfAccount(Account account) {
       List<Task> task  = account.getTasks();

        return mapperProvider.getTaskMapper().toDTOList(task);
    }

    public void create(TaskDTO dto, SubjectDTO subjectDTO, ChecklistDTO checklist, Account account) {
        Task task = new Task();

        task.setName(dto.getName());
        task.setDescription(dto.getDescription());
        task.setPriority(Priority.valueOf(dto.getPriority()));
        task.setAccount(account);

        if (dto.getEpochDeadline() != null) {
            task.setDeadline(Instant.ofEpochSecond(dto.getEpochDeadline()));
        }

        if (dto.getSubjectId() != null) {
            DAOFactory.getFactory().getSubjectDAO().findById(dto.getSubjectId())
                    .ifPresent(task::setSubject);
        }

        DAOFactory.getFactory().getTaskDAO().persist(task);
        account.getTasks().add(task);
    }

    public void edit(TaskDTO dto, Subject subject, Checklist checklist) {
        Optional<Task> taskOptional = DAOFactory.getFactory().getTaskDAO().findById(dto.getId());

        if (taskOptional.isEmpty()) {
            throw new ServiceException("Task does not exist");
        }

        Task task = taskOptional.get();

        task.setName(dto.getName());
        task.setDescription(dto.getDescription());

        if (dto.getEpochDeadline() != null) {
            task.setDeadline(Instant.ofEpochSecond(dto.getEpochDeadline()));
        }

        if (dto.getSubjectId() != null) {
            DAOFactory.getFactory().getSubjectDAO().findById(dto.getSubjectId())
                    .ifPresent(task::setSubject);
        }

        task.setPriority(Priority.valueOf(dto.getPriority()));

        DAOFactory.getFactory().getTaskDAO().merge(task);
    }

    public void delete(Long taskId) {
        Optional<Task> taskOptional = DAOFactory.getFactory().getTaskDAO().findById(taskId);

        if (taskOptional.isEmpty()) {
            throw new ServiceException("Task does not exist");
        }

        Task task = taskOptional.get();

        DAOFactory.getFactory().getTaskDAO().remove(task);
    }

    public void updateStatus(Long taskId, Status status) {
        Optional<Task> taskOptional = DAOFactory.getFactory().getTaskDAO().findById(taskId);

        if (taskOptional.isEmpty()) {
            throw new ServiceException("Task does not exist");
        }

        Task task = taskOptional.get();

        task.setStatus(status);

        DAOFactory.getFactory().getTaskDAO().merge(task);
    }

    public TaskDTO getTaskById(Long id) {
        Optional<Task> taskOptional = DAOFactory.getFactory().getTaskDAO().findById(id);

        if (taskOptional.isEmpty()) {
            throw new ServiceException("Task does not exist");
        }

        return mapperProvider.getTaskMapper().toDTO(taskOptional.get());
    }
}
