class Patient {
  private String patientName;
  private int patientID;

  public Patient(String name, int ID){
    this.patientName = name;
    this.patientID = ID;
  }

  public void displayPatientInfo() {
    System.out.println("Patient ID: " + patientID);
    System.out.println("Patient Name: " + patientName);
  }
}

class covidParameter extends Patient {
  int ctScore;
  double dDimer;
  int plateletCount;

  public covidParameter(String name, int id, int ctScore, double dDimer, int plateletCount) {
    super(name, id);
    this.ctScore = ctScore;
    this.dDimer = dDimer;
    this.plateletCount = plateletCount;
  }

  public void displayCovidReport() {
    super.displayPatientInfo();
    System.out.println("CT Score: " + ctScore + " / 25");
    System.out.println("D-Dimer level: " + dDimer + " mg/L");
    System.out.println("Platelet Count: " + plateletCount + " mcL");
  }
}

class practical17 {
  public static void main(String[] args) {
    covidParameter patientRecord = new covidParameter("Rahul Sharma", 101, 14, 0.85, 180000);

    System.out.println("--- Patient Medical Report ---");
    patientRecord.displayCovidReport();
  }
}
