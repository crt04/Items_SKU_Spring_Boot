package com.hd.items.services;

		import java.util.List;

import com.hd.items.entity.Items;
import com.hd.items.entity.ItemsPK;
import com.hd.items.util.ItemsException;

/**
 * @author crt04
 *
 */
public interface ItemsService {

	 Items save(Items item) throws ItemsException;

	 void deleteItems(ItemsPK itemsPK) throws ItemsException;

	 List<Items> getItems(Integer catlgId) throws ItemsException;

}
