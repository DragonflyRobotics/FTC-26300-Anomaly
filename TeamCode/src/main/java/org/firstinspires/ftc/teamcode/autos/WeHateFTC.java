package org.firstinspires.ftc.teamcode.autos;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.CompoundActions;
import org.firstinspires.ftc.teamcode.PinpointDrive;
import org.firstinspires.ftc.teamcode.SparkFunOTOSDrive;

@Autonomous(name = "wehateftc")

public final class WeHateFTC extends LinearOpMode {

    @Override

    public void runOpMode() throws InterruptedException {

        Pose2d beginPose = new Pose2d(-39.500, -64.000, Math.toRadians(180-180));

        PinpointDrive drive = new PinpointDrive(hardwareMap, beginPose);

        CompoundActions compoundActions = new CompoundActions(hardwareMap, true);

        while (!isStopRequested() && !opModeIsActive()) {

            telemetry.addData("Opmode not active", true);

            telemetry.update();

        }

        waitForStart();

        if (isStopRequested()) return;

        Actions.runBlocking(

                drive.actionBuilder(beginPose, 21)



                        .strafeToLinearHeading(new Vector2d(-53.500, -53.500), Math.toRadians(225-180))

                        .waitSeconds(3)

                        .strafeToLinearHeading(new Vector2d(-48.07, -47.819), Math.toRadians(270-180)) // x: -49.07
                        .waitSeconds(3)
                        .strafeToLinearHeading(new Vector2d(-53.000, -53.000), Math.toRadians(225-180))
                        .waitSeconds(3)

                        .strafeToLinearHeading(new Vector2d(-60.021, -47.945), Math.toRadians(270-180))
                        .waitSeconds(3)
                        .strafeToLinearHeading(new Vector2d(-53.000, -53.000), Math.toRadians(225-180))
                        .waitSeconds(3)


                        .strafeToLinearHeading(new Vector2d(-54.531, -45.671), Math.toRadians(300-180))
                        .waitSeconds(3)


                        .strafeToLinearHeading(new Vector2d(-53.000, -53.000), Math.toRadians(225-180))
                        .waitSeconds(3)

                        .strafeToLinearHeading(new Vector2d(-45.239, -16.184), Math.toRadians(180-180))
                        .waitSeconds(3)
                        .strafeToLinearHeading(new Vector2d(-26.475, -10.322), Math.toRadians(170-180))
                        .waitSeconds(3)
                        .strafeToLinearHeading(new Vector2d(-45.239, -16.184), Math.toRadians(180-180))
                        .waitSeconds(3)
                        .strafeToLinearHeading(new Vector2d(-53.000, -52.70), Math.toRadians(225-180))
                        .waitSeconds(3)

                        .strafeToLinearHeading(new Vector2d(-45.239, -16.184), Math.toRadians(180-180))
                        .waitSeconds(3)
                        .strafeToLinearHeading(new Vector2d(-26.275, -10.322), Math.toRadians(205-180))
                        .waitSeconds(3)
                        .strafeToLinearHeading(new Vector2d(-45.239, -16.184), Math.toRadians(180-180))
                        .waitSeconds(3)
                        .strafeToLinearHeading(new Vector2d(-53.000, -52.700), Math.toRadians(225-180))
                        .waitSeconds(3)

                        .build()

        );

    }

}