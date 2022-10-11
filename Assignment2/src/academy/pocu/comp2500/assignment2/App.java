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
        registry.registerLandscapeBannerTextApertureAdder("ProductAperture", "addAperture");
        registry.registerLandscapeBannerImageApertureAdder("ProductAperture", "addAperture");
        registry.registerPortraitBannerTextApertureAdder("ProductAperture", "addAperture");
        registry.registerPortraitBannerImageApertureAdder("ProductAperture", "addAperture");
        registry.registerGlossBannerTextApertureAdder("ProductAperture", "addAperture");
        registry.registerGlossBannerImageApertureAdder("ProductAperture", "addAperture");
        registry.registerScrimBannerTextApertureAdder("ProductAperture", "addAperture");
        registry.registerScrimBannerImageApertureAdder("ProductAperture", "addAperture");
        registry.registerMeshBannerTextApertureAdder("ProductAperture", "addAperture");
        registry.registerMeshBannerImageApertureAdder("ProductAperture", "addAperture");
        registry.registerLandscapeBusinessCardTextApertureAdder("ProductAperture", "addAperture");
        registry.registerLandscapeBusinessCardImageApertureAdder("ProductAperture", "addAperture");
        registry.registerPortraitBusinessCardTextApertureAdder("ProductAperture", "addAperture");
        registry.registerPortraitBusinessCardImageApertureAdder("ProductAperture", "addAperture");
        registry.registerIvoryBusinessCardTextApertureAdder("ProductAperture", "addAperture");
        registry.registerIvoryBusinessCardImageApertureAdder("ProductAperture", "addAperture");
        registry.registerGrayBusinessCardTextApertureAdder("ProductAperture", "addAperture");
        registry.registerGrayBusinessCardImageApertureAdder("ProductAperture", "addAperture");
        registry.registerWhiteBusinessCardTextApertureAdder("ProductAperture", "addAperture");
        registry.registerWhiteBusinessCardImageApertureAdder("ProductAperture", "addAperture");
        registry.registerLaidBusinessCardTextApertureAdder("ProductAperture", "addAperture");
        registry.registerLaidBusinessCardImageApertureAdder("ProductAperture", "addAperture");
        registry.registerLinenBusinessCardTextApertureAdder("ProductAperture", "addAperture");
        registry.registerLinenBusinessCardImageApertureAdder("ProductAperture", "addAperture");
        registry.registerSmoothBusinessCardTextApertureAdder("ProductAperture", "addAperture");
        registry.registerSmoothBusinessCardImageApertureAdder("ProductAperture", "addAperture");
        registry.registerSingleSidedBusinessCardTextApertureAdder("ProductAperture", "addAperture");
        registry.registerSingleSidedBusinessCardImageApertureAdder("ProductAperture", "addAperture");
        registry.registerDoubleSidedBusinessCardTextApertureAdder("ProductAperture", "addAperture");
        registry.registerDoubleSidedBusinessCardImageApertureAdder("ProductAperture", "addAperture");
    }
}
