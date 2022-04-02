package com.se.mockitotest;

public class App {
    public static void main(String[] args) {
        Sensor sensor = new Sensor();
        Controller controller = new Controller(sensor);

        for (int i = 0; i < 10; i++) {
            controller.check();
            if(! controller.getStatus())
                System.out.println(">>>>>>>>>>>> Status: " + controller.getStatus());
        }
    }
}
