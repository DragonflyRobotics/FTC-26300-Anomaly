package org.firstinspires.ftc.teamcode.autos;

import com.acmerobotics.roadrunner.Pose2d;

import com.acmerobotics.roadrunner.Vector2d;

import com.acmerobotics.roadrunner.ftc.Actions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.CompoundActions;

import org.firstinspires.ftc.teamcode.SparkFunOTOSDrive;

@Autonomous(name = "Auto_0_5_HP_ex")

public final class Auto_0_5_HP_ex extends LinearOpMode {

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

                drive.actionBuilder(beginPose, 15)

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

                        .stopAndAdd(compoundActions.primitives.getArmVertical()) // changed

                        .waitSeconds(.3)

                        .strafeToLinearHeading(new Vector2d(49, 49), Math.toRadians(235))

                        .stopAndAdd(compoundActions.primitives.getArmHeilHitler())

                        .waitSeconds(.35)

                        .stopAndAdd(compoundActions.primitives.getClawOpen())

                        .waitSeconds(.25)

                        .afterTime(0, compoundActions.primitives.getArmHandoff())

                        .strafeToLinearHeading(new Vector2d(46, 45), Math.toRadians(235))

                        .stopAndAdd(compoundActions.primitives.getArmWristParallel())

                        .stopAndAdd(compoundActions.primitives.getArmWristPerpendicular())

                        .stopAndAdd(compoundActions.primitives.getElevatorDown())

                        .stopAndAdd(compoundActions.getExtendIntake())

                        .strafeToLinearHeading(new Vector2d(41.5, 46.5), Math.toRadians(270))

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.getRetract())

                        .waitSeconds(.05)

                        .stopAndAdd(compoundActions.primitives.getClawClose())

                        .stopAndAdd(compoundActions.getScore())

                        .waitSeconds(.1)

                        .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getArmVertical()) // changed

                        // Intake

                        .strafeToLinearHeading(new Vector2d(46, 48), Math.toRadians(235))

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getArmHeilHitler())

                        .waitSeconds(.35)

                        .stopAndAdd(compoundActions.primitives.getClawOpen())

                        .waitSeconds(.25)

                        .afterTime(0, compoundActions.primitives.getArmHandoff())

                        .strafeToLinearHeading(new Vector2d(45, 45), Math.toRadians(235))

                        .stopAndAdd(compoundActions.primitives.getExtendoWristOut())

                        .stopAndAdd(compoundActions.primitives.getElevatorDown())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getArmHeilHitler())

                        // Score

                        .stopAndAdd(compoundActions.getExtendIntake())

                        .strafeToLinearHeading(new Vector2d(51.3, 45.5), Math.toRadians(270))

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.getRetract())

                        .waitSeconds(.05)

                        .stopAndAdd(compoundActions.primitives.getClawClose())

                        .stopAndAdd(compoundActions.getScore())

                        .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())

                        .waitSeconds(.15)

                        .stopAndAdd(compoundActions.primitives.getArmVertical()) // changed

                        // Intake

                        .strafeToLinearHeading(new Vector2d(48, 47), Math.toRadians(245))

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getArmHeilHitler())

                        .waitSeconds(.5)

                        .stopAndAdd(compoundActions.primitives.getClawOpen())

                        .waitSeconds(.35)

                        .afterTime(0, compoundActions.primitives.getArmHandoff())

                        .strafeToLinearHeading(new Vector2d(47, 43), Math.toRadians(235))

                        .stopAndAdd(compoundActions.primitives.getExtendoWristOut())

                        .stopAndAdd(compoundActions.primitives.getElevatorDown())

                        .waitSeconds(.1)

                        .stopAndAdd(compoundActions.primitives.getArmHeilHitler())

                        // Score

                        .strafeToLinearHeading(new Vector2d(51, 45.5), Math.toRadians(290))

                        .stopAndAdd(compoundActions.getExtendIntake())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.getRetract())

                        .waitSeconds(.05)

                        .stopAndAdd(compoundActions.primitives.getClawClose())

                        .stopAndAdd(compoundActions.getScore())

                        .waitSeconds(.1)

                        .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getArmVertical()) // changed

                        // Intake

                        .strafeToLinearHeading(new Vector2d(48.1, 47), Math.toRadians(245))

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getArmHeilHitler())

                        .waitSeconds(.25)

                        .stopAndAdd(compoundActions.primitives.getClawOpen())

                        .waitSeconds(.15)

                        .afterTime(0, compoundActions.primitives.getArmHandoff())

                        .strafeToLinearHeading(new Vector2d(49.5, 44.5), Math.toRadians(235))

                        .stopAndAdd(compoundActions.primitives.getElevatorDown())

                        .strafeToLinearHeading(new Vector2d(30, 53), Math.toRadians(200))

                        .strafeToLinearHeading(new Vector2d(-23, 56), Math.toRadians(165))

                        .stopAndAdd(compoundActions.primitives.getExtendoWristOut())

                        .stopAndAdd(compoundActions.getExtendIntake())

                        .waitSeconds(.25)

                        .stopAndAdd(compoundActions.getExtendIntake())

                        .waitSeconds(.3)

                        .stopAndAdd(compoundActions.getRetract())

                        .waitSeconds(.1)

                        .stopAndAdd(compoundActions.primitives.getClawClose())

                        .stopAndAdd(compoundActions.getScore())

                        .strafeToLinearHeading(new Vector2d(0, 47), Math.toRadians(235))

                        .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getArmVertical()) // changed

                        // Intake

                        .strafeToLinearHeading(new Vector2d(40, 47), Math.toRadians(235))

                        .stopAndAdd(compoundActions.primitives.getArmHeilHitler())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getClawOpen())

                        .waitSeconds(.2)

                        .afterTime(0, compoundActions.primitives.getArmHandoff())

                        .strafeToLinearHeading(new Vector2d(42, 47), Math.toRadians(235))

                        .stopAndAdd(compoundActions.primitives.getElevatorDown())

                        .stopAndAdd(compoundActions.primitives.getArmHeilHitler())

                        .strafeToLinearHeading(new Vector2d(24, 12), Math.toRadians(0))

                        .build()

        );

    }

}