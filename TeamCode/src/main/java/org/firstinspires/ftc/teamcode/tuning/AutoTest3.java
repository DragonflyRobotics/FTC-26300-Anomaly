//package org.firstinspires.ftc.teamcode.tuning;
//
//import com.acmerobotics.roadrunner.ParallelAction;
//import com.acmerobotics.roadrunner.Pose2d;
//import com.acmerobotics.roadrunner.Vector2d;
//import com.acmerobotics.roadrunner.ftc.Actions;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//
//import org.firstinspires.ftc.teamcode.CompoundActions;
//import org.firstinspires.ftc.teamcode.SparkFunOTOSDrive;
//
//@Autonomous(name = "KYS3")
//public final class AutoTest3 extends LinearOpMode {
//    @Override
//    public void runOpMode() throws InterruptedException {
//        Pose2d beginPose = new Pose2d(10, 61, Math.toRadians(90));
//        SparkFunOTOSDrive drive = new SparkFunOTOSDrive(hardwareMap, beginPose);
//        CompoundActions compoundActions = new CompoundActions(hardwareMap, true);
//
//
//        while (!isStopRequested() && !opModeIsActive()) {
//            telemetry.addData("Opmode not active", true);
//            telemetry.update();
//        }
//
//        waitForStart();
//
//        if (isStopRequested()) return;
//
//        Actions.runBlocking(
//            drive.actionBuilder(beginPose)
//                    .stopAndAdd(compoundActions.primitives.getScoreClawClose())
//                    .stopAndAdd(compoundActions.primitives.getScoreWristPerp())
//                    .stopAndAdd(compoundActions.primitives.getArmIn())
//                    .stopAndAdd(new ParallelAction(
//                            compoundActions.getScore(),
//                            compoundActions.primitives.getElevatorPark(),
//                            compoundActions.primitives.getScoreWristFlat()
//                    ))
//                    .waitSeconds(.25)
//                    .strafeTo(new Vector2d(6.5, 36.5))
//                    .stopAndAdd(new ParallelAction(
//                            compoundActions.primitives.getArmHitler(),
//                            compoundActions.primitives.getElevatorDownLittle()
//                    ))
//                    .waitSeconds(0.25)
//                    .stopAndAdd(compoundActions.primitives.getScoreClawOpen())
//                    //Score on high chamber
//                    .waitSeconds(0.25)
//                    .stopAndAdd(compoundActions.primitives.getElevatorDown())
//                //Score
//                .splineTo(new Vector2d(10, 40), Math.toRadians(90))
//                .strafeToLinearHeading(new Vector2d(40, 41), Math.toRadians(290))
//                .waitSeconds(.5)
//                .stopAndAdd(compoundActions.getExtendIntake())
//                .waitSeconds(0.5)
//                .stopAndAdd(compoundActions.getRetract())
//                .waitSeconds(0.5)
//                //Intake
//                .strafeToLinearHeading(new Vector2d(42, 41), Math.toRadians(225))
//                .waitSeconds(.5)
//                .stopAndAdd(compoundActions.getScore())
//                .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())
//                .stopAndAdd(compoundActions.primitives.getScoreClawOpen())
//                .waitSeconds(0.5)
//                .stopAndAdd(compoundActions.primitives.getElevatorDown())
//                    //Score
//                .strafeToLinearHeading(new Vector2d(58, 48), Math.toRadians(270))
//                .waitSeconds(.5)
//                .stopAndAdd(compoundActions.getExtendIntake())
//                .waitSeconds(0.5)
//                .stopAndAdd(compoundActions.getRetract())
//                .waitSeconds(0.5)
//                //Intake
//                .turn(Math.toRadians(-15))
//                .waitSeconds(.5)
//                .stopAndAdd(compoundActions.getScore())
//                .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())
//                .stopAndAdd(compoundActions.primitives.getScoreClawOpen())
//                .waitSeconds(0.5)
//                .stopAndAdd(compoundActions.primitives.getElevatorDown())
//                //Score
//                .turn(Math.toRadians(45))
//                .waitSeconds(.5)
//                .stopAndAdd(compoundActions.getExtendIntake())
//                .waitSeconds(0.5)
//                .stopAndAdd(compoundActions.getRetract())
//                .waitSeconds(0.5)
//                //Intake
//                .waitSeconds(.5)
//                .turn(Math.toRadians(-45))
//                .stopAndAdd(compoundActions.getScore())
//                .stopAndAdd(compoundActions.primitives.getElevatorHighBasket())
//                .stopAndAdd(compoundActions.primitives.getScoreClawOpen())
//                .waitSeconds(0.5)
//                .stopAndAdd(compoundActions.primitives.getElevatorDown())
//                //Score
//                .strafeTo(new Vector2d(41, 35))
//                .strafeToLinearHeading(new Vector2d(41, 9), Math.toRadians(0))
//                //Lift arm
//                .strafeTo(new Vector2d(22, 9))
//                .build());
//    }
//}
