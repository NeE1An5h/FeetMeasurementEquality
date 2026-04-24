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

    double fromFeet(double value) {
        return value / factorToFeet;
    }
}

class QuantityLength {

    double value;
    Unit unit;

    QuantityLength(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    double toFeet() {
        return unit.toFeet(this.value);
    }

    static QuantityLength add(QuantityLength l1, QuantityLength l2, Unit targetUnit) {

        double l1InFeet = l1.toFeet();
        double l2InFeet = l2.toFeet();

        double sumInFeet = l1InFeet + l2InFeet;

        double resultValue = targetUnit.fromFeet(sumInFeet);

        return new QuantityLength(resultValue, targetUnit);
    }
}

public class main {
    public static void main(String[] args) {

        System.out.println("=== UC7 Addition with Target Unit ===");

        QuantityLength length1 = new QuantityLength(1, Unit.FEET);
        QuantityLength length2 = new QuantityLength(12, Unit.INCH);

        QuantityLength result1 = QuantityLength.add(length1, length2, Unit.YARD);

        System.out.println("1 Feet + 12 Inch in Yards = " +
                result1.value + " " + result1.unit);

        QuantityLength length3 = new QuantityLength(2, Unit.YARD);
        QuantityLength length4 = new QuantityLength(36, Unit.INCH);

        QuantityLength result2 = QuantityLength.add(length3, length4, Unit.FEET);

        System.out.println("2 Yard + 36 Inch in Feet = " +
                result2.value + " " + result2.unit);
    }
}