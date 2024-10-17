package com.example.meepmeep;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class HumanPlayerSide_1_0 {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(10*180), Math.toRadians(5*180), 12)
                .setDimensions(2.0, 2.0) // This controls the size of the robot in the MeepMeep visulaizaiton \(^ヮ^)/
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(-10, 61, Math.toRadians(270)))
                .splineTo(new Vector2d(-10, 36), Math.toRadians(270))
                //Score on high chamber
                        .waitSeconds(1)
                .strafeTo(new Vector2d(-30, 36))
                .splineTo(new Vector2d(-36, 18), Math.toRadians(270))
                .strafeTo(new Vector2d(-45, 10))
                .strafeTo(new Vector2d(-45, 52))
                .strafeTo(new Vector2d(-45, 10))
                .strafeTo(new Vector2d(-53, 10))
                .strafeTo(new Vector2d(-53, 52))
                .strafeTo(new Vector2d(-53, 10))
                .strafeTo(new Vector2d(-61, 10))
                .strafeTo(new Vector2d(-61, 52))
                .strafeTo(new Vector2d(-61, 10))
                .strafeTo(new Vector2d(-68, 10))
                .strafeTo(new Vector2d(-68, 52))

                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
