package com.shorewise.wiseconnect.router.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "swift_transaction_data", schema = "xml_storage")
public class SwiftTransactionDataEntity {

    @Override
	public String toString() {
		return "SwiftTransactionDataEntity [id=" + id + ", instRefNum=" + instRefNum + ", ownerRefNum=" + ownerRefNum
				+ ", ccy=" + ccy + ", amount=" + amount + ", solIdB=" + solIdB + ", solIdC=" + solIdC + ", uniqueId="
				+ uniqueId + ", entryDate=" + entryDate + ", valueDate=" + valueDate + ", drCr=" + drCr + ", nostro="
				+ nostro + ", field86=" + field86 + ", createdUser=" + createdUser + ", updatedUser=" + updatedUser
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	@Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "inst_ref_num", length = 50)
    private String instRefNum;

    @Column(name = "owner_ref_num", length = 50)
    private String ownerRefNum;

    @Column(name = "ccy", length = 10)
    private String ccy;

    @Column(name = "amount", precision = 20, scale = 4)
    private BigDecimal amount;

    @Column(name = "sol_id_b")
    private Integer solIdB;

    @Column(name = "sol_id_c")
    private Integer solIdC;

    @Column(name = "unique_id", length = 50, unique = true)
    private String uniqueId;

    @Column(name = "entry_date")
    private LocalDateTime entryDate;

    @Column(name = "value_date")
    private LocalDateTime valueDate;

    @Column(name = "dr_cr", length = 10)
    private String drCr;

    @Column(name = "nostro", length = 50)
    private String nostro;

    @Column(name = "field_86", length = 8000)
    private String field86;

    @Column(name = "created_user", length = 24)
    private String createdUser;

    @Column(name = "updated_user", length = 24)
    private String updatedUser;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

	public String getId() {
		return id;
	}

	public String getInstRefNum() {
		return instRefNum;
	}

	public String getOwnerRefNum() {
		return ownerRefNum;
	}

	public String getCcy() {
		return ccy;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Integer getSolIdB() {
		return solIdB;
	}

	public Integer getSolIdC() {
		return solIdC;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public LocalDateTime getEntryDate() {
		return entryDate;
	}

	public LocalDateTime getValueDate() {
		return valueDate;
	}

	public String getDrCr() {
		return drCr;
	}

	public String getNostro() {
		return nostro;
	}

	public String getField86() {
		return field86;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public String getUpdatedUser() {
		return updatedUser;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setInstRefNum(String instRefNum) {
		this.instRefNum = instRefNum;
	}

	public void setOwnerRefNum(String ownerRefNum) {
		this.ownerRefNum = ownerRefNum;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setSolIdB(Integer solIdB) {
		this.solIdB = solIdB;
	}

	public void setSolIdC(Integer solIdC) {
		this.solIdC = solIdC;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}

	public void setValueDate(LocalDateTime valueDate) {
		this.valueDate = valueDate;
	}

	public void setDrCr(String drCr) {
		this.drCr = drCr;
	}

	public void setNostro(String nostro) {
		this.nostro = nostro;
	}

	public void setField86(String field86) {
		this.field86 = field86;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
    
	
	
}