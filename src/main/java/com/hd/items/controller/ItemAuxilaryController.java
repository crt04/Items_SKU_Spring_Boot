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
import com.hd.items.dto.ItemsResp;
import com.hd.items.dto.ItemsSkuRelReq;
import com.hd.items.entity.ItemsSkuRel;
import com.hd.items.services.AuxilaryService;
import com.hd.items.util.GenericResponseWrapper;


@CrossOrigin
@Validated
@RestController
@RequestMapping(value = UrlConstants.AUXILIARY_CONTROLLER)
public class ItemAuxilaryController implements UrlConstants {
	
	private static final Logger LOGGER = LogManager.getLogger(ItemAuxilaryController.class);

	@Autowired
	AuxilaryService auxilaryService;

	@PostMapping(value = SAVE_UPDATE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> saveAndUpdateAuxilarySkus(@RequestBody ItemsSkuRelReq itemsSkuRelReq){

		List<ItemsSkuRel> itemsSkuRelResp = auxilaryService.saveUpdate(itemsSkuRelReq);
		
		return new ResponseEntity<GenericResponseWrapper<List<ItemsSkuRel>>>(new GenericResponseWrapper<List<ItemsSkuRel>>(itemsSkuRelResp), HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = DELETE + "/{primarySkuNbr}/{auxSkuNbr}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> deleteAuxilarySkus(@PathVariable Long primarySkuNbr, @PathVariable Long auxSkuNbr){
	
		ItemsResp itemsResp = new ItemsResp();
		String  itemSkuRelMsg = "";
		
		itemSkuRelMsg = auxilaryService.deleteAuxilarySkus(primarySkuNbr, auxSkuNbr);
		itemsResp.setStatusCode(200);
		itemSkuRelMsg = itemSkuRelMsg.contains("successful") ? itemSkuRelMsg : "Delete of auxilary sku: " + auxSkuNbr + " with primary sku: " + primarySkuNbr + " FAILED.";
		itemsResp.setMessage(itemSkuRelMsg);
		
		return new ResponseEntity<GenericResponseWrapper<ItemsResp>>(new GenericResponseWrapper<ItemsResp>(itemsResp), HttpStatus.OK);
	}
	
	
	@GetMapping(value = LIST_AUX_ITEMS_BY_SKU + "/{primarySkuNbr}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> getAuxilarySkusItems(@PathVariable Long primarySkuNbr) {
		
		List<ItemsSkuRel> auxItemCatlgResp = new ArrayList<ItemsSkuRel>();
		
		auxItemCatlgResp = auxilaryService.getAuxilarySkusItems(primarySkuNbr);
		
		return new ResponseEntity<GenericResponseWrapper<List<ItemsSkuRel>>>(new GenericResponseWrapper<List<ItemsSkuRel>>(auxItemCatlgResp), HttpStatus.OK);
	}
}
