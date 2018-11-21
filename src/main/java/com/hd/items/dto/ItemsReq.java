package com.hd.items.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.hd.items.entity.Items;
import org.springframework.stereotype.Component;

@Component
public class ItemsReq implements Serializable {

	private static final long serialVersionUID = 5847348441486979596L;

	@NotBlank(message = "catlgId must not be null or blank!")
	private Integer catlgId;

	@NotBlank(message = "itemCd must not be null or blank!")
	@Pattern(regexp = "^[a-zA-z_\\d]{0,16}$", message = "itemCd length should not exceed 16 characters")
	private String itemId;

	@NotBlank(message = "skuNbr must not be null or blank!")
	@Size(min = 6, max = 10)
	// @Pattern(regexp="^[0-9]{6,10}$",message = "skuNbr length should be with in 6
	// to 10 digits")
	private Integer skuNbr;

	@NotBlank(message = "itemSkuDesc must not be null or blank!")
	@Pattern(regexp = "^.{0,150}$", message = "Item SKU description length should not exceed 150 characters")
	private String itemSkuDesc;

	@NotBlank(message = "userId must not be null or blank!")
	@Pattern(regexp = "^.{1,24}$", message = "User id length should not exceed 20 characters")
	private String userId;

	public Integer getCatlgId() {
		return catlgId;
	}

	public void setCatlgId(Integer catlgId) {
		this.catlgId = catlgId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Integer getSkuNbr() {
		return skuNbr;
	}

	public void setSkuNbr(Integer skuNbr) {
		this.skuNbr = skuNbr;
	}

	public String getItemSkuDesc() {
		return itemSkuDesc;
	}

	public void setItemSkuDesc(String itemSkuDesc) {
		this.itemSkuDesc = itemSkuDesc;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Items toEntity() {
		Items item = new Items();
		item.setCatlgId(this.getCatlgId());
		item.setItemId(this.getItemId());
		item.setItemSkuDesc(this.getItemSkuDesc());
		item.setSkuNbr(this.getSkuNbr());
		item.setCrtUsrId(this.getUserId());
		item.setUpdUsrId(this.getUserId());
		return item;

	}

}
