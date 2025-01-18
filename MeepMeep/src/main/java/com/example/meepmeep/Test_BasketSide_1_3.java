package com.example.meepmeep;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class Test_BasketSide_1_3 {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(10*180), Math.toRadians(5*180), 18)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(10, 61, Math.toRadians(270)))
                .splineTo(new Vector2d(10, 36), Math.toRadians(270))
                                .waitSeconds(.5)
                //Score on High Chamber
                .strafeTo(new Vector2d(21, 36))
                .strafeToLinearHeading(new Vector2d(38, 26), Math.toRadians(0))
                .waitSeconds(.5)
                //Intake
                .strafeTo(new Vector2d(37, 35))
                .strafeToLinearHeading(new Vector2d(50, 50), Math.toRadians(45))
                .waitSeconds(.5)
                //Score
                .strafeToLinearHeading(new Vector2d(54, 45), Math.toRadians(157.5))
                .strafeToLinearHeading(new Vector2d(58, 40), Math.toRadians(270))
                .waitSeconds(.5)
                //Intake
                .strafeToLinearHeading(new Vector2d(57.5, 45), Math.toRadians(162.5))
                .strafeToLinearHeading(new Vector2d(57, 50), Math.toRadians(55))
                .waitSeconds(.5)
                //Score
                .strafeToLinearHeading(new Vector2d(57.5, 43.5), Math.toRadians(182.5))
                .strafeToLinearHeading(new Vector2d(58, 37), Math.toRadians(310))
                .waitSeconds(.5)
                //Intake
                .strafeToLinearHeading(new Vector2d(57.5, 43.5), Math.toRadians(182.5))
                .strafeToLinearHeading(new Vector2d(57, 50), Math.toRadians(55))
                .waitSeconds(.5)
                //Score
                .build());


        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}