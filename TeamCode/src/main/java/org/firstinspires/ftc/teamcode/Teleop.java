package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Actions;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.ArrayList;
import java.util.List;

@TeleOp(name = "Drive-fCD")
public class Teleop extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        boolean clawIsOpen = true;

        SparkFunOTOSDrive drive = new SparkFunOTOSDrive(hardwareMap, new Pose2d(0, 0, 0));
        DcMotor elevator1 = hardwareMap.get(DcMotor.class, "elevator1");
        DcMotor elevator2 = hardwareMap.get(DcMotor.class, "elevator2");
        DistanceSensor dist = hardwareMap.get(DistanceSensor.class, "dist");
        elevator1.setDirection(DcMotorSimple.Direction.REVERSE);

        List<Action> runningActions = new ArrayList<>();
        CompoundActions compoundActions = new CompoundActions(hardwareMap);
        waitForStart();

        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x;
            double rx = gamepad1.right_stick_x;

            if (gamepad1.options) {
                drive.otos.resetTracking();
            }

            if(gamepad1.a) {
                runningActions.add(compoundActions.getExtendIntake());
            }
            if(gamepad1.b) {
                runningActions.add(compoundActions.getRetract());
            }
            if(gamepad1.y) {
                runningActions.add(compoundActions.getScore());
            }
            if(gamepad1.x) {
                runningActions.add(compoundActions.getFold());
            }

            if(gamepad1.right_bumper) {
                if (clawIsOpen) {
                    runningActions.add(
                            new SequentialAction(
                                compoundActions.primitives.getScoreClawClose(),
                                new SleepAction(0.1)
                            )
                    );
                    clawIsOpen = false;
                } else {
                    runningActions.add(
                            new SequentialAction(
                                    compoundActions.primitives.getScoreClawOpen(),
                                    new SleepAction(0.1)
                            )
                    );
                    clawIsOpen = true;
                }
            }

            if(gamepad2.left_trigger > 0.1 || gamepad2.right_trigger > 0.1) {
                elevator1.setPower(gamepad2.left_trigger-gamepad2.right_trigger);
                elevator2.setPower(gamepad2.left_trigger-gamepad2.right_trigger);
            } else {
                elevator1.setPower(0);
                elevator2.setPower(0);
            }

            double botHeading = drive.pose.heading.toDouble();
            double rotX = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
            double rotY = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);

            rotX *= 1.1;

            double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rx), 1);
            double flPower = (rotY + rotX + rx) / denominator;
            double blPower = (rotY - rotX + rx) / denominator;
            double frPower = (rotY - rotX - rx) / denominator;
            double brPower = (rotY + rotX - rx) / denominator;

            drive.leftFront.setPower(flPower);
            drive.leftBack.setPower(blPower);
            drive.rightFront.setPower(frPower);
            drive.rightBack.setPower(brPower);

            drive.updatePoseEstimate();
            if(dist.getDistance(DistanceUnit.MM) < 40) {
                gamepad1.rumble(1);
                gamepad1.setLedColor(0, 1, 0, 500);
            } else {
                gamepad1.setLedColor(1, 0, 0, 500);
            }

            telemetry.addData("x", drive.pose.position.x);
            telemetry.addData("y", drive.pose.position.y);
            telemetry.addData("heading (deg)", Math.toDegrees(drive.pose.heading.toDouble()));
            telemetry.addData("dist", dist.getDistance(DistanceUnit.MM));
            telemetry.update();

            TelemetryPacket packet = new TelemetryPacket();
            packet.fieldOverlay().setStroke("#3F51B5");
            Drawing.drawRobot(packet.fieldOverlay(), drive.pose);

            List<Action> newActions = new ArrayList<>();
            for (Action action : runningActions) {
                action.preview(packet.fieldOverlay());
                if (action.run(packet)) {
                    newActions.add(action);
                }
            }
            runningActions = newActions;

            FtcDashboard.getInstance().sendTelemetryPacket(packet);
        }
    }
}

