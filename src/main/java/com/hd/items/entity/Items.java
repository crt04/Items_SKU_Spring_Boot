package com.hd.items.entity;

import com.hd.items.dto.ItemsReq;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@IdClass(ItemsPK.class)
public class Items {
	private int catlgId;
	private String itemId;
	private String itemSkuDesc;
	private int skuNbr;
	private String crtUsrId;
	private Timestamp crtTs;
	private String updUsrId;
	private Timestamp updTs;

	@Id
	@Column(name = "CATLG_ID")
	public int getCatlgId() {
		return catlgId;
	}

	public void setCatlgId(int catlgId) {
		this.catlgId = catlgId;
	}

	@Id
	@Column(name = "ITEM_ID")
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	@Basic
	@Column(name = "ITEM_SKU_DESC")
	public String getItemSkuDesc() {
		return itemSkuDesc;
	}

	public void setItemSkuDesc(String itemSkuDesc) {
		this.itemSkuDesc = itemSkuDesc;
	}

	@Basic
	@Column(name = "SKU_NBR")
	public int getSkuNbr() {
		return skuNbr;
	}

	public void setSkuNbr(int skuNbr) {
		this.skuNbr = skuNbr;
	}

	@Basic
	@Column(name = "CRT_USR_ID")
	public String getCrtUsrId() {
		return crtUsrId;
	}

	public void setCrtUsrId(String crtUsrId) {
		this.crtUsrId = crtUsrId;
	}

	@Basic
	@Column(name = "CRT_TS")
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Items items = (Items) o;
		return catlgId == items.catlgId && skuNbr == items.skuNbr && Objects.equals(itemId, items.itemId)
				&& Objects.equals(itemSkuDesc, items.itemSkuDesc) && Objects.equals(crtUsrId, items.crtUsrId)
				&& Objects.equals(crtTs, items.crtTs) && Objects.equals(updUsrId, items.updUsrId)
				&& Objects.equals(updTs, items.updTs);
	}

	@Override
	public int hashCode() {
		return Objects.hash(catlgId, itemId, itemSkuDesc, skuNbr, crtUsrId, crtTs, updUsrId, updTs);
	}

}
