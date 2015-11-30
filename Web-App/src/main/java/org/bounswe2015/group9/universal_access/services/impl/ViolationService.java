package org.bounswe2015.group9.universal_access.services.impl;

import org.bounswe2015.group9.universal_access.daos.IViolationDao;
import org.bounswe2015.group9.universal_access.dtos.ViolationDTO;
import org.bounswe2015.group9.universal_access.entities.User;
import org.bounswe2015.group9.universal_access.entities.Violation;
import org.bounswe2015.group9.universal_access.exceptions.RecordNotFoundException;
import org.bounswe2015.group9.universal_access.services.IViolationService;
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
        Violation violation = new Violation(violationDTO,user);
        vdao.create(violation);

        return new ViolationDTO(violation);
    }

    @Override
    public void updateViolation(User user, ViolationDTO violationDTO) {

    }

    @Override
    public void deleteViolation(User user, ViolationDTO violationDTO) {

    }
}
