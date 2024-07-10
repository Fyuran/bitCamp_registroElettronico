package team1.elettronico.registro;
import java.util.Arrays;
import java.util.Scanner;

public class RegistroElettronico {
	//Console text colors
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String ANSI_CYAN = "\u001B[36m";
	
	private static Scanner scanner = new Scanner(System.in);
	
	//anti-magic variable settings
	private static final int NULL_VALUE = -1;
	
	//Data tracking for teachers
	private static final int MAX_PROFILES = 10;
	private static String[] profiles = new String[MAX_PROFILES];
	private static String[] profilesPasswords = new String[MAX_PROFILES];
	private static String[] educations = new String[MAX_PROFILES];
	
	//Data tracking for students
	private static final int MAX_STUDENTS = 20;
	private static final int MAX_ABSENCES = 20;
	private static final int MAX_GRADES = 10;
	
	private static String[] students = new String[MAX_STUDENTS];
	private static double[][] grades = new double[MAX_STUDENTS][MAX_GRADES];
	private static int[] absences = new int[MAX_STUDENTS];
	
	
	public static int findIndex(String s, String[] array) { //find index of string s in array
		for(int i = 0; i < array.length; i++)
			if(array[i] != null && array[i].equalsIgnoreCase(s)) 
				return i;
		
		return -1;
	}
	
	public static boolean doesExist(String s, String[] array) { //find first entry of string s in array
		for(String val : array) {
			if(val != null && val.equalsIgnoreCase(s))
				return true;
		}
		
		return false;
	}
	

	public static boolean addEntry(double d, double[] array) { //replace 0 value within array with double d
		for(int i = 0; i < array.length; i++) {
			if(array[i] == NULL_VALUE) {
				array[i] = d;
				return true;
			}
		}
		return false;
	}
	public static boolean addEntry(int d, int[] array) { //replace 0 value within array with int d
		for(int i = 0; i < array.length; i++) {
			if(array[i] == NULL_VALUE) {
				array[i] = d;
				return true;
			}
		}
		return false;
	}
	public static boolean addEntry(double d[], double[][] array) { //replace 0 value within array with double d
		for(int i = 0; i < array.length; i++) {
			double[] empty = new double[d.length];
			Arrays.fill(empty, NULL_VALUE);
			if(Arrays.equals(array[i], empty)) {
				array[i] = d;
				return true;
			}
		}
		return false;
	}
	
	public static boolean addEntry(String s, String[] array) { //replace first null value within array with string s
		for(int i = 0; i < array.length; i++) {
			if(array[i] == null) {
				array[i] = s;
				return true;
			}
		}
		return false;
	}
	
	public static boolean removeEntry(String s, String[] array) { //replace string s value with null
		for(int i = 0; i < array.length; i++) {
			if(array[i] != null && array[i].equalsIgnoreCase(s)) {
				array[i] = null;
				rearrangeArray(array);
				return true;
			}
		}
		return false;
	}
	public static boolean removeEntry(double d, double[] array) { //replace double d value with 0
		for(int i = 0; i < array.length; i++) {
			if(array[i] == d) {
				array[i] = NULL_VALUE;
				rearrangeArray(array);
				return true;
			}
		}
		return false;
	}
	public static boolean removeEntry(int d, int[] array) { //replace int d value with 0
		for(int i = 0; i < array.length; i++) {
			if(array[i] == d) {
				array[i] = NULL_VALUE;
				rearrangeArray(array);
				return true;
			}
		}
		return false;
	}
	public static boolean removeEntry(double d[], double[][] array) { //replace double[] array with array of same size but with default values
		
		for(int i = 0; i < array.length; i++) {
			double[] emptyTemp = new double[array[i].length];
			Arrays.fill(emptyTemp, NULL_VALUE);
			if(array[i] == d) { //if it's not an array of default values
				array[i] = emptyTemp;
				rearrangeArray(array);
				return true;
			}
		}
		return false;
	}
	
	
	public static void rearrangeArray(String[] array) { //fixes array to always have continued valid values, shifting null values to the right
		String[] temp = new String[array.length];
		for(String s : array)
			addEntry(s, temp);
		
		for(int i = 0; i < array.length; i++)
			array[i] = temp[i];
	}
	
	public static void rearrangeArray(double[] array) { //fixes array to always have continued valid values, shifting 0 values to the right
		double[] temp = new double[array.length];
		Arrays.fill(temp, NULL_VALUE);
		for(double d : array)
			addEntry(d, temp);
		
		for(int i = 0; i < array.length; i++)
			array[i] = temp[i];
	}
	public static void rearrangeArray(int[] array) { //fixes array to always have continued valid values, shifting 0 values to the right
		int[] temp = new int[array.length];
		Arrays.fill(temp, NULL_VALUE);
		for(int d : array)
			addEntry(d, temp);
		
		for(int i = 0; i < array.length; i++)
			array[i] = temp[i];
	}
	public static void rearrangeArray(double[][] array) { //fixes array to always have continued valid values, shifting empty arrays to the right
		double[][] temp = new double[array.length][array[0].length];
		double[] empty = new double[MAX_GRADES];
		Arrays.fill(empty, NULL_VALUE);
		Arrays.fill(temp, empty);
		for(double d[] : array)
			addEntry(d, temp);
		
		for(int i = 0; i < array.length; i++)
			array[i] = temp[i];
	}
	
	private static void debugVars() {

		students[0] = "Paolo Pellicanò";
		grades[0] = new double[]{10,10,10,NULL_VALUE,NULL_VALUE,NULL_VALUE,NULL_VALUE,NULL_VALUE,NULL_VALUE,NULL_VALUE};
		absences[0] = 2;
		
		students[1] = "Alessio Cappai";
		grades[1] = new double[]{8,8,9,NULL_VALUE,NULL_VALUE,NULL_VALUE,NULL_VALUE,NULL_VALUE,NULL_VALUE,NULL_VALUE};
		absences[1] = 0;
		
		students[2] = "Vincenzo Tito";
		grades[2] = new double[]{9,9,9,NULL_VALUE,NULL_VALUE,NULL_VALUE,NULL_VALUE,NULL_VALUE,NULL_VALUE,NULL_VALUE};
		absences[2] = 1;
		
		students[3] = "Daniel Camuffo";
		grades[3] = new double[]{3,2,4,NULL_VALUE,NULL_VALUE,NULL_VALUE,NULL_VALUE,NULL_VALUE,NULL_VALUE,NULL_VALUE};
		absences[3] = MAX_ABSENCES;
	}
	
	public static void main(String[] args) {

		Arrays.fill(absences, NULL_VALUE);
		double[] emptyGradesList = new double[MAX_GRADES];
		Arrays.fill(emptyGradesList, NULL_VALUE);
		Arrays.fill(grades, emptyGradesList);
		debugVars();
		
		boolean isLoggedIn = true;
		profiles[0] = "admin";
		profilesPasswords[0] = "password";
		educations[0] = "Amministratore";
		
		while(isLoggedIn) {
			System.out.println(ANSI_CYAN + "\n-=-=-=-=REGISTRO SCOLASTICO ELETTRONICO 2024/2025-=-=-=-=-" + ANSI_RESET
					+ "\nInserisci il tuo nome e cognome"
					+ "\nScrivi 'esci' per uscire dal programma");
			
			String login = scanner.nextLine();
			if(login.equalsIgnoreCase("esci")) {
				isLoggedIn = false;
				System.out.println(ANSI_GREEN + "Uscita dal programma effettuata" + ANSI_RESET);
			} else {
				System.out.print("Inserisci la password: ");
				String password = scanner.nextLine();
				
				if(doesExist(login, profiles)) { //lookup password with same index as login entry
					int loginIndex = findIndex(login, profiles);
					if(loginIndex >= 0) {
						String dbPwd = profilesPasswords[loginIndex];
						if(password.equals(dbPwd)) {
							System.out.println(ANSI_GREEN + "Benvenuto/a " + login + ANSI_RESET);
							studentsMenu();							
						}
						else
							System.out.println(ANSI_RED + "Password errata" + ANSI_RESET);
					}	
				} else {
					System.out.print(ANSI_YELLOW + "\n" + login + " non trovato, è un nuovo profilo? rispondi con Y o N: " + ANSI_RESET);
					char cmd = scanner.nextLine().charAt(0);
					if(Character.toLowerCase(cmd) == 'y') {
						System.out.print("\nInserisci la materia scolastica: ");
						String education = scanner.nextLine();
						if(addEntry(login, profiles)) {
							addEntry(password, profilesPasswords);
							addEntry(education, educations);
							System.out.println(ANSI_GREEN + "Nuovo utente aggiunto" + ANSI_RESET);
							System.out.println(ANSI_GREEN + "Benvenuto/a " + login + ANSI_RESET);
							studentsMenu();
						} else {
							System.out.println(ANSI_RED + "Ci spiace " + login + " non c'è più spazio per nuovi docenti, contatta un amministratore" + ANSI_RESET);
						}
						
					}
				}

			}
			
		}
		
		scanner.close();

	}

	

	
	private static void studentsMenu() {
		boolean exitMenu = false;
		while(!exitMenu) {
	        System.out.println(ANSI_CYAN + "\n-=-=-=-=MENU STUDENTI-=-=-=-=-" + ANSI_RESET
		        	+ "\nIndica la tua scelta"
					+ "\n1. Aggiungi Studente"
		        	+ "\n2. Rimuovi Studente"
					+ "\n3. Seleziona Studente"
		        	+ "\n4. Mostra lista Studenti"
					+ "\n5. Esci");
	        
	        if(scanner.hasNextInt()) {
	        	int choice = scanner.nextInt();
	        	
	        	//parse list of non-null students refreshed on each while loop iteration
	            int validStudents = 0;
	            String output = ANSI_GREEN + "\nLista Studenti:\n" + ANSI_RESET;
	        	for(int i = 0; i < students.length; i++) {
	        		if(students[i] != null) {
	        			validStudents++;  
	        			output += (i+1 + ". " + students[i] + "\n");
	        		}
	        	}
	            
	        	switch(choice) {
		        case 1: //Aggiungi studente
		        	System.out.print("\nInserire nome e cognome dello studente: ");
		        	scanner.nextLine();
		        	String name = scanner.nextLine();
		        	
					if(addEntry(name, students))
						System.out.println(ANSI_GREEN + "Nuovo studente " + name + " aggiunto" + ANSI_RESET);	
					else
						System.out.println(ANSI_RED + "Massimo numero(" + MAX_STUDENTS +") studenti raggiunto" + ANSI_RESET);			
					
		        	break;
		        	
		        case 2: //Rimuovi studente
                	if(validStudents <= 0) {
                		System.out.println(ANSI_RED + "Nessun studente presente" + ANSI_RESET);
                		break;
                	}
                	 
                    System.out.println(output);
                    System.out.println("\nScrivi la posizione dello studente da rimuovere da 1 a " + validStudents);
                    int studentIndex = scanner.nextInt() - 1; //remove 1 from index for a n-based position from 0
                    
                    if(studentIndex >= 0 && studentIndex < students.length) {
                    	removeEntry(absences[studentIndex], absences);
                    	removeEntry(grades[studentIndex], grades);
                		removeEntry(students[studentIndex], students);
                		System.out.println(ANSI_GREEN + "Studente rimosso" + ANSI_RESET);
                	} else {
                		System.out.println(ANSI_RED + "Posizione studente errata o studente inesistente" + ANSI_RESET);
                	}

		        	break;
		        	
		        case 3: //Seleziona studente
                	if(validStudents <= 0) {
                		System.out.println(ANSI_RED + "Nessun studente presente" + ANSI_RESET);
                		break;
                	}
                	

                    System.out.println(output);
                    System.out.println("\nScrivi la posizione dello studente da selezionare da 1 a " + validStudents);
                    studentIndex = scanner.nextInt() - 1; //remove 1 from index for a n-based position from 0
                    
                    if(studentIndex >= 0 && studentIndex < students.length && students[studentIndex] != null) {
                		studentMenu(studentIndex);
                	} else {
                		System.out.println(ANSI_RED + "Posizione studente errata o studente inesistente" + ANSI_RESET);
                	}
		        	break;
		        	
		        case 4: //Lista Studenti
                	if(validStudents <= 0) {
                		System.out.println(ANSI_RED + "Nessun studente presente" + ANSI_RESET);
                		break;
                	}
                	
                	System.out.println(output);
		        	break;
		        	
		        case 5: //Esci
		        	exitMenu = true;
		        	System.out.println(ANSI_GREEN + "Uscito dal menù Studenti" + ANSI_RESET);
		        	scanner.nextLine();
		        	break;
		        	
	        	default:
	        		System.out.println(ANSI_RED + "Opzione non valida." + ANSI_RESET);
	        	}
	        	
	        } else {
				scanner.nextLine();
				System.out.println(ANSI_RED + "Inserisci un numero." + ANSI_RESET);					
	        }
	        
		}
	}
	
	
	private static void studentMenu(int studentIndex) {
		boolean exitMenu = false;
		while(!exitMenu) {
	        System.out.println(ANSI_CYAN + "\n-=-=-=-=MENU DI " + students[studentIndex] + ")-=-=-=-=-" + ANSI_RESET
		        	+ "\nIndica la tua scelta"
					+ "\n1. Gestisci voti studente"
		        	+ "\n2. Gestisci assenze studente"
					+ "\n3. Esci");
	        
	        if(scanner.hasNextInt()) {
	        	int choice = scanner.nextInt();
	        	switch(choice) {
			        case 1: //Menu voti
			        	votesMenu(studentIndex);
			        	break;
			        	
			        case 2: //Menu Assenze
			        	absencesMenu(studentIndex);
			        	break;
			        	
			        case 3: //Esci
			        	exitMenu = true;
			        	System.out.println(ANSI_GREEN + "Uscito dal menù dello studente " + students[studentIndex] + ANSI_RESET);
			        	scanner.nextLine();
			        	break;
			        	
		        	default:
		        		System.out.println(ANSI_RED + "Opzione non valida." + ANSI_RESET);
	        	}
	        } else {
				scanner.nextLine();
				System.out.println(ANSI_RED + "Inserisci un numero." + ANSI_RESET);					
	        }
		}
	}
	
    private static void votesMenu(int studentIndex) {

		boolean exitMenu = false;
	    while(!exitMenu) {
	        System.out.println(ANSI_CYAN + "\n-=-=-=-=MENU VOTI-=-=-=-=-" + ANSI_RESET
		        	+ "\nIndica la tua scelta"
					+ "\n1. Aggiungi voto"
		        	+ "\n2. Rimuovi voto"
					+ "\n3. Visualizza voti"
		        	+ "\n4. Calcola media voti"
					+ "\n5. Esci");

	        if(scanner.hasNextInt()) {
		        int choice = scanner.nextInt();
		        
		        //parse list of non-zero votes refreshed on each while loop iteration
	        	String output = ANSI_GREEN + "\nVoti Studente: " + students[studentIndex] + ": " + ANSI_RESET;
	        	int validVotes = 0;
	            for (int i = 0; i < grades[studentIndex].length; i++) {
	            	if(grades[studentIndex][i] > 0) {
	            		output += (grades[studentIndex][i] + " ");
	            		validVotes++;
	            	}
	            }
	        	
	            switch (choice) {
	                case 1: // Aggiungi voto
	                	System.out.println("Aggiungi il voto che vuoi assegnare allo studente");
	                	double grade = scanner.nextDouble();
	                	if(addEntry(grade, grades[studentIndex]))
	                		System.out.println(ANSI_GREEN + "Voto aggiunto" + ANSI_RESET);
	                	else
	                		System.out.println(ANSI_RED + "Raggiunto massimo(" + MAX_GRADES +  ") quantità voti" + ANSI_RESET);
	                	
	                    break;
	                case 2: // Rimuovi voto
	                	
	                	if(validVotes <= 0) {
	                		System.out.println(ANSI_RED + students[studentIndex] + " non ha nessun voto" + ANSI_RESET);
	                		break;
	                	}
	                	
	                    System.out.println(output);     
	                    System.out.println("\nScrivi la posizione del voto da rimuovere da 1 a " + validVotes);
	                    
	                    int gradeIndex = scanner.nextInt() - 1; //remove 1 from index for a n-based position from 0
	                	if(gradeIndex >= 0 && gradeIndex < grades.length && grades[studentIndex][gradeIndex] > 0) {
	                		removeEntry(grades[studentIndex][gradeIndex], grades[studentIndex]);
	                		System.out.println(ANSI_GREEN + "Voto rimosso" + ANSI_RESET);
	                	} else {
	                		System.out.println(ANSI_RED + "Posizione voto errata o voto inesistente" + ANSI_RESET);
	                	}

	                    break;
	                    
	                case 3: // Visualizza voti
	                	
	                	if(validVotes <= 0) {
	                		System.out.println(ANSI_RED + students[studentIndex] + " non ha nessun voto" + ANSI_RESET);
	                		break;
	                	}
	                	
	                    System.out.println(output);
	                    break;  
	                    
	                case 4: // Calcola media voti
	                	
	                	if(validVotes <= 0) {
	                		System.out.println(ANSI_RED + students[studentIndex] + " non ha nessun voto" + ANSI_RESET);
	                		break;
	                	}
	                	
	                	double sum = 0;
	                	double average = 0;
	                	
	                	for(int i = 0; i < grades[studentIndex].length; i++) {
	                		if(grades[studentIndex][i] > 0) {
	                			sum += grades[studentIndex][i];                			
	                		}
	                	}
	                	
	                	if(validVotes > 0)
	                		average = sum / validVotes;
	                	
	                	System.out.println(ANSI_GREEN + "La media dei voti di " + students[studentIndex] + " è: " + average + ANSI_RESET);
	                	break;
	                	
	                case 5: //Esci
			        	exitMenu = true;
			        	System.out.println(ANSI_GREEN + "Uscito dal menù voti di " + students[studentIndex] + ANSI_RESET);
			        	scanner.nextLine();
			        	break;
			        	
	                default:
	                    System.out.println(ANSI_RED + "Opzione non valida." + ANSI_RESET);
	            }
	        } else {
				scanner.nextLine();
				System.out.println(ANSI_RED + "Inserisci un numero." + ANSI_RESET);					
	        }
	    }
        
    }
    
	private static void absencesMenu(int studentIndex) { //remove or increases absences for determined student index
		boolean exitMenu = false;
	    while(!exitMenu) {
	        System.out.println(ANSI_CYAN + "\n-=-=-=-=MENU ASSENZE-=-=-=-=-" + ANSI_RESET
	        	+ "\nIndica la tua scelta"
				+ "\n1. Visualizza le assenze"
				+ "\n2. Inserisci assenza"
				+ "\n3. Rimuovi assenza"
				+ "\n4. Esci");
       
	        
	        System.out.println();   
	        
	        if(scanner.hasNextInt()) {
	        	int choice = scanner.nextInt();
		        switch(choice) {
		        case 1: //Visualizza giorni di assenza
		        	if(absences[studentIndex] > 0) {
			        	System.out.println(ANSI_GREEN + "Totale Giorni d'assenza per " +  
			        			students[studentIndex] + " sono " + absences[studentIndex] + ANSI_RESET);
		        	} else {
		        		System.out.println(ANSI_RED + students[studentIndex] + " non ha assenze" + ANSI_RESET);
		        	}

		        	break;
		        	
		        case 2: //Inserisci giorno assenza
		        	if(absences[studentIndex] < MAX_ABSENCES) {
		        		if(absences[studentIndex] <= 0)
		        			absences[studentIndex] = 1;
		        		else
		        			absences[studentIndex]++;
		        		
		        		System.out.println(ANSI_GREEN + "Giorno d'assenza aggiunto per " + 
		        				students[studentIndex] + " totale: " + absences[studentIndex] + ANSI_RESET);
		        	} else {
		        		System.out.println(ANSI_RED + "Massimo giorni(" + MAX_ABSENCES + ") d'assenza raggiunto per " +  students[studentIndex] + ANSI_RESET);
		        	}
		        		
		        	break;
		        	
		        case 3: //Rimuovi giorno assenza
		        	if(absences[studentIndex] > 0) {
		        		absences[studentIndex]--;
		        		
		        		System.out.println(ANSI_GREEN + "Giorno d'assenza rimosso per " 
		        				+  students[studentIndex] + " totale: " + absences[studentIndex] + ANSI_RESET);
		        	} else {
		        		System.out.println(ANSI_RED + students[studentIndex] + " non ha assenze" + ANSI_RESET);
		        	}
		        	
		      	    break;
		        	
		        case 4: //Esci
		        	exitMenu = true;
		        	System.out.println(ANSI_GREEN + "Uscito dal menù assenze di " + students[studentIndex] + ANSI_RESET);
		        	scanner.nextLine();
		        	break;
		        	
		        default:		   
		        	System.out.println(ANSI_RED + "Opzione non valida." + ANSI_RESET);
		        	
		        }
	        } else {
				scanner.nextLine();
				System.out.println(ANSI_RED + "Inserisci un numero." + ANSI_RESET);					
	        }
  
	    }
	}
}


