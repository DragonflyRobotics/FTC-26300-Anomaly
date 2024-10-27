package org.firstinspires.ftc.teamcode;


import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.CRServo;
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

    public PrimitiveActions(HardwareMap hardwareMap) {
        scoreArm = hardwareMap.get(Servo.class, "scoreArm");
        scoreWrist = hardwareMap.get(Servo.class, "scoreWrist");
        scoreClaw = hardwareMap.get(Servo.class, "scoreClaw");
        extendo1 = hardwareMap.get(Servo.class, "extendo1");
        extendo2 = hardwareMap.get(Servo.class, "extendo2");
        extendoWrist = hardwareMap.get(Servo.class, "extendoWrist");
        wheel1 = hardwareMap.get(CRServo.class, "wheel1");
        wheel2 = hardwareMap.get(CRServo.class, "wheel2");
    }

    private class Extendo implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            extendo1.setPosition(0.75);
            extendo2.setPosition(0.25);
            return false;
        }
    }

    public Action getExtendo() {
        return new Extendo();
    }

    private class ExtendoPartial implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            extendo1.setPosition(0.9);
            extendo2.setPosition(0.1);
            return false;
        }
    }

    public Action getExtendoPartial() {
        return new ExtendoPartial();
    }

    private class RetractExdendo implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            extendo1.setPosition(1);
            extendo2.setPosition(0);
            return false;
        }
    }

    public Action getRetractExtendo() {
        return new RetractExdendo();
    }

    private class ExtendoWristIn implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            extendoWrist.setPosition(0);
            return false;
        }
    }

    public Action getExtendoWristIn() {
        return new ExtendoWristIn();
    }

    private class ExtendoWristOut implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            extendoWrist.setPosition(0.95);
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
            scoreArm.setPosition(0.08);
            return false;
        }
    }

    public Action getArmIn() {
        return new ArmIn();
    }

    private class ArmOut implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            scoreArm.setPosition(0.5);
            return false;
        }
    }

    public Action getArmOut() {
        return new ArmOut();
    }

    private class ScoreWristFlat implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            scoreWrist.setPosition(0.75);
            return false;
        }
    }

    public Action getScoreWristFlat() {
        return new ScoreWristFlat();
    }

    private class ScoreWristPerp implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            scoreWrist.setPosition(0.45);
            return false;
        }
    }

    public Action getScoreWristPerp() {
        return new ScoreWristPerp();
    }

    private class ScoreClawClose implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            scoreClaw.setPosition(0.3);
            return false;
        }
    }

    public Action getScoreClawClose() {
        return new ScoreClawClose();
    }

    private class ScoreClawOpen implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            scoreClaw.setPosition(1);
            return false;
        }
    }

    public Action getScoreClawOpen() {
        return new ScoreClawOpen();
    }
}


