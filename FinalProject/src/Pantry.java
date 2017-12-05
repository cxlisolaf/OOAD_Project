import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;

public class Pantry {
	private List<Ingred> ingredList = new ArrayList<Ingred>();
    private SessionFactory factory;

	Pantry() {
		Ingred bread = new Ingred("bread", "loaf", 1);
		ingredList.add(bread);
	}

	public void setSessionFactory(SessionFactory factory){
	    this.factory = factory;
    }

	public Ingred getAt(int num) {
		return this.ingredList.get(num);
	}

	public int getSize() {
		return this.ingredList.size();
	}

	public void display() {
//		for (int i = 0; i < ingredList.size(); i++) {
//			System.out.println(ingredList.get(i).getName() + "\t" + ingredList.get(i).getAmount() + "\t" + ingredList.get(i).getUnit());
//		}
		Session session = factory.openSession();
		List<Ingred> ingredList = session.createQuery("from Ingred").list();
		for (Ingred i : ingredList) {
			System.out.println(i.getName() + "\t" + i.getAmount() + "\t" + i.getUnit());
		}
	}

	public void displayNumbered() {
		for (int i = 0; i < ingredList.size(); i++) {
			System.out.println((i+1) + "\t" + ingredList.get(i).getName());
		}
	}

	public void remove(int num) {
		ingredList.remove(num-1);
	}

	public void adjust(int num) {
		
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