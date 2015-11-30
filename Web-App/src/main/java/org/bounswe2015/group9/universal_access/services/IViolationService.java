package org.bounswe2015.group9.universal_access.services;

import org.bounswe2015.group9.universal_access.dtos.ViolationDTO;
import org.bounswe2015.group9.universal_access.entities.User;
import org.bounswe2015.group9.universal_access.entities.Violation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IViolationService {
    ViolationDTO getViolation(Long id);
    List<ViolationDTO> getViolationsByOwner(Long userId, Boolean closed);
    List<ViolationDTO> getViolations(Boolean closed);
    List<ViolationDTO> getViolations();
    ViolationDTO createViolation(User user, ViolationDTO violationDTO);
    void updatePatchViolation(User user, ViolationDTO violationDTO);
    void deleteViolation(User user, ViolationDTO violationDTO);
    void updatePutViolation(User user, ViolationDTO violationDTO);
}
