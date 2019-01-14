package com.hd.items.dto;

import com.hd.items.entity.ItemsSkuRel;

public class ItemsSkuRelReq {

	private static final long serialVersionUID = 54082677931410516L;
	
	private Long itemSkuRelRef;
    private Long skuNbr;
    private Long updatedAuxSkuNbr;
    private Long auxSkuNbr;
    private String auxSkuDesc;
    private Integer skuTypCd;
    private String usrId;

    
    
	public Long getItemSkuRelRef() {
		return itemSkuRelRef;
	}
	public void setItemSkuRelRef(Long itemSkuRelRef) {
		this.itemSkuRelRef = itemSkuRelRef;
	}
	public Long getSkuNbr() {
		return skuNbr;
	}
	public void setSkuNbr(Long skuNbr) {
		this.skuNbr = skuNbr;
	}
	public Long getUpdatedAuxSkuNbr() {
		return updatedAuxSkuNbr;
	}
	public void setUpdatedAuxSkuNbr(Long updatedAuxSkuNbr) {
		this.updatedAuxSkuNbr = updatedAuxSkuNbr;
	}
	public Long getAuxSkuNbr() {
		return auxSkuNbr;
	}
	public void setAuxSkuNbr(Long auxSkuNbr) {
		this.auxSkuNbr = auxSkuNbr;
	}
	public String getAuxSkuDesc() {
		return auxSkuDesc;
	}
	public void setAuxSkuDesc(String auxSkuDesc) {
		this.auxSkuDesc = auxSkuDesc;
	}
	public Integer getSkuTypCd() {
		return skuTypCd;
	}
	public void setSkuTypCd(Integer skuTypCd) {
		this.skuTypCd = skuTypCd;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	public ItemsSkuRel toEntity(ItemsSkuRelReq itemsSkuRelReq) {
		
		ItemsSkuRel isr = new ItemsSkuRel();
		isr.setItemSkuRelRef(this.getItemSkuRelRef());
		isr.setAuxSkuDesc(this.getAuxSkuDesc());
		isr.setAuxSkuNbr(this.getAuxSkuNbr());
		isr.setSkuNbr(this.getSkuNbr());
		isr.setCrtUsrId(this.getUsrId());
		isr.setUpdUsrId(this.getUsrId());
		isr.setSkuTypCd(this.getSkuTypCd());
		return isr;
	}
    
    

}
