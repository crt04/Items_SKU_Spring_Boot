package com.hd.items.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(ItemsSkuRelPK.class)
public class ItemsSkuRel implements Serializable {
	
	private static final long serialVersionUID = 54082677931410516L;
	
	private Long itemSkuRelRef;
    private Long skuNbr;
    private Long auxSkuNbr;
    private String auxSkuDesc;
    private Integer skuTypCd;
    private String crtUsrId;
    private Timestamp crtTs;
    private String updUsrId;
    private Timestamp updTs;

    @Id
    @Column(name = "SKU_NBR")
    public Long getSkuNbr() {
        return skuNbr;
    }

    public void setSkuNbr(Long skuNbr) {
        this.skuNbr = skuNbr;
    }

    @Id
    @Column(name = "AUX_SKU_NBR")
    public Long getAuxSkuNbr() {
        return auxSkuNbr;
    }

    public void setAuxSkuNbr(Long auxSkuNbr) {
        this.auxSkuNbr = auxSkuNbr;
    }

    @Basic
    @Column(name = "AUX_SKU_DESC")
    public String getAuxSkuDesc() {
        return auxSkuDesc;
    }

    public void setAuxSkuDesc(String auxSkuDesc) {
        this.auxSkuDesc = auxSkuDesc;
    }

    @Basic
    @Column(name = "SKU_TYP_CD")
    public Integer getSkuTypCd() {
        return skuTypCd;
    }

    public void setSkuTypCd(Integer skuTypeCd) {
        this.skuTypCd = skuTypeCd;
    }

    @Basic
    @Column(name = "CRT_USR_ID", updatable = false)
    public String getCrtUsrId() {
        return crtUsrId;
    }

    public void setCrtUsrId(String crtUsrId) {
        this.crtUsrId = crtUsrId;
    }

    @Basic
    @Column(name = "CRT_TS", updatable = false)
    public Timestamp getCrtTs() {
        return crtTs;
    }

    public void setCrtTs(Timestamp crtTs) {
        this.crtTs = crtTs;
    }

    @Basic
    @Column(name = "UPD_USR_ID")
    public String getUpdUsrId() {
        return updUsrId;
    }

    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    @Basic
    @Column(name = "UPD_TS")
    public Timestamp getUpdTs() {
        return updTs;
    }

    public void setUpdTs(Timestamp updTs) {
        this.updTs = updTs;
    }
    

    public Long getItemSkuRelRef() {
		return itemSkuRelRef;
	}

	public void setItemSkuRelRef(Long itemSkuRelRef) {
		this.itemSkuRelRef = itemSkuRelRef;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemsSkuRel that = (ItemsSkuRel) o;
        return skuNbr == that.skuNbr &&
                auxSkuNbr == that.auxSkuNbr &&
                Objects.equals(auxSkuDesc, that.auxSkuDesc) &&
                Objects.equals(skuTypCd, that.skuTypCd) &&
                Objects.equals(crtUsrId, that.crtUsrId) &&
                Objects.equals(crtTs, that.crtTs) &&
                Objects.equals(updUsrId, that.updUsrId) &&
                Objects.equals(updTs, that.updTs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skuNbr, auxSkuNbr, auxSkuDesc, skuTypCd, crtUsrId, crtTs, updUsrId, updTs);
    }
}
