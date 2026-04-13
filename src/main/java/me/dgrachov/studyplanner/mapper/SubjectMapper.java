package me.dgrachov.studyplanner.mapper;

import java.util.ArrayList;
import java.util.List;

import me.dgrachov.studyplanner.dto.SubjectDTO;
import me.dgrachov.studyplanner.model.Color;
import me.dgrachov.studyplanner.model.Subject;

public class SubjectMapper implements Mapper<Subject, SubjectDTO> {
    @Override
    public Subject toBase(SubjectDTO dto) {
        var subject = new Subject();

        subject.setId(dto.getId());
        subject.setName(dto.getName());
        subject.setColor(Color.valueOf(dto.getColor()));

        return subject;
    }

    @Override
    public List<Subject> toBaseList(List<SubjectDTO> dtoList) {
        var subjects = new ArrayList<Subject>();

        for (var subjectDTO : dtoList) {
            subjects.add(toBase(subjectDTO));
        }

        return subjects;
    }

    @Override
    public SubjectDTO toDTO(Subject base) {
        var dto = new SubjectDTO();

        dto.setId(base.getId());
        dto.setName(base.getName());
        dto.setColor(base.getColor().name());

        return dto;
    }

    @Override
    public List<SubjectDTO> toDTOList(List<Subject> baseList) {
        var subjectDTOs = new ArrayList<SubjectDTO>();

        for (var subject : baseList) {
            subjectDTOs.add(toDTO(subject));
        }

        return subjectDTOs;
    }
}
