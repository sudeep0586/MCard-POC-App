/**
 * 
 */
package com.mc.demo.app.enrollement.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.demo.app.enrollement.CardEnrolled;
import com.mc.demo.app.enrollement.EnrollCard;
import com.mc.demo.app.enrollement.LoginResponse;
import com.mc.demo.app.enrollement.UserProfile;
import com.mc.demo.app.enrollement.model.Account;
import com.mc.demo.app.enrollement.model.AccountRepository;
import com.mc.demo.app.enrollement.model.CustAccRefRepository;
import com.mc.demo.app.enrollement.model.Customer;
import com.mc.demo.app.enrollement.model.CustomerRespository;
import com.mc.demo.app.enrollement.model.UserRespository;
import com.mc.demo.app.enrollement.model.Userprofile;
import com.mc.demo.app.enrollment.exception.ObjectNotFoundException;

/**
 * @author Wipro
 *
 */
@Service("enrollService")
public class EnrollServiceImpl implements EnrollService {

	@Autowired
	AccountRepository accountRepo;

	@Autowired
	CustomerRespository custRepo;

	@Autowired
	UserRespository userRepo;

	@Autowired
	CustAccRefRepository custAccRefRepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mc.demo.app.enrollement.service.EnrollService#validateCard(com.mc.demo.
	 * app.enrollement.EnrollCard)
	 */
	@Override
	public CardEnrolled validateCard(EnrollCard enrollCard) {

		System.out.println("***************************          " + enrollCard.getCardnumber());

		String cardNumber = enrollCard.getCardnumber();
		Account acc = accountRepo.findByAccountnumber(enrollCard.getCardnumber());
		if (acc == null) {
			throw new ObjectNotFoundException("No Cardfound");
		}

		Customer customer = custRepo.getCustBycustid(acc.getCustid());

		if (!enrollCard.getSsn().equalsIgnoreCase(customer.getSsn())) {
			throw new ObjectNotFoundException("failed Validation");
		}

		if (enrollCard.getZipcode() != null && !enrollCard.getZipcode().equalsIgnoreCase(customer.getZipcode())) {
			throw new ObjectNotFoundException("failed Validation");
		}

		CardEnrolled cardEnrolObj = new CardEnrolled();
		cardEnrolObj.setCardNumber(cardNumber);
		cardEnrolObj.setProgramID(acc.getProgramid());
		Userprofile usrProfile = userRepo.findUserByAccountnumber(cardNumber);
		if (null == usrProfile) {
			cardEnrolObj.setEnrolledAlready(false);
			cardEnrolObj.setMessage("card not enrolled yet ");
		} else {
			cardEnrolObj.setUserid(usrProfile.getUserid());
			cardEnrolObj.setEnrolledAlready(true);
			cardEnrolObj.setMessage("User already enrolled ");
		}

		return cardEnrolObj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mc.demo.app.enrollement.service.EnrollService#createUserProfile(com.mc.
	 * demo.app.enrollement.model.UserProfile)
	 */
	@Override
	public boolean createUserProfile(UserProfile userProfile) {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" + userProfile.getAccountNumber());
		Userprofile userPro = new Userprofile();
		userPro.setUserid(userProfile.getUserId());
		userPro.setPswd(userProfile.getPassword());
		userPro.setEmailid(userProfile.getEmailId());
		userPro.setMobilenumber(userProfile.getMobileNumber());
		userPro.setCommunicationaddress(userProfile.getCommunicationAddress());
		userPro.setAccountnumber(userProfile.getAccountNumber());
		userPro.setSq1(userProfile.getSQ1());
		userPro.setSq2(userProfile.getSQ2());
		userPro.setSq3(userProfile.getSQ3());
		userPro.setSqa1(userProfile.getSQA1());
		userPro.setSqa2(userProfile.getSQA2());
		userPro.setSqa3(userProfile.getSQA3());
		userPro.setCreated_at(java.sql.Timestamp.valueOf(LocalDateTime.now()));
		userPro.setUpdated_at(java.sql.Timestamp.valueOf("2018-11-15 15:30:14.332"));
		userRepo.save(userPro);
		return true;
	}

	@Override
	public boolean isUserIdAvailable(String userID) {
		if (userRepo.findUserByUserid(userID) == null) {
			return true;
		}
		return false;
	}

	@Override
	public LoginResponse ulogin(UserProfile userProfile) {

		Userprofile user = null;
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setAuthenticated(false);

		if (null != userProfile.getAccountNumber()) {
			user = userRepo.findUserByAccountnumber(userProfile.getAccountNumber());
		} else if (null != userProfile.getUserId()) {
			user = userRepo.findUserByUserid(userProfile.getUserId());
		}

		if (null == user) {
			throw new ObjectNotFoundException("No User found");
		}
		String cardNumber = user.getAccountnumber();
		if (user.getPswd().equalsIgnoreCase(userProfile.getPassword())) {
			loginResponse.setAuthenticated(true);
			Account account = accountRepo.findByAccountnumber(cardNumber);
			loginResponse.setCardnumber(cardNumber);
			loginResponse.setMessage("user authenticated");
			loginResponse.setUserid(user.getUserid());
			loginResponse.setCustid(account.getCustid());
			return loginResponse;
		}
		return loginResponse;
	}

}
