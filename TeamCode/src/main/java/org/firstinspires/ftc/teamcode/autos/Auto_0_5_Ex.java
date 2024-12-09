package org.firstinspires.ftc.teamcode.autos;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.CompoundActions;
import org.firstinspires.ftc.teamcode.SparkFunOTOSDrive;

@Autonomous(name = "Auto_0_5_Ex")
public final class Auto_0_5_Ex extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Pose2d beginPose = new Pose2d(36.5, 61, Math.toRadians(180));
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
                    .stopAndAdd(compoundActions.primitives.getExtendoWristOut())
                    .stopAndAdd(compoundActions.primitives.getClawClose())
                    .stopAndAdd(compoundActions.primitives.getExtendoWristIn())
                    .stopAndAdd(compoundActions.primitives.getClawClose())
                    .stopAndAdd(compoundActions.primitives.getExtendoWristOut())
                    .stopAndAdd(compoundActions.primitives.getArmHeilHitler())
                    .stopAndAdd(compoundActions.primitives.getArmVertical()) // changed
                    .waitSeconds(.8)
                    .strafeToLinearHeading(new Vector2d(58, 49), Math.toRadians(235))
                    .stopAndAdd(compoundActions.primitives.getArmHeilHitler())
                    .waitSeconds(.25)
                    .stopAndAdd(compoundActions.primitives.getClawOpen())
                    .waitSeconds(.15)
                    .afterTime(0, compoundActions.primitives.getArmHandoff())
                    .strafeToLinearHeading(new Vector2d(55, 45), Math.toRadians(235))
                    .stopAndAdd(compoundActions.primitives.getArmWristParallel())
                    .stopAndAdd(compoundActions.primitives.getArmWristPerpendicular())
                    .stopAndAdd(compoundActions.primitives.getElevatorDown())
                    .strafeToLinearHeading(new Vector2d(45.6, 44), Math.toRadians(270))
                    .stopAndAdd(compoundActions.getExtendIntake())
                    .waitSeconds(.1)
                    .waitSeconds(.2)
                    .stopAndAdd(compoundActions.getRetract())
                    .waitSeconds(.2)
                    .stopAndAdd(compoundActions.primitives.getClawClose())
                    .stopAndAdd(compoundActions.getScore())
                    .waitSeconds(.1)
                    .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())
                    .waitSeconds(.3)
                    .stopAndAdd(compoundActions.primitives.getArmVertical()) // changed
                    //Intake
                    .strafeToLinearHeading(new Vector2d(54, 49), Math.toRadians(235))
                    .waitSeconds(.7)
                    .stopAndAdd(compoundActions.primitives.getArmHeilHitler())
                    .waitSeconds(.25)
                    .stopAndAdd(compoundActions.primitives.getClawOpen())
                    .waitSeconds(.15)
                    .afterTime(0, compoundActions.primitives.getArmHandoff())
                    .strafeToLinearHeading(new Vector2d(51, 45), Math.toRadians(235))
                    .stopAndAdd(compoundActions.primitives.getExtendoWristOut())
                    .stopAndAdd(compoundActions.primitives.getElevatorDown())
                    .waitSeconds(.3)
                    .stopAndAdd(compoundActions.primitives.getArmHeilHitler())
                    //Score
                    .strafeToLinearHeading(new Vector2d(56.2, 42), Math.toRadians(270))
                    .stopAndAdd(compoundActions.getExtendIntake())
                    .waitSeconds(.3)
                    .stopAndAdd(compoundActions.getRetract())
                    .waitSeconds(.2)
                    .stopAndAdd(compoundActions.primitives.getClawClose())
                    .stopAndAdd(compoundActions.getScore())
                    .waitSeconds(.1)
                    .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())
                    .waitSeconds(.25)
                    .stopAndAdd(compoundActions.primitives.getArmVertical()) // changed
                    //Intake
                    .strafeToLinearHeading(new Vector2d(56, 49), Math.toRadians(245))
                    .waitSeconds(1)
                    .stopAndAdd(compoundActions.primitives.getArmHeilHitler())
                    .waitSeconds(.5)
                    .stopAndAdd(compoundActions.primitives.getClawOpen())
                    .waitSeconds(.15)
                    .afterTime(0, compoundActions.primitives.getArmHandoff())
                    .strafeToLinearHeading(new Vector2d(53, 45), Math.toRadians(235))
                    .stopAndAdd(compoundActions.primitives.getExtendoWristOut())
                    .stopAndAdd(compoundActions.primitives.getElevatorDown())
                    .waitSeconds(.3)
                    .stopAndAdd(compoundActions.primitives.getArmHeilHitler())
                    //Score
                    .strafeToLinearHeading(new Vector2d(56.5, 43), Math.toRadians(290))
                    .waitSeconds(.3)
                    .stopAndAdd(compoundActions.getExtendIntake())
                    .waitSeconds(.3)
                    .stopAndAdd(compoundActions.getRetract())
                    .waitSeconds(.2)
                    .stopAndAdd(compoundActions.primitives.getClawClose())
                    .stopAndAdd(compoundActions.getScore())
                    .waitSeconds(.1)
                    .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())
                    .waitSeconds(.25)
                    .stopAndAdd(compoundActions.primitives.getArmVertical()) // changed
                    //Intake
                    .strafeToLinearHeading(new Vector2d(56.1, 48.5), Math.toRadians(245))
                    .waitSeconds(.6)
                    .stopAndAdd(compoundActions.primitives.getArmHeilHitler())
                    .waitSeconds(.25)
                    .stopAndAdd(compoundActions.primitives.getClawOpen())
                    .waitSeconds(.15)
                    .afterTime(0, compoundActions.primitives.getArmHandoff())
                    .strafeToLinearHeading(new Vector2d(53.5, 44.5), Math.toRadians(235))
                    .stopAndAdd(compoundActions.primitives.getElevatorDown())
                    .strafeToLinearHeading(new Vector2d(30, 12), Math.toRadians(180))
                    .strafeToLinearHeading(new Vector2d(24, 12), Math.toRadians(180))
                    .stopAndAdd(compoundActions.primitives.getExtendoWristOut())
                    .stopAndAdd(compoundActions.getExtendIntake())
                    .waitSeconds(.05)
                    .stopAndAdd(compoundActions.getExtendIntake())
                    .waitSeconds(.3)
                    .stopAndAdd(compoundActions.getRetract())
                    .waitSeconds(.3)
                    .stopAndAdd(compoundActions.primitives.getClawClose())
                    .stopAndAdd(compoundActions.getScore())
                    .waitSeconds(.3)
                    .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())
                    .waitSeconds(.2)
                    .stopAndAdd(compoundActions.primitives.getArmVertical()) // changed
                    //Intake
                    .strafeToLinearHeading(new Vector2d(32, 12), Math.toRadians(180))
                    .strafeToLinearHeading(new Vector2d(56.5, 49), Math.toRadians(235))
                    .stopAndAdd(compoundActions.primitives.getArmHeilHitler())
                    .waitSeconds(.2)
                    .stopAndAdd(compoundActions.primitives.getClawOpen())
                    .waitSeconds(.2)
                    .afterTime(0, compoundActions.primitives.getArmHandoff())
                    .strafeToLinearHeading(new Vector2d(52, 47), Math.toRadians(235))
                    .stopAndAdd(compoundActions.primitives.getElevatorDown())
                    .build());
    }
}
