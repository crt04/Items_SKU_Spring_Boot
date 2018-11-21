package com.hd.items.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hd.items.entity.Items;
import com.hd.items.entity.ItemsPK;

/**
 * @author crt04
 *
 */
@Repository
public interface ItemsRepository extends CrudRepository<Items, ItemsPK> {

	List<Items> findAllByCatlgId(Integer catlgId);

}
