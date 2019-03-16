package com.codecool.virtual_pet.controller;

import com.codecool.virtual_pet.model.*;
import com.codecool.virtual_pet.notification_system_lib.Notification;
import com.codecool.virtual_pet.notification_system_lib.NotificationCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class PetControllerTest {

    PetController petController = new PetController(
            new PetModel("Test",
                new PetStats(40, 40, 40)
            ));

    @Test
    void constructor() {
        assertNull(petController.getPetView());
        assertNotNull(petController.getPetModel());
    }

    @Test
    void handlesCorrectNotifications() {
        assertTrue(petController.handleNotification(new Notification(NotificationCode.FEED_PET, PetFoodFactory.createFood(FoodName.JELLY))));
        assertTrue(petController.handleNotification(new Notification(NotificationCode.SLEEP)));
        assertTrue(petController.handleNotification(new Notification(NotificationCode.PLAY_WITH_PET)));
        assertFalse(petController.handleNotification(new Notification(NotificationCode.CREATE_PET)));
    }

    @Test
    void throwsExceptionWhenNoFoodProvided() {
        assertThrows(IllegalArgumentException.class,
                () -> petController.handleNotification(new Notification(NotificationCode.FEED_PET)));
    }

   @ParameterizedTest
   @EnumSource(FoodName.class)
    void handlesFeedNotificationProperly(FoodName foodName) {
        PetFood food = PetFoodFactory.createFood(foodName);
        double petHungerBefore = petController.getPetModel().getHunger();
        boolean handled = petController.handleNotification(new Notification(NotificationCode.FEED_PET, food));
        assertTrue(handled);
        assertEquals(petHungerBefore - food.getHungerModifier(), petController.getPetModel().getHunger());
    }

}