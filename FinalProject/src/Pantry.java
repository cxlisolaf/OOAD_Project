import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;

public class Pantry {
	private List<Ingred> ingredList = new ArrayList<Ingred>();
    private SessionFactory factory;

	Pantry() {

	}

	public void setSessionFactory(SessionFactory factory){
	    this.factory = factory;
    }

	public Ingred getAt(int num) {
		return this.ingredList.get(num);
	}

	public int getSize() {
		Session session = factory.openSession();
		List<Ingred> ingredList = session.createQuery("from Ingred").list();
		return ingredList.size();
	}

	public void display() {
//		for (int i = 0; i < ingredList.size(); i++) {
//			System.out.println(ingredList.get(i).getName() + "\t" + ingredList.get(i).getAmount() + "\t" + ingredList.get(i).getUnit());
//		}
		if(factory == null){
			System.out.println("no factory");
		}
		Session session = factory.openSession();
		if(session == null){
			System.out.println("no session");
		}
		List<Ingred> ingredList = session.createQuery("from Ingred").list();
		if(ingredList == null || ingredList.size() == 0){
			System.out.println("Empty");
		} else{
			for (Ingred i : ingredList) {
				System.out.println(i.getName() + "\t" + i.getAmount() + "\t" + i.getUnit());
			}
		}

	}

	public void displayNumbered() {
//		for (int i = 0; i < ingredList.size(); i++) {
//			System.out.println((i+1) + "\t" + ingredList.get(i).getName());
//		}
		Session session = factory.openSession();
		List<Ingred> ingredList = session.createQuery("from Ingred").list();
		int count = 1;
		for (Ingred i : ingredList) {
			System.out.println(count + "\t" + i.getName() + "\t" + i.getAmount() + "\t" + i.getUnit());
			count += 1;
		}
	}

	public void remove(int num) {
//		ingredList.remove(num-1);
		Session session = factory.openSession();
		List<Ingred> ingredList = session.createQuery("from Ingred").list();
		int count = 1;
		for (Ingred i : ingredList) {
			if (count == num){
				System.out.println("Open session...");
				session.beginTransaction();
				System.out.println("Begin transaction...");
				session.delete(i);
				System.out.println("Add to database...");
				session.getTransaction().commit();
				System.out.println("commit...");
				break;
			}
//			System.out.println(count + "\t" + i.getName());
			count += 1;
		}
	}

	public void adjust(int num, double amount) {
		Session session = factory.openSession();
		List<Ingred> ingredList = session.createQuery("from Ingred").list();
		int count = 1;
		for (Ingred i : ingredList) {
			if (count == num){
				System.out.println("Open session...");
				session.beginTransaction();
				System.out.println("Begin transaction...");
				i.setAmount(amount);
				session.update(i);
				System.out.println("Add to database...");
				session.getTransaction().commit();
				System.out.println("commit...");
				break;
			}
//			System.out.println(count + "\t" + i.getName());
			count += 1;
		}
	}

	public void add(Ingred newIn) {
		//ingredList.add(newIn);
        Session session = factory.openSession();
        System.out.println("Open session...");
        session.beginTransaction();
		System.out.println("Begin transaction...");
        session.persist(newIn);
		System.out.println("Add to database...");
        session.getTransaction().commit();
		System.out.println("commit...");
	}
}