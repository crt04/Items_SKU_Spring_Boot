package com.hd.items.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hd.items.constants.UrlConstants;
import com.hd.items.dto.ItemsReq;
import com.hd.items.dto.ItemsResp;
import com.hd.items.entity.Items;
import com.hd.items.entity.ItemsPK;
import com.hd.items.services.ItemsService;
import com.hd.items.util.ItemsException;
import com.hd.items.util.GenericResponseWrapper;

/**
 * @author crt04
 *
 */
@CrossOrigin
@RestController
@Validated
@RequestMapping(value = UrlConstants.ITEMS_CONTROLLER)
public class ItemController implements UrlConstants {

	private static final Logger LOGGER = LogManager.getLogger(ItemController.class);

	@Autowired
	ItemsService itemsService;

	@PostMapping(value = SAVE_UPDATE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveAndUpdateItems(@RequestBody List<ItemsReq> addItems) throws ItemsException {

		int totalAddedCnt = 0;
		ItemsResp itemsResponse = new ItemsResp();
		List<Items> respList = new ArrayList<Items>();
		for (ItemsReq itemsRequest : addItems) {
			respList.add(itemsService.save(itemsRequest.toEntity()));
			totalAddedCnt += 1;
		}
		itemsResponse.setStatusCode(0);
		itemsResponse.setDatabaseUpdateCount(totalAddedCnt);
		itemsResponse.setMessage(totalAddedCnt + " Item(s) added successfully");

		return new ResponseEntity<GenericResponseWrapper<ItemsResp>>(
				new GenericResponseWrapper<ItemsResp>(itemsResponse), HttpStatus.OK);
	}

	@DeleteMapping(value = DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteItems(@RequestBody List<ItemsPK> deleteItems) throws ItemsException {

		int totalDeletedCnt = 0;
		ItemsResp itemsResponse = new ItemsResp();

		for (ItemsPK itemsPK : deleteItems) {

			try {
				itemsService.deleteItems(itemsPK);
				// this throws exception if no row found below two lines aren't executed
				totalDeletedCnt++;
				itemsResponse.setStatusCode(0);

			} catch (ItemsException de) {
				itemsResponse.setStatusCode(500);
				LOGGER.error(de.getMessage());

			} catch (Exception ex) {
				itemsResponse.setStatusCode(500);
				LOGGER.error(
						"Delete items failed for catalog: " + itemsPK.getCatlgId() + " item: " + itemsPK.getItemId());
			}
		}
		itemsResponse.setDatabaseUpdateCount(totalDeletedCnt);
		itemsResponse.setMessage(totalDeletedCnt + " Item(s) deleted successfully");

		return new ResponseEntity<GenericResponseWrapper<ItemsResp>>(
				new GenericResponseWrapper<ItemsResp>(itemsResponse), HttpStatus.OK);

	}

	@GetMapping(value = LIST + "/{catlgId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getItems(@PathVariable Integer catlgId) throws ItemsException {
		List<Items> items = itemsService.getItems(catlgId);
		return new ResponseEntity<GenericResponseWrapper<List<Items>>>(
				new GenericResponseWrapper<List<Items>>(items, "Success", 0), HttpStatus.OK);
	}

}
