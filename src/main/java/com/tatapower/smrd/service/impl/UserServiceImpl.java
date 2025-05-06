package com.tatapower.smrd.service.impl;

import com.tatapower.smrd.dto.UserRequest;
import com.tatapower.smrd.entity.*;
import com.tatapower.smrd.repository.*;
import com.tatapower.smrd.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final DiscomRepository discomRepository;
    private final DepartmentRepository departmentRepository;
    private final AgencyRepository agencyRepository;
    private final AgentRepository agentRepository;
    private final RoleMasterRepository roleMasterRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, DiscomRepository discomRepository, DepartmentRepository departmentRepository, AgencyRepository agencyRepository, AgentRepository agentRepository, RoleMasterRepository roleMasterRepository) {
        this.userRepository = userRepository;
        this.discomRepository = discomRepository;
        this.departmentRepository = departmentRepository;
        this.agencyRepository = agencyRepository;
        this.agentRepository = agentRepository;
        this.roleMasterRepository = roleMasterRepository;
    }

    @Override
    public User saveUser(UserRequest userRequest) {

        User user = (userRequest.getUserId() != null)
                ? findUserById(userRequest.getUserId())
                : new User();

        user.setName(userRequest.getName());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setDiscom(findDiscomById(userRequest.getDiscomId()));
        user.setDepartment(findDepartmentById(userRequest.getDepartmentId()));
        user.setAgency(findAgencyById(userRequest.getAgencyId()));
        user.setAgent(findAgentById(userRequest.getAgentId()));
        user.setRoleMaster(findRoleById(userRequest.getRoleId()));

        return userRepository.save(user);
    }

    private User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    private Discom findDiscomById(Long id) {
        return discomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Discom not found with id: " + id));
    }

    private Department findDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + id));
    }

    private Agency findAgencyById(Long id) {
        return agencyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agency not found with id: " + id));
    }

    private Agent findAgentById(Long id) {
        return agentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agent not found with id: " + id));
    }

    private RoleMaster findRoleById(Long id) {
        return roleMasterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("RoleMaster not found with id: " + id));
    }
}

