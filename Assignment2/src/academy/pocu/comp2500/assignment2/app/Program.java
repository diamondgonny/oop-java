package academy.pocu.comp2500.assignment2.app;

import academy.pocu.comp2500.assignment2.*;
import academy.pocu.comp2500.assignment2.App;
import academy.pocu.comp2500.assignment2.registry.Registry;

public class Program {

    public static void main(String[] args) {
//        BusinessCard businessCard = new BusinessCard(BusinessCardType.LAID, BusinessCardSides.DOUBLE, BusinessCardColor.GRAY, Orientation.LANDSCAPE, ShippingMethod.PICKUP);
//        businessCard.addAperture(new ImageAperture(0, 0, 3, 3, "hello"));
//        System.out.println(businessCard.getPrice());

//        ShoppingCart shoppingCart = new ShoppingCart();
//        Stamp stamp = new Stamp(StampSize.W70H40, StampColor.GREEN, "ABC", ShippingMethod.PICKUP);
//        shoppingCart.addItem(stamp);
//        stamp.setShippingMethod(ShippingMethod.SHIP);

//        ShoppingCart shoppingCart = new ShoppingCart();
//        Stamp stamp = new Stamp(StampSize.W40H30, StampColor.RED, "ABC", ShippingMethod.PICKUP);
//        shoppingCart.addItem(stamp);
//        stamp.setShippingMethod(ShippingMethod.SHIP);
//        System.out.println(stamp.getShippingMethod());
//        ...

        BusinessCard businessCard = new BusinessCard(BusinessCardType.LAID, BusinessCardColor.GRAY,
                BusinessCardSides.SINGLE, Orientation.LANDSCAPE, ShippingMethod.SHIP);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(businessCard);
        assert(shoppingCart.getTotalPrice() == 120);

        // 유효하지 않은 aperture 테스트
        TextAperture t1 = new TextAperture(-1, 0, 1, 1, "text");
        businessCard.addAperture(t1);
        assert(businessCard.getApertures().size() == 0);
        assert(shoppingCart.getTotalPrice() == 120);
        TextAperture t2 = new TextAperture(0, -1, 1, 1, "text");
        businessCard.addAperture(t2);
        assert(businessCard.getApertures().size() == 0);
        assert(shoppingCart.getTotalPrice() == 120);
        TextAperture t3 = new TextAperture(90, 0, 1, 1, "text");
        businessCard.addAperture(t3);
        assert(businessCard.getApertures().size() == 0);
        assert(shoppingCart.getTotalPrice() == 120);
        TextAperture t4 = new TextAperture(0, 50, 1, 1, "text");
        businessCard.addAperture(t4);
        assert(businessCard.getApertures().size() == 0);
        assert(shoppingCart.getTotalPrice() == 120);
        TextAperture t5 = new TextAperture(-10, 0, 10, 10, "text");
        businessCard.addAperture(t5);
        assert(businessCard.getApertures().size() == 0);
        assert(shoppingCart.getTotalPrice() == 120);
        TextAperture t6 = new TextAperture(0, -10, 10, 10, "text");
        businessCard.addAperture(t6);
        assert(businessCard.getApertures().size() == 0);
        assert(shoppingCart.getTotalPrice() == 120);
        TextAperture t7 = new TextAperture(90, 0, 10, 10, "text");
        businessCard.addAperture(t7);
        assert(businessCard.getApertures().size() == 0);
        assert(shoppingCart.getTotalPrice() == 120);
        TextAperture t8 = new TextAperture(0, 50, 10, 10, "text");
        businessCard.addAperture(t8);
        assert(businessCard.getApertures().size() == 0);
        assert(shoppingCart.getTotalPrice() == 120);

        // 유효한 aperture 테스트
        TextAperture v1 = new TextAperture(0, 0, 1, 1, "text");
        businessCard.addAperture(v1);
        assert(businessCard.getApertures().size() == 1);
        assert(shoppingCart.getTotalPrice() == 125);
        TextAperture v2 = new TextAperture(89, 49, 1, 1, "text");
        businessCard.addAperture(v2);
        assert(businessCard.getApertures().size() == 2);
        assert(shoppingCart.getTotalPrice() == 130);
        TextAperture v3 = new TextAperture(-9, -9, 10, 10, "text");
        businessCard.addAperture(v3);
        assert(businessCard.getApertures().size() == 3);
        assert(shoppingCart.getTotalPrice() == 135);
        TextAperture v4 = new TextAperture(89, 49, 10, 10, "text");
        businessCard.addAperture(v4);
        assert(businessCard.getApertures().size() == 4);
        assert(shoppingCart.getTotalPrice() == 140);
        TextAperture v5 = new TextAperture(0, 0, 90, 50, "text");
        businessCard.addAperture(v5);
        assert(businessCard.getApertures().size() == 5);
        assert(shoppingCart.getTotalPrice() == 145);
        ImageAperture w1 = new ImageAperture(0,0,90,50, "imagePath");
        businessCard.addAperture(w1);
        assert(businessCard.getApertures().size() == 6);
        assert(shoppingCart.getTotalPrice() == 150);
    }
}
