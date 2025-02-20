package org.firstinspires.ftc.teamcode.autos;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.CompoundActions;
import org.firstinspires.ftc.teamcode.SparkFunOTOSDrive;

@Autonomous(name = "Auto_0_6_KrishnaVersion")

public final class Auto_0_6_KrishnaVersion extends LinearOpMode {

    @Override

    public void runOpMode() throws InterruptedException {

        Pose2d beginPose = new Pose2d(-39.500, -64.000, Math.toRadians(180-180));

        SparkFunOTOSDrive drive = new SparkFunOTOSDrive(hardwareMap, beginPose);

        CompoundActions compoundActions = new CompoundActions(hardwareMap, true);

        while (!isStopRequested() && !opModeIsActive()) {

            telemetry.addData("Opmode not active", true);

            telemetry.update();

        }

        waitForStart();

        if (isStopRequested()) return;

        Actions.runBlocking(

                drive.actionBuilder(beginPose, 21)

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

                        .stopAndAdd(compoundActions.primitives.getClawClose())

                        .strafeToLinearHeading(new Vector2d(-53.500, -53.500), Math.toRadians(225-180))

                        .stopAndAdd(compoundActions.primitives.getArmHeilHitler())

                        .stopAndAdd(compoundActions.primitives.getClawClose())

                        .waitSeconds(.85)

                        .stopAndAdd(compoundActions.primitives.getClawOpen())

                        .waitSeconds(.15)

                        .afterTime(0, compoundActions.primitives.getArmHandoff())

                        .stopAndAdd(compoundActions.primitives.getArmWristParallel())

                        .stopAndAdd(compoundActions.primitives.getArmWristPerpendicular())

                        .waitSeconds(.25)

                        .stopAndAdd(compoundActions.primitives.getElevatorDown())

                        .afterTime(.2, compoundActions.getExtendIntake())

                        .strafeToLinearHeading(new Vector2d(-48.07, -47.819), Math.toRadians(270-180)) // x: -49.07
                        .stopAndAdd(compoundActions.getExtendIntakeGinger())
                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.getRetract())

                        .stopAndAdd(compoundActions.primitives.getClawClose())

                        .stopAndAdd(compoundActions.getScore())

                        .waitSeconds(.1)

                        .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getArmVertical())

                        .strafeToLinearHeading(new Vector2d(-53.000, -53.000), Math.toRadians(225-180))

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getArmHeilHitler())

                        .waitSeconds(.35)

                        .stopAndAdd(compoundActions.primitives.getClawOpen())

                        .waitSeconds(.25)

                        .afterTime(0, compoundActions.primitives.getArmHandoff())

                        .stopAndAdd(compoundActions.primitives.getExtendoWristOut())

                        .waitSeconds(.25)

                        .stopAndAdd(compoundActions.primitives.getElevatorDown())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getArmHeilHitler())

//                        .afterTime(.2, compoundActions.getExtendIntake())

                        .strafeToLinearHeading(new Vector2d(-60.021, -47.945), Math.toRadians(270-180))
                        .stopAndAdd(compoundActions.getExtendIntakeGinger())
                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.getRetract())

                        .waitSeconds(.3)

                        .stopAndAdd(compoundActions.primitives.getClawClose())

                        .stopAndAdd(compoundActions.getScore())

                        .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())

                        .waitSeconds(.15)

                        .stopAndAdd(compoundActions.primitives.getArmVertical())

                        .strafeToLinearHeading(new Vector2d(-53.000, -53.000), Math.toRadians(225-180))

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getArmHeilHitler())

                        .waitSeconds(.5)

                        .stopAndAdd(compoundActions.primitives.getClawOpen())

                        .waitSeconds(.35)

                        .afterTime(0, compoundActions.primitives.getArmHandoff())

                        .waitSeconds(.35)

                        .stopAndAdd(compoundActions.primitives.getExtendoWristOut())

                        .stopAndAdd(compoundActions.primitives.getElevatorDown())

                        .waitSeconds(.1)

                        .stopAndAdd(compoundActions.primitives.getArmHeilHitler())

                        .strafeToLinearHeading(new Vector2d(-54.531, -45.671), Math.toRadians(300-180))

                        .stopAndAdd(compoundActions.getExtendIntakeGinger())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.getRetract())

                        .waitSeconds(.05)

                        .stopAndAdd(compoundActions.primitives.getClawClose())

                        .stopAndAdd(compoundActions.getScore())

                        .waitSeconds(.1)

                        .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getArmVertical())

                        .strafeToLinearHeading(new Vector2d(-53.000, -53.000), Math.toRadians(225-180))

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getArmHeilHitler())

                        .waitSeconds(.35)

                        .stopAndAdd(compoundActions.primitives.getClawOpen())

                        .waitSeconds(.15)

                        .afterTime(0, compoundActions.primitives.getArmHandoff())

                        .waitSeconds(.15)

                        .stopAndAdd(compoundActions.primitives.getElevatorDown())

                        .strafeToLinearHeading(new Vector2d(-45.239, -16.184), Math.toRadians(180-180))

                        .strafeToLinearHeading(new Vector2d(-26.475, -10.322), Math.toRadians(170-180))
                        .stopAndAdd(compoundActions.primitives.getSweeperOut())
                        .waitSeconds(.2)
                        .stopAndAdd(compoundActions.primitives.getExtendoWristOut())
                        // LUCAS CHECK THIS LINE
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

                        .strafeToLinearHeading(new Vector2d(-45.239, -16.184), Math.toRadians(180-180))

                        .strafeToLinearHeading(new Vector2d(-53.000, -52.70), Math.toRadians(225-180))

                        .stopAndAdd(compoundActions.primitives.getArmHeilHitler())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getClawOpen())

                        .waitSeconds(.2)

                        .afterTime(0, compoundActions.primitives.getArmHandoff())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getElevatorDown())

                        .strafeToLinearHeading(new Vector2d(-45.239, -16.184), Math.toRadians(180-180))

                        .strafeToLinearHeading(new Vector2d(-26.275, -10.322), Math.toRadians(205-180))
                        .stopAndAdd(compoundActions.primitives.getSweeperOut())
                        .waitSeconds(.2)
                        .stopAndAdd(compoundActions.primitives.getExtendoWristOut())
                        // LUCAS CHECK THIS LINE
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

                        .strafeToLinearHeading(new Vector2d(-45.239, -16.184), Math.toRadians(180-180))

                        .strafeToLinearHeading(new Vector2d(-53.000, -52.700), Math.toRadians(225-180))

                        .stopAndAdd(compoundActions.primitives.getArmHeilHitler())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getClawOpen())

                        .waitSeconds(.2)

                        .afterTime(0, compoundActions.primitives.getArmHandoff())

                        .waitSeconds(.2)

                        .stopAndAdd(compoundActions.primitives.getElevatorDown())

                        .build()

        );

    }

}