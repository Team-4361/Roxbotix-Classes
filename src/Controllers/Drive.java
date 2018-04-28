package Controllers;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Drive
{
	WPI_TalonSRX[] CAN;
	
	static WPI_TalonSRX[] FullCAN;
	
	public Drive(WPI_TalonSRX[] CAN)
	{
		this.CAN = CAN;
	}
	
	public Drive(int[] nums)
	{
		CAN = new WPI_TalonSRX[nums.length];
		for(int i = 0; i < nums.length; i++)
		{
			CAN[i] = FullCAN[nums[i]];
		}
	}
	
	public void drive(double val)
	{
		for (WPI_TalonSRX tal : CAN)
		{
			tal.set(val);
		}
	}
	
	public double GetSpeed()
	{
		if(CAN != null && CAN[0] != null)
			return CAN[0].get();
		return 0;
	}
	
	public static void SetFullCAN(WPI_TalonSRX[] CAN)
	{
		FullCAN = CAN;
	}
	
	public WPI_TalonSRX[] GetTalons()
	{
		return CAN;
	}
}