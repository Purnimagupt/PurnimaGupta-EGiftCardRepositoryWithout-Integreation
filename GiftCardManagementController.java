package com.egiftcard.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egiftcard.entity.GiftCard;
import com.egiftcard.exception.DuplicateGiftCardIdException;
import com.egiftcard.exception.GiftCardNotFoundException;
import com.egiftcard.exception.InvalidIdException;
import com.egiftcard.service.IGiftCardManagementService;

@RestController
@RequestMapping("/api/GiftCard")
public class GiftCardManagementController {

	@Autowired
	private IGiftCardManagementService giftCardService;
	
	//http://localhost:8080/EGiftApp/api/GiftCard/getGiftCard
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value="/getGiftCard")
	public ResponseEntity<List<GiftCard>>getAllGiftCard(){
		List<GiftCard>giftCardList=giftCardService.getAllGiftCards();
		if(giftCardList.isEmpty()) {
			return new ResponseEntity("Sorry!GiftCards Not Found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<GiftCard>>(giftCardList,HttpStatus.OK);
	}
	
	//http://localhost:8080/EGiftApp/api/GiftCard/getGiftCard/
	@GetMapping(value="/getGiftCard/{giftCardId}")
	public ResponseEntity<GiftCard>getGiftCardById(@PathVariable("giftCardId")Integer giftCardId)throws GiftCardNotFoundException,InvalidIdException{
		GiftCard giftcardIdObj=giftCardService.getGiftCardById(giftCardId);
		return new ResponseEntity<GiftCard>(giftcardIdObj,HttpStatus.OK);
	}
	
	
	//http://localhost:8080/EGiftApp/api/GiftCard/update/
	@PutMapping(value="/update/{giftCardId}")
	public ResponseEntity<GiftCard>updateGiftCardById(@PathVariable int giftCardId,@Valid @RequestBody GiftCard giftCard)throws InvalidIdException{
		
		return new ResponseEntity<GiftCard>( giftCardService.updateGiftCardById(giftCardId,giftCard),HttpStatus.ACCEPTED);
		
	}
	
	
	//http://localhost:8080/EGiftApp/api/GiftCard/create
	@PostMapping(value="/create")
	public ResponseEntity<GiftCard>registerGiftCard(@Valid @RequestBody GiftCard giftCard)throws DuplicateGiftCardIdException,MethodArgumentNotValidException{
		GiftCard registerGiftCard=giftCardService.registerGiftCard(giftCard);
		return  ResponseEntity.ok(registerGiftCard);
	}
	
	
	//http://localhost:8080/EGiftApp/api/GiftCard/delete/{giftCardId}
	@DeleteMapping(value="/delete/{giftCardId}")
	public ResponseEntity<String>deleteGiftCardById(@PathVariable("giftCardId")int giftCardId)throws InvalidIdException{
		String deleteGiftCard=giftCardService.deleteGiftCardById(giftCardId);
		return new ResponseEntity<String>(deleteGiftCard,HttpStatus.OK);
	}
}
