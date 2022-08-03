package java8.behaviorParameterization.predicate;

import java8.behaviorParameterization.Apple;
import java8.behaviorParameterization.Color;

public class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals(Color.GRREN);
    }
}
