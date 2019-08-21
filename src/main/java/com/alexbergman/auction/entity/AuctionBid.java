package com.alexbergman.auction.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AuctionBid {

    @Id
    @GeneratedValue
    private Integer auctionBidId;
    private String auctionItemId;
    private Double maxAutoBidAmount;
    private String bidderName;

    public String getAuctionItemId() {
        return auctionItemId;
    }

    public void setAuctionItemId(String auctionItemId) {
        this.auctionItemId = auctionItemId;
    }

    public Double getMaxAutoBidAmount() {
        return maxAutoBidAmount;
    }

    public void setMaxAutoBidAmount(Double maxAutoBidAmount) {
        this.maxAutoBidAmount = maxAutoBidAmount;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }
}
