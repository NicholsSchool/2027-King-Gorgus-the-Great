package org.firstinspires.ftc.teamcode.Transfer;

public interface TransferIO {

    public static class TransferIOInputs{
        double transferCurrent = 0.0;
    }

    public default void updateInputs (TransferIO.TransferIOInputs inputs) {};
    public default void setTransferPower(double power){}

}
