package com.example.meepmeep;

import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class BasketSide_1_3 {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(10*180), Math.toRadians(5*180), 18)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(10, 61, Math.toRadians(90)))
                .strafeTo(new Vector2d(10, 36))
                .waitSeconds(.5)
//                .stopAndAdd(compoundActions.getScore())
//                .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())
//                .stopAndAdd(compoundActions.primitives.getScoreClawOpen())
                //Score
                .splineTo(new Vector2d(10, 40), Math.toRadians(90))
                .strafeToLinearHeading(new Vector2d(41, 45), Math.toRadians(290))
                .waitSeconds(.5)
//                .stopAndAdd(compoundActions.getExtendIntake())
//                .stopAndAdd(compoundActions.getRetract())
                //Intake
                .strafeToLinearHeading(new Vector2d(50, 50), Math.toRadians(225))
                .waitSeconds(.5)
//                .stopAndAdd(compoundActions.getScore())
//                .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())
//                .stopAndAdd(compoundActions.primitives.getScoreClawOpen())
                //Score
                .strafeToLinearHeading(new Vector2d(58, 48), Math.toRadians(270))
                .waitSeconds(.5)
//                .stopAndAdd(compoundActions.getExtendIntake())
//                .stopAndAdd(compoundActions.getRetract())
                //Intake
                .turn(Math.toRadians(-15))
                .waitSeconds(.5)
//                .stopAndAdd(compoundActions.getScore())
//                .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())
//                .stopAndAdd(compoundActions.primitives.getScoreClawOpen())
                //Score
                .turn(Math.toRadians(45))
                .waitSeconds(.5)
//                .stopAndAdd(compoundActions.getExtendIntake())
//                .stopAndAdd(compoundActions.getRetract())
                //Intake
                .waitSeconds(.5)
                .turn(Math.toRadians(-45))
//                .stopAndAdd(compoundActions.getScore())
//                .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())
//                .stopAndAdd(compoundActions.primitives.getScoreClawOpen())
                //Score
                .strafeTo(new Vector2d(41, 35))
                .strafeToLinearHeading(new Vector2d(41, 9), Math.toRadians(0))
                //Lift arm
                .strafeTo(new Vector2d(22, 9))
                .build());


        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}