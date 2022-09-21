package com.egiftcard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.egiftcard.dao.IGiftCardManagementRepository;
import com.egiftcard.entity.GiftCard;
import com.egiftcard.exception.DuplicateGiftCardIdException;
import com.egiftcard.exception.GiftCardNotFoundException;
import com.egiftcard.exception.InvalidIdException;

@Service
public  class GiftCardManagementServiceImpl implements IGiftCardManagementService{

	@Autowired
	private IGiftCardManagementRepository giftCardRepository;
	
	@Override
	public List<GiftCard> getAllGiftCards() {
		System.out.println("Service layer getALLGiftCard!");
		return giftCardRepository.findAll();
		}

	
	@Override
	public GiftCard getGiftCardById(Integer giftCardId)throws GiftCardNotFoundException,InvalidIdException {
		System.out.println("Service layer getGiftCardById!");
		Optional<GiftCard> giftCardObj=giftCardRepository.findById(giftCardId);
		if(!giftCardObj.isPresent()) {
			throw new GiftCardNotFoundException("GiftCard with this Id " +giftCardId +"  does not exist!");
		}
		if(giftCardId==0 || giftCardId<0) {
			throw new InvalidIdException("Invalid Id! Enter correct Id!");
		}
		return giftCardObj.get();
	}

	@Override
	public GiftCard registerGiftCard(GiftCard giftCard)throws DuplicateGiftCardIdException,MethodArgumentNotValidException {
		System.out.println("Service layer registerGiftCard!");
		Optional<GiftCard>registerIdObj= giftCardRepository.findById(giftCard.getGiftcardId());
		if(registerIdObj.isPresent()) {
			throw new DuplicateGiftCardIdException("This GiftCard Id"+giftCard.getGiftcardId()+"is already exist");
		}
        return giftCardRepository.saveAndFlush(giftCard);
		}
	
	

	@Override
	public GiftCard updateGiftCardById(Integer giftCardId,GiftCard giftCard) throws InvalidIdException{
		System.out.println("Service layer updateGiftCardById!");
		Optional<GiftCard>updateGiftCardObj=giftCardRepository.findById(giftCardId);
		if(!updateGiftCardObj.isPresent()) {
			throw new InvalidIdException("Updating with invalid id! GiftCard with this Id  "+ giftCardId +" does not exist!");
		}
	   GiftCard giftCardUpdateByIdObj=giftCardRepository.findById(giftCardId).get();
	   giftCardUpdateByIdObj.setGiftcardId(giftCard.getGiftcardId());
	   giftCardUpdateByIdObj.setAboutGiftCard(giftCard.getAboutGiftCard());
	   giftCardUpdateByIdObj.setBrandlist(giftCard.getBrandlist()); 
	   giftCardUpdateByIdObj.setGiftcardName(giftCard.getGiftcardName());
	   giftCardUpdateByIdObj.setMaxAmount(giftCard.getMaxAmount());
	   giftCardUpdateByIdObj.setMinAmount(giftCard.getMinAmount());
	   giftCardUpdateByIdObj.setRedemptiondetails(giftCard.getRedemptiondetails());
		return giftCardRepository.saveAndFlush( giftCardUpdateByIdObj);
		
	}
	

	@Override
	public String deleteGiftCardById(Integer giftCardId) throws InvalidIdException {
		//System.out.println("Service layer deleteGiftCardById!");
		Optional<GiftCard>deleteGiftCardObj=giftCardRepository.findById(giftCardId);
		//System.out.println(deleteGiftCardObj.get());
		if(!deleteGiftCardObj.isPresent()) {
			throw new InvalidIdException("Deleting with invalid id ! GiftCard with this id "+ giftCardId+"  does not exist!");
		}
		giftCardRepository.deleteById(giftCardId);
		return "Gift Card With Id "+ giftCardId + "is Succesfully Deleted";
	}
	


}
