class Vessel {
    private String vesselId;
    private String vesselName;
    private double averageSpeed;
    private String vesselType;

    Vessel() {
    }

    Vessel(String vesselId, String vesselName, double averageSpeed, String vesselType) {
        this.vesselId = vesselId;
        this.vesselName = vesselName;
        this.averageSpeed = averageSpeed;
        this.vesselType = vesselType;
    }

    String getVesselId() {
        return vesselId;
    }

    void setVesselId(String vesselId) {
        this.vesselId = vesselId;
    }

    String getVesselName() {
        return vesselName;
    }

    void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    double getAverageSpeed() {
        return averageSpeed;
    }

    void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    String getVesselType() {
        return vesselType;
    }

    void setVesselType(String vesselType) {
        this.vesselType = vesselType;
    }
}
