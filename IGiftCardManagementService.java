package com.egiftcard.service;

import java.util.List;

import org.springframework.web.bind.MethodArgumentNotValidException;

import com.egiftcard.entity.GiftCard;
import com.egiftcard.exception.DuplicateGiftCardIdException;
import com.egiftcard.exception.GiftCardNotFoundException;
import com.egiftcard.exception.InvalidIdException;

public interface IGiftCardManagementService {

	public List<GiftCard> getAllGiftCards();
	public GiftCard getGiftCardById(Integer  giftcardId)throws GiftCardNotFoundException,InvalidIdException;
	public GiftCard registerGiftCard(GiftCard giftCard) throws DuplicateGiftCardIdException,MethodArgumentNotValidException;
	public String deleteGiftCardById(Integer giftcardId)throws InvalidIdException;
	public GiftCard updateGiftCardById(Integer giftcardId, GiftCard giftCard)throws InvalidIdException;

}
