class VolcanoRobot 
{
   String status;
   int speed;
   int power;

   VolcanoRobot()
	{
      status = "Attacking";
      speed = 5;
      power = 66;
		System.out.println("Hello World! I'm a newly created robot.");
	}

   VolcanoRobot(String in1, int in2, int in3)
	{
      status = in1;
      speed = in2;
      power = in3;
		System.out.println("Hello World! I'm a newly created robot.");
	}

   public int getSpeed(Integer x)
   {
      return speed+x;
   }

   public int getPower()
   {
      return power;
   }

   public String getStatus()
   {
      return status;
   }
}
