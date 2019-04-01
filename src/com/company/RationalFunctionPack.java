package com.company;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
class RationalFunctionPack {
    private List<RationalFunction> rationalFunctionList = new ArrayList<>();
    private RationalFunction currentMax;
    private RationalFunction currentMin;

    void add(RationalFunction rationalFunction) {
        rationalFunctionList.add(rationalFunction);
        if (currentMin == null) {
            currentMin = rationalFunction;
            currentMax = rationalFunction;
        } else {
            updateMaxAnMin(rationalFunction);
        }
    }

    long lessThan (RationalFunction rationalFunction) {
        return rationalFunctionList.stream()
                .filter(e -> e.doubleRepresentation() < rationalFunction.doubleRepresentation())
                .count();
    }

    long moreThan (RationalFunction rationalFunction) {
        return rationalFunctionList.stream()
                .filter(e -> e.doubleRepresentation() > rationalFunction.doubleRepresentation())
                .count();
    }

    int getSize() {
        return rationalFunctionList.size();
    }

    private void updateMaxAnMin(RationalFunction rationalFunction) {
        if (rationalFunction.doubleRepresentation() < currentMin.doubleRepresentation()) {
            currentMin = rationalFunction;
        }
        if (rationalFunction.doubleRepresentation() > currentMax.doubleRepresentation()) {
            currentMax = rationalFunction;
        }
    }
}
