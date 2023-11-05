package com.binarfud.challenge6.Config;

import com.binarfud.challenge6.Repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import com.binarfud.challenge6.Enum.ERole;
import com.binarfud.challenge6.Model.Roles;

@Slf4j
public class Config {

    Config(RoleRepository roleRepository) {
        log.info("Cheking roles presented");
        for(ERole c : ERole.values()) {
            try {
                Roles roles = roleRepository.findByRoleName(c)
                        .orElseThrow(() -> new RuntimeException("Roles not found"));
                log.info("Role {} has been found!", roles.getRoleName());
            } catch(RuntimeException rte) {
                log.info("Role {} is not found, inserting to DB . . .", c.name());
                Roles roles = new Roles();
                roles.setRoleName(c);
                roleRepository.save(roles);
            }
        }
    }
}
