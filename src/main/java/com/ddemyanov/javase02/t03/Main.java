package com.ddemyanov.javase02.t03;

import com.ddemyanov.javase02.t02.stationery.Ruler;
import com.ddemyanov.javase02.t03.OfficeEquipment.HolePuncher;
import com.ddemyanov.javase02.t03.OfficeEquipment.Stapler;
import com.ddemyanov.javase02.t03.OfficeEquipment.Staples;
import com.ddemyanov.javase02.t03.SchoolEqipment.Sharpener;
import com.ddemyanov.javase02.t03.WritingEquipment.Pen;
import com.ddemyanov.javase02.t03.WritingEquipment.Pencil;

import java.util.ArrayList;

public class Main {

private static final ArrayList<Stationery> noviceSet = new ArrayList <>();

    public static void main(String[] args) {
        noviceSet.add(new Stapler());
        noviceSet.add(new Staples());
        noviceSet.add(new HolePuncher());
        noviceSet.add(new Pen());
        noviceSet.add(new Pencil());
        noviceSet.add(new Sharpener());
    }


}
