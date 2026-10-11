package org.firstinspires.ftc.teamcode.Drivetrain;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.math_utils.PoseEstimator;

public class DrivetrainIOReal implements DrivetrainIO{

    //GoBilda 500 rpm motors
    public DcMotorEx frontRight, frontLeft, backRight, backLeft;
    //Kickstands on the bottom of the robot
    public Servo leftFoot, rightFoot;

    public DrivetrainIOReal(HardwareMap hwMap) {

        frontLeft = hwMap.get(DcMotorEx.class, "fL");
        frontRight = hwMap.get(DcMotorEx.class, "fR");
        backLeft = hwMap.get(DcMotorEx.class, "bL");
        backRight = hwMap.get(DcMotorEx.class, "bR");

        frontLeft.setDirection(DcMotorEx.Direction.FORWARD);
        backLeft.setDirection(DcMotorEx.Direction.FORWARD);

        frontRight.setDirection(DcMotorEx.Direction.REVERSE);
        backRight.setDirection(DcMotorEx.Direction.REVERSE);

        frontRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

    }

    @Override
    public void setDriveMotorPower(double y, double x, double turn) {

        backRight.setPower(y - x + turn);
        backLeft.setPower(y + x - turn);
        frontRight.setPower(y + x + turn);
        frontLeft.setPower(y - x - turn);

    }

    @Override
    public void setFieldDriveMotorPower(double y, double x, double turn, double headingOffset) {
        double offset = PoseEstimator.getPose().getHeading(AngleUnit.RADIANS) + headingOffset;
        double fieldX = x * Math.cos(offset) - y * Math.sin(offset);
        double fieldY = x * Math.sin(offset) + y * Math.cos(offset);

        setDriveMotorPower(fieldY, fieldX, turn);
    }
}
