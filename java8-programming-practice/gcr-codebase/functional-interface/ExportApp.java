interface Exporter{
    void exportToCSV();
    void exportToPDF();
    default void exportToJSON(){
        System.out.println("Exported to JSON");
    }
}

class ReportExporter implements Exporter{
    public void exportToCSV(){
        System.out.println("Exported to CSV");
    }
    public void exportToPDF(){
        System.out.println("Exported to PDF");
    }
}

public class ExportApp{
    public static void main(String[] args){
        Exporter e=new ReportExporter();
        e.exportToCSV();
        e.exportToPDF();
        e.exportToJSON();
    }
}
