package org.firstinspires.ftc.teamcode.autos;

import com.acmerobotics.roadrunner.Pose2d;

import com.acmerobotics.roadrunner.Vector2d;

import com.acmerobotics.roadrunner.ftc.Actions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.CompoundActions;

import org.firstinspires.ftc.teamcode.SparkFunOTOSDrive;

@Autonomous(name = "Auto_0_6_ex")

public final class Auto_0_6 extends LinearOpMode {

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

                        .strafeToLinearHeading(new Vector2d(49, 49), Math.toRadians(235))

                        .stopAndAdd(compoundActions.primitives.getArmHeilHitler())

                        .waitSeconds(.45)

                        .stopAndAdd(compoundActions.primitives.getClawOpen())

                        .waitSeconds(.15)

                        .afterTime(0, compoundActions.primitives.getArmHandoff())

                        .strafeToLinearHeading(new Vector2d(46, 45), Math.toRadians(235))

                        .stopAndAdd(compoundActions.primitives.getArmWristParallel())

                        .stopAndAdd(compoundActions.primitives.getArmWristPerpendicular())

                        .stopAndAdd(compoundActions.primitives.getElevatorDown())

//                        .afterTime(.2, compoundActions.getExtendIntake())

                        .strafeToLinearHeading(new Vector2d(42.3, 46.5), Math.toRadians(270))
                        .stopAndAdd(compoundActions.getExtendIntake())
                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.getRetract())

                        .stopAndAdd(compoundActions.primitives.getClawClose())

                        .stopAndAdd(compoundActions.getScore())

                        .waitSeconds(.1)

                        .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getArmVertical())

                        .strafeToLinearHeading(new Vector2d(50, 46.5), Math.toRadians(235))

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getArmHeilHitler())

                        .waitSeconds(.35)

                        .stopAndAdd(compoundActions.primitives.getClawOpen())

                        .waitSeconds(.25)

                        .afterTime(0, compoundActions.primitives.getArmHandoff())

                        .strafeToLinearHeading(new Vector2d(45.4, 45), Math.toRadians(235))

                        .stopAndAdd(compoundActions.primitives.getExtendoWristOut())

                        .stopAndAdd(compoundActions.primitives.getElevatorDown())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getArmHeilHitler())

//                        .afterTime(.2, compoundActions.getExtendIntake())

                        .strafeToLinearHeading(new Vector2d(52.8, 45), Math.toRadians(270))
                        .stopAndAdd(compoundActions.getExtendIntake())
                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.getRetract())

                        .waitSeconds(.3)

                        .stopAndAdd(compoundActions.primitives.getClawClose())

                        .stopAndAdd(compoundActions.getScore())

                        .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())

                        .waitSeconds(.15)

                        .stopAndAdd(compoundActions.primitives.getArmVertical())

                        .strafeToLinearHeading(new Vector2d(51, 46.5), Math.toRadians(245))

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

                        .strafeToLinearHeading(new Vector2d(50.7, 45), Math.toRadians(290))

                        .stopAndAdd(compoundActions.getExtendIntake())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.getRetract())

                        .waitSeconds(.05)

                        .stopAndAdd(compoundActions.primitives.getClawClose())

                        .stopAndAdd(compoundActions.getScore())

                        .waitSeconds(.1)

                        .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getArmVertical())

                        .strafeToLinearHeading(new Vector2d(52.8, 45), Math.toRadians(245))

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getArmHeilHitler())

                        .waitSeconds(.25)

                        .stopAndAdd(compoundActions.primitives.getClawOpen())

                        .waitSeconds(.15)

                        .afterTime(0, compoundActions.primitives.getArmHandoff())

                        .strafeToLinearHeading(new Vector2d(53.5, 44.5), Math.toRadians(235))

                        .stopAndAdd(compoundActions.primitives.getElevatorDown())

                        .strafeToLinearHeading(new Vector2d(30, 10), Math.toRadians(180))

                        .strafeToLinearHeading(new Vector2d(15, 10), Math.toRadians(180))

                        .stopAndAdd(compoundActions.primitives.getExtendoWristOut())

                        .stopAndAdd(compoundActions.primitives.getSweeperOut()) // LUCAS CHECK THIS LINE
                        .stopAndAdd(compoundActions.getExtendIntake())
                        .stopAndAdd(compoundActions.primitives.getSweeperIn()) // LUCAS CHECK THIS LINE

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.getRetract())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getClawClose())

                        .stopAndAdd(compoundActions.getScore())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())

                        .stopAndAdd(compoundActions.primitives.getArmVertical())

                        .strafeToLinearHeading(new Vector2d(32, 16), Math.toRadians(180))

                        .strafeToLinearHeading(new Vector2d(50.5, 41.5), Math.toRadians(235))

                        .stopAndAdd(compoundActions.primitives.getArmHeilHitler())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getClawOpen())

                        .waitSeconds(.2)

                        .afterTime(0, compoundActions.primitives.getArmHandoff())

                        .strafeToLinearHeading(new Vector2d(50, 46), Math.toRadians(235))

                        .stopAndAdd(compoundActions.primitives.getElevatorDown())

                        .strafeToLinearHeading(new Vector2d(53.5, 44.5), Math.toRadians(235))

                        .stopAndAdd(compoundActions.primitives.getElevatorDown())

                        .strafeToLinearHeading(new Vector2d(30, 10), Math.toRadians(180))

                        .strafeToLinearHeading(new Vector2d(14.3, 10), Math.toRadians(200))

                        .stopAndAdd(compoundActions.primitives.getExtendoWristOut())

                        .stopAndAdd(compoundActions.primitives.getSweeperOut()) // LUCAS CHECK THIS LINE
                        .stopAndAdd(compoundActions.getExtendIntake())
                        .stopAndAdd(compoundActions.primitives.getSweeperIn()) // LUCAS CHECK THIS LINE

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.getRetract())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getClawClose())

                        .stopAndAdd(compoundActions.getScore())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())

                        .stopAndAdd(compoundActions.primitives.getArmVertical())

                        .strafeToLinearHeading(new Vector2d(32, 18), Math.toRadians(180))

                        .strafeToLinearHeading(new Vector2d(50, 41.5), Math.toRadians(235))

                        .stopAndAdd(compoundActions.primitives.getArmHeilHitler())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getClawOpen())

                        .waitSeconds(.2)

                        .afterTime(0, compoundActions.primitives.getArmHandoff())

                        .strafeToLinearHeading(new Vector2d(52, 45), Math.toRadians(235))

                        .stopAndAdd(compoundActions.primitives.getElevatorDown())

                        .build()

        );

    }

}