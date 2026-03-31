import java.util.*;

public class UserInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VesselUtil vesselUtil = new VesselUtil();

        System.out.println("Enter the number of vessels to be added");
        int n = Integer.parseInt(sc.nextLine());

        System.out.println("Enter vessel details");
        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split(":");

            Vessel vessel = new Vessel(
                    data[0],
                    data[1],
                    Double.parseDouble(data[2]),
                    data[3]
            );

            vesselUtil.addVesselPerformance(vessel);
        }

        System.out.println("Enter the Vessel Id to check speed");
        String searchId = sc.nextLine();

        Vessel vessel = vesselUtil.getVesselById(searchId);

        if (vessel != null) {
            System.out.println(
                    vessel.getVesselId() + " | " +
                    vessel.getVesselName() + " | " +
                    vessel.getVesselType() + " | " +
                    vessel.getAverageSpeed() + " knots"
            );
        } else {
            System.out.println("Vessel Id " + searchId + " not found");
        }

        System.out.println("High performance vessels are");
        List<Vessel> highList = vesselUtil.getHighPerformanceVessels();

        for (Vessel v : highList) {
            System.out.println(
                    v.getVesselId() + " | " +
                    v.getVesselName() + " | " +
                    v.getVesselType() + " | " +
                    v.getAverageSpeed() + " knots"
            );
        }
    }
}
