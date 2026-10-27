package org.firstinspires.ftc.teamcode.Drivetrain;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.math_utils.PIDController;
import org.firstinspires.ftc.teamcode.math_utils.PoseEstimator;
import org.firstinspires.ftc.teamcode.math_utils.Vector;

public class Drivetrain implements DrivetrainConstant {

    private DrivetrainIO io;
    private final DrivetrainIO.DrivetrainIOInputs inputs = new DrivetrainIO.DrivetrainIOInputs();
    public Pose2D setpoint = new Pose2D(DistanceUnit.METER, 0, 0, AngleUnit.DEGREES, 0);
    public PIDController turnController;
    public PIDController drivePIDheading;
    public double headingSetpoint = 0.0;
    public Vector audienceOrbitVector;
    public double drivePIDPower;

    public Drivetrain (HardwareMap hwMap){

        turnController = new PIDController(2.3, 0.04, 0.2);
        drivePIDheading = new PIDController(kDP, kDI, kDD);

    }

    public void periodic(){
//        audienceOrbitVector = new Vector((PoseEstimator.getPose().getX(DistanceUnit.INCH) - audienceHive.getX(DistanceUnit.INCH)),
//                (PoseEstimator.getPose().getY(DistanceUnit.INCH) - audienceHive.getY(DistanceUnit.INCH)));

        audienceOrbitVector = new Vector( audienceHive.getX(DistanceUnit.INCH) - (PoseEstimator.getPose().getX(DistanceUnit.INCH)),
                ( audienceHive.getY(DistanceUnit.INCH) - PoseEstimator.getPose().getY(DistanceUnit.INCH)));

        drivePIDPower = (Math.abs(PoseEstimator.getPose().getHeading(AngleUnit.RADIANS) - (headingSetpoint)) < AngleUnit.RADIANS.fromDegrees(2)) ? 0 :
                -drivePIDheading.calculate(PoseEstimator.getPose().getHeading(AngleUnit.RADIANS), headingSetpoint);

        io.updateInputs(inputs);
    }

    public double getDrivePIDPower(){
        return drivePIDPower;
    }


    public void setDriveSetPoint(){
        drivePIDheading.setSetpoint(headingSetpoint);
    }

}
