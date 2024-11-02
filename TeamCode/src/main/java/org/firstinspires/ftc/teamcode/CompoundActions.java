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
    public CompoundActions(HardwareMap hardwareMap) {
        primitives = new PrimitiveActions(hardwareMap);
    }
    public Action getExtendIntake() {
        return new SequentialAction(
                new ParallelAction(
                    primitives.getScoreClawClose(),
                    primitives.getExtendo(),
                    primitives.getSpinIn(),
                    primitives.getExtendoWristOut(),
                    primitives.getArmOut(),
                    primitives.getScoreWristFlat()
                ),
                new SleepAction(0.25),
                primitives.getScoreClawOpen()
        );
    }

    public Action getRetract() {
        return new SequentialAction(
                primitives.getScoreClawOpen(),
                new ParallelAction(
                    primitives.getRetractExtendo(),
                    primitives.getSpinIn(),
                    primitives.getExtendoWristIn(),
                    primitives.getArmIn(),
                    primitives.getScoreWristPerp()
                ),
                new SleepAction(0.6),
                new ParallelAction(
                    primitives.getSpinOut(),
                    new SleepAction(0.1),
                    primitives.getScoreClawClose()
                ),
                primitives.getExtendoPartial(),
                primitives.getSpinStop()
        );
    }

    public Action getScore() {
        return new ParallelAction(
                primitives.getSpinStop(),
                primitives.getArmOut(),
                primitives.getScoreClawClose(),
                primitives.getExtendoPartial(),
                primitives.getScoreWristFlat()
        );
    }

    public Action getFold() {
        return new SequentialAction(
                new ParallelAction(
                        primitives.getScoreClawOpen(),
                        primitives.getRetractExtendo(),
                        primitives.getSpinStop(),
                        primitives.getExtendoWristIn(),
                        primitives.getArmIn(),
                        primitives.getScoreWristPerp()
                )
        );
    }
}
