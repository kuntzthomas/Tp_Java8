package java8.ex01;

import java.util.List;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;

/**
 * Exercice 01 - Méthode par défaut
 */
public class Method_01_Test {

	// tag::IDao[]
	interface IDao {
		List<Person> findAll();

		default int sumAge() {
			int sommeAge = 0;

			for (Person p : findAll()) {
				sommeAge += p.getAge();
			}
			return sommeAge;
		}

	}
	// end::IDao[]

	class DaoA implements IDao {

		List<Person> people = Data.buildPersonList(20);

		@Override
		public List<Person> findAll() {
			return people;
		}
	}

	class DaoB implements IDao {

		List<Person> people = Data.buildPersonList(100);

		@Override
		public List<Person> findAll() {
			return people;
		}
	}

	@Test
	public void test_daoA_sumAge() throws Exception {

		DaoA daoA = new DaoA();

		int result = daoA.sumAge();

		assert result == 210;
	}

	@Test
	public void test_daoB_sumAge() throws Exception {

		DaoB daoB = new DaoB();

		int result = daoB.sumAge();

		assert result == 5050;

	}
}
