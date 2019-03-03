package dao;

import model.Building;
import model.Village;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class AssertsDAO {
    public static ArrayList<Village> villages = new ArrayList<Village>();

    public static void save() throws FileNotFoundException {
        PrintWriter out = new PrintWriter("filename.txt");
        for (Village village : villages) {
            out.println("<Village>");
            out.println("\t<id>" + village.getID() + "</id>");
            out.println("\t<name>" + village.getName() + "</name>");
            out.println("\t<isLeft>" + village.isLeft() + "</isLeft>");
            out.println("\t<buildings>");
            for (Building building : village.getBuildings()) {
                out.println("\t\t<Building>");
                out.println("\t\t\t<name>" + building.getName() + "</name>");
                out.println("\t\t\t<level>" + building.getLevel() + "</level>");
                out.println("\t\t</Building>");
            }
            out.println("\t</buildings>");
            out.println("</Village>");
        }
        out.close();
    }

    public static void load() throws FileNotFoundException {
        Scanner in = new Scanner(new File("filename.txt"));
        villages = new ArrayList<Village>();
        String line;
        ArrayList<String> list = new ArrayList<String>();
        while (in.hasNext()) {
            line = in.nextLine();
            list.add(line);
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("<Village>")) {
                i++;
                int id = Integer.valueOf(getAttribute(list.get(i)));
                i++;
                String name = getAttribute(list.get(i));
                i++;
                boolean isLeft = Boolean.valueOf(getAttribute(list.get(i)));
                i += 2;
                Village newVillage = new Village(id, name, isLeft);
                if (list.get(i).contains("</buildings>"))
                    villages.add(newVillage);
                else if (list.get(i).contains("<Building>")) {

                    while (list.get(i).contains("<Building>")) {
                        i++;
                        String buildingName = getAttribute(list.get(i));
                        i++;
                        int level = Integer.valueOf(getAttribute(list.get(i)));
                        i += 2;
                        Building newBuilding = new Building(buildingName, level);
                        newVillage.getBuildings().add(newBuilding);
                    }
                    villages.add(newVillage);
                }
            }
        }
    }

    private static void printArray(ArrayList<String> list) {
        for (String s : list)
            System.out.println(s);
    }

    private static String getAttribute(String line) {
        if (line.contains("<id>")) {
            return line.substring(line.indexOf("<id>") + 4, line.indexOf("</id>"));
        } else if (line.contains("<name>")) {
            return line.substring(line.indexOf("<name>") + 6, line.indexOf("</name>"));
        } else if (line.contains("<level>")) {
            return line.substring(line.indexOf("<level>") + 7, line.indexOf("</level>"));
        } else if (line.contains("<isLeft>")) {
            return line.substring(line.indexOf("<isLeft>") + 8, line.indexOf("</isLeft>"));
        } else
            return "";
    }

    public static void sort() {
        Collections.sort(villages, new Comparator<Village>() {
            public int compare(Village o1, Village o2) {
                return o1.getID()-o2.getID();
            }
        });
    }
}
