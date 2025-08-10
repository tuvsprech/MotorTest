public class MotorTest {
        public static void main(String[] args) {
            // יצירת מנועים מסוגים שונים
            // new keyword creates new instance/object of DriveMotor class
            // declares variable leftDrive, doesnt yet point to object
            // allocates memory for the object and initializes it by making a
            // call to constructor of DriveMotor, passes string as argument
            // = creates new object assigned to leftDrive variable
            DriveMotor leftDrive = new DriveMotor("Left Drive");
            DriveMotor rightDrive = new DriveMotor("Right Drive");
            ShooterMotor shooter = new ShooterMotor("Launch");
            //leftDrive is instance of DriveMotor class, 
            // belongs to specific object 
            // not a static member of the class
            
            System.out.println("=== Set Speed ===");
            leftDrive.setSpeed(0.7); // method from BaseMotor class
            rightDrive.setSpeed(0.7);
            
            // סימולציה של נסיעה
            leftDrive.updateEncoder(1500);// method from DriveMotor class
            rightDrive.updateEncoder(1450);
            
            System.out.println("Left: " + leftDrive.getDistanceTraveled() 
            + " meters");
            System.out.println("Right: " + rightDrive.getDistanceTraveled() 
            + " meters");
            // getDistanceTraveled() method from DriveMotor class,
            
            System.out.println("\n=== Test Shooter ===");
            shooter.setTargetRPM(4500); //method from ShooterMotor class
            
            // סימולציה של הגעה למהירות
            shooter.updateCurrentRPM(4000);//method from ShooterMotor class
            System.out.println("Ready to Shoot: " + shooter.isReadyToShoot());
            
            shooter.updateCurrentRPM(4480);
            System.out.println("Ready to Shoot: " + shooter.isReadyToShoot());
            
            // עצירה של כל המנועים
            System.out.println("\n   === Stop ===");
            leftDrive.stop(); // stop is method from BaseMotor class
            rightDrive.stop();
            shooter.stop();
        }
    }
    
    
