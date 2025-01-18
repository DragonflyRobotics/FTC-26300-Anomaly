package org.firstinspires.ftc.teamcode.autos;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.CompoundActions;
import org.firstinspires.ftc.teamcode.SparkFunOTOSDrive;

@Autonomous(name = "Auto_0_4")
public final class Auto_0_4 extends LinearOpMode {
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
            drive.actionBuilder(beginPose)
                    .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())
                    .stopAndAdd(compoundActions.primitives.getClawOpen())
                    .stopAndAdd(compoundActions.primitives.getClawClose())
                    .strafeToLinearHeading(new Vector2d(41, 55), Math.toRadians(200))
                    .stopAndAdd(compoundActions.primitives.getClawClose())
                    .stopAndAdd(compoundActions.primitives.getExtendoWristOut())
                    .stopAndAdd(compoundActions.primitives.getClawClose())
                    .stopAndAdd(compoundActions.primitives.getExtendoWristIn())
                    .stopAndAdd(compoundActions.primitives.getClawClose())
                    .stopAndAdd(compoundActions.primitives.getExtendoWristOut())
                    .waitSeconds(.5)
                    .stopAndAdd(compoundActions.primitives.getArmHandoff())
                    .stopAndAdd(compoundActions.primitives.getArmHeilHitler())
                    .waitSeconds(.5)
                    .strafeToLinearHeading(new Vector2d(59, 50), Math.toRadians(235))
                    .stopAndAdd(compoundActions.primitives.getClawOpen())
                    .waitSeconds(.5)
                    .stopAndAdd(compoundActions.primitives.getArmHandoff())
                    .strafeToLinearHeading(new Vector2d(48, 44), Math.toRadians(270))
                    .stopAndAdd(compoundActions.primitives.getElevatorDown())
                    .stopAndAdd(compoundActions.primitives.getExtendoOverFence())
                    .stopAndAdd(compoundActions.getExtendIntake())
                    .waitSeconds(.1)
                    .stopAndAdd(compoundActions.getExtendIntake())
                    .waitSeconds(.4)
                    .stopAndAdd(compoundActions.getRetract())
                    .waitSeconds(.2)
                    .stopAndAdd(compoundActions.primitives.getClawClose())
                    .stopAndAdd(compoundActions.getScore())
                    .waitSeconds(.2)
                    .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())
                    .waitSeconds(2)
                    //Intake
                    .strafeToLinearHeading(new Vector2d(55, 50), Math.toRadians(235))
                    .waitSeconds(.3)
                    .stopAndAdd(compoundActions.primitives.getClawOpen())
                    .waitSeconds(.3)
                    .stopAndAdd(compoundActions.primitives.getArmHandoff())
                    .waitSeconds(.3)
                    .stopAndAdd(compoundActions.primitives.getExtendoWristOut())
                    .stopAndAdd(compoundActions.primitives.getElevatorDown())
                    .waitSeconds(1.3)
                    //Score
                    .strafeToLinearHeading(new Vector2d(55.5, 44), Math.toRadians(270))
                    .stopAndAdd(compoundActions.getExtendIntake())
                    .waitSeconds(.2)
                    .stopAndAdd(compoundActions.getRetract())
                    .waitSeconds(.5)
                    .stopAndAdd(compoundActions.primitives.getClawClose())
                    .waitSeconds(.3)
                    .stopAndAdd(compoundActions.getScore())
                    .waitSeconds(.2)
                    .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())
                    .waitSeconds(2)
                    //Intake
                    .strafeToLinearHeading(new Vector2d(57, 50), Math.toRadians(245))
                    .waitSeconds(1.2)
                    .stopAndAdd(compoundActions.primitives.getClawOpen())
                    .waitSeconds(.3)
                    .stopAndAdd(compoundActions.primitives.getArmHandoff())
                    .waitSeconds(.3)
                    .stopAndAdd(compoundActions.primitives.getExtendoWristOut())
                    .stopAndAdd(compoundActions.primitives.getElevatorDown())
                    .waitSeconds(1)
                    //Score
                    .strafeToLinearHeading(new Vector2d(56, 45), Math.toRadians(290))
                    .waitSeconds(.3)
                    .stopAndAdd(compoundActions.getExtendIntake())
                    .waitSeconds(.3)
                    .stopAndAdd(compoundActions.getRetract())
                    .waitSeconds(.3)
                    .stopAndAdd(compoundActions.primitives.getClawClose())
                    .waitSeconds(.2)
                    .stopAndAdd(compoundActions.getScore())
                    .waitSeconds(.3)
                    .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())
                    .waitSeconds(2)
                    //Intake
                    .strafeToLinearHeading(new Vector2d(57, 50), Math.toRadians(245))
                    .stopAndAdd(compoundActions.primitives.getClawOpen())
                    .waitSeconds(.2)
                    .stopAndAdd(compoundActions.primitives.getArmHandoff())
                    //Score
                    .build());
    }
}
