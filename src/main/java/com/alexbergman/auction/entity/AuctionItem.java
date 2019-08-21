package com.alexbergman.auction.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AuctionItem {

    @Id
    @GeneratedValue
    private Integer auctionItemId;
    private Double currentBid;
    private Double reservePrice;
//    private Item item;

    public Integer getAuctionItemId() {
        return auctionItemId;
    }

    public void setAuctionItemId(Integer auctionItemId) {
        this.auctionItemId = auctionItemId;
    }

    public Double getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(Double currentBid) {
        this.currentBid = currentBid;
    }

    public Double getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(Double reservePrice) {
        this.reservePrice = reservePrice;
    }
}
