package org.firstinspires.ftc.teamcode.tuning;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.CompoundActions;
import org.firstinspires.ftc.teamcode.SparkFunOTOSDrive;

@Autonomous(name = "KYS")
public final class AutoTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Pose2d beginPose = new Pose2d(-10, 61, Math.toRadians(90));
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
                    .stopAndAdd(compoundActions.primitives.getScoreClawClose())
                    .stopAndAdd(compoundActions.getScore())
                    .waitSeconds(2)
                    .strafeTo(new Vector2d(-8, 36.5))
                    .stopAndAdd(compoundActions.primitives.getScoreWristFlat())
                    .stopAndAdd(compoundActions.primitives.getArmHitler())
                    .waitSeconds(2)
                    .stopAndAdd(compoundActions.primitives.getScoreClawOpen())
                    //Score on high chamber
                    .waitSeconds(1)
                    .strafeTo(new Vector2d(-8, 48))
//                    .turn(Math.toRadians(180))
                    .splineToLinearHeading(new Pose2d(-34, 42, Math.toRadians(180)), Math.toRadians(180))
                    .strafeTo(new Vector2d(-34, 18))
                    .strafeTo(new Vector2d(-43, 10))
                    .strafeTo(new Vector2d(-43, 52))
                    .strafeTo(new Vector2d(-43, 10))
                    .strafeTo(new Vector2d(-53, 10))
                    .strafeTo(new Vector2d(-53, 52))
                    .strafeTo(new Vector2d(-53, 10))
                    .strafeTo(new Vector2d(-61, 10))
                    .strafeTo(new Vector2d(-61, 56))
                    .build());

    }
}
