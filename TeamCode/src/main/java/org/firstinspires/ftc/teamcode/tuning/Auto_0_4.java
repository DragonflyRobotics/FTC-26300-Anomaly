package org.firstinspires.ftc.teamcode.tuning;

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
                    .stopAndAdd(compoundActions.primitives.getClawOpen())
                    .stopAndAdd(compoundActions.primitives.getClawClose())
                    .strafeToLinearHeading(new Vector2d(41, 55), Math.toRadians(200))
                    .stopAndAdd(compoundActions.primitives.getClawClose())
                    .stopAndAdd(compoundActions.primitives.getExtendoWristOut())
                    .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())
                    .waitSeconds(2)
                    .stopAndAdd(compoundActions.primitives.getArmHeilHitler())
                    .waitSeconds(2)
                    .strafeToLinearHeading(new Vector2d(52, 57), Math.toRadians(220))
                    .stopAndAdd(compoundActions.primitives.getClawOpen())
                    .strafeToLinearHeading(new Vector2d(48, 50), Math.toRadians(270))
                    .stopAndAdd(compoundActions.primitives.getElevatorDown())
                    .stopAndAdd(compoundActions.getExtendIntake())
                    .waitSeconds(2)
                    .stopAndAdd(compoundActions.getRetract())
                    .waitSeconds(2)
                    .stopAndAdd(compoundActions.primitives.getClawClose())
                    .stopAndAdd(compoundActions.getScore())
                    //Intake
                    .strafeToLinearHeading(new Vector2d(50, 50), Math.toRadians(235))
                    .waitSeconds(.5)
                    //Score
                    .strafeToLinearHeading(new Vector2d(58, 50), Math.toRadians(270))
                    .waitSeconds(.5)
                    //Intake
                    .strafeToLinearHeading(new Vector2d(57, 50), Math.toRadians(245))
                    .waitSeconds(.5)
                    //Score
                    .strafeToLinearHeading(new Vector2d(56, 45), Math.toRadians(300))
                    .waitSeconds(.5)
                    //Intake
                    .strafeToLinearHeading(new Vector2d(57, 50), Math.toRadians(255))
                    .waitSeconds(.5)
                    //Score
                    .build());
    }
}
