package java8.behaviorParameterization.predicate;

import java8.behaviorParameterization.Apple;

public class AppleHeavyWeightPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
