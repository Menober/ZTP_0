import model.Building;
import model.Village;
import org.junit.Test;
import view.VillageView;

import java.util.ArrayList;

public class VillageViewTest {

    @Test
    public void VillageViewHiddenBuildingsTest(){
        ArrayList<Village> list=new ArrayList<Village>();
        Village s1=new Village(1,"Olsztyn",false);
        Village s2=new Village(2,"Warszawa",false);
        Village s3=new Village(3,"Wroclaw",false);
        Village s4=new Village(4,"Krakow", true);

        ArrayList<Building> Buildings=new ArrayList<Building>();
        Buildings.add(new Building("Ratusz",5));
        Buildings.add(new Building("Karczma",6));
        Buildings.add(new Building("Spichlerz",3));
        s1.setBuildings((ArrayList<Building>) Buildings.clone());
        Buildings.remove(2);
        s3.setBuildings((ArrayList<Building>) Buildings.clone());
        Buildings.remove(1);
        s4.setBuildings((ArrayList<Building>) Buildings.clone());
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        VillageView.printVillages(list,false);

    }

    @Test
    public void VillageViewVisibleBuildingsTest(){
        ArrayList<Village> list=new ArrayList<Village>();
        Village s1=new Village(1,"Olsztyn",false);
        Village s2=new Village(2,"Warszawa",false);
        Village s3=new Village(3,"Wroclaw",false);
        Village s4=new Village(4,"Krakow", true);

        ArrayList<Building> Buildings=new ArrayList<Building>();
        Buildings.add(new Building("Ratusz",5));
        Buildings.add(new Building("Karczma",6));
        Buildings.add(new Building("Spichlerz",3));
        s1.setBuildings((ArrayList<Building>) Buildings.clone());
        Buildings.remove(2);
        s3.setBuildings((ArrayList<Building>) Buildings.clone());
        Buildings.remove(1);
        s4.setBuildings((ArrayList<Building>) Buildings.clone());
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        VillageView.printVillages(list,true);

    }
}
