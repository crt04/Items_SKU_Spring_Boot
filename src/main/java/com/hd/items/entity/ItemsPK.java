package com.hd.items.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Id;

public class ItemsPK implements Serializable {
	private static final long serialVersionUID = 54082677931410516L;

	private int catlgId;
	private String itemId;

	@Column(name = "CATLG_ID")
	@Id
	public int getCatlgId() {
		return catlgId;
	}

	public void setCatlgId(int catlgId) {
		this.catlgId = catlgId;
	}

	@Column(name = "ITEM_ID")
	@Id
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ItemsPK itemsPK = (ItemsPK) o;
		return catlgId == itemsPK.catlgId && Objects.equals(itemId, itemsPK.itemId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(catlgId, itemId);
	}
}
