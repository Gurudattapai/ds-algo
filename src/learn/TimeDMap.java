package learn;
//package learn;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.TreeSet;
//
//public class TimeDMap {
//	
//	private Map<String, List<Employee>> idVsEmpMap = new HashMap<>();
//	
//	TreeSet<Employee> employeeSet = idVsEmpMap.get("");
//	employeeSet.
//
//}
//
//class Employee implements Comparable<Employee> {
//	public String empId;
//	public Date date;
//	public String floor;
//	
//	@Override
//	public int compareTo(Employee o) {
//		if(this.date < o.date) {
//			return -1;
//		} else if(this.date > o.date) {
//			return 1;
//		}
//		return 0;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((date == null) ? 0 : date.hashCode());
//		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
//		result = prime * result + ((floor == null) ? 0 : floor.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Employee other = (Employee) obj;
//		if (date == null) {
//			if (other.date != null)
//				return false;
//		} else if (!date.equals(other.date))
//			return false;
//		if (empId == null) {
//			if (other.empId != null)
//				return false;
//		} else if (!empId.equals(other.empId))
//			return false;
//		if (floor == null) {
//			if (other.floor != null)
//				return false;
//		} else if (!floor.equals(other.floor))
//			return false;
//		return true;
//	}	
//
//}
