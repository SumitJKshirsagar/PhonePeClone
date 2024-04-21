package com.example.phonepay.model;

public class OfferModel {
    private String offer_on_offer,offer_details;
    private int image;




    public OfferModel(String offer_on_offer, String offer_details, int image) {
        this.offer_on_offer = offer_on_offer;
        this.offer_details = offer_details;
        this.image = image;

    }
    public String getOffer_on_offer() {
        return offer_on_offer;
    }

    public void setOffer_on_offer(String offer_on_offer) {
        this.offer_on_offer = offer_on_offer;
    }


    public String getOffer_details() {
        return offer_details;
    }

    public void setOffer_details(String offer_details) {
        this.offer_details = offer_details;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
