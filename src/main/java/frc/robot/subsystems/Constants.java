/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static int kPoweredV1 = 11;
    public static int kPoweredv2 = 12;
    public static int kFrontClaw = 4;
    public static int kElevator1 = 14;
    public static int kElevator2 = 15;
    public static int klDT1 = 0;
    public static int klDT2 = 1;
    public static int krDT3 = 2;
    public static int krDT4 = 3;
    public static int kShooter = 25;

    public static boolean isCurvatureDrive = true;
}
