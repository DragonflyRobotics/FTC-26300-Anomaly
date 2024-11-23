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
//@Autonomous(name = "KYS2")
//public final class AutoTest2 extends LinearOpMode {
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
//                    .stopAndAdd(new ParallelAction(
//                            compoundActions.primitives.getScoreClawClose(),
//                            compoundActions.primitives.getScoreWristPerp(),
//                            compoundActions.primitives.getArmIn()
//                    ))
//                    .stopAndAdd(new ParallelAction(
//                                compoundActions.getScore(),
//                                compoundActions.primitives.getElevatorPark(),
//                                compoundActions.primitives.getScoreWristFlat()
//                            ))
//                    .waitSeconds(.25)
//                    .strafeTo(new Vector2d(6.5, 36.25))
//                    .stopAndAdd(new ParallelAction(
//                            compoundActions.primitives.getArmHitler(),
//                            compoundActions.primitives.getElevatorDownLittle()
//                    ))
//                    .waitSeconds(0.25)
//                    .stopAndAdd(compoundActions.primitives.getScoreClawOpen())
//                    //Score on high chamber
//                    .waitSeconds(0.25)
//                    .strafeTo(new Vector2d(8, 48))
////                    .turn(Math.toRadians(180))
//                    .splineToLinearHeading(new Pose2d(34, 42, Math.toRadians(0)), Math.toRadians(0))
//                    .strafeTo(new Vector2d(34, 16))
//                    .strafeTo(new Vector2d(43, 6))
//                    .strafeTo(new Vector2d(47, 56.5))
//                    .strafeTo(new Vector2d(45, 50))
//                    .strafeTo(new Vector2d(40, 9))
//                    .strafeTo(new Vector2d(51, 9))
//                    .strafeTo(new Vector2d(50, 52))
//                    .strafeTo(new Vector2d(50, 10))
//                    .strafeTo(new Vector2d(59, 10))
//                    .strafeTo(new Vector2d(59, 50))
//                    .strafeTo(new Vector2d(59, 10))
//                    .strafeTo(new Vector2d(56, 10))
//                    .afterTime(0, new ParallelAction(
//                            compoundActions.primitives.getScoreClawClose(),
//                            compoundActions.primitives.getArmHitler(),
//                            compoundActions.primitives.getElevatorPark()
//                    ))
//                    .strafeTo(new Vector2d(20.5, 10))
//                    .stopAndAdd(compoundActions.primitives.getArmHitler())
//
//                    .build());
//    }
//}
