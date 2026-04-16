package Bai3;

public class Bai3 {
    public static void main(String[] args) {
        Class<BusinessLogic> clazz = BusinessLogic.class;

        if (clazz.isAnnotationPresent(Developer.class)) {
            Developer dev = clazz.getAnnotation(Developer.class);
            System.out.println("Developer Info:");
            System.out.println("Name: " + dev.name());
            System.out.println("Version: " + dev.version());
        }
    }
}