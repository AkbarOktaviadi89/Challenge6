package com.binarfud.challenge6.Service;

import com.binarfud.challenge6.Model.Roles;

import java.util.List;
import java.util.Optional;

public interface RolesService {
    List<Roles> getAllRoles();

    Optional<Roles> getRoleById(Integer id);

    boolean addNewRole(Roles role);

    void updateRole(Roles role);

    void deleteRoleById(Integer id);
}
