enum Unit {
    FEET(1.0),
    INCH(1.0 / 12.0),
    YARD(3.0),
    CM(0.0328084);

    double factorToFeet;

    Unit(double factorToFeet) {
        this.factorToFeet = factorToFeet;
    }

    double toFeet(double value) {
        return value * factorToFeet;
    }

    double fromFeet(double valueInFeet) {
        return valueInFeet / factorToFeet;
    }
}

class QuantityLength {

    double value;
    Unit unit;

    QuantityLength(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    double toBaseFeet() {
        return unit.toFeet(this.value);
    }

    static double convert(double value, Unit source, Unit target) {
        double inFeet = source.toFeet(value);
        return target.fromFeet(inFeet);
    }
}

public class main {
    public static void main(String[] args) {

        System.out.println("=== UC5 Unit Conversion ===");

        System.out.println("12 Inch to Feet: " +
                QuantityLength.convert(12, Unit.INCH, Unit.FEET));

        System.out.println("3 Feet to Inch: " +
                QuantityLength.convert(3, Unit.FEET, Unit.INCH));

        System.out.println("1 Yard to Feet: " +
                QuantityLength.convert(1, Unit.YARD, Unit.FEET));

        System.out.println("100 CM to Inch: " +
                QuantityLength.convert(100, Unit.CM, Unit.INCH));
    }
}