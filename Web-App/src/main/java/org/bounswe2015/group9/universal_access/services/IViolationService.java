package org.bounswe2015.group9.universal_access.services;

import org.bounswe2015.group9.universal_access.dtos.ViolationDTO;
import org.bounswe2015.group9.universal_access.entities.Violation;

import java.util.List;

/**
 * Created by burakcoskun on 11/30/15.
 */
public interface IViolationService {
    Violation getViolation(Long id);

    List<Violation> getAllViolations();

    Violation createViolation(Violation violation);

    Violation createViolation(ViolationDTO violation);

    void updateViolation(Violation violation);

    void updateViolation(ViolationDTO violation);

    void deleteViolation(Long id);
}
