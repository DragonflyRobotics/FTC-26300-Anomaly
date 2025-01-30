package com.example.meepmeep;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class Test {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(10*180), Math.toRadians(5*180), 18)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(-62.243, 12.983, Math.toRadians(0)))
                //(compoundActions.primitives.getElevatorHighBasket())

                //(compoundActions.primitives.getClawOpen())

                //(compoundActions.primitives.getClawClose())

                //(compoundActions.primitives.getClawClose())

                //(compoundActions.primitives.getExtendo())

                //(compoundActions.primitives.getRetract())

                //(compoundActions.primitives.getExtendoWristOut())

                //(compoundActions.primitives.getClawClose())

                //(compoundActions.primitives.getExtendoWristIn())

                //(compoundActions.primitives.getClawClose())

                //(compoundActions.primitives.getExtendoWristOut())

                //(compoundActions.primitives.getArmHeilHitler())

                //(compoundActions.primitives.getArmVertical())

                .waitSeconds(.3)

                .strafeToLinearHeading(new Vector2d(49, 49), Math.toRadians(235))

                //(compoundActions.primitives.getArmHeilHitler())

                .waitSeconds(.55)

                //(compoundActions.primitives.getClawOpen())

                .waitSeconds(.15)

                //(0, compoundActions.primitives.getArmHandoff())

                .strafeToLinearHeading(new Vector2d(46.5, 45), Math.toRadians(235))

                //(compoundActions.primitives.getArmWristParallel())

                //(compoundActions.primitives.getArmWristPerpendicular())

                //(compoundActions.primitives.getElevatorDown())

//                        //(.2, compoundActions.getExtendIntake())

                .strafeToLinearHeading(new Vector2d(45, 47), Math.toRadians(270))
                //(compoundActions.getExtendIntakeGinger())
                .waitSeconds(.2)

                //(compoundActions.getRetract())

                //(compoundActions.primitives.getClawClose())

                //(compoundActions.getScore())

                .waitSeconds(.1)

                //(compoundActions.primitives.getElevatorHighBasket())

                .waitSeconds(.2)

                //(compoundActions.primitives.getArmVertical())

                .strafeToLinearHeading(new Vector2d(50, 46.5), Math.toRadians(235))

                .waitSeconds(.2)

                //(compoundActions.primitives.getArmHeilHitler())

                .waitSeconds(.35)

                //(compoundActions.primitives.getClawOpen())

                .waitSeconds(.25)

                //(0, compoundActions.primitives.getArmHandoff())

                .strafeToLinearHeading(new Vector2d(46.5, 45), Math.toRadians(235))

                //(compoundActions.primitives.getExtendoWristOut())

                //(compoundActions.primitives.getElevatorDown())

                .waitSeconds(.2)

                //(compoundActions.primitives.getArmHeilHitler())

//                        //(.2, compoundActions.getExtendIntake())

                .strafeToLinearHeading(new Vector2d(52.9, 45), Math.toRadians(270))
                //(compoundActions.getExtendIntakeGinger())
                .waitSeconds(.2)

                //(compoundActions.getRetract())

                .waitSeconds(.3)

                //(compoundActions.primitives.getClawClose())

                //(compoundActions.getScore())

                //(compoundActions.primitives.getElevatorHighBasket())

                .waitSeconds(.15)

                //(compoundActions.primitives.getArmVertical())

                .strafeToLinearHeading(new Vector2d(53, 46.5), Math.toRadians(245))

                .waitSeconds(.2)

                //(compoundActions.primitives.getArmHeilHitler())

                .waitSeconds(.5)

                //(compoundActions.primitives.getClawOpen())

                .waitSeconds(.35)

                //(0, compoundActions.primitives.getArmHandoff())

                .strafeToLinearHeading(new Vector2d(47, 43), Math.toRadians(235))

                //(compoundActions.primitives.getExtendoWristOut())

                //(compoundActions.primitives.getElevatorDown())

                .waitSeconds(.1)

                //(compoundActions.primitives.getArmHeilHitler())

                .strafeToLinearHeading(new Vector2d(51, 43.1), Math.toRadians(290))

                //(compoundActions.getExtendIntakeGinger())

                .waitSeconds(.2)

                //(compoundActions.getRetract())

                .waitSeconds(.05)

                //(compoundActions.primitives.getClawClose())

                //(compoundActions.getScore())

                .waitSeconds(.1)

                //(compoundActions.primitives.getElevatorHighBasket())

                .waitSeconds(.2)

                //(compoundActions.primitives.getArmVertical())

                .strafeToLinearHeading(new Vector2d(53.5, 48.5), Math.toRadians(235))

                .waitSeconds(.2)

                //(compoundActions.primitives.getArmHeilHitler())

                .waitSeconds(.25)

                //(compoundActions.primitives.getClawOpen())

                .waitSeconds(.15)

                //(0, compoundActions.primitives.getArmHandoff())

                .strafeToLinearHeading(new Vector2d(53.5, 44.5), Math.toRadians(235))

                //(compoundActions.primitives.getElevatorDown())

                .strafeToLinearHeading(new Vector2d(30, 10), Math.toRadians(180))

                .strafeToLinearHeading(new Vector2d(15, 10), Math.toRadians(180))
                //(compoundActions.primitives.getSweeperOut())
                .waitSeconds(.2)
                //(compoundActions.primitives.getExtendoWristOut())
                // LUCAS CHECK THIS LINE
                //(compoundActions.getExtendIntake())
                //(compoundActions.primitives.getSweeperIn()) // LUCAS CHECK THIS LINE

                .waitSeconds(.2)

                //(compoundActions.getRetract())

                .waitSeconds(.2)

                //(compoundActions.primitives.getClawClose())

                //(compoundActions.getScore())

                .waitSeconds(.2)

                //(compoundActions.primitives.getElevatorHighBasket())

                //(compoundActions.primitives.getArmVertical())

                .strafeToLinearHeading(new Vector2d(32, 16), Math.toRadians(180))

                .strafeToLinearHeading(new Vector2d(50.5, 41.5), Math.toRadians(235))

                //(compoundActions.primitives.getArmHeilHitler())

                .waitSeconds(.2)

                //(compoundActions.primitives.getClawOpen())

                .waitSeconds(.2)

                //(0, compoundActions.primitives.getArmHandoff())

                .strafeToLinearHeading(new Vector2d(50, 46), Math.toRadians(235))

                //(compoundActions.primitives.getElevatorDown())

                .strafeToLinearHeading(new Vector2d(53.5, 44.5), Math.toRadians(235))

                //(compoundActions.primitives.getElevatorDown())

                .strafeToLinearHeading(new Vector2d(30, 10), Math.toRadians(180))

                .strafeToLinearHeading(new Vector2d(14.3, 10), Math.toRadians(200))
                //(compoundActions.primitives.getSweeperOut())
                .waitSeconds(.2)
                //(compoundActions.primitives.getExtendoWristOut())

                // LUCAS CHECK THIS LINE
                //(compoundActions.getExtendIntake())
                //(compoundActions.primitives.getSweeperIn()) // LUCAS CHECK THIS LINE

                .waitSeconds(.2)

                //(compoundActions.getRetract())

                .waitSeconds(.4)

                //(compoundActions.primitives.getClawClose())

                //(compoundActions.getScore())

                .waitSeconds(.2)

                //(compoundActions.primitives.getElevatorHighBasket())

                //(compoundActions.primitives.getArmVertical())

                .strafeToLinearHeading(new Vector2d(32, 18), Math.toRadians(180))

                .strafeToLinearHeading(new Vector2d(50, 41.5), Math.toRadians(235))

                //(compoundActions.primitives.getArmHeilHitler())

                .waitSeconds(.2)

//                //(compoundActions.primitives.getClawOpen())

                .waitSeconds(.2)

//                //(0, compoundActions.primitives.getArmHandoff())

                .strafeToLinearHeading(new Vector2d(52, 45), Math.toRadians(235))

//                //(compoundActions.primitives.getElevatorDown())
                .build());


        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}