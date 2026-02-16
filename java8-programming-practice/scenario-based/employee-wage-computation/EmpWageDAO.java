
import java.util.*;
public class EmpWageDAO{

    private List<CompanyEmpWage>companyList=new ArrayList<>();
    private Map<String,CompanyEmpWage>companyMap=new HashMap<>();

    public void addCompany(CompanyEmpWage company){
        companyList.add(company);
        companyMap.put(company.company,company);
    }

    public List<CompanyEmpWage>getCompanies(){
        return companyList;
    }

    public CompanyEmpWage getCompany(String name){
        return companyMap.get(name);
    }
}