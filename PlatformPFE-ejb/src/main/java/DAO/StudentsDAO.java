package DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import au.com.bytecode.opencsv.CSVReader;
import tn.pfe.entity.Student;

public class StudentsDAO {
	 private final static String RESOURCES_PATH = "src/main/resources/";
	 private final static String ELEVES_FILE_NAME = "notes.csv";
	 private final static char SEPARATOR = ';';
	 
	 public StudentsDAO() {
		// TODO Auto-generated constructor stub
	}
	 
	 public List<Student> findEleves() throws IOException {
	        File file = new File(RESOURCES_PATH + ELEVES_FILE_NAME);
	        FileReader fReader = new FileReader(file);
	        CSVReader csvReader = new CSVReader(fReader,SEPARATOR);
	        
	        List<String[] > data = new ArrayList<String[] >();

	        String[] nextLine = null;
	        while ((nextLine = csvReader.readNext()) != null) {
	            int size = nextLine.length;

	            // ligne vide
	            if (size == 0) {
	                continue;
	            }
	            String debut = nextLine[0].trim();
	            if (debut.length() == 0 && size == 1) {
	                continue;
	            }

	            // ligne de commentaire
	            if (debut.startsWith("#")) {
	                continue;
	            }
	            data.add(nextLine);
	        }
	        
	        List<Student> eleves = new ArrayList<Student>();

	        for (String[] oneData : data) {
	            String nom = oneData[0];
	            String prenom = oneData[1];
	            String notest = oneData[2];
	            
	            Double note = Double.parseDouble(notest);
	            Student s = new Student();
	            s.setFirstName(prenom);
	            s.setLastName(nom);
	            s.setPhoneNumber(25896);
	            	eleves.add(s);
	        }
	 return eleves;
	 }
	 
	 
	 
}
