package org.firstinspires.ftc.teamcode.tuning;

import com.acmerobotics.roadrunner.Pose2d;
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
        Pose2d beginPose = new Pose2d(-10, 61, Math.toRadians(270));
        SparkFunOTOSDrive drive = new SparkFunOTOSDrive(hardwareMap, beginPose);
        CompoundActions compoundActions = new CompoundActions(hardwareMap);


        waitForStart();

        Actions.runBlocking(
            drive.actionBuilder(beginPose)
                    .splineTo(new Vector2d(-10, 36), Math.toRadians(270))
                    //Score on high chamber
                    .waitSeconds(1)
                    .strafeTo(new Vector2d(-30, 36))
                    .splineTo(new Vector2d(-36, 18), Math.toRadians(270))
                    .strafeTo(new Vector2d(-45, 10))
                    .strafeTo(new Vector2d(-45, 52))
                    .strafeTo(new Vector2d(-45, 10))
                    .strafeTo(new Vector2d(-53, 10))
                    .strafeTo(new Vector2d(-53, 52))
                    .strafeTo(new Vector2d(-53, 10))
                    .strafeTo(new Vector2d(-61, 10))
                    .strafeTo(new Vector2d(-61, 52))
                    .strafeTo(new Vector2d(-61, 10))
                    .strafeTo(new Vector2d(-68, 10))
                    .strafeTo(new Vector2d(-68, 52))
                    .build());

    }
}
