import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/observable';
import { AuctionItem } from './auction-item';
import { AuctionBid } from './auction-bid';

@Injectable()
export class AuctionServiceService {

  private itemsUrl: string;
  private bidUrl: string;

  constructor(private http: HttpClient) {
    this.itemsUrl = 'http://localhost:8080/auctionItems';
    this.bidUrl = 'http://localhost:8080/bids';
  }

  public findAll() : Observable<AuctionItem[]> {
    return this.http.get<AuctionItem[]>(this.itemsUrl);
  }

  public saveItem(item: AuctionItem) {
    return this.http.post<AuctionItem>(this.itemsUrl, item);
  }

  public saveBid(bid: AuctionBid) {
      return this.http.post<AuctionItem>(this.bidUrl, bid);
    }
}
