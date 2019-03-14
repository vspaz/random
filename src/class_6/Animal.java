package class_6;

abstract class Animal {
    private double jumpAbility, runAbility;
    String name;

    Animal(String name) {
        this.name = name;
    }

    void setJumpHeight(double height) {
        this.jumpAbility = height;
    }

    void setRunDistance(double distance) {
        this.runAbility = distance;
    }

    String getAbility(double animalAbility, double requiredAbility, String what) {
        boolean isAble = animalAbility >= requiredAbility;
        return String.format("%s%s %s %.2f meters. %s",
                this.name,
                isAble ? "" : " can't",
                what,
                requiredAbility,
                isAble ? "weeeeee!!!!" : ":-(");
    }

    String run(double distance) {
        return getAbility(runAbility, distance, "run");
    }

    String jump(double height) {
        return getAbility(jumpAbility, height, "jump");
    }
}
