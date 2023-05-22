package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address(){ //임베디드 타입은 생성자 있어야 함

    }
    public Address(String city, String street, String zipcode){
        this.city=city;
        this.street=street;
        this.zipcode=zipcode;
    }
}
