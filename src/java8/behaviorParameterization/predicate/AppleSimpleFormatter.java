package java8.behaviorParameterization.predicate;

import java8.behaviorParameterization.Apple;

public class AppleSimpleFormatter implements AppleFormatter {

    @Override
    public String accept(Apple apple) {
        return apple.getWeight() + "g apple";
    }
}
