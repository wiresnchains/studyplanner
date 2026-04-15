package me.dgrachov.studyplanner.mapper;

import java.util.ArrayList;
import java.util.List;
import me.dgrachov.studyplanner.dto.ChecklistItemDTO;
import me.dgrachov.studyplanner.model.Checklist;
import me.dgrachov.studyplanner.model.ChecklistItem;

public class ChecklistItemMapper implements Mapper<ChecklistItem, ChecklistItemDTO> {
    @Override
    public ChecklistItem toBase(ChecklistItemDTO dto) {
        var item = new ChecklistItem();

        item.setId(dto.getId());
        item.setName(dto.getName());

        var checklistId = dto.getChecklistId();
        if (checklistId != null) {
            var checklist = new Checklist();
            checklist.setId(checklistId);
            item.setChecklist(checklist);
        }

        return item;
    }

    @Override
    public List<ChecklistItem> toBaseList(List<ChecklistItemDTO> dtoList) {
        var items = new ArrayList<ChecklistItem>();

        for (var itemDTO : dtoList) {
            items.add(toBase(itemDTO));
        }

        return items;
    }

    @Override
    public ChecklistItemDTO toDTO(ChecklistItem base) {
        var dto = new ChecklistItemDTO();

        dto.setId(base.getId());
        dto.setName(base.getName());

        var checklist = base.getChecklist();
        if (checklist != null) {
            dto.setChecklistId(checklist.getId());
        }

        return dto;
    }

    @Override
    public List<ChecklistItemDTO> toDTOList(List<ChecklistItem> baseList) {
        var itemDTOs = new ArrayList<ChecklistItemDTO>();

        for (var item : baseList) {
            itemDTOs.add(toDTO(item));
        }

        return itemDTOs;
    }
}
