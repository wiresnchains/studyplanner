package me.dgrachov.studyplanner.service;

import java.util.List;

import me.dgrachov.studyplanner.dto.SubjectDTO;
import me.dgrachov.studyplanner.exception.ServiceException;
import me.dgrachov.studyplanner.mapper.MapperProvider;
import me.dgrachov.studyplanner.model.Account;
import me.dgrachov.studyplanner.model.Subject;
import me.dgrachov.studyplanner.persistence.dao.DAOFactory;

public class SubjectService {
    private static final MapperProvider mapperProvider = MapperProvider.getInstance();

    public List<SubjectDTO> getSubjectsOfAccount(Account account) {
        var subjects = account.getSubjects();

        return mapperProvider.getSubjectMapper().toDTOList(subjects);
    }

    public void createSubject(String name, Account account) {
        var subject = new Subject();

        subject.setName(name);
        subject.setAccount(account);

        DAOFactory.getFactory().getSubjectDAO().persist(subject);

        account.getSubjects().add(subject);
    }

    public void editSubject(SubjectDTO dto) {
        var subject = mapperProvider.getSubjectMapper().toBase(dto);

        DAOFactory.getFactory().getSubjectDAO().merge(subject);
    }

    public void deleteSubject(Long subjectId) {
        var subjectOptional = DAOFactory.getFactory().getSubjectDAO().findById(subjectId);

        if (subjectOptional.isEmpty()) {
            throw new ServiceException("Subject does not exist");
        }

        var subject = subjectOptional.get();

        DAOFactory.getFactory().getSubjectDAO().remove(subject);
    }
}
