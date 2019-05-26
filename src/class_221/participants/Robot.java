package class_221.participants;


// ideally all this code should go a common ancestor class along with Mammalia for all participant classes to
// avoid code duplication, but since all the three classes can't inherit from a base class, Robot is somewhat a duplicate of
// Mammalia.
public class Robot implements Participant {
    private int runDistance, jumpHeight;
    private boolean failed = false;

    public Robot(int runDistance, int jumpHeight) {
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    public void run(int runDdistance) {
        printResult(runDdistance, this.runDistance, "run");
    }

    public void jump(int height) {
        printResult(height, this.jumpHeight, "jump");
    }

    void printResult(int requiredCapacity, int participantCapacity, String action) {
        String can = "can";
        if (requiredCapacity > participantCapacity) {
            setFailedStatus();
            can = "can't";
        }
        System.out.println(String.format("%s %s %s %s meter(s)",
                this.toString(),
                can,
                action,
                requiredCapacity
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
        return "Robot";
    }
}

