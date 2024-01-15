package com.shorewise.wiseconnect.router.model;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

import lombok.Data;


@Data
@Component
public class SwiftTransactionData {

    private String id;
    private String instRefNum;
    private String ownerRefNum;
    private String ccy;
    private BigDecimal amount;
    private Integer solIdB;
    private Integer solIdC;
    private String uniqueId;
    private LocalDateTime entryDate;
    private LocalDateTime valueDate;
    private String drCr;
    private String nostro;
    private String field86;
    private String createdUser;
    private String updatedUser;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
	
  

	@Override
	public String toString() {
		return "SwiftTransactionData [id=" + id + ", instRefNum=" + instRefNum + ", ownerRefNum=" + ownerRefNum
				+ ", ccy=" + ccy + ", amount=" + amount + ", solIdB=" + solIdB + ", solIdC=" + solIdC + ", uniqueId="
				+ uniqueId + ", entryDate=" + entryDate + ", valueDate=" + valueDate + ", drCr=" + drCr + ", nostro="
				+ nostro + ", field86=" + field86 + ", createdUser=" + createdUser + ", updatedUser=" + updatedUser
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
    
}