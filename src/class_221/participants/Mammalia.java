package class_221.participants;

abstract public class Mammalia implements Participant {
    private int runDistance, jumpHeight;
    private boolean failed;

    Mammalia(int runDistance, int jumpHeight) {
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    public void run(int runDdistance) {
        printResult(runDdistance, this.runDistance, "run");
    }

    public void jump(int height) {
        printResult(height, this.jumpHeight, "jump");
    }

    void printResult(int requiredAbility, int participantAbility, String action) {
        String can = "can";
        if (requiredAbility > participantAbility) {
            can = "can't";
            setFailedStatus();
        }
        System.out.println(String.format("%s %s %s %s meter(s)",
                this.toString(),
                can,
                action,
                requiredAbility
        ));
    }

    @Override
    public boolean isFailed() {
        return failed;
    }

    private void setFailedStatus() {
        this.failed = true;
    }

    public String toString() {
        return "Mammalia";
    }
}
