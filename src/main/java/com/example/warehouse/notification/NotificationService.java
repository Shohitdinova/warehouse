package com.example.warehouse.notification;

import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
public class NotificationService {
    private List<WarehouseCostItem> products;
    private List<Notification> notifications;


    // Notifikatsiya qo'shish metodi
    public void addNotification(String message, LocalDate expirationDate) {
        Notification notification = new Notification(message, expirationDate);
        notifications.add(notification);
    }



    // Notifikatsiyalarni tekshirish va olib tashlash metodi
    public void checkAndRemoveExpiredNotifications() {
        LocalDate currentDate =LocalDate.now();
        List<Notification> expiredNotifications = new ArrayList<>();

        for (Notification notification : notifications) {
            if (notification.getExpirationDate().isBefore(currentDate)) {
                expiredNotifications.add(notification);
            }
        }

        // Olib tashlash
        notifications.removeAll(expiredNotifications);
    }
}
