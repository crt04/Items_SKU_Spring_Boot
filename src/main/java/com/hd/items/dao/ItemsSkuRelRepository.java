package com.hd.items.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hd.items.entity.ItemsSkuRel;
import com.hd.items.entity.ItemsSkuRelPK;

public interface ItemsSkuRelRepository extends CrudRepository<ItemsSkuRel, ItemsSkuRelPK>{
	
	List<ItemsSkuRel> findAllByAuxSkuNbr(Long auxSkuNbr);
	
	List<ItemsSkuRel> findAllBySkuNbr(Long primarySkuNbr);

}
