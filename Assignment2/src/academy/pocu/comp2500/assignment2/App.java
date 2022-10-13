package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        // register your classes or methods here
        registry.registerRedStampCreator("Stamp");
        registry.registerBlueStampCreator("Stamp");
        registry.registerGreenStampCreator("Stamp");
        registry.registerWallCalendarCreator("Calendar");
        registry.registerMagnetCalendarCreator("Calendar");
        registry.registerDeskCalendarCreator("Calendar");
        registry.registerLandscapeBannerCreator("Banner");
        registry.registerPortraitBannerCreator("Banner");
        registry.registerGlossBannerCreator("Banner");
        registry.registerScrimBannerCreator("Banner");
        registry.registerMeshBannerCreator("Banner");
        registry.registerLandscapeBusinessCardCreator("BusinessCard");
        registry.registerPortraitBusinessCardCreator("BusinessCard");
        registry.registerIvoryBusinessCardCreator("BusinessCard");
        registry.registerGrayBusinessCardCreator("BusinessCard");
        registry.registerWhiteBusinessCardCreator("BusinessCard");
        registry.registerLaidBusinessCardCreator("BusinessCard");
        registry.registerLinenBusinessCardCreator("BusinessCard");
        registry.registerSmoothBusinessCardCreator("BusinessCard");
        registry.registerSingleSidedBusinessCardCreator("BusinessCard");
        registry.registerDoubleSidedBusinessCardCreator("BusinessCard");

        registry.registerCartCreator("ShoppingCart");
        registry.registerProductAdder("ShoppingCart", "addItem");
        registry.registerProductRemover("ShoppingCart", "removeItem");
        registry.registerTotalPriceGetter("ShoppingCart", "getTotalPrice");
        registry.registerLandscapeBannerTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerLandscapeBannerImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerPortraitBannerTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerPortraitBannerImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerGlossBannerTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerGlossBannerImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerScrimBannerTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerScrimBannerImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerMeshBannerTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerMeshBannerImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerLandscapeBusinessCardTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerLandscapeBusinessCardImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerPortraitBusinessCardTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerPortraitBusinessCardImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerIvoryBusinessCardTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerIvoryBusinessCardImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerGrayBusinessCardTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerGrayBusinessCardImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerWhiteBusinessCardTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerWhiteBusinessCardImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerLaidBusinessCardTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerLaidBusinessCardImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerLinenBusinessCardTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerLinenBusinessCardImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerSmoothBusinessCardTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerSmoothBusinessCardImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerSingleSidedBusinessCardTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerSingleSidedBusinessCardImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerDoubleSidedBusinessCardTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerDoubleSidedBusinessCardImageApertureAdder("CustomizableProduct", "addAperture");
    }
}
