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
                //.stopAndAdd(new ParallelAction(
                //compoundActions.primitives.getScoreClawClose(),
                //compoundActions.primitives.getScoreWristPerp(),
                //compoundActions.primitives.getArmIn()
                //))
                //.stopAndAdd(new ParallelAction(
                //compoundActions.getScore(),
                //compoundActions.primitives.getElevatorPark(),
                //compoundActions.primitives.getScoreWristFlat()
                //))
                //.waitSeconds(.25)
                .strafeTo(new Vector2d(6.5, 36.25))
                //.stopAndAdd(new ParallelAction(
                //compoundActions.primitives.getArmHitler(),
                //compoundActions.primitives.getElevatorDownLittle()
                //))
                //.waitSeconds(0.25)
                //.stopAndAdd(compoundActions.primitives.getScoreClawOpen())
                //Score on high chamber
                //.waitSeconds(0.25)
                .strafeTo(new Vector2d(8, 48))
//                    .turn(Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(34, 42, Math.toRadians(0)), Math.toRadians(0))
                .strafeTo(new Vector2d(34, 16))
                .strafeTo(new Vector2d(43, 6))
                .strafeTo(new Vector2d(47, 56.5))
                .strafeTo(new Vector2d(45, 50))
                .strafeTo(new Vector2d(40, 9))
                .strafeTo(new Vector2d(51, 9))
                .strafeTo(new Vector2d(50, 52))
                .strafeTo(new Vector2d(50, 10))
                .strafeTo(new Vector2d(59, 10))
                .strafeTo(new Vector2d(59, 50))
                .strafeTo(new Vector2d(59, 10))
                .strafeTo(new Vector2d(56, 10))
                //.afterTime(0, new ParallelAction(
                //compoundActions.primitives.getScoreClawClose(),
                //compoundActions.primitives.getArmHitler(),
                //compoundActions.primitives.getElevatorPark()
                //))
                .strafeTo(new Vector2d(20.5, 10))
                //.stopAndAdd(compoundActions.primitives.getArmHitler())
                .build());


        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}