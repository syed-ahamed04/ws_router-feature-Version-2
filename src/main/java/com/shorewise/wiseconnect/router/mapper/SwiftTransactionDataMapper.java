package com.shorewise.wiseconnect.router.mapper;

import com.shorewise.wiseconnect.router.entity.SwiftTransactionDataEntity;
import com.shorewise.wiseconnect.router.model.SwiftTransactionData;

public class SwiftTransactionDataMapper {
	
	
	 public static SwiftTransactionDataEntity toEntity(SwiftTransactionData dto) {
	        if (dto == null) {
	            return null;
	        }

	        SwiftTransactionDataEntity entity = new SwiftTransactionDataEntity();
	        entity.setId(dto.getId());
	        entity.setInstRefNum(dto.getInstRefNum());
	        entity.setOwnerRefNum(dto.getOwnerRefNum());
	        entity.setCcy(dto.getCcy());
	        entity.setAmount(dto.getAmount());
	        entity.setSolIdB(dto.getSolIdB());
	        entity.setSolIdC(dto.getSolIdC());
	        entity.setUniqueId(dto.getUniqueId());
	        entity.setEntryDate(dto.getEntryDate());
	        entity.setValueDate(dto.getValueDate());
	        entity.setDrCr(dto.getDrCr());
	        entity.setNostro(dto.getNostro());
	        entity.setField86(dto.getField86());
	        entity.setCreatedUser(dto.getCreatedUser());
	        entity.setUpdatedUser(dto.getUpdatedUser());
	        entity.setCreatedAt(dto.getCreatedAt());
	        entity.setUpdatedAt(dto.getUpdatedAt());
	       
	        return entity;
	    }


}
