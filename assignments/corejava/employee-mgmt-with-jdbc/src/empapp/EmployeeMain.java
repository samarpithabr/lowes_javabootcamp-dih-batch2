package empapp;

import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import dao.EmployeeDaoJdbcImpl;
import exception.EmployeeException;
import model.Employee;
import service.EmployeeServiceArrImpl;



public class EmployeeMain  {
	public static void main(String[] args){
		Boolean entered=true;
		Employee emp = new Employee();
		Random random = new Random();
		int empIdInteger = random.nextInt(20);
		Boolean status;
		EmployeeServiceArrImpl empser = new EmployeeServiceArrImpl();
		Scanner scanner = new Scanner(System.in);
		ExecutorService exeSrvice= Executors.newFixedThreadPool(3);

		do {
			System.out.println("1.  Add Employee");
			System.out.println("2.  update Employee");
			System.out.println("3.  Delete Employee");
			System.out.println("4.  view Employee");
             System.out.println("5. viewall");
             System.out.println("6. Import");
             System.out.println("7. export");
             System.out.println("8.  statistics");
			System.out.println("Enter the option: ");
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				status = empser.create(emp);
				if (status == true) {
					System.out.println("Employee has been create successfully !!!");
				} else
					System.out.println("Employee has not created");
				break;
			case 2:
				status = empser.update(emp);
				if (status == true) {
					System.out.println("Employee has been updated successfully !!!");
				} else
					System.out.println("Employee has not updated");
				break;
			case 3:
				status = empser.delete(emp.getEmpId());
				if (status == true) {
					System.out.println("Employee has been deleted successfully !!!");
				} else
					System.out.println("Employee has not deleted");
				break;
			case 4:
				try {
					empser.viewData(emp.getEmpId());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				empser.viewAll();
				break;
			case 6:
				Future<Boolean> future = exeSrvice.submit(new Callable<Boolean>() {
					@Override
					public Boolean call() throws Exception {
						Thread.sleep(3000);
						empser.bulkImport();
						//future.get();
						return true;
					}						
				});
				break;
			case 7:
				Future<Boolean> future1 = exeSrvice.submit(new Callable<Boolean>() {
					@Override
					public Boolean call() throws Exception {
						Thread.sleep(2000);
						empser.bulkExport();
						//future.get();
						return true;
					}						
				});						
				exeSrvice.shutdown();
				break;
				
			case 8:
				empser.printStatistics();
				break;
			case 9:
				exeSrvice.shutdown();
				break;
			default:
				System.out.println("Please Enter Valid Input");
				break;

			}
		} while (entered);

	}
}