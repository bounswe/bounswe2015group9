package org.bounswe2015.group9.universal_access.daos;

import org.bounswe2015.group9.universal_access.entities.Violation;
import java.util.List;

public interface IViolationDao extends IBaseDao<Violation, Long> {
    List<Violation> getViolationsByOwner(Long userId, Boolean closed);
    List<Violation> getViolations(Boolean closed);

}
