package view;

import model.Building;
import model.Village;

import java.util.ArrayList;
import java.util.List;

public class VillageView {
    public static void printVillage(Village village, boolean withBuildings) {
        printHeader();
        printSuperiorData(village);
        if (withBuildings && village.getBuildings().size() > 0)
            printBuildings(village.getBuildings());

    }

    public static void printVillages(List<Village> villages, boolean withBuildings) {
        printHeader(villages);
        for (Village village : villages) {
            printSuperiorData(village);
            if (withBuildings && village.getBuildings().size() > 0)
                printBuildings(village.getBuildings());

        }
        System.out.println();

    }

    private static void printSuperiorData(Village s) {
        System.out.print(String.format("%5d", s.getID()));
        System.out.print(String.format("%10s", s.getName()));
        System.out.println(String.format("%10s", s.isLeft()));
    }

    private static void printHeader(List<Village> villages) {
        System.out.println("<Villages>");
        System.out.println("Count: " + villages.size());
        System.out.println(String.format("%5s", "ID:") + String.format("%10s", "Name:") + String.format("%10s", "Left:"));
    }

    private static void printHeader() {
        System.out.println("<Village>");
        System.out.println(String.format("%5s", "ID:") + String.format("%10s", "Name:") + String.format("%10s", "Left:"));
    }

    private static void printBuildingsHeader(ArrayList<Building> Buildings) {
        printTab();
        System.out.println("<<Buildings>>");
        printTab();
        System.out.println("Count: " + Buildings.size());
        printTab();
        System.out.println(String.format("%15s", "Name:") + String.format("%10s", "Level:"));
    }

    public static void printBuildings(ArrayList<Building> Buildings) {
        printBuildingsHeader(Buildings);
        for (Building Building : Buildings)
            printBuildingData(Building);
        printBuildingsFooter();
    }

    private static void printBuildingsFooter() {
        printTab();
        System.out.println("<---------------------->");
    }

    private static void printBuildingData(Building s) {
        printTab();
        System.out.print(String.format("%15s", s.getName()));
        System.out.println(String.format("%10s", s.getLevel()));
    }

    private static void printTab() {
        System.out.print("                   ");
    }

    public static void printReadVillagesMenu() {
        System.out.println("[1] Print all villages");
        System.out.println("[2] Find and print village by ID");
        System.out.println("[3] Find and print villages by name");
        System.out.println("[4] Print not left villages");
        System.out.println("[5] Print left villages");
    }

    public static void printVillagesOption() {
        System.out.println("Do you want to print villages with a buildings? yes/no");
    }

    public static void createVillageHeader(int id) {
        System.out.println("ID of new village: " + id);
        System.out.println("Enter the name:");
    }

    public static void isNewVillageNewQuestion() {
        System.out.println("Is left?: true/false");
    }

    public static void successCreateMessage(String name) {
        System.out.println("The village " + name + " created correctly.");
        System.out.println("Do you want to add buildings? yes/no");
    }

    public static void insertSearchedVillageID() {
        System.out.println("Insert ID of village you want to see:");
    }

    public static void villageNotFound() {
        System.out.println("Sorry, village not found.");
    }

    public static void insertSearchedVillagesName() {
        System.out.println("Insert name of villages you want to see:");
    }

    public static void printUpdateVillagesMenu() {
        System.out.println("[1] Change village name");
        System.out.println("[2] Change village status");
        System.out.println("[3] Manage buildings");

    }

    public static void insertNewVillageName() {
        System.out.println("Insert new name for this village:");
    }

    public static void successUpdateMessage() {
        System.out.println("Village update success.");
    }

    public static void insertNewVillageStatus() {
        System.out.println("Insert new status for this village:");
    }

    public static void deleteVillageID() {
        System.out.println("Insert ID of village which you want to delete:");
    }

    public static void confirmDeleteMessage() {
        System.out.println("Do you really want to delete this village? yes/no");
    }

    public static void successDeleteMessage() {
        System.out.println("Village success deleted.");
    }
}
