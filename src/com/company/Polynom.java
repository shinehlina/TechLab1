package com.company;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
class Polynom {
    private RationalFunctionPack pack;

    double compute(double x) {
        List<RationalFunction> coefficients = pack.getRationalFunctionList();
        if (coefficients.isEmpty())
            return 0;
        double result = 0;
        for (RationalFunction coefficient: coefficients) {
            result = result * x + coefficient.doubleRepresentation();
        }
        return result;
    }

    Polynom sum (Polynom polynom) {
        RationalFunctionPack resultPack = new RationalFunctionPack();
        int maxIndex = Math.min(pack.getSize(), polynom.getPack().getSize());
        for (int i = 0; i < maxIndex; i++){
            RationalFunction first = pack.getRationalFunctionList().get(i);
            RationalFunction second = polynom.getPack().getRationalFunctionList().get(i);
            resultPack.add(first.sum(second));
        }
        return new Polynom(resultPack);
    }
}

