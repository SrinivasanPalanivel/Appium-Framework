package absa.aic.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.time.Duration;

public final class AppiumServerManager {

    private static AppiumDriverLocalService service;

    public static void startAppiumServer() {
        // To Start the Appium Server Programmatically
        File file = new File("C:\\nvm4w\\nodejs\\node_modules\\appium\\build\\lib\\main.js");
        service = new AppiumServiceBuilder()
                .withAppiumJS(file)
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withTimeout(Duration.ofSeconds(90))
                .build();
        service.start();

        System.out.println("Server started: " + service.isRunning());
    }

    public static void stopAppiumServer() {
        // To Stop the Appium Server Programmatically
        if (service != null && service.isRunning()) {
            service.stop();
            System.out.println("Server stopped.");
        }
    }
}
