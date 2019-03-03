package controller;

import dao.AssertsDAO;
import model.Village;
import view.InterfaceView;
import view.VillageView;

import java.util.ArrayList;

import static view.InterfaceView.readKeyboard;


public class VillageController {

    public static void createVillage() {
        int id = getNewVillageID();
        VillageView.createVillageHeader(id);
        String name = readKeyboard();
        VillageView.isNewVillageNewQuestion();
        boolean isLeft = parseMessageToBoolean(readKeyboard());
        Village newVillage = new Village(id, name, isLeft);
        AssertsDAO.villages.add(newVillage);
        VillageView.successCreateMessage(name);
        if ("yes".equals(readKeyboard()))
            BuildingController.addBuilding(newVillage);
    }


    private static boolean parseMessageToBoolean(String message) {
        if ("true".equals(message) || "yes".equals(message) || "left".equals(message))
            return true;
        else
            return false;
    }

    private static int getNewVillageID() {
        boolean foundedFreeID = false;
        int i=1;
        for (; i < 1000 && !foundedFreeID;) {
            foundedFreeID = true;
            for (Village village : AssertsDAO.villages) {
                if (village.getID() == i)
                    foundedFreeID = false;
            }
            if (!foundedFreeID)
                i++;
        }

        return i;
    }

    public static void readVillage(Village village) {
        VillageView.printVillage(village, true);
    }

    public static void readVillages() {
        VillageView.printReadVillagesMenu();
        String message = readKeyboard();
        choosePrintOption(message);
        if ("yes".equals(message))
            VillageView.printVillages(AssertsDAO.villages, true);
        else if ("no".equals(message))
            VillageView.printVillages(AssertsDAO.villages, false);
    }

    public static void updateVillage() {
        VillageView.printUpdateVillagesMenu();
        String message = readKeyboard();
        chooseUpdateOption(message);
    }

    public static void deleteVillage() {
        VillageView.printVillages(AssertsDAO.villages, true);
        int id = askForVillageID();
        Village village = findVillageByID(id);
        if (village != null) {
            readVillage(village);
            if (confirmDelete()) {
                AssertsDAO.villages.remove(village);
                VillageView.successDeleteMessage();
            }
        } else {
            VillageView.villageNotFound();
        }

    }

    private static boolean confirmDelete() {
        VillageView.confirmDeleteMessage();
        return parseMessageToBoolean(readKeyboard());
    }

    private static void chooseUpdateOption(String message) {
        if ("1".equals(message)) {
            changeVillageName();
        } else if ("2".equals(message)) {
            changeVillageStatus();
        } else if ("3".equals(message)) {
            BuildingController.manageBuildings();
        }
    }

    private static void changeVillageStatus() {
        Village village = findVillageByInsertedID();
        VillageView.printVillage(village, false);
        boolean newStatus = askForVillageStatus();
        village.setLeft(newStatus);
        VillageView.successUpdateMessage();
    }

    private static boolean askForVillageStatus() {
        VillageView.insertNewVillageStatus();
        return parseMessageToBoolean(readKeyboard());
    }

    private static void changeVillageName() {
        Village village = findVillageByInsertedID();
        VillageView.printVillage(village, false);
        String newName = askForVillageName();
        village.setName(newName);
        VillageView.successUpdateMessage();
    }

    private static String askForVillageName() {
        VillageView.insertNewVillageName();
        return readKeyboard();
    }

    private static int askForVillageID() {
        VillageView.deleteVillageID();
        return Integer.valueOf(readKeyboard());
    }

    private static Village findVillageByInsertedID() {
        VillageView.insertSearchedVillageID();
        int id = parseMessageToInt(readKeyboard());
        return findVillageByID(id);
    }

    public static void choosePrintOption(String message) {
        if ("1".equals(message)) {
            printAllVillages();
        } else if ("2".equals(message)) {
            printVillageByID();
        } else if ("3".equals(message)) {
            printVillagesByName();
        } else if ("4".equals(message)) {
            printVillagesByStatus(false);
        } else if ("5".equals(message)) {
            printVillagesByStatus(true);
        } else {
            InterfaceView.invalidCommand();
        }
    }

    private static void printVillagesByStatus(boolean isLeft) {
        VillageView.printVillages(findVillagesByStatus(isLeft), printWithBuildingsQuestion());
    }

    private static ArrayList<Village> findVillagesByStatus(boolean isLeft) {
        ArrayList<Village> foundedVillages = new ArrayList<Village>();
        for (Village village : AssertsDAO.villages)
            if (village.isLeft() == isLeft)
                foundedVillages.add(village);
        return foundedVillages;
    }

    private static void printVillagesByName() {
        VillageView.insertSearchedVillagesName();
        String name = readKeyboard();
        ArrayList<Village> foundedVillages = findVillagesByName(name);
        if (foundedVillages.isEmpty())
            VillageView.villageNotFound();
        else
            VillageView.printVillages(foundedVillages, printWithBuildingsQuestion());
    }

    private static ArrayList<Village> findVillagesByName(String name) {
        ArrayList<Village> foundedVillages = new ArrayList<Village>();
        for (Village village : AssertsDAO.villages)
            if (village.getName().equals(name))
                foundedVillages.add(village);
        return foundedVillages;
    }

    public static void printAllVillages() {
        VillageView.printVillages(AssertsDAO.villages, printWithBuildingsQuestion());
    }

    private static void printVillageByID() {
        VillageView.insertSearchedVillageID();
        int id = parseMessageToInt(readKeyboard());
        Village foundedVillage = findVillageByID(id);
        if (foundedVillage == null)
            VillageView.villageNotFound();
        else
            VillageView.printVillage(foundedVillage, printWithBuildingsQuestion());
    }

    public static Village findVillageByID(int id) {
        for (Village village : AssertsDAO.villages) {
            if (village.getID() == id)
                return village;
        }
        return null;
    }

    private static boolean printWithBuildingsQuestion() {
        VillageView.printVillagesOption();
        String message = readKeyboard();
        if ("yes".equals(message) || "true".equals(message))
            return true;
        else
            return false;
    }

    private static int parseMessageToInt(String message) {
        return Integer.valueOf(message);
    }

}
