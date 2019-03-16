package com.codecool.virtual_pet.view;

import com.codecool.virtual_pet.model.pet_food.PetFood;

public class Util {

    public static String getFoodImageUrl(PetFood food) {
        String url = DisplayConfig.FOOD_ASSETS_DIR_URL;
        switch (food.getName()) {
            case MEAT:
                url += DisplayConfig.MEAT_IMG_URL;
                break;
            case MILK:
                url += DisplayConfig.MILK_IMG_URL;
                break;
            case BREAD:
                url += DisplayConfig.BREAD_IMG_URL;
                break;
            case JELLY:
                url += DisplayConfig.JELLY_IMG_URL;
                break;
            case ENERGY_TABS:
                url += DisplayConfig.PILLS_IMG_URL;
                break;
            case FAT:
                url += DisplayConfig.FAT_IMG_URL;
                break;
            case WATER:
                url += DisplayConfig.WATER_IMG_URL;
                break;
            default:
                url += DisplayConfig.NO_IMG_URL;
        }
        return url;
    }
}
