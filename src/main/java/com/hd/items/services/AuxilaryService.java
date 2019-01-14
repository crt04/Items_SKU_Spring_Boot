package com.hd.items.services;

import java.util.List;

import com.hd.items.dto.ItemsSkuRelReq;
import com.hd.items.entity.ItemsSkuRel;

public interface AuxilaryService {
	
	List<ItemsSkuRel>  getAuxilarySkusItems(Long primarySkuNbr);
	
	public List<ItemsSkuRel> saveUpdate(ItemsSkuRelReq itemsSkuRelReq);
	
	public String deleteAuxilarySkus(Long primarySkuNbr, Long auxSkuNbr);

}
