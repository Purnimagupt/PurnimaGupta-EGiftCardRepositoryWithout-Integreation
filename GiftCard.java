package com.egiftcard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="gift_card")
public class GiftCard {
		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE)
		@Column(name="gift_card_id")
		private int giftCardId;
		

		@Column(name="about_gift_card")
		@NotBlank(message="About GiftCard should have some information about GiftCard!")
		private String aboutGiftCard;
		
        @Column(name="brand_list")
        @NotBlank(message="BrandList must have at least one brand name of GiftCards! ")
		private String brandList;
		
		@Column(name="gift_card_name")
		@NotBlank(message="Name is mandatory.")
		private String giftCardName;
		
		@Column(name="maximum_amount")
		@Max(value=1000,message="Maximum Amount should be less than or equals to 1000")
		private float maxAmount;
		
		@Column(name=" minimum_amount")
		@Min(value=100,message="Miniimum Amount should be less than or equals to 100")
		private float minAmount;
		
		@Column(name="redemption_details")
		@NotBlank(message="Add some redemptiondetails.")
		private String redemptionDetails;
				
	
		
		public GiftCard() {
			super();
		}

		

		public GiftCard(int giftCardId,
				@NotBlank(message = "About GiftCard should have some information about GiftCard!") String aboutGiftCard,
				@NotBlank(message = "BrandList must have at least one brand name of GiftCards! ") String brandList,
				@NotBlank(message = "Name is mandatory.") String giftCardName,
				@Max(value = 1000, message = "Maximum Amount should be less than or equals to 1000") float maxAmount,
				@Min(value = 100, message = "Miniimum Amount should be less than or equals to 100") float minAmount,
				@NotBlank(message = "Add some redemptiondetails.") String redemptionDetails) {
			super();
			this.giftCardId = giftCardId;
			this.aboutGiftCard = aboutGiftCard;
			this.brandList = brandList;
			this.giftCardName = giftCardName;
			this.maxAmount = maxAmount;
			this.minAmount = minAmount;
			this.redemptionDetails = redemptionDetails;
		}



		//getters & setters
		public int getGiftcardId() {
			return giftCardId;
		}

		public void setGiftcardId(int giftcardId) {
			this.giftCardId = giftcardId;
		}

		public String getAboutGiftCard() {
			return aboutGiftCard;
		}

		public void setAboutGiftCard(String aboutGiftCard) {
			this.aboutGiftCard = aboutGiftCard;
		}

		public String getBrandlist() {
			return brandList;
		}

		public void setBrandlist(String brandlist) {
			this.brandList = brandlist;
		}
		
		public String getGiftcardName() {
			return giftCardName;
		}

		public void setGiftcardName(String giftcardName) {
			this.giftCardName = giftcardName;
		}
		
		public float getMaxAmount() {
			return maxAmount;
		}

		public void setMaxAmount(float maxAmount) {
			this.maxAmount = maxAmount;
		}
		

		public float getMinAmount() {
			return minAmount;
		}

		public void setMinAmount(float minAmount) {
			this.minAmount = minAmount;
		}


		public String getRedemptiondetails() {
			return redemptionDetails;
		}

		public void setRedemptiondetails(String redemptiondetails) {
			this.redemptionDetails = redemptiondetails;
		}

		@Override
		public String toString() {
			return "GiftCard [giftcardId=" + giftCardId + ", aboutGiftCard=" + aboutGiftCard + ", brandlist="
					+ brandList + ", giftcardName=" + giftCardName + ", maxAmount=" + maxAmount + ", minAmount="
					+ minAmount + ", redemptiondetails=" + redemptionDetails + "]";
		}


		

		
	}



