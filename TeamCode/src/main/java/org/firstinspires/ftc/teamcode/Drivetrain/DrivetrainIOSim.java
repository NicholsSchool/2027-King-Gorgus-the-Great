package org.firstinspires.ftc.teamcode.Drivetrain;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.SimStuff.SimMotor;
import org.firstinspires.ftc.teamcode.math_utils.PoseEstimator;

public class DrivetrainIOSim {

    //GoBilda 500 rpm motors
    public SimMotor bR,bL,fL,fR;
    //Kickstands on the bottom of the robot
    public Servo leftFoot, rightFoot;

    public DrivetrainIOSim(HardwareMap hwMap) {


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
