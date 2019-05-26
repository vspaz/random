package class_221;

import class_221.participants.Cat;
import class_221.participants.Human;
import class_221.participants.Participant;
import class_221.participants.Robot;

public class Competition {
    public static void main(String[] argv) {
        Participant[] participants = {
                new Human(10_000, 1),
                new Cat(100, 3),
                new Robot(1_000, 2),
        };
        Obstacle[] obstacles = {
                new RunningTrack(1_000),
                new Wall(1),
        };

        for (Participant participant : participants) {
            if (participant.isFailed()) {
                continue;
            }
            participant.run(obstacles[0].getValue());
            participant.jump(obstacles[1].getValue());
        }

        System.out.println("==========================================");
        System.out.println("Competition completed by:");
        System.out.println("==========================================");
        for (Participant participant : participants) {
            if (participant.isFailed()) {
                continue;
            }
            System.out.println(participant);
        }
    }
}
