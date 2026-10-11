package org.firstinspires.ftc.teamcode.Teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.Drivetrain.Drivetrain;
import org.firstinspires.ftc.teamcode.Intake.Intake;
import org.firstinspires.ftc.teamcode.Shooter.Shooter;
import org.firstinspires.ftc.teamcode.math_utils.PoseEstimator;


@TeleOp(name = "firsttestteleopoftheyear")
public class TestTeleOp extends OpMode {

    public boolean isRed;
    public Drivetrain drivetrain;
    public Shooter shooter;
    public Intake intake;

    @Override
    public void init() {
        PoseEstimator.init(hardwareMap, new Pose2D(DistanceUnit.METER, 0, 0, AngleUnit.DEGREES, 0), false, true);
        drivetrain = new Drivetrain(hardwareMap);
        shooter = new Shooter(hardwareMap);
        intake = new Intake(hardwareMap);

    }

    @Override
    public void init_loop(){
        if(gamepad2.aWasPressed()){
            isRed = !isRed;
        }
        telemetry.addLine("[G2 A] Teleop Alliance Color: " + (isRed ? "RED" : "BLUE"));
        telemetry.update();
    }

    @Override
    public void loop() {

        PoseEstimator.periodic();
        drivetrain.periodic();
//        if(!gamepad1.a) {
//            drivetrain.setFieldDriveMotorPower(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x, -Math.PI/2);
//        }else{
//            drivetrain.setFieldDriveMotorPower(gamepad1.left_stick_y, gamepad1.left_stick_x, drivetrain.getDrivePIDPower(), -Math.PI/2);
//        }


//        drivetrain.setFieldDriveMotorPower(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x, -Math.PI/2);

        if(gamepad1.b){

            //intake on controller2

            intake.setIntakePower(-0.7);
            intake.setKickerPower(0.7);

        }else if(gamepad1.a){

            //outtake on controller2

            intake.setIntakePower(0.5);
            intake.setKickerPower(-0.5);

        }else if (gamepad1.right_trigger > 0.2) {

            shooter.shooterSetVelocity(2200);

        }else{

            //everything off
            shooter.shooterSetVelocity(0);
            intake.setIntakePower(0);
            intake.setKickerPower(0);

        }

        telemetry.addData("pose X",PoseEstimator.getPose().getX(DistanceUnit.CM));
        telemetry.addData("pose Y",PoseEstimator.getPose().getY(DistanceUnit.CM));
        telemetry.addData("pose heading",PoseEstimator.getPose().getHeading(AngleUnit.DEGREES));
      //  telemetry.addData("orbit vector angle", drivetrain.getOrbitVector());

    }
}
