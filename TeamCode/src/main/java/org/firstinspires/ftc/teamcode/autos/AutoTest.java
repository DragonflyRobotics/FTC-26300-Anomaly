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

        Pose2d beginPose = new Pose2d(38, 56.5, Math.toRadians(225));

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

                        .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())

                        .stopAndAdd(compoundActions.primitives.getClawOpen())

                        .stopAndAdd(compoundActions.primitives.getClawClose())

                        .stopAndAdd(compoundActions.primitives.getClawClose())

                        .stopAndAdd(compoundActions.primitives.getExtendo())

                        .stopAndAdd(compoundActions.primitives.getRetract())

                        .stopAndAdd(compoundActions.primitives.getExtendoWristOut())

                        .stopAndAdd(compoundActions.primitives.getClawClose())

                        .stopAndAdd(compoundActions.primitives.getExtendoWristIn())

                        .stopAndAdd(compoundActions.primitives.getClawClose())

                        .stopAndAdd(compoundActions.primitives.getExtendoWristOut())

                        .stopAndAdd(compoundActions.primitives.getArmHeilHitler())

                        .stopAndAdd(compoundActions.primitives.getArmVertical())

                        .waitSeconds(.3)



                        .build()

        );

    }

}