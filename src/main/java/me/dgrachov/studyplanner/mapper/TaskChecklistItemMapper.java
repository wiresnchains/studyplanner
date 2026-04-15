package me.dgrachov.studyplanner.mapper;

import me.dgrachov.studyplanner.dto.TaskChecklistItemDTO;
import me.dgrachov.studyplanner.model.TaskChecklistItem;

import java.util.List;
import java.util.stream.Collectors;

public class TaskChecklistItemMapper implements Mapper<TaskChecklistItem, TaskChecklistItemDTO> {

    @Override
    public TaskChecklistItemDTO toDTO(TaskChecklistItem base) {
        TaskChecklistItemDTO dto = new TaskChecklistItemDTO();
        dto.setId(base.getId());
        dto.setTaskId(base.getTask().getId());
        dto.setChecklistItemTemplateId(base.getChecklistItemTemplate().getId());
        dto.setName(base.getChecklistItemTemplate().getName());
        dto.setCompleted(base.isCompleted());
        return dto;
    }

    @Override
    public TaskChecklistItem toBase(TaskChecklistItemDTO dto) {
        TaskChecklistItem base = new TaskChecklistItem();
        base.setId(dto.getId());
        base.setCompleted(dto.isCompleted());
        return base;
    }

    @Override
    public List<TaskChecklistItemDTO> toDTOList(List<TaskChecklistItem> baseList) {
        return baseList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<TaskChecklistItem> toBaseList(List<TaskChecklistItemDTO> dtoList) {
        return dtoList.stream().map(this::toBase).collect(Collectors.toList());
    }
}
