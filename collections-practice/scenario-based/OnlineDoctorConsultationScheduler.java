import java.util.*;

class SlotUnavailableException extends Exception {
    public SlotUnavailableException(String message) {
        super(message);
    }
}

class Doctor {
    private String name;
    private String specialization;
    private Set<String> availableSlots = new HashSet<>();
    private Set<String> bookedSlots = new HashSet<>();

    public Doctor(String name, String specialization, List<String> slots) {
        this.name = name;
        this.specialization = specialization;
        this.availableSlots.addAll(slots);
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getName() {
        return name;
    }

    public void bookSlot(String slot) throws SlotUnavailableException {
        if (!availableSlots.contains(slot) || bookedSlots.contains(slot)) {
            throw new SlotUnavailableException("Slot unavailable");
        }
        bookedSlots.add(slot);
    }
}

class Appointment {
    private String patientName;
    private Doctor doctor;
    private String slot;

    public Appointment(String patientName, Doctor doctor, String slot) {
        this.patientName = patientName;
        this.doctor = doctor;
        this.slot = slot;
    }

    public String toString() {
        return patientName + " booked with Dr." + doctor.getName() + " at " + slot;
    }
}

public class OnlineDoctorConsultationScheduler {
    public static void main(String[] args) {
        Map<String, List<Doctor>> doctors = new HashMap<>();
        List<Appointment> history = new ArrayList<>();

        Doctor d1 = new Doctor("Sharma", "Cardiology", Arrays.asList("10AM", "11AM"));
        Doctor d2 = new Doctor("Mehta", "Dermatology", Arrays.asList("12PM", "1PM"));

        doctors.computeIfAbsent(d1.getSpecialization(), k -> new ArrayList<>()).add(d1);
        doctors.computeIfAbsent(d2.getSpecialization(), k -> new ArrayList<>()).add(d2);

        try {
            Doctor doctor = doctors.get("Cardiology").get(0);
            doctor.bookSlot("10AM");
            Appointment a1 = new Appointment("Amit", doctor, "10AM");
            history.add(a1);
            System.out.println(a1);
        } catch (SlotUnavailableException e) {
            System.out.println(e.getMessage());
        }

        for (Appointment a : history) {
            System.out.println(a);
        }
    }
}
