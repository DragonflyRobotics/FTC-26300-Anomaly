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
    CRServo wheell;
    CRServo wheelr;
    DcMotorEx elevatorl;
    DcMotorEx elevatorr;

    double SERVO_TOLERANCE = 0.05;
    double MOTOR_TOLERANCE = 20;


    public PrimitiveActions(HardwareMap hardwareMap, boolean isAuto) {
        scoreArm = hardwareMap.get(Servo.class, "arm");
        scoreWrist = hardwareMap.get(Servo.class, "arm_wrist");
        scoreClaw = hardwareMap.get(Servo.class, "claw");
        extendol = hardwareMap.get(Servo.class, "extendo_left");
        extendor = hardwareMap.get(Servo.class, "extendo_right");
        extendoWrist = hardwareMap.get(Servo.class, "extendo_wrist");
        wheell = hardwareMap.get(CRServo.class, "intake_wheel_l");
        wheelr = hardwareMap.get(CRServo.class, "intake_wheel_r");

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
        }
        elevatorl.setTargetPosition(0);
        elevatorr.setTargetPosition(0);
        elevatorl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        elevatorr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        elevatorl.setPower(0.3);
        elevatorr.setPower(0.3);
    }

    //=======================================
    private class Extendo implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(extendol.getPosition() - 1) > SERVO_TOLERANCE || Math.abs(extendor.getPosition() - 1) > SERVO_TOLERANCE) {
                extendol.setPosition(1);
                extendor.setPosition(1);
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
            if (Math.abs(extendol.getPosition() - 0.015) > SERVO_TOLERANCE || Math.abs(extendor.getPosition() - 0.015) > SERVO_TOLERANCE) {
                extendol.setPosition(0.015);
                extendor.setPosition(0.015);
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
            if (Math.abs(extendoWrist.getPosition() - 0.15) > SERVO_TOLERANCE) {
                extendoWrist.setPosition(0.15);
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
            if (Math.abs(extendoWrist.getPosition() - 0.78) > SERVO_TOLERANCE) {
                extendoWrist.setPosition(0.78);
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
    private class ElevatorHighBasket implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            elevatorl.setTargetPosition(2750);
            elevatorr.setTargetPosition(2750);
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
            elevatorl.setTargetPosition(1375);
            elevatorr.setTargetPosition(1375);
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
            elevatorl.setTargetPosition(1100);
            elevatorr.setTargetPosition(1100);
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
            if (Math.abs(scoreClaw.getPosition() - 0) > SERVO_TOLERANCE) {
                scoreClaw.setPosition(0);
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
            if (Math.abs(scoreClaw.getPosition() - 0.5) > SERVO_TOLERANCE) {
                scoreClaw.setPosition(0.5);
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
            if (Math.abs(scoreWrist.getPosition() - 0) > SERVO_TOLERANCE) {
                scoreWrist.setPosition(0);
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
            if (Math.abs(scoreWrist.getPosition() - 0.5) > SERVO_TOLERANCE) {
                scoreWrist.setPosition(0.5);
                return true;
            }
            return false;
        }
    }

    public Action getArmWristPerpendicular() {
        return new ArmWristPerpendicular();
    }

    private class ArmHeilHitler implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(scoreArm.getPosition() - 0.15) > SERVO_TOLERANCE) {
                scoreArm.setPosition(0.15);
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
    private class ArmHandoff implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(scoreArm.getPosition() - 1) > SERVO_TOLERANCE) {
                scoreArm.setPosition(1);
                return true;
            }
            return false;
        }
    }

    public Action getArmHandoff() {
        return new ArmHandoff();
    }
    //=======================================
}


