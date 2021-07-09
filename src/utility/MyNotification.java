package utility;

import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class MyNotification {

    public void getNotification( NotificationType notiType,
                                 String title,String message,
                                 AnimationType animationType, Integer milliSecond){

        TrayNotification trayNotification = new TrayNotification();

        trayNotification.setNotificationType(notiType);
        trayNotification.setTitle(title);
        trayNotification.setMessage(message);
        trayNotification.setAnimationType(animationType);
        trayNotification.showAndDismiss(Duration.millis(milliSecond));

    }

}
