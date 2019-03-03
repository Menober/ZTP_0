package controller;

import dao.AssertsDAO;
import view.InterfaceView;

import java.io.FileNotFoundException;

public class InterfaceController {

    public static void chooseOption(String message) {
        if ("bye".equals(message) || "exit".equals(message)) {
            InterfaceView.exitMessage();
        } else if ("1".equals(message)) {
            VillageController.createVillage();
        } else if ("2".equals(message)) {
            VillageController.readVillages();
        } else if ("3".equals(message)) {
            VillageController.updateVillage();
        } else if ("4".equals(message)) {
            VillageController.deleteVillage();
        } else if ("5".equals(message)) {
            try {
                AssertsDAO.load();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else if ("6".equals(message)) {
            try {
                InterfaceView.tryToSaveMessage();
                AssertsDAO.save();
                InterfaceView.successSaveMessage();
            } catch (FileNotFoundException e) {
                InterfaceView.exceptionMessage(e);
            }
        }else if ("7".equals(message)) {
           AssertsDAO.sort();
        } else {
            InterfaceView.invalidCommand();
        }

    }


}
