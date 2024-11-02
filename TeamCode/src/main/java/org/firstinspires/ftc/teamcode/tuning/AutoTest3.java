package org.firstinspires.ftc.teamcode.tuning;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.CompoundActions;
import org.firstinspires.ftc.teamcode.SparkFunOTOSDrive;

@Autonomous(name = "KYS3")
public final class AutoTest3 extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Pose2d beginPose = new Pose2d(10, 61, Math.toRadians(270));
        SparkFunOTOSDrive drive = new SparkFunOTOSDrive(hardwareMap, beginPose);
        CompoundActions compoundActions = new CompoundActions(hardwareMap);


        while (!isStopRequested() && !opModeIsActive()) {
            telemetry.addData("Opmode not active", true);
            telemetry.update();
        }

        waitForStart();

        if (isStopRequested()) return;

        Actions.runBlocking(
            drive.actionBuilder(beginPose)
                    .splineTo(new Vector2d(10, 36), Math.toRadians(270))
                    .waitSeconds(.5)
                    .stopAndAdd(compoundActions.getScore())
                    .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())
                    .stopAndAdd(compoundActions.primitives.getScoreClawOpen())
                    //Score
                    .splineTo(new Vector2d(10, 40), Math.toRadians(270))
                    .strafeToLinearHeading(new Vector2d(41, 45), Math.toRadians(110))
                    .waitSeconds(.5)
                    .stopAndAdd(compoundActions.getExtendIntake())
                    .stopAndAdd(compoundActions.getRetract())
                    //Intake
                    .strafeToLinearHeading(new Vector2d(50, 50), Math.toRadians(45))
                    .waitSeconds(.5)
                    .stopAndAdd(compoundActions.getScore())
                    .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())
                    .stopAndAdd(compoundActions.primitives.getScoreClawOpen())
                    //Score
                    .strafeToLinearHeading(new Vector2d(58, 48), Math.toRadians(90))
                    .waitSeconds(.5)
                    .stopAndAdd(compoundActions.getExtendIntake())
                    .stopAndAdd(compoundActions.getRetract())
                    //Intake
                    .turn(Math.toRadians(-15))
                    .waitSeconds(.5)
                    .stopAndAdd(compoundActions.getScore())
                    .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())
                    .stopAndAdd(compoundActions.primitives.getScoreClawOpen())
                    //Score
                    .turn(Math.toRadians(45))
                    .waitSeconds(.5)
                    .stopAndAdd(compoundActions.getExtendIntake())
                    .stopAndAdd(compoundActions.getRetract())
                    //Intake
                    .waitSeconds(.5)
                    .turn(Math.toRadians(-45))
                    .stopAndAdd(compoundActions.getScore())
                    .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())
                    .stopAndAdd(compoundActions.primitives.getScoreClawOpen())
                    //Score
                    .strafeTo(new Vector2d(41, 35))
                    .strafeToLinearHeading(new Vector2d(41, 9), Math.toRadians(180))
                    //Lift arm
                    .strafeTo(new Vector2d(22, 9))
                    .build());
    }
}
