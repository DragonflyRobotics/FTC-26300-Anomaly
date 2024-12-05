package org.firstinspires.ftc.teamcode;

import androidx.core.math.MathUtils;

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
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.ArrayList;
import java.util.List;

@TeleOp(name = "Drive-fCD")
public class Teleop extends LinearOpMode {
    int ElevatorPosition(int percent) {
        return (2750/100) * percent;
    }

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        SparkFunOTOSDrive drive = new SparkFunOTOSDrive(hardwareMap, new Pose2d(0, 0, 0));

        double drivePowerMult = 0.9;
        int elevatorPercent = 0;

        DistanceSensor dist = hardwareMap.get(DistanceSensor.class, "dist");

        List<Action> runningActions = new ArrayList<>();
        CompoundActions compoundActions = new CompoundActions(hardwareMap, true); //TODO: CHANGE BEFORE COMP
        waitForStart();

        while (opModeIsActive()) {
            double y = -Math.pow(gamepad1.left_stick_y, 3);
            double x = Math.pow(gamepad1.left_stick_x, 3);
            double rx = Math.pow(gamepad1.right_stick_x, 3);

            if (gamepad1.options) {
                drive.otos.resetTracking();
            }
            if(gamepad1.a && runningActions.isEmpty()) {
                runningActions.add(compoundActions.getExtendIntake());
            }
            if(gamepad1.b && runningActions.isEmpty()) {
                runningActions.add(compoundActions.getRetract());
            }
            if(gamepad1.y && runningActions.isEmpty()) {
                runningActions.add(compoundActions.getScore());
            }
            if(gamepad1.x && runningActions.isEmpty()) {
                runningActions.add(compoundActions.getFold());
            }
            if((gamepad1.right_bumper || gamepad2.right_bumper) && runningActions.isEmpty()) {
                    runningActions.add(compoundActions.primitives.getClawClose());
            }
            if((gamepad1.left_bumper || gamepad2.left_bumper) && runningActions.isEmpty()) {
                runningActions.add(compoundActions.primitives.getClawOpen());
            }


            if(gamepad2.y && runningActions.isEmpty()) {
                runningActions.add(compoundActions.primitives.getElevatorHighBasket());
            }
            if(gamepad2.x && runningActions.isEmpty()) {
                runningActions.add(compoundActions.primitives.getElevatorChamber());
            }
            if(gamepad2.b && runningActions.isEmpty()) {
                runningActions.add(compoundActions.primitives.getElevatorMidBasket());
            }
            if(gamepad2.a && runningActions.isEmpty()) {
                runningActions.add(compoundActions.primitives.getElevatorDown());
            }
            if (gamepad2.dpad_up && runningActions.isEmpty()) {
                compoundActions.primitives.extendol.setPosition(-gamepad2.right_stick_y);
                compoundActions.primitives.extendor.setPosition(-gamepad2.right_stick_y);
            }
            if (Math.abs(gamepad2.left_stick_y) > 0.1 && gamepad2.dpad_down && runningActions.isEmpty()) {
                int velocity = (int)(-gamepad2.left_stick_y * 10);
                elevatorPercent += velocity;
                elevatorPercent = MathUtils.clamp(elevatorPercent, 0, 100);
                compoundActions.primitives.elevatorl.setTargetPosition(ElevatorPosition(elevatorPercent));
                compoundActions.primitives.elevatorr.setTargetPosition(ElevatorPosition(elevatorPercent));
                compoundActions.primitives.elevatorl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                compoundActions.primitives.elevatorr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                compoundActions.primitives.elevatorl.setPower(0.6);
                compoundActions.primitives.elevatorr.setPower(0.6);
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

            drive.leftFront.setPower(flPower * drivePowerMult);
            drive.leftBack.setPower(blPower * drivePowerMult);
            drive.rightFront.setPower(frPower * drivePowerMult);
            drive.rightBack.setPower(brPower * drivePowerMult);

            drive.updatePoseEstimate();
            if(dist.getDistance(DistanceUnit.MM) < 40) {
                gamepad1.rumble(1);
                gamepad1.setLedColor(0, 1, 0, 500);
            }

//            telemetry.addData("x", drive.pose.position.x);
//            telemetry.addData("y", drive.pose.position.y);
//            telemetry.addData("heading (deg)", Math.toDegrees(drive.pose.heading.toDouble()));
//            telemetry.addData("dist", dist.getDistance(DistanceUnit.MM));
            telemetry.addData("elevr", compoundActions.primitives.elevatorr.getCurrentPosition());
            telemetry.addData("elevl", compoundActions.primitives.elevatorl.getCurrentPosition());
            telemetry.addData("elevl_speed", compoundActions.primitives.elevatorl.getVelocity());
            telemetry.addData("elevr_speed", compoundActions.primitives.elevatorr.getVelocity());
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

