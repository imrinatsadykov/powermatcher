package net.powermatcher.fpai.agent;

import static javax.measure.unit.SI.WATT;

import javax.measure.Measurable;
import javax.measure.Measure;
import javax.measure.quantity.Power;

import org.flexiblepower.rai.values.Constraint;
import org.flexiblepower.rai.values.ConstraintList;
import org.flexiblepower.rai.values.ConstraintList.Builder;

public class ConstraintListUtil {

    private ConstraintListUtil() {
    }

    public static Constraint<Power> negate(Constraint<Power> pc) {
        Measurable<Power> l = pc.getLowerBound(), u = pc.getUpperBound();
        return new Constraint<Power>(Measure.valueOf(-l.doubleValue(WATT), WATT), Measure.valueOf(-u.doubleValue(WATT),
                                                                                                  WATT));
    }

    public static ConstraintList<Power> combinePowerConstraintLists(ConstraintList<Power> charge,
                                                                    ConstraintList<Power> discharge) {
        if (discharge == null) {
            return charge;
        }
        // Make a clone and merge powerConstraintLists
        Builder<Power> builder = ConstraintList.create(WATT);

        for (Constraint<Power> pc : charge) {
            builder.addRange(pc.getLowerBound(), pc.getUpperBound());
        }
        for (Constraint<Power> pc : charge) {
            Constraint<Power> neg = negate(pc);
            builder.addRange(neg.getLowerBound(), neg.getUpperBound());
        }
        return builder.build();
    }

    public static Measurable<Power> getClosestPower(ConstraintList<Power> pcl, final Measurable<Power> wantedPower) {
        Measurable<Power> resultValue = null;
        double result = Double.NaN;
        final double wantedPowerWatt = wantedPower.doubleValue(WATT);

        for (Constraint<Power> pc : pcl) {
            Measurable<Power> powerValue = pc.getClosestValue(wantedPower);
            double power = powerValue.doubleValue(WATT);

            if (resultValue == null || (Math.abs(power - wantedPowerWatt) < Math.abs(result - wantedPowerWatt))) {
                resultValue = powerValue;
                result = power;
            }
        }

        return resultValue;
    }
}
