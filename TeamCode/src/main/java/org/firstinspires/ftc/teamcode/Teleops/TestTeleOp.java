package org.firstinspires.ftc.teamcode.Teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.Drivetrain.Drivetrain;
import org.firstinspires.ftc.teamcode.FIntake.FIntake;
import org.firstinspires.ftc.teamcode.FIntake.FIntakeIOReal;
import org.firstinspires.ftc.teamcode.Intake.Intake;
import org.firstinspires.ftc.teamcode.Shooter.Shooter;
import org.firstinspires.ftc.teamcode.Shooter.ShooterIOReal;
import org.firstinspires.ftc.teamcode.Transfer.Transfer;
import org.firstinspires.ftc.teamcode.Transfer.TransferIOReal;
import org.firstinspires.ftc.teamcode.Turret.Turret;
import org.firstinspires.ftc.teamcode.Turret.TurretIOReal;
import org.firstinspires.ftc.teamcode.math_utils.PoseEstimator;
import org.firstinspires.ftc.teamcode.Intake.IntakeIOReal;


@TeleOp(name = "firsttestteleopoftheyear")
public class TestTeleOp extends OpMode {

    public boolean isRed;
    public Drivetrain drivetrain;
    public Shooter shooter;
    public Intake intake;
    public FIntake fIntake;
    public Turret turret;
    public Transfer transfer;

    @Override
    public void init() {
        PoseEstimator.init(hardwareMap, new Pose2D(DistanceUnit.METER, 0, 0, AngleUnit.DEGREES, 0), false, true);
        drivetrain = new Drivetrain(hardwareMap);
        shooter = new Shooter(new ShooterIOReal(hardwareMap));
        intake = new Intake(new IntakeIOReal(hardwareMap));
        fIntake = new FIntake(new FIntakeIOReal(hardwareMap));
        turret = new Turret(new TurretIOReal(hardwareMap));
        transfer = new Transfer(new TransferIOReal(hardwareMap));


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

        if(gamepad2.b){

            //intake on controller2

            intake.intake();
            transfer.feed();

        }else if(gamepad2.a){

            //outtake on controller2

            intake.outtake();
            transfer.backfeed();

        }else if (gamepad2.right_trigger > 0.2) {

            shooter.revShooterWheelsVelocity();
            intake.intake();
            transfer.feed();

        }else{

            //everything off

            shooter.turnOffShooters();
            intake.off();
            transfer.off();

        }

        telemetry.addData("pose X",PoseEstimator.getPose().getX(DistanceUnit.CM));
        telemetry.addData("pose Y",PoseEstimator.getPose().getY(DistanceUnit.CM));
        telemetry.addData("pose heading",PoseEstimator.getPose().getHeading(AngleUnit.DEGREES));
      //  telemetry.addData("orbit vector angle", drivetrain.getOrbitVector());

    }
}
