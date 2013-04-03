public class Doctor extends User {
  private int[] patients = new int[20];
	

	public Doctor(){
		userType = "doctor";
	}
	public int addPatient(int userID){
		int i = 0;
		while(i<patients.length){
		if(i<patients.length && patients[i] == 0){
		patients[i] = userID;
		i = patients.length;
		}else{
			i++;
		}
		}
		return userID;
		
	}
	public boolean patientCheck(int userID){
		int i = 0;
		while(i<patients.length){
			if(patients[i] == userID){
				return true;
			}else i++;
			}
		return false;
	}
	
}
