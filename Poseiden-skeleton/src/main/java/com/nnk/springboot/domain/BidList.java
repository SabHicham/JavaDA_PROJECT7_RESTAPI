package com.nnk.springboot.domain;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "bidlist")
public class BidList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String account;
    private String type;
    @Column(name = "bid_quantity")
    private Double bidQuantity;
    private Double askQuantity;
    private Double bid;
    private Double ask;
    private String benchmark;
    private Timestamp bidListDate;
    private String commentary;
    private String security;
    private String status;
    private String trader;
    private String book;
    private String creationName;
    private Timestamp creationDate;
    private String revisionName;
    private Timestamp revisionDate;
    private String dealName;
    private String dealType;
    private String sourceListId;
    private String side;

    public BidList() {

    }

    public BidList(int id, String account, String type, Double bidQuantity) {
        this.id = id;
        this.account = account;
        this.type = type;
        this.bidQuantity = bidQuantity;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getBidQuantity() {
        return bidQuantity;
    }

    public void setBidQuantity(Double bidQuantity) {
        this.bidQuantity = bidQuantity;
    }
}
