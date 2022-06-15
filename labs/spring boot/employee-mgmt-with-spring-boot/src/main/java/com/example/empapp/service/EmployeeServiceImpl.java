package com.example.empapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empapp.exception.EmployeeException;
import com.example.empapp.model.Employee;
import com.example.empapp.repository.EmployeeRepository;



@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository repo;

//	Map<Integer, Account> accounts = new HashMap<>();

	@Override
	public Employee create(Employee account) throws EmployeeException {
//		account.setId(accounts.size() + 1);
//		if (accounts.size() > 2) {
//			throw new AccountException("Account creation failed.");
//		}
//		accounts.put(account.getId(), account);
//		return account;
		return repo.save(account);
	}

	@Override
	public List<Employee> list() throws EmployeeException {
//		if (accounts.size() > 1) {
//			throw new AccountException("Account Listing failed.");
//		}
//		return new ArrayList<Account>(accounts.values());
		return repo.findAll();
	}

	@Override
	public Employee get(int id) {
//		return accounts.get(id);
		return repo.findById(id).get();
	}

	@Override
	public Employee update(int id, Employee account) {
//		accounts.put(id, account);
//		return account;
		return repo.save(account);
	}

	@Override
	public void delete(int id) {
//		accounts.remove(id);
		repo.deleteById(id);
	}

	@Override
	public List<Employee> search(String type) {
//		return repo.findByType(type);
		return repo.findByAccountType(type);
	}

}
