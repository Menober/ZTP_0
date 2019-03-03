package controller;

import model.Building;
import model.Village;
import view.BuildingView;
import view.VillageView;

import static controller.VillageController.findVillageByID;
import static controller.VillageController.printAllVillages;
import static view.InterfaceView.readKeyboard;

public class BuildingController {
    public static void addBuilding(Village newVillage) {
        Building newBuilding = new Building();
        insertBuildingName(newBuilding);
        insertBuildingLevel(newBuilding);
        attachBuilding(newVillage, newBuilding);
        BuildingView.successAddBuilding();
    }

    public static void addBuilding() {
        Village foundedVillage = findVillageByID(insertVillageID());
        if (foundedVillage != null) {
            Building newBuilding = new Building();
            insertBuildingName(newBuilding);
            insertBuildingLevel(newBuilding);
            attachBuilding(foundedVillage, newBuilding);
            BuildingView.successAddBuilding();
        } else {
            VillageView.villageNotFound();
        }
    }

    private static void attachBuilding(Village village, Building building) {
        village.getBuildings().add(building);
    }

    public static void manageBuildings() {
        BuildingView.printBuildingsMenu();
        String message = readKeyboard();
        chooseManageBuildingsOption(message);
    }

    private static void chooseManageBuildingsOption(String message) {
        if ("1".equals(message)) {
            showBuildingsOfVillage();
        } else if ("2".equals(message)) {
            addBuilding();
        } else if ("3".equals(message)) {
            removeBuilding();
        } else if ("4".equals(message)) {
            editBuilding();
        }
    }

    private static void editBuilding() {
        printAllVillages();
        int id = insertVillageID();
        Village village = findVillageByID(id);
        if (village != null) {
            boolean hasBuildings = showBuildingsOfVillageWithIndexes(village);
            if (hasBuildings) {
                int idBuilding = insertBuildingIndex();
                editBuildingByIndex(village, idBuilding);


                BuildingView.successRemoveBuildingMessage();
            } else {
                BuildingView.noBuildingsMessage();
            }
        } else {
            VillageView.villageNotFound();
        }
    }

    private static void editBuildingByIndex(Village village, int idBuilding) {
        BuildingView.askWhatToEdit();
        int option = parseMessageToInt(readKeyboard());
        if (option == 1) {
            insertBuildingName(village.getBuildings().get(idBuilding));
            insertBuildingLevel(village.getBuildings().get(idBuilding));
        } else if (option == 2) {
            insertBuildingName(village.getBuildings().get(idBuilding));
        } else if (option == 3) {
            insertBuildingLevel(village.getBuildings().get(idBuilding));
        }
    }

    private static void removeBuilding() {
        printAllVillages();
        int id = insertVillageID();
        Village village = findVillageByID(id);
        if (village != null) {
            boolean hasBuildings = showBuildingsOfVillageWithIndexes(village);
            if (hasBuildings) {
                int idBuilding = insertBuildingIndex();
                village.getBuildings().remove(idBuilding);
                BuildingView.successRemoveBuildingMessage();
            } else {
                BuildingView.noBuildingsMessage();
            }
        } else {
            VillageView.villageNotFound();
        }
    }

    private static void showBuildingsOfVillage() {
        int id = insertVillageID();
        Village village = findVillageByID(id);
        if (village.getBuildings() == null)
            BuildingView.noBuildingsMessage();
        else
            BuildingView.printVillageBuildings(village);
    }

    private static boolean showBuildingsOfVillageWithIndexes(Village village) {
        if (village.getBuildings() == null) {
            BuildingView.noBuildingsMessage();
            return false;
        } else {
            BuildingView.printVillageBuildingsWithIndexes(village);
            return true;
        }

    }

    private static int insertBuildingIndex() {
        BuildingView.askforBuildingIndex();
        return parseMessageToInt(readKeyboard());
    }

    private static int insertVillageID() {
        BuildingView.askforVillageID();
        return parseMessageToInt(readKeyboard());
    }

    public static void insertBuildingName(Building building) {
        BuildingView.askForBuildingName();
        String name = readKeyboard();
        building.setName(name);
    }

    public static void insertBuildingLevel(Building building) {
        BuildingView.askForBuildingLevel();
        int level = parseMessageToInt(readKeyboard());
        building.setLevel(level);
    }
    private static int parseMessageToInt(String message){
        try{
            int intValue=Integer.valueOf(message);
            return intValue;
        }catch (NumberFormatException e){
            return -1;
        }
    }
}
