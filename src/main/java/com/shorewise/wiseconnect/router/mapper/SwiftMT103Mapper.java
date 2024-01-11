package com.shorewise.wiseconnect.router.mapper;

import com.shorewise.wiseconnect.router.entity.SwiftMT103Entity;
import com.shorewise.wiseconnect.router.model.SwiftMT103;

public class SwiftMT103Mapper {

    public static SwiftMT103Entity toEntity(SwiftMT103 dto) {
        if (dto == null) {
            return null;
        }

        SwiftMT103Entity entity = new SwiftMT103Entity();
      
        entity.setId(dto.getId());
        entity.setSwidta(dto.getSwidta());
        entity.setSwircv(dto.getSwircv());
        entity.setSwisnd(dto.getSwisnd());
        entity.setSenderDetail(dto.getSenderDetail());
        entity.setBeneficiaryAccount(dto.getBeneficiaryAccount());
        entity.setSenderReference(dto.getSenderReference());
       
        return entity;
    }

    
}
