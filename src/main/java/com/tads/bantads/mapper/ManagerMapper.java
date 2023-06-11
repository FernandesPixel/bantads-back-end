package com.tads.bantads.mapper;

import com.tads.bantads.dto.ManagerDTO;
import com.tads.bantads.dto.UpdateManagerDTO;
import com.tads.bantads.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManagerMapper {

    @Autowired
    public ManagerDTO managerToDTO(Manager manager) {
        return new ManagerDTO(manager.getId(), manager.getName(), manager.getEmail(), manager.getCpf(), manager.getPhonenumber());
    }

    public Manager DTOToManager(ManagerDTO managerDTO) {
        return Manager.builder()
                .id(managerDTO.id())
                .name(managerDTO.name())
                .email(managerDTO.email())
                .cpf(managerDTO.cpf())
                .phonenumber(managerDTO.phonenumber())
                .build();
    }

    public Manager updateManager(Manager manager, UpdateManagerDTO updateManagerDTO) {
        manager.setName(updateManagerDTO.name());
        manager.setEmail(updateManagerDTO.email());
        manager.setPhonenumber(updateManagerDTO.phonenumber());
        return manager;
    }
}
