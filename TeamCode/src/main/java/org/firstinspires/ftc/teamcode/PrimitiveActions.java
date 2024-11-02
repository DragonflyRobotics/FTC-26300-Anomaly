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
    Servo extendo1;
    Servo extendo2;
    Servo extendoWrist;
    CRServo wheel1;
    CRServo wheel2;
    DcMotorEx elevator1;
    DcMotorEx elevator2;

    double elevatorTolerance = 20;
    double servoTolerance = 0.05;

    public PrimitiveActions(HardwareMap hardwareMap) {
        scoreArm = hardwareMap.get(Servo.class, "scoreArm");
        scoreWrist = hardwareMap.get(Servo.class, "scoreWrist");
        scoreClaw = hardwareMap.get(Servo.class, "scoreClaw");
        extendo1 = hardwareMap.get(Servo.class, "extendo1");
        extendo2 = hardwareMap.get(Servo.class, "extendo2");
        extendoWrist = hardwareMap.get(Servo.class, "extendoWrist");
        wheel1 = hardwareMap.get(CRServo.class, "wheel1");
        wheel2 = hardwareMap.get(CRServo.class, "wheel2");

        elevator1 = hardwareMap.get(DcMotorEx.class, "elevator1");
        elevator1.setDirection(DcMotorSimple.Direction.REVERSE);
        elevator2 = hardwareMap.get(DcMotorEx.class, "elevator2");
        elevator1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        elevator2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        elevator1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        elevator2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        elevator1.setTargetPosition(0);
        elevator2.setTargetPosition(0);
        elevator1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        elevator2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        elevator1.setPower(0.7);
        elevator2.setPower(0.7);
    }

    private class Extendo implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(extendo1.getPosition() - 0.75) > servoTolerance || Math.abs(extendo2.getPosition() - 0.25) > servoTolerance) {
                extendo1.setPosition(0.75);
                extendo2.setPosition(0.25);
                return true;
            }
            return false;
        }
    }

    public Action getExtendo() {
        return new Extendo();
    }

    private class ExtendoPartial implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(extendo1.getPosition() - 0.95) > servoTolerance || Math.abs(extendo2.getPosition() - 0.05) > servoTolerance) {
                extendo1.setPosition(0.95);
                extendo2.setPosition(0.05);
                return true;
            }
            return false;
        }
    }

    public Action getExtendoPartial() {
        return new ExtendoPartial();
    }

    private class RetractExdendo implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(extendo1.getPosition() - 1) > servoTolerance || Math.abs(extendo2.getPosition() - 0) > servoTolerance) {
                extendo1.setPosition(1);
                extendo2.setPosition(0);
                return true;
            }
            return false;
        }
    }

    public Action getRetractExtendo() {
        return new RetractExdendo();
    }

    private class ExtendoWristIn implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(extendoWrist.getPosition() - 0) > servoTolerance) {
                extendoWrist.setPosition(0);
                return true;
            }
            return false;
        }
    }

    public Action getExtendoWristIn() {
        return new ExtendoWristIn();
    }

    private class ExtendoWristOut implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(extendoWrist.getPosition() - 0.98) > servoTolerance) {
                extendoWrist.setPosition(0.98);
                return true;
            }
            return false;
        }
    }

    public Action getExtendoWristOut() {
        return new ExtendoWristOut();
    }

    private class SpinIn implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            wheel1.setPower(-1);
            wheel2.setPower(1);
            return false;
        }
    }

    public Action getSpinIn() {
        return new SpinIn();
    }

    private class SpinOut implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            wheel1.setPower(1);
            wheel2.setPower(-1);
            return false;
        }
    }

    public Action getSpinOut() {
        return new SpinOut();
    }

    private class SpinStop implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            wheel1.setPower(0);
            wheel2.setPower(0);
            return false;
        }
    }

    public Action getSpinStop() {
        return new SpinStop();
    }

    private class ArmIn implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(scoreArm.getPosition() - 0.08) > servoTolerance) {
                scoreArm.setPosition(0.08);
                return true;
            }
            return false;
        }
    }

    public Action getArmIn() {
        return new ArmIn();
    }

    private class ArmOut implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(scoreArm.getPosition() - 0.5) > servoTolerance) {
                scoreArm.setPosition(0.5);
                return true;
            }
            return false;
        }
    }

    public Action getArmOut() {
        return new ArmOut();
    }

    private class ArmHitler implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(scoreArm.getPosition() - 0.7) > servoTolerance) {
                scoreArm.setPosition(0.7);
                return true;
            }
            return false;
        }
    }

    public Action getArmHitler() {
        return new ArmHitler();
    }

    private class ScoreWristFlat implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(scoreWrist.getPosition() - 0.75) > servoTolerance) {
                scoreWrist.setPosition(0.75);
                return true;
            }
            return false;
        }
    }

    public Action getScoreWristFlat() {
        return new ScoreWristFlat();
    }

    private class ScoreWristPerp implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(scoreWrist.getPosition() - 0.45) > servoTolerance) {
                scoreWrist.setPosition(0.45);
                return true;
            }
            return false;
        }
    }

    public Action getScoreWristPerp() {
        return new ScoreWristPerp();
    }

    private class ScoreClawClose implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
//            if (Math.abs(scoreClaw.getPosition() - 0.3) > servoTolerance) {
                scoreClaw.setPosition(0.2);
//                return true;
//            }
            return false;
        }
    }

    public Action getScoreClawClose() {
        return new ScoreClawClose();
    }

    private class ScoreClawOpen implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
//            if (Math.abs(scoreClaw.getPosition() - 1) > servoTolerance) {
                scoreClaw.setPosition(1);
//                return true;
//            }
            return false;
        }
    }

    public Action getScoreClawOpen() {
        return new ScoreClawOpen();
    }

    private class ElevatorDown implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(elevator1.getCurrentPosition()) > 20 || Math.abs(elevator2.getCurrentPosition()) > 20) {
                elevator1.setTargetPosition(0);
                elevator2.setTargetPosition(0);
                elevator1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                elevator2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                elevator1.setPower(0.7);
                elevator2.setPower(0.7);
                return true;
            }
            return false;
        }
    }

    public Action getElevatorDown() {
        return new ElevatorDown();
    }

    private class ElevatorDownLittle implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(elevator1.getCurrentPosition() - (-1026)) > 20 || Math.abs(elevator2.getCurrentPosition() - (-753)) > 20) {
                elevator1.setTargetPosition(-1026);
                elevator2.setTargetPosition(-753);
                elevator1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                elevator2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                elevator1.setPower(0.7);
                elevator2.setPower(0.7);
                return true;
            }
            return false;
        }
    }

    public Action getElevatorDownLittle() {
        return new ElevatorDownLittle();
    }

    private class ElevatorLowBasket implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(elevator1.getCurrentPosition() - (-2526)) > 20 || Math.abs(elevator2.getCurrentPosition() - (-2253)) > 20) {
                elevator1.setTargetPosition(-2526);
                elevator2.setTargetPosition(-2253);
                elevator1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                elevator2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                elevator1.setPower(0.7);
                elevator2.setPower(0.7);
                return true;
            }
            return false;
        }
    }

    public Action getElevatorLowBasket() {
        return new ElevatorLowBasket();
    }

    private class ElevatorPark implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(elevator1.getCurrentPosition() - (-1426)) > 20 || Math.abs(elevator2.getCurrentPosition() - (-1153)) > 20) {
                elevator1.setTargetPosition(-1426);
                elevator2.setTargetPosition(-1153);
                elevator1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                elevator2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                elevator1.setPower(0.7);
                elevator2.setPower(0.7);
                return true;
            }
            return false;
        }
    }

    public Action getElevatorPark() {
        return new ElevatorPark();
    }

    private class ElevatorHighBasket implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (Math.abs(elevator1.getCurrentPosition() - (-3490)) > 20 || Math.abs(elevator2.getCurrentPosition() - (-3080)) > 20) {
                elevator1.setTargetPosition(-3490);
                elevator2.setTargetPosition(-3080);
                elevator1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                elevator2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                elevator1.setPower(0.7);
                elevator2.setPower(0.7);
                return true;
            }
            return false;
        }
    }

    public Action getElevatorHighBasket() {
        return new ElevatorHighBasket();
    }
}


