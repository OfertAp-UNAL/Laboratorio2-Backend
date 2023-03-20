package co.edu.unal.software_engineering.labs.controller;

import co.edu.unal.software_engineering.labs.pojo.RolePOJO;
import co.edu.unal.software_engineering.labs.service.RoleService;
import co.edu.unal.software_engineering.labs.service.UserRolesService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    private final RoleService roleService;
    private final UserRolesService userRolesService;

    public RoleController(
            RoleService roleService,
            UserRolesService userRolesService) {
        this.roleService = roleService;
        this.userRolesService = userRolesService;
    }

    @GetMapping("/mis-roles")
    public List<RolePOJO> getUserRoles() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRolesService.findRolesByUsername(username);
    }

    @GetMapping(value = { "/roles" })
    public List<RolePOJO> getAllRoles() {
        return roleService.getAll();
    }
}
