package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        RationalFunctionPack pack = new RationalFunctionPack();

        try {
            Scanner in = new Scanner(new File("input.txt"));
            while (in.hasNext()) {
                pack.add(new RationalFunction(in.nextInt(), in.nextInt()));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(pack.getCurrentMax());
        System.out.println(pack.getCurrentMin());
        System.out.println(pack.lessThan(new RationalFunction(1, 1)));
        System.out.println(pack.lessThan(new RationalFunction(1, 2)));
        System.out.println(pack.moreThan(new RationalFunction(1, 1)));
        System.out.println(pack.moreThan(new RationalFunction(1, 4)));

        Polynom polynom = new Polynom(pack);
        Polynom polynom1 = new Polynom(pack);

        System.out.println(polynom.compute(1));
        System.out.println(polynom.sum(polynom1).compute(1));
    }
}
