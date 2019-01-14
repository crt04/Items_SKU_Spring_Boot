package com.hd.items.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.items.dao.ItemsRepository;
import com.hd.items.dao.ItemsSkuRelRepository;
import com.hd.items.dto.ItemsSkuRelReq;
import com.hd.items.entity.ItemsSkuRel;
import com.hd.items.entity.ItemsSkuRelPK;
import com.hd.items.services.AuxilaryService;

@Service
public class AuxilaryServiceImpl implements AuxilaryService {

	
	@Autowired
	ItemsSkuRelRepository itemsSkuRelRepository;
	
	@Autowired
	ItemsRepository itemsRepository;

	
	public List<ItemsSkuRel>  getAuxilarySkusItems(Long primarySkuNbr) {
		List<ItemsSkuRel> itemsSkuRelList = itemsSkuRelRepository.findAllBySkuNbr(primarySkuNbr);
		return itemsSkuRelList;
	}
	
	public List<ItemsSkuRel> saveUpdate(ItemsSkuRelReq itemsSkuRelReq) {
		
		
		List<ItemsSkuRel> itemsSkuRelList = new ArrayList<ItemsSkuRel>();
		
		if ( itemsSkuRelReq.getUpdatedAuxSkuNbr() != null && itemsSkuRelReq.getUpdatedAuxSkuNbr() > 0) {
			
			// Need to do custom update 
			itemsSkuRelList = itemsSkuRelRepository.findAllByAuxSkuNbr(itemsSkuRelReq.getAuxSkuNbr());
			for(ItemsSkuRel itemsSkuRel : itemsSkuRelList) {
				
				//delete old Aux Sku row
				ItemsSkuRelPK oldItemsSkuRelPK = new ItemsSkuRelPK();
				oldItemsSkuRelPK.setAuxSkuNbr(itemsSkuRelReq.getAuxSkuNbr());
				oldItemsSkuRelPK.setSkuNbr(itemsSkuRelReq.getSkuNbr());
				itemsSkuRelRepository.deleteById(oldItemsSkuRelPK);
				
				//insert new Aux Sku row
				ItemsSkuRel updatedItemsSkuRel = new ItemsSkuRel();
				updatedItemsSkuRel.setAuxSkuDesc(itemsSkuRel.getAuxSkuDesc());
				updatedItemsSkuRel.setAuxSkuNbr(itemsSkuRelReq.getUpdatedAuxSkuNbr());
				updatedItemsSkuRel.setCrtUsrId(itemsSkuRelReq.getUsrId());
				updatedItemsSkuRel.setUpdUsrId(itemsSkuRelReq.getUsrId());
				updatedItemsSkuRel.setItemSkuRelRef(itemsSkuRel.getItemSkuRelRef());
				updatedItemsSkuRel.setSkuTypCd(itemsSkuRel.getSkuTypCd());
				updatedItemsSkuRel.setSkuNbr(itemsSkuRelReq.getSkuNbr());
				itemsSkuRelRepository.save(updatedItemsSkuRel);
			}
			itemsSkuRelList =  itemsSkuRelRepository.findAllByAuxSkuNbr(itemsSkuRelReq.getUpdatedAuxSkuNbr());
		
		}else {
			ItemsSkuRel itemsSkuRel = itemsSkuRelReq.toEntity(itemsSkuRelReq);
			itemsSkuRel =  itemsSkuRelRepository.save(itemsSkuRel);
			itemsSkuRelList.add(itemsSkuRel);
		}
		
	
		return itemsSkuRelList;
		
	}
	
	public String deleteAuxilarySkus(Long primarySkuNbr, Long auxSkuNbr) {
		
		ItemsSkuRelPK itemsSkuRelPK = new ItemsSkuRelPK(primarySkuNbr, auxSkuNbr);
		
		itemsSkuRelRepository.deleteById(itemsSkuRelPK);
		
		return "Delete of auxilary sku: " + auxSkuNbr + " with primary sku: " + primarySkuNbr + " was successful.";
		
	}

}
