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
                // Line 1
                .strafeToLinearHeading(
                        new Vector2d(-35.332, 12.983),
                        Math.toRadians(90)
                )
                // Line 2
                .strafeToLinearHeading(
                        new Vector2d(-50.336, 38.103),
                        Math.toRadians(180)
                )
                .build());


        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}