package com.hd.items.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hd.items.dao.ItemsRepository;
import com.hd.items.entity.Items;
import com.hd.items.entity.ItemsPK;
import com.hd.items.services.ItemsService;
import com.hd.items.util.ItemsException;

/**
 * @author crt04
 *
 */
@Service
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	ItemsRepository itemsRepository;

	public Items save(Items items) throws ItemsException {
		return itemsRepository.save(items);
	}

	public void deleteItems(ItemsPK itemsPK) throws ItemsException {
		try {
			itemsRepository.deleteById(itemsPK);
		} catch (DataIntegrityViolationException e) {
			throw new ItemsException(
					"Delete Item Failed for catlgId: " + itemsPK.getCatlgId() + " and  itemId:" + itemsPK.getItemId(),
					e.getCause(), 1);
		}
	}

	public List<Items> getItems(Integer catlgId) throws ItemsException {
		try {
			return itemsRepository.findAllByCatlgId(catlgId);
		} catch (DataIntegrityViolationException e) {
			throw new ItemsException("No Catalog Found by :" + catlgId);
		}
	}

}
