package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springboot.model.Guest;
import com.springboot.model.GuestReservationDetails;
import com.springboot.repository.GuestDetailsRepository;
import com.springboot.repository.MyRepository;
@Service
public class GuestService {
	@Autowired
	private MyRepository myRepository;
	@Autowired
	private GuestDetailsRepository repository;
	public MyRepository getMyRepository() {
		return myRepository;
	}
	public void setMyRepository(MyRepository myRepository) {
		this.myRepository = myRepository;
	}
	public GuestService() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GuestService(MyRepository myRepository) {
		super();
		this.myRepository = myRepository;
	}
	public Guest registerNewGuest(Guest guest)
	{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(guest);
		session.getTransaction().commit();
		session.close();
//		Guest guest1=myRepository.save(guest);
		return guest;
		
	}
	
	public Guest checkGuest(String email,String password)
	{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Guest where guestEmailId=?1 and guestPassword=?2");
		query.setString(1, email);
		query.setString(2, password);
		List<Guest> list=(List<Guest>)query.list();
		session.getTransaction().commit();
		session.close();
		if(list.size()==1)
		{
			return list.get(0);
		}
		else
		{
			return null;
		}
	}
	
	public Guest getGuestByEmail(String email)
	{
		Guest guest=myRepository.findByGuestEmailId(email);
		return guest;
	}
	
	public GuestReservationDetails addReservationInfo(GuestReservationDetails guestReservationDetails)
	{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(guestReservationDetails);
		session.getTransaction().commit();
		session.close();
//		Guest guest1=myRepository.save(guest);
		return guestReservationDetails;
		
		//return repository.save(guestReservationDetails);
	}
	
	
	public List<GuestReservationDetails> getAllHistory(String email)
	{
		Guest guest=myRepository.findByGuestEmailId(email);
		long id=guest.getGuestId();
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from GuestReservationDetails where guest_id=?1");
		query.setLong(1, id);
		List<GuestReservationDetails> list=(List<GuestReservationDetails>)query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Guest> getAllGuest()
	{
		return (List<Guest>) myRepository.findAll();
	}
	public Guest getInformationOfGuest(long guestId)
	{
//		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
//		Session session=sessionFactory.openSession();
//		session.beginTransaction();
//		Query query=session.createQuery("from Guest where guestId=?1");
//		query.setLong(1, guestId);
//		List<Guest> list=(List<Guest>)query.list();
//		Guest guest=null;
//		if(list.size()>0)
//		{
//			 guest=list.get(0);
//		}
//		
//		
//		session.getTransaction().commit();
//		session.close();
		//Guest guest=null;
		Optional<Guest> dbGuest = myRepository.findById(guestId);
//		if(dbGuest.isPresent()) {
		  Guest guest = dbGuest.get();
		//}
		return guest;
	}

}
