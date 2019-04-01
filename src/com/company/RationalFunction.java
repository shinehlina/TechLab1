package com.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
class RationalFunction {
    private int numerator;
    private int denominator;

    double doubleRepresentation() {
        return (double) numerator / denominator;
    }

    RationalFunction sum(RationalFunction x) {
        return new RationalFunction(numerator * x.getDenominator() + x.getNumerator() * denominator,
                denominator * x.getDenominator());
    }
}
