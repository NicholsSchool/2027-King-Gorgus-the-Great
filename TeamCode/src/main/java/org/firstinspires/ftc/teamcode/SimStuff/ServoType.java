package org.firstinspires.ftc.teamcode.SimStuff;

public enum ServoType {

    //Axon Servos
    AXON_MINI_4_8V (90, 3.2),
    AXON_MINI_6V (111, 3.8),

    AXON_MAX_4_8V (71,3.6),
    AXON_MAX_6V (83,4.0);

    public final double rotationsPerMinute;
    public final double stallCurrentAmps;

    ServoType(double rotationsPerMinute, double stallCurrentAmps) {
        this.rotationsPerMinute = rotationsPerMinute;
        this.stallCurrentAmps = stallCurrentAmps;
    }
}
