package me.dgrachov.studyplanner.mapper;

import java.util.ArrayList;
import java.util.List;
import me.dgrachov.studyplanner.dto.ChecklistDTO;
import me.dgrachov.studyplanner.model.Checklist;

public class ChecklistMapper implements Mapper<Checklist, ChecklistDTO> {
    @Override
    public Checklist toBase(ChecklistDTO dto) {
        var checklist = new Checklist();

        checklist.setId(dto.getId());
        checklist.setName(dto.getName());

        return checklist;
    }

    @Override
    public List<Checklist> toBaseList(List<ChecklistDTO> dtoList) {
        var checklists = new ArrayList<Checklist>();

        for (var checklistDTO : dtoList) {
            checklists.add(toBase(checklistDTO));
        }

        return checklists;
    }

    @Override
    public ChecklistDTO toDTO(Checklist base) {
        var dto = new ChecklistDTO();

        dto.setId(base.getId());
        dto.setName(base.getName());

        return dto;
    }

    @Override
    public List<ChecklistDTO> toDTOList(List<Checklist> baseList) {
        var checklistDTOs = new ArrayList<ChecklistDTO>();

        for (var checklist : baseList) {
            checklistDTOs.add(toDTO(checklist));
        }

        return checklistDTOs;
    }
}
