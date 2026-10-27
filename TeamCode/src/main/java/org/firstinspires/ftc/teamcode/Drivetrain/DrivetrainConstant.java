package org.firstinspires.ftc.teamcode.Drivetrain;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

public interface DrivetrainConstant {

    public Pose2D audienceHive = new Pose2D(DistanceUnit.CM, 35, -30, AngleUnit.DEGREES, 0);
    public Pose2D ScoringHive = new Pose2D(DistanceUnit.CM, 35, -30, AngleUnit.DEGREES, 0);

    public static double kDP = 8, kDI = 1.8, kDD = 1.7;


}
