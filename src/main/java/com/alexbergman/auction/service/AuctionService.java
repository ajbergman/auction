package com.alexbergman.auction.service;


import com.alexbergman.auction.entity.AuctionBid;
import com.alexbergman.auction.entity.AuctionItem;
import com.alexbergman.auction.repository.AuctionBidRepository;
import com.alexbergman.auction.repository.AuctionItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuctionService {

    @Autowired
    AuctionItemRepository auctionItemRepository;

    @Autowired
    AuctionBidRepository auctionBidRepository;

    public List<AuctionItem> getAuctionItems() {
        return auctionItemRepository.findAll();
    }

    public AuctionItem getAuctionItem(String auctionItemId) {
        return auctionItemRepository.findById(auctionItemId).get();
    }

    public AuctionItem saveAuctionItem(AuctionItem auctionItem) {
        if(auctionItem.getCurrentBid() == null)
            auctionItem.setCurrentBid(0.0);
        auctionItemRepository.save(auctionItem);
        return auctionItem;
    }


    public void saveAuctionBid(AuctionBid bid) {
        auctionBidRepository.save(bid);

        AuctionItem auctionItem = getAuctionItem(bid.getAuctionItemId());
        if(auctionItem != null){

            if(bid.getMaxAutoBidAmount() < auctionItem.getCurrentBid()){
                //TODO: return exception max bid less than current bid
                return;
            }

            if(auctionItem.getReservePrice() > bid.getMaxAutoBidAmount()){
                //  If the reserve price has not been met,
                //  current bid should be set to the maximum of the current bid and the max auto-bid amount

                if(auctionItem.getCurrentBid() < bid.getMaxAutoBidAmount()){
                    auctionItem.setCurrentBid(bid.getMaxAutoBidAmount());
                    auctionItem.setBidderName(bid.getBidderName());
                    auctionItemRepository.save(auctionItem);
                }
                //TODO: return exception letting the bidder know they have not met the reserve
                return;

            } else {
                // max auto-bid amount becomes the max amount bidder is willing to pay but not necessarily the amount they must pay.
                // As new bids are submitted for an item, bidder with the highest max auto-bid amount must only pay $1.00 more than the next highest bidder.
                // It is important to remember the bid leaders max auto-bid amount in case future bids are submitted for the item.
                // Any time a bidder has been outbid, an event/exception should be broadcast notifying them that they’ve been outbid.
                // TODO: finish this logic

                auctionItem.setCurrentBid( auctionItem.getCurrentBid() + 1.0 );
                auctionItem.setBidderName(bid.getBidderName());
                auctionItemRepository.save(auctionItem);

            }
        }

    }
}
