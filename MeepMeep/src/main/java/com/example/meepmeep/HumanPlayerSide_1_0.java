package com.example.meepmeep;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.entity.Entity;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class HumanPlayerSide_1_0 {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(600);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 30, Math.PI, Math.PI, 12)
                .setDimensions(12.0, 12.0) // This controls the size of the robot in the MeepMeep visulaizaiton \(^ヮ^)/
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(10, 61, Math.toRadians(90)))
//                .stopAndAdd(compoundActions.primitives.getScoreClawClose())
//                .stopAndAdd(compoundActions.getScore())
                .waitSeconds(2)
                .strafeTo(new Vector2d(8, 38))
//                .stopAndAdd(compoundActions.primitives.getScoreWristFlat())
//                .stopAndAdd(compoundActions.primitives.getArmHitler())
                .waitSeconds(0.5)
//                .stopAndAdd(compoundActions.primitives.getScoreClawOpen())
                //Score on high chamber
                .waitSeconds(0.5)
                .strafeTo(new Vector2d(8, 48))
//                    .turn(Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(34, 42, Math.toRadians(0)), Math.toRadians(0))
                .strafeTo(new Vector2d(34, 16))
                .strafeTo(new Vector2d(43, 6))
                .strafeTo(new Vector2d(47, 53.5))
                .strafeTo(new Vector2d(40, 50))
                .strafeTo(new Vector2d(40, 10))
                .strafeTo(new Vector2d(50, 10))
                .strafeTo(new Vector2d(50, 52))
                .strafeTo(new Vector2d(50, 10))
                .strafeTo(new Vector2d(58, 10))
                .strafeTo(new Vector2d(58, 50))
                .strafeTo(new Vector2d(58, 10))
                .strafeTo(new Vector2d(56, 10))
//                .turn(Math.toRadians(90))
                .splineToLinearHeading(new Pose2d(31, 10, Math.toRadians(180)), Math.toRadians(180))
//                .stopAndAdd(compoundActions.primitives.getElevatorPark())
//                .strafeTo(new Vector2d(31, 10))
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
