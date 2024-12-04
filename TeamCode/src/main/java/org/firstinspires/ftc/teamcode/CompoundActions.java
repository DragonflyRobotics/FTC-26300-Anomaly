package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Actions;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.ArrayList;
import java.util.List;

public class CompoundActions {
    public PrimitiveActions primitives;
    public CompoundActions(HardwareMap hardwareMap, boolean isAuto) {
        primitives = new PrimitiveActions(hardwareMap, isAuto);
    }
    public Action getExtendIntake() {
        return new SequentialAction(
                primitives.getSpinIn(),
                primitives.getExtendoOverFence(),
                new SleepAction(0.25),
                new ParallelAction(
                    primitives.getExtendoWristOut(),
                    primitives.getSpinIn()
                ),
                new SleepAction(0.25),
                new ParallelAction(
                    primitives.getClawClose(),
                    primitives.getExtendo(),
                    primitives.getArmHeilHitler(),
                    primitives.getArmWristParallel()
                ),
                new SleepAction(0.25),
                primitives.getClawOpen()
        );
    }

    public Action getRetract() {
        return new SequentialAction(
                new ParallelAction(
                        primitives.getClawOpen(),
                        primitives.getArmHandoff(),
                        primitives.getArmWristPerpendicular()
                ),
                new SleepAction(0.2),
                new ParallelAction(
                    primitives.getExtendoOverFence(),
                    primitives.getSpinIn(),
                    primitives.getExtendoWristIn()
                ),
                new SleepAction(0.6),
                new ParallelAction(
                    primitives.getSpinOut(),
                    new SleepAction(0.1)
                ),
                primitives.getExtendoOverFence(),
                primitives.getSpinStop(),
                primitives.getClawClose()
        );
    }

    public Action getScore() {
        return new SequentialAction(
                new ParallelAction(
                    primitives.getSpinStop(),
                    primitives.getArmHeilHitler(),
                    primitives.getClawClose(),
                    primitives.getExtendoOverFence(),
                    primitives.getArmWristPerpendicular(),
                    primitives.getSpinOut()
                ),
                new SleepAction(0.5),
                primitives.getArmWristParallel(),
                primitives.getSpinIn()
        );
    }

    public Action getFold() {
        return new SequentialAction(
                new ParallelAction(
                        primitives.getClawOpen(),
                        primitives.getRetract(),
                        primitives.getSpinStop(),
                        primitives.getExtendoWristIn(),
                        primitives.getArmHandoff(),
                        primitives.getArmWristPerpendicular()
                )
        );
    }
}
