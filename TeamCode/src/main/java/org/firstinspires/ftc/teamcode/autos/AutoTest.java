package org.firstinspires.ftc.teamcode.autos;

import com.acmerobotics.roadrunner.Pose2d;

import com.acmerobotics.roadrunner.Vector2d;

import com.acmerobotics.roadrunner.ftc.Actions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.CompoundActions;

import org.firstinspires.ftc.teamcode.SparkFunOTOSDrive;

@Autonomous(name = "immakys")

public final class AutoTest extends LinearOpMode {

    @Override

    public void runOpMode() throws InterruptedException {

        Pose2d beginPose = new Pose2d(-39.500, -64.000, Math.toRadians(180));

        SparkFunOTOSDrive drive = new SparkFunOTOSDrive(hardwareMap, beginPose);

        CompoundActions compoundActions = new CompoundActions(hardwareMap, true);

        while (!isStopRequested() && !opModeIsActive()) {

            telemetry.addData("Opmode not active", true);

            telemetry.update();

        }

        waitForStart();

        if (isStopRequested()) return;

        Actions.runBlocking(

                drive.actionBuilder(beginPose, 18)

                        // Line 1
                        .strafeToLinearHeading(
                                new Vector2d(-53.000, -53.000),
                                Math.toRadians(225)
                        )
                        // Line 2
                        .strafeToLinearHeading(
                                new Vector2d(-48.807, -44.219),
                                Math.toRadians(270)
                        )
                        // Line 3
                        .strafeToLinearHeading(
                                new Vector2d(-53.000, -53.000),
                                Math.toRadians(225)
                        )
                        // Line 4
                        .strafeToLinearHeading(
                                new Vector2d(-60.021, -42.945),
                                Math.toRadians(270)
                        )
                        // Line 5
                        .strafeToLinearHeading(
                                new Vector2d(-53.000, -53.000),
                                Math.toRadians(225)
                        )
                        // Line 6
                        .strafeToLinearHeading(
                                new Vector2d(-60.531, -41.671),
                                Math.toRadians(300)
                        )
                        // Line 7
                        .strafeToLinearHeading(
                                new Vector2d(-53.000, -53.000),
                                Math.toRadians(225)
                        )
                        // Line 8
                        .strafeToLinearHeading(
                                new Vector2d(-45.239, -16.184),
                                Math.toRadians(180)
                        )
                        // Line 9
                        .strafeToLinearHeading(
                                new Vector2d(-23.575, -10.322),
                                Math.toRadians(180)
                        )
                        // Line 10
                        .strafeToLinearHeading(
                                new Vector2d(-53.000, -53.000),
                                Math.toRadians(225)
                        )


                        .build()

        );

    }

}