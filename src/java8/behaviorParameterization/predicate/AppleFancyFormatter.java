package java8.behaviorParameterization.predicate;

import java8.behaviorParameterization.Apple;

public class AppleFancyFormatter implements AppleFormatter {

    @Override
    public String accept(Apple apple) {
        String weight = apple.getWeight() > 150 ? "Heavy" : "Light";
        return weight + "apple!" ;
    }
}
