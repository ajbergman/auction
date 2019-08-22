import { Item } from './item';

export class AuctionItem {
    auctionItemId: string;
    reservePrice: string;
    item: Item;

    currentBid: string;
    bidderName: string;
}
