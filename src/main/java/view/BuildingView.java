package view;

import model.Building;
import model.Village;

public class BuildingView {

    public static void askForBuildingName() {
        System.out.println("Insert new building name:");
    }

    public static void askForBuildingLevel() {
        System.out.println("Insert new building level:");
    }

    public static void successAddBuilding() {
        System.out.println("Building added with success.");
    }

    public static void printBuildingsMenu() {
        System.out.println("[1] Print buildings of the village");
        System.out.println("[2] Add building to the village");
        System.out.println("[3] Remove building from the village");
        System.out.println("[4] Edit building of the village");
    }

    public static void askforVillageID() {
        System.out.println("What is an ID of village?");
    }

    public static void noBuildingsMessage() {
        System.out.println("This village has no buildings");
    }

    public static void printVillageBuildings(Village village) {
        System.out.println(String.format("%15s%7s", "Name:", "Level:"));
        for (Building building : village.getBuildings()) {
            System.out.print(String.format("%15s", building.getName()));
            System.out.println(String.format("%7d", building.getLevel()));
        }
    }

    public static void printVillageBuildingsWithIndexes(Village village) {
        System.out.println(String.format("%6s%15s%7s", "Index:", "Name:", "Level:"));
        int index = 0;
        for (Building building : village.getBuildings()) {
            System.out.print(String.format("%6d", index));
            System.out.print(String.format("%15s", building.getName()));
            System.out.println(String.format("%7d", building.getLevel()));
            index += 1;
        }
    }

    public static void askforBuildingIndex() {
        System.out.println("Choose index of building.");
    }

    public static void successRemoveBuildingMessage() {
        System.out.println("Building removed successful.");
    }

    public static void askWhatToEdit() {
        System.out.println("What do you want to edit?");
        System.out.println("[1] Everything");
        System.out.println("[2] Name");
        System.out.println("[3] Level");
    }
}
