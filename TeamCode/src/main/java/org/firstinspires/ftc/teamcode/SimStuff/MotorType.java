package org.firstinspires.ftc.teamcode.SimStuff;

public enum MotorType {
    // goBILDA Yellow Jackets (5203 / 5204 Series)
    GOBILDA_6000  (28.0,   6000.0,  9.2), // Bare motor
    GOBILDA_1620  (103.8,  1620.0,  9.2),
    GOBILDA_1150  (145.6,  1150.0,  9.2),
    GOBILDA_435  (383.6,  435.0,   9.2),
    GOBILDA_312  (537.7,  312.0,   9.2),
    GOBILDA_223  (753.2,  223.0,   9.2),
    GOBILDA_117 (1425.1,117.0,9.2),

    // REV Robotics HD Hex Series
    REV_HD_BARE   (28.0,   6000.0,  8.5), // No gearbox
    REV_HD_20_1   (560.0,  300.0,   8.5), // Planetary / Spur
    REV_HD_40_1   (1120.0, 150.0,    8.5),

    // TETRIX Max DC Motor
    TETRIX_40_1   (1440.0, 152.0,  11.0);

    public final double ticksPerRev;
    public final double maxRpm;
    public final double stallCurrentAmps;

    MotorType(double ticksPerRev, double maxRpm, double stallCurrentAmps) {
        this.ticksPerRev = ticksPerRev;
        this.maxRpm = maxRpm;
        this.stallCurrentAmps = stallCurrentAmps;
    }
}
