package org.firstinspires.ftc.teamcode;


import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class PrimitiveActions {
    Servo scoreArm;
    Servo scoreWrist;
    Servo scoreClaw;
    Servo extendol;
    Servo extendor;
    Servo extendoWrist;
    Servo sweeper;
    CRServo wheell;
    CRServo wheelr;
    DcMotorEx elevatorl;
    DcMotorEx elevatorr;
    Servo hatcher;

    double SERVO_TOLERANCE = 0.05;
    double MOTOR_TOLERANCE = 20;


    public PrimitiveActions(HardwareMap hardwareMap, boolean isAuto) {
        scoreArm = hardwareMap.get(Servo.class, "arm");
        scoreWrist = hardwareMap.get(Servo.class, "arm_wrist");
        scoreClaw = hardwareMap.get(Servo.class, "claw");
        extendol = hardwareMap.get(Servo.class, "extendo_left");
        extendor = hardwareMap.get(Servo.class, "extendo_right");
        extendoWrist = hardwareMap.get(Servo.class, "extendo_wrist");
        sweeper = hardwareMap.get(Servo.class, "sweeper");
        wheell = hardwareMap.get(CRServo.class, "intake_wheel_l");
        wheelr = hardwareMap.get(CRServo.class, "intake_wheel_r");
        hatcher = hardwareMap.get(Servo.class, "waytoomanydegreesoffreedomonthisthing");

        wheell.setDirection(CRServo.Direction.REVERSE);
        extendol.setDirection(Servo.Direction.REVERSE);

        elevatorl = hardwareMap.get(DcMotorEx.class, "elevator_l");
        elevatorl.setDirection(DcMotorSimple.Direction.REVERSE);
        elevatorr = hardwareMap.get(DcMotorEx.class, "elevator_r");
        elevatorl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        elevatorr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        if(isAuto) {
            elevatorl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            elevatorr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            elevatorl.setTargetPosition(0);
            elevatorr.setTargetPosition(0);
            elevatorl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            elevatorr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            elevatorl.setPower(0.3);
            elevatorr.setPower(0.3);
        }

    }

    //=======================================
    private class Extendo implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(extendol.getPosition() - 0.28) > SERVO_TOLERANCE || Math.abs(extendor.getPosition() - 0.28) > SERVO_TOLERANCE) {
                extendol.setPosition(0.28);
                extendor.setPosition(0.28);
                return true;
            }
            return false;
        }
    }

    public Action getExtendo() {
        return new Extendo();
    }
    //=======================================


    //=======================================
    private class ExtendoOverFence implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(extendol.getPosition() - 0.06) > SERVO_TOLERANCE || Math.abs(extendor.getPosition() - 0.06) > SERVO_TOLERANCE) {
                extendol.setPosition(0.06);
                extendor.setPosition(0.06);
                return true;
            }
            return false;
        }
    }

    public Action getExtendoOverFence() {
        return new ExtendoOverFence();
    }
    //=======================================

    //=======================================
    private class ExtendoOverGinger implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(extendol.getPosition() - 0.15) > SERVO_TOLERANCE || Math.abs(extendor.getPosition() - 0.15) > SERVO_TOLERANCE) {
                extendol.setPosition(0.15);
                extendor.setPosition(0.15);
                return true;
            }
            return false;
        }
    }

    public Action getExtendoOverGinger() {
        return new ExtendoOverGinger();
    }
    //=======================================

    //=======================================
    private class Retract implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(extendol.getPosition() - 0) > SERVO_TOLERANCE || Math.abs(extendor.getPosition() - 0) > SERVO_TOLERANCE) {
                extendol.setPosition(0);
                extendor.setPosition(0);
                return true;
            }
            return false;
        }
    }

    public Action getRetract() {
        return new Retract();
    }
    //=======================================

    //=======================================
    private class SpinIn implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            wheell.setPower(1);
            wheelr.setPower(1);
            return false;
        }
    }

    public Action getSpinIn() {
        return new SpinIn();
    }
    //=======================================

    //=======================================
    private class SpinOut implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            wheell.setPower(-1);
            wheelr.setPower(-1);
            return false;
        }
    }

    public Action getSpinOut() {
        return new SpinOut();
    }
    //=======================================

    //=======================================
    private class SpinStop implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            wheell.setPower(0);
            wheelr.setPower(0);
            return false;
        }
    }

    public Action getSpinStop() {
        return new SpinStop();
    }
    //=======================================

    //=======================================
    private class ExtendoWristIn implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(extendoWrist.getPosition() - 0.05) > SERVO_TOLERANCE) {
                extendoWrist.setPosition(0.05);
                return true;
            }
            return false;
        }
    }

    public Action getExtendoWristIn() {
        return new ExtendoWristIn();
    }
    //=======================================

    //=======================================
    private class ExtendoWristOut implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(extendoWrist.getPosition() - 0.74) > SERVO_TOLERANCE) { // 0.78
                extendoWrist.setPosition(0.74);
                return true;
            }
            return false;
        }
    }

    public Action getExtendoWristOut() {
        return new ExtendoWristOut();
    }
    //=======================================

    //=======================================
    private class ExtendoWristOutTeleop implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(extendoWrist.getPosition() - 0.74) > SERVO_TOLERANCE) { // 0.78
                extendoWrist.setPosition(0.74);
                return true;
            }
            return false;
        }
    }

    public Action getExtendoWristOutTeleop() {
        return new ExtendoWristOutTeleop();
    }
    //=======================================

    //=======================================
    private class ElevatorHighBasket implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            elevatorl.setTargetPosition(825);
            elevatorr.setTargetPosition(825);
            elevatorl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            elevatorr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            elevatorl.setPower(0.9);
            elevatorr.setPower(0.9);
            return false;
        }
    }

    public Action getElevatorHighBasket() {
        return new ElevatorHighBasket();
    }
    //=======================================

    //=======================================
    private class ElevatorMidBasket implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            elevatorl.setTargetPosition(400);
            elevatorr.setTargetPosition(400);
            elevatorl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            elevatorr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            elevatorl.setPower(0.9);
            elevatorr.setPower(0.9);
            return false;
        }
    }

    public Action getElevatorMidBasket() {
        return new ElevatorMidBasket();
    }
    //=======================================

    //=======================================
    private class ElevatorChamber implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            elevatorl.setTargetPosition(400);
            elevatorr.setTargetPosition(400);
            elevatorl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            elevatorr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            elevatorl.setPower(0.9);
            elevatorr.setPower(0.9);
            return false;
        }
    }

    public Action getElevatorChamber() {
        return new ElevatorChamber();
    }
    //=======================================

    //=======================================
    private class ElevatorDown implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            elevatorl.setTargetPosition(0);
            elevatorr.setTargetPosition(0);
            elevatorl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            elevatorr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            elevatorl.setPower(0.9);
            elevatorr.setPower(0.9);
            return false;
        }
    }

    public Action getElevatorDown() {return new ElevatorDown();}
    //=======================================

    //=======================================
    private class ClawClose implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(scoreClaw.getPosition() - 0.205) > SERVO_TOLERANCE) {
                scoreClaw.setPosition(0.205);
                return true;
            }
            return false;
        }
    }

    public Action getClawClose() {
        return new ClawClose();
    }
    //=======================================

    //=======================================
    private class ClawOpen implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(scoreClaw.getPosition() - 0.38) > SERVO_TOLERANCE) {
                scoreClaw.setPosition(0.38);
                return true;
            }
            return false;
        }
    }

    public Action getClawOpen() {
        return new ClawOpen();
    }
    //=======================================

    //=======================================
    private class ArmWristParallel implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(scoreWrist.getPosition() - 0.3) > SERVO_TOLERANCE) {
                scoreWrist.setPosition(0.3);
                return true;
            }
            return false;
        }
    }

    public Action getArmWristParallel() {
        return new ArmWristParallel();
    }
    //=======================================

    //=======================================
    private class ArmWristPerpendicular implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(scoreWrist.getPosition() - 0.67) > SERVO_TOLERANCE) {
                scoreWrist.setPosition(0.67);
                return true;
            }
            return false;
        }
    }

    public Action getArmWristPerpendicular() {
        return new ArmWristPerpendicular();
    }
    //=======================================

    //=======================================
    private class ArmHeilHitler implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(scoreArm.getPosition() - 0.65) > SERVO_TOLERANCE) {
                scoreArm.setPosition(0.65);
                return true;
            }
            return false;
        }
    }

    public Action getArmHeilHitler() {
        return new ArmHeilHitler();
    }
    //=======================================

    //=======================================
    private class ArmChamber implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(scoreArm.getPosition() - 1) > SERVO_TOLERANCE) {
                scoreArm.setPosition(1);
                return true;
            }
            return false;
        }
    }

    public Action getArmChamber() {
        return new ArmChamber();
    }
    //=======================================

    //=======================================
    private class ArmVertical implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(scoreArm.getPosition() - 0.55) > SERVO_TOLERANCE) {
                scoreArm.setPosition(0.55);
                return true;
            }
            return false;
        }
    }

    public Action getArmVertical() {
        return new ArmVertical();
    }
    //=======================================

    //=======================================
    private class ArmHandoff implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(scoreArm.getPosition() - 0.27) > SERVO_TOLERANCE) {
                scoreArm.setPosition(0.27);
                return true;
            }
            return false;
        }
    }

    public Action getArmHandoff() {
        return new ArmHandoff();
    }
    //=======================================

    //=======================================
    private class SweeperIn implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(sweeper.getPosition() - 0.0) > SERVO_TOLERANCE) {
                sweeper.setPosition(0.0);
                return true;
            }
            return false;
        }
    }

    public Action getSweeperIn() {
        return new SweeperIn();
    }
    //=======================================

    //=======================================
    private class SweeperOut implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(sweeper.getPosition() - 1) > SERVO_TOLERANCE) {
                sweeper.setPosition(1);
                return true;
            }
            return false;
        }
    }

    public Action getSweeperOut() {
        return new SweeperOut();
    }
    //=======================================


    //=======================================
    private class HatcherOpen implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(hatcher.getPosition() - 0.33) > SERVO_TOLERANCE) {
                hatcher.setPosition(0.33);
                return true;
            }
            return false;
        }
    }

    public Action getHatcherOpen() {
        return new HatcherOpen();
    }
    //=======================================


    //=======================================
    private class HatcherClose implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(hatcher.getPosition() - 0.15) > SERVO_TOLERANCE) {
                hatcher.setPosition(0.15);
                return true;
            }
            return false;
        }
    }

    public Action getHatcherClose() {
        return new HatcherClose();
    }
    //=======================================



}


