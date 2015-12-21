package org.bounswe2015.group9.universal_access.services.impl;

import org.bounswe2015.group9.universal_access.daos.IViolationDao;
import org.bounswe2015.group9.universal_access.dtos.TagDTO;
import org.bounswe2015.group9.universal_access.dtos.ViolationDTO;
import org.bounswe2015.group9.universal_access.entities.Tag;
import org.bounswe2015.group9.universal_access.entities.User;
import org.bounswe2015.group9.universal_access.entities.Violation;
import org.bounswe2015.group9.universal_access.exceptions.ForbiddenProccessException;
import org.bounswe2015.group9.universal_access.exceptions.RecordNotFoundException;
import org.bounswe2015.group9.universal_access.services.IViolationService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ViolationService implements IViolationService {
    @Autowired
    IViolationDao vdao;

    @Override
    public ViolationDTO getViolation(Long id) {
        Violation violation = vdao.read(id);
        if(violation == null) {
            throw new RecordNotFoundException("Violation not found.");
        }

        return new ViolationDTO(violation);
    }

    private List<ViolationDTO> convertToDTO(List<Violation> violations) {
        List<ViolationDTO> violationDTOs = new ArrayList<>();
        for(Violation violation: violations) {
            violationDTOs.add( new ViolationDTO(violation));
        }

        return violationDTOs;
    }

    @Override
    public List<ViolationDTO> getViolationsByOwner(Long userId, Boolean closed) {
        List<Violation> violations = vdao.getViolationsByOwner(userId, closed);
        return convertToDTO(violations);
    }

    @Override
    public List<ViolationDTO> getViolations(Boolean closed) {
        List<Violation> violations = vdao.getViolations(closed);
        return convertToDTO(violations);
    }

    @Override
    public List<ViolationDTO> getViolations() {
        List<Violation> violations = vdao.getAll();
        return convertToDTO(violations);
    }

    @Override
    public ViolationDTO createViolation(User user, ViolationDTO violationDTO) {
        violationDTO.setDate(DateTime.now());
        Violation violation = new Violation(violationDTO,user);
        System.out.println(violation.getUser().getId());
        vdao.create(violation);

        return new ViolationDTO(violation);
    }

    private Object selector(Object first, Object second, boolean put) {
        return put ? first : first == null ? second : first;
    }

    private void updateViolation(Violation v, ViolationDTO vD, boolean put) {
       v.setClosed((Boolean) selector(vD.getClosed(), v.getClosed(), put));
       v.setDescription((String) selector(vD.getDescription(), v.getDescription(), put));
       v.setTitle((String) selector(vD.getTitle(), v.getTitle(), put));
       v.setImageUrl((String) selector(vD.getImageUrl(), v.getImageUrl(), put));
       v.setLocation((String) selector(vD.getLocation(), v.getLocation(), put));
        vD.setModificationDate(DateTime.now());
       v.setModificationDate((DateTime) selector(vD.getModificationDate(), v.getModificationDate(), put)); //UPDATE HERE TO AUTOMATICALLY SET DATE
    }

    private Violation checkForUpdate(User user, ViolationDTO violationDTO) {
        if(violationDTO.getId() == null) {
            throw new IllegalArgumentException("id field not exists");
        }

        Violation violation = vdao.read(violationDTO.getId());

        if (violation == null) {
            throw new RecordNotFoundException("violation not found");
        }

        if(!violation.getUser().getId().equals(user.getId())) {
            System.out.println(violation.getUser().getId());
            System.out.println(user.getId());
            throw new ForbiddenProccessException("can not update or delete another user violation.");
        }

        return violation;
    }

    @Override
    public void updatePutViolation(User user, ViolationDTO violationDTO) {
        Violation violation = checkForUpdate(user, violationDTO);

        updateViolation(violation, violationDTO, true);
        vdao.update(violation);
    }

    @Override
    public void updatePatchViolation(User user, ViolationDTO violationDTO) {
        Violation violation = checkForUpdate(user, violationDTO);

        updateViolation(violation, violationDTO, false);
        vdao.update(violation);
    }

    @Override
    public void deleteViolation(User user, ViolationDTO violationDTO) {
        Violation violation = checkForUpdate(user, violationDTO);

        vdao.delete(violation);
    }
    @Override
    public void addTag(Violation violation, TagDTO tagDTO){
        Tag tag = new Tag(tagDTO);
        violation.addTag(tag);
    }
}
