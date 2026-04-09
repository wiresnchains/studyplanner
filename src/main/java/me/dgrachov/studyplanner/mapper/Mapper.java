package me.dgrachov.studyplanner.mapper;

import java.util.List;

public interface Mapper<T, DTO> {
    T toBase(DTO dto);

    List<T> toBaseList(List<DTO> dtoList);

    DTO toDTO(T base);

    List<DTO> toDTOList(List<T> baseList);
}
