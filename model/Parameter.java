package com.diabetes.simpleserver.model;

import javax.persistence.*;

/**
 * Created by Milamesher on 12.09.2019.
 */
@Entity
@Table(name = "parameter")
public class Parameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public int getId() {
        return id;
    }

    @Basic
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "val")
    private String val;


    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Parameter () {}
    @Override
    public String toString() {
        return "parameter{" +
                "id=" + id +
                ", name='" + name +
                ", val=" + val +
                '}';
    }
}