package java8.ex03;

import java8.data.Account;
import java8.data.Person;
import org.junit.Test;

import java.util.Optional;

/**
 * Exercice 03 - Navigation avec map
 */
public class Optional_03_Test {

    class GoodException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
    }

    // tag::methodes[]
    private Account getAccountNull() {
        return null;
    }

    private Account getAccountWithPersonNull() {
        return new Account();
    }

    private Account getAccountWithPersonFirstnameNull() {
        Account account = new Account();
        account.setOwner(new Person());
        return account;
    }

    private Account getAccountWithPersonFirstnameNotNull() {
        Account account = new Account();
        account.setOwner(new Person("A", "B", 19, "C"));
        return account;
    }
    // end::methodes[]

    @Test(expected = GoodException.class)
    public void test_getAccountNull() throws Exception {
        Account account = getAccountNull();
        Optional<Account> accOpt = Optional.ofNullable(account);
        // TODO A l'aide de la méthode map récupérer le prénom (account -> person -> firstname)
        // TODO Utiliser la méthode orElseThrow pour déclencher l'exception GoodException si non trouvé
        // accOpt.map...
        accOpt.map(p -> p.getOwner().getFirstname()).orElseThrow(() -> new GoodException());
        
    }

    @Test(expected = GoodException.class)
    public void test_getAccountWithPersonNull() throws Exception {
        Account account = getAccountWithPersonNull();
        Optional<Account> accOpt = Optional.ofNullable(account);
        // TODO A l'aide de la méthode map récupérer le prénom (account -> person -> firstname)
        // TODO Utiliser la méthode orElseThrow pour déclencher l'exception GoodException si non trouvé
        // accOpt.map...
        accOpt.map(p -> p.getOwner()).map(p -> p.getFirstname()).orElseThrow(() -> new GoodException());
    }

    @Test(expected = GoodException.class)
    public void test_getAccountWithPersonFirstnameNull() throws Exception {
        Account account = getAccountWithPersonFirstnameNull();
        Optional<Account> accOpt = Optional.ofNullable(account);
        // TODO A l'aide de la méthode map récupérer le prénom (account -> person -> firstname)
        // TODO Utiliser la méthode orElseThrow pour déclencher l'exception GoodException si non trouvé
        // accOpt.map...
        accOpt.map(p -> p.getOwner()).map(p -> p.getFirstname()).orElseThrow(() -> new GoodException());
    }

    @Test
    public void test_getAccountWithPersonFirstnameNotNull() throws Exception {
        Account account = getAccountWithPersonFirstnameNotNull();
        Optional<Account> accOpt = Optional.ofNullable(account);
        // TODO A l'aide de la méthode map récupérer le prénom (account -> person -> firstname)
        // TODO Utiliser la méthode ifPresent pour valider que le prénom est "A"
        // accOpt.map...
        accOpt.map(p -> p.getOwner()).map(p -> p.getFirstname()).ifPresent(name -> {
        	if(!name.equals("A")){
        		throw new GoodException();
        	}
        });
    }
}
