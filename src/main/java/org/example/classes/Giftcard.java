package org.example.classes;

import org.example.enums.GiftcardType;

public class Giftcard {
    Software gift;
    GiftcardType gift_type;

    public Giftcard(Software gift, GiftcardType gift_type) {
        this.gift = gift;
        this.gift_type = gift_type;
    }

    public Software getGift() {
        return gift;
    }

    public void setGift(Software gift) {
        this.gift = gift;
    }

    public GiftcardType getGift_type() {
        return gift_type;
    }

    public void setGift_type(GiftcardType gift_type) {
        this.gift_type = gift_type;
    }
}
