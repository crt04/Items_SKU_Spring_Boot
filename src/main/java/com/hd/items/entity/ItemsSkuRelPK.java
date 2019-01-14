package com.hd.items.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ItemsSkuRelPK implements Serializable {
	
	private static final long serialVersionUID = 54082677931410516L;
    private Long skuNbr;
    private Long auxSkuNbr;

    
    public ItemsSkuRelPK(Long skuNbr, Long auxSkuNbr) {
	    	this.skuNbr = skuNbr;
	    	this.auxSkuNbr = auxSkuNbr;	
    }
    
    public ItemsSkuRelPK() {
   
    }
    
    @Column(name = "SKU_NBR")
    @Id
    public Long getSkuNbr() {
        return skuNbr;
    }

    public void setSkuNbr(Long skuNbr) {
        this.skuNbr = skuNbr;
    }

    @Column(name = "AUX_SKU_NBR")
    @Id
    public Long getAuxSkuNbr() {
        return auxSkuNbr;
    }

    public void setAuxSkuNbr(Long auxSkuNbr) {
        this.auxSkuNbr = auxSkuNbr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemsSkuRelPK that = (ItemsSkuRelPK) o;
        return skuNbr == that.skuNbr &&
                auxSkuNbr == that.auxSkuNbr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(skuNbr, auxSkuNbr);
    }
}
