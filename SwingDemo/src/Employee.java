
public class Employee {
   public String name;
   public String address;
   public String dob;
   
   public Employee(String name,String address, String dob) {
	   this.name = name;
	   this.address =address;
	   this.dob = dob;
   }

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getDob() {
	return dob;
}

public void setDob(String dob) {
	this.dob = dob;
}
   
}
